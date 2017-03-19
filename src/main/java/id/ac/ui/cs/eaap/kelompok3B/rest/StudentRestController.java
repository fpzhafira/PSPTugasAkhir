package id.ac.ui.cs.eaap.kelompok3B.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.kelompok3B.domain.Student;
import id.ac.ui.cs.eaap.kelompok3B.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentRestController 
{
	@Autowired
	StudentService studentDAO;
	
	@RequestMapping(value="/allRole/get/studentByNpm/{npm}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable(value="npm") String npm)
	{
		return studentDAO.getStudent(npm);
	}
	
	@RequestMapping(value="/sekre/get/allStudentByUnivFacultyMajor/{univId}/{facultyId}/{majorId}", method=RequestMethod.GET)
	public List<Student> getAllStudentByUnivFacultyMajor(
			@PathVariable(value="univId") String univId, 
			@PathVariable(value="facultyId") String facultyId, 
			@PathVariable(value="majorId") String majorId)
	{
		return studentDAO.getAllStudentByUnivFacultyMajor(univId, facultyId, majorId);
	}
	
	@RequestMapping(value="/sekre/get/batchesOfAllStudent/{univId}/{facultyId}/{majorId}", method=RequestMethod.GET)
	public List<String> getStudentBatches(
			@PathVariable(value="univId") String univ_id, 
			@PathVariable(value="facultyId") String faculty_id, 
			@PathVariable(value="majorId") String major_id)
	{
		return studentDAO.getAllOfStudentBatch(univ_id, faculty_id, major_id);
	}
}
