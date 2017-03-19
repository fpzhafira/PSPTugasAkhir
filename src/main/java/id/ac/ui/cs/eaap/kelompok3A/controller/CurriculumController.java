package id.ac.ui.cs.eaap.kelompok3A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CourseService;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.MajorService;
import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;
import id.ac.ui.cs.eaap.kelompok3C.service.TermService;

@Controller

@RequestMapping("/sekre")
public class CurriculumController {

	@Autowired
	CurriculumService currservice;
	
	@Autowired
	CourseService courseservice;
	
	@Autowired
	TermService termservice;
	
	@Autowired
	MajorService majorservice;
	
	@RequestMapping("curriculum/view/{id}")
	public String viewCurriculum(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		MajorModel major = majorservice.selectMajor(curr.getIdMajor());
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("major", major);
		
		return "kurikulum/view-curriculum";
	}
	
	@RequestMapping("/curriculum/update/{id}")
	public String updateCurriculum(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		
		model.addAttribute("curriculum", curr);
		
		return "kurikulum/update-curriculum";
	}
	
	@PostMapping("/curriculum/update/submit")
	public String updateCurriculumSubmit(Model model, @ModelAttribute CurriculumModel curriculum)
	{
		currservice.updateCurriculum(curriculum);
		MajorModel major = majorservice.selectMajor(curriculum.getIdMajor());
	
		CurriculumModel curr = currservice.selectCurriculum(curriculum.getIdCurriculum());
		
		model.addAttribute("curriculum",curr);
		model.addAttribute("major", major);
		
		return "kurikulum/view-curriculum";
	}
	
	@RequestMapping("/curriculum/add/{id}")
	public String addCurriculum(Model model, @PathVariable(value = "id") String idMajor)
	{
		MajorModel major = majorservice.selectMajor(idMajor);
		
		model.addAttribute("major", major);
		
		return "kurikulum/add-curriculum";
	}
	
	@PostMapping("/curriculum/add/submit")
	public String addCurriculumSubmit(Model model, @ModelAttribute CurriculumModel curriculum)
	{
		currservice.createCurriculum(curriculum);
		MajorModel major = majorservice.selectMajor(curriculum.getIdMajor());
		String idMajor = curriculum.getIdMajor();
		model.addAttribute("curriculum", curriculum);
		model.addAttribute("major", major);
       	List <CourseModel> courses = courseservice.selectAllCourses(idMajor);
		model.addAttribute("courses", courses);
		return "kurikulum/view-curriculum";
	}
	
	@RequestMapping("/curriculum/delete/{id}")
	public String deleteCurriculum(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		String id = curr.getIdMajor();
		String name = curr.getYear();
		currservice.deleteCurriculum(idCurriculum);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		String idMajor = curr.getIdMajor();
		String link = "sekre/major/view/" + idMajor;
		model.addAttribute("link", link);
		
		return "kurikulum/delete";
	}
	
	@RequestMapping("/curriculum/selectcourse/{id}")
	public String selectCourseOnTerm(Model model, @PathVariable(value = "id") String idCurriculum)
	{	
		List<TermModel> terms = termservice.selectAllTerms(); 
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		
		model.addAttribute("terms", terms);
		model.addAttribute("curriculum", curr);
		
		return "kurikulum/select-course-on-term";
	}
	
	@RequestMapping("/curriculum/submitcourse")
	public String submitCourseOnTerm(Model model,
			@RequestParam(value = "picker", required = true) String idTerm,
		@RequestParam(value = "idCurriculum", required = true) String idCurriculum) {

		List<CourseModel> courses = currservice.selectCourseOnTerm(idCurriculum, idTerm);
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		TermModel term = termservice.selectTerm(idTerm);
		model.addAttribute("courses", courses);
		model.addAttribute("curriculum", curr);
		model.addAttribute("term", term);
		return "kurikulum/submit-course-on-term";
	}
	
	@RequestMapping("/curriculum/allobligatory/{id}")
	public String viewAllObligatoryCourse(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		List<CourseModel> courses = currservice.selectAllObligatoryCourses(idCurriculum);
		
		String desc = "All Obligatory Course";
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("description", desc);
		model.addAttribute("courses", courses);
		
		return "kurikulum/view-obligatory";
	}
	
	@RequestMapping("/curriculum/univobligatory/{id}")
	public String viewUnivObligatoryCourse(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		List<CourseModel> courses = currservice.selectUnivObligatoryCourses(idCurriculum);
		
		String desc = "University Obligatory Course";
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("description", desc);
		model.addAttribute("courses", courses);
		
		return "kurikulum/view-obligatory";
	}
	
	@RequestMapping("/curriculum/groupobligatory/{id}")
	public String viewGroupObligatoryCourse(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		List<CourseModel> courses = currservice.selectGroupObligatoryCourses(idCurriculum);
		
		String desc = "Group Obligatory Course";
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("description", desc);
		model.addAttribute("courses", courses);
		
		return "kurikulum/view-obligatory";
	}
	
	@RequestMapping("/curriculum/facultyobligatory/{id}")
	public String viewFacultyObligatoryCourse(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		List<CourseModel> courses = currservice.selectFacultyObligatoryCourses(idCurriculum);
		
		String desc = "Faculty Obligatory Course";
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("description", desc);
		model.addAttribute("courses", courses);
		
		return "kurikulum/view-obligatory";
	}
	
	@RequestMapping("/curriculum/majorobligatory/{id}")
	public String viewMajorObligatoryCourse(Model model, @PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = currservice.selectCurriculum(idCurriculum);
		List<CourseModel> courses = currservice.selectMajorObligatoryCourses(idCurriculum);
		
		String desc = "Major Obligatory Course";
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("description", desc);
		model.addAttribute("courses", courses);
		
		return "kurikulum/view-obligatory";
	}
}