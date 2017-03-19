package id.ac.ui.cs.eaap.kelompok3B.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;
import id.ac.ui.cs.eaap.kelompok3B.domain.Student;
import id.ac.ui.cs.eaap.kelompok3B.service.StudentService;

@Controller
public class StudentCurriculumController 
{		
	@Autowired
	StudentService studentDAO;
	
	@Autowired
	UnivService univDAO;
	
	@Autowired
	CurriculumService curriculumDAO;
	
	@RequestMapping("sekre/assignCurriculum")
	public String viewCurriculumAssignment(Model model)
	{	
		List<UnivModel> universities = univDAO.selectAllUnivs();
		model.addAttribute("universities", universities);
		return "registrasi/assigncurriculum";
	}
	
	@RequestMapping(value="/sekre/assignCurriculumToStudents", method=RequestMethod.POST)
	public String assignCurriculum( 
			@RequestParam(value="univ-select", required=true) String univ,
			@RequestParam(value="fakultas-select", required=true) String fakultas, 
			@RequestParam(value="prodi-select", required=true) String prodi,
			@RequestParam(value="angkatan-select", required=true) String angkatan,
			@RequestParam(value="kurikulum-select", required=true) String kurikulum)
	{
		String batch = angkatan.substring(2); 
		List<Student> students= studentDAO.getStudentByUnivIdFacultyIdMajorIdAndBatch(univ, fakultas, prodi, batch+"%");
		for(Student student : students){
			setCurriculum(kurikulum, student.getNpm());
		}	
		
		return  "redirect:/sekre/assignCurriculum";
	}
	
	public void setCurriculum(String curriculum_id, String student_id)
	{
		studentDAO.assignCurriculumToStudent(curriculum_id, student_id);	
	}
}
