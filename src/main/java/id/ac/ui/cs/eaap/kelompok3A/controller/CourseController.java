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
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CourseService;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.MajorService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;

@Controller

@RequestMapping("/sekre")
public class CourseController {
	/*
	 * Void addPreconditions (String idCourse, String idCoursePrecondition) Void
	 * deletePreconditions (String idCourse, String idCoursePrecondition)
	 * 
	 */

	@Autowired
	CourseService courseService;

	@Autowired
	UnivService univService;
	
	@Autowired
	CurriculumService currService;
	
	@Autowired
	MajorService majorService;

	@RequestMapping("/course/view/{id}")
	public String viewCourse(Model model, @PathVariable(value = "id") String idCourse) {
		CourseModel course = courseService.selectCourse(idCourse);
		model.addAttribute("course", course);
		return "kurikulum/view-course";
	}

	@RequestMapping("/course/create")
	public String createCourse(Model model) {
		List<UnivModel> univ = univService.selectAllUnivs();
		model.addAttribute("univ", univ);
		return "kurikulum/create-course";
	}
	
	@PostMapping("/course/create/submit")
	public String createCourseSubmit(Model model, 
			@RequestParam(value = "idUniv", required = true) String initial,
			@RequestParam(value = "courseName", required = true) String courseName,
			@RequestParam(value = "sks", required = true) String sks,
			@RequestParam(value = "sksRequired", required = true) String sksRequired) {

		System.out.println(initial);
		CourseModel course =courseService.selectCourseByNameAndInitial(courseName, initial);
		if(course == null) {
			course = new CourseModel(initial, courseName, null, null, Integer.parseInt(sks), Integer.parseInt(sksRequired));
			courseService.createCourse(course);
			String idCourse = course.getIdCourse();
			System.out.println(idCourse);
			course = courseService.selectCourse(idCourse);
			model.addAttribute("course", course);
			return "kurikulum/view-course";
		} else {
			courseService.enableCourse(course.getCourseName());
			String idCourse = course.getIdCourse();
			System.out.println(idCourse);
			course = courseService.selectCourse(idCourse);
			model.addAttribute("course", course);
			return "kurikulum/view-course";
		}
		
	}
	
	@RequestMapping("/course/update/{id}")
	public String updateCourse(Model model, @PathVariable(value = "id") String idCourse) {
		CourseModel course = courseService.selectCourse(idCourse);
		model.addAttribute("course", course);
		return "kurikulum/update-course";
	}
	
	@PostMapping("/course/update/submit")
	public String updateCourseSubmit(Model model, @ModelAttribute CourseModel course) {
		courseService.updateCourse(course);

		CourseModel getCourse = courseService.selectCourse(course.getIdCourse());

		model.addAttribute("course", getCourse);
		return "kurikulum/view-course";
	}

	@RequestMapping("/course/delete/{id}")
	public String deleteCourse(@PathVariable(value = "id") String idCourse, Model model) {
		CourseModel course = courseService.selectCourse(idCourse);
		String name = course.getCourseName();
		String id = course.getIdCourse();
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		courseService.deleteCourse(idCourse);

		String link = "sekre/3A";
		model.addAttribute("link", link);
		
		return "kurikulum/delete";
	}
	
	@RequestMapping("/course/add/{id}")
	public String addCourse(Model model, @PathVariable(value = "id") String idCurriculum) {
		CurriculumModel curr = currService.selectCurriculum(idCurriculum);
		List<CourseModel> courses = courseService.selectCoursesFromUniv(idCurriculum);
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("courses", courses);
		
		return "kurikulum/add-course";
	}
	
	@PostMapping("/course/add/submit")
	public String addCourseSubmit(Model model, 
			@RequestParam(value = "idCurriculum", required = true) String idCurriculum,
			@RequestParam(value = "idCourse", required = true) String idCourse,
			@RequestParam(value = "obligatory", required = true) String obligatory) {

		currService.addCourse(idCourse, idCurriculum, obligatory);
		
		CurriculumModel curr = currService.selectCurriculum(idCurriculum);
		MajorModel major = majorService.selectMajor(curr.getIdMajor());
		
		model.addAttribute("curriculum", curr);
		model.addAttribute("major", major);
		
		return "kurikulum/view-curriculum";
	}
	
	@RequestMapping("/course/addPreconditions/{id}")
	public String addCoursePreconditions(Model model, @PathVariable(value = "id") String idCourse) {

		CourseModel course = courseService.selectCourse(idCourse);
		List<CourseModel> precon = courseService.selectCoursesFromUniv(idCourse); //ID course and curriculum share exact consensus
		
		model.addAttribute("course", course);
		model.addAttribute("preconditions", precon);
		
		return "kurikulum/add-coursePreconditions";
	}
	
	@RequestMapping("/course/addPreconditions/submit")
	public String addCoursePreconditionsSubmit(Model model, 
			@RequestParam(value = "idCourse", required = true) String idCourse,
			@RequestParam(value = "idPreconditions", required = true) String idPreconditions) {
		courseService.addPreconditions(idCourse, idPreconditions);
		CourseModel course = courseService.selectCourse(idCourse);
		model.addAttribute("course", course);
		return "kurikulum/view-course";
	}

	@RequestMapping("/course/deletePreconditions/{idCourse}/{idPrecond}")
	public String deletePreconditions(	@PathVariable(value = "idCourse", required = true) String idCourse,
										@PathVariable(value = "idPrecond", required = true) String idPreconditions, 
										Model model) {
		
		System.out.println(idCourse);
		System.out.println(idPreconditions);
		
		courseService.deletePreconditions(idCourse, idPreconditions);
		CourseModel course = courseService.selectCourse(idCourse);
		model.addAttribute("course", course);
		
		return "kurikulum/view-course";
	}
}
