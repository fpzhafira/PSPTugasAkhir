package id.ac.ui.cs.eaap.kelompok3C.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CourseService;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;
import id.ac.ui.cs.eaap.kelompok3C.service.ClassesService;
import id.ac.ui.cs.eaap.kelompok3C.service.LecturerService;
import id.ac.ui.cs.eaap.kelompok3C.service.TermService;

@Controller

@RequestMapping("/sekre")
public class ClassesController {

	@Autowired
	ClassesService classesDAO;

	@Autowired
	CourseService courseDAO;
	
	@Autowired
	TermService termDAO;
	
	@Autowired
	LecturerService lecturerDAO;
	
	@RequestMapping("/3C")
	public String index()
	{
		return "enrollment/index3C";
	}
	
	@RequestMapping("/classes/viewAllClass")
	public String viewAllClass(Model model) {
		List<ClassesModel> classes = classesDAO.viewAllClass();
		model.addAttribute("classes", classes);
		return "classes/view-all-class";
	}

	@RequestMapping("/classes/view/{id_term}")
	public String viewClassByTerm(@PathVariable(value = "id_term") Integer id_term, Model model) {
		List<ClassesModel> classes = classesDAO.viewClassByTerm(id_term);
		model.addAttribute("classes", classes);
		return "classes/view-class-by-term";
	}
	
	@RequestMapping("/classes/view/info/{class_id}")
	public String viewClassInfo(@PathVariable(value = "class_id") String class_id, Model model) {
		ClassesModel classes = classesDAO.viewClassInfo(class_id);
		if (classes == null){
			model.addAttribute ("classes", classes);
			return "classes/class-not-found";
		} else {
			model.addAttribute ("classes", classes);
			return "classes/view-class-info";
		}
	}

	@RequestMapping("/classes/add/")
	public String add(Model model) {
		List<CourseModel> courses = courseDAO.selectAllCourse();
		List<TermModel> terms = termDAO.selectAllTerms();
		List<LecturerModel> lecturers = lecturerDAO.selectAllLecturers();
		
		model.addAttribute("courses", courses);
		model.addAttribute("terms", terms);
		model.addAttribute("lecturers", lecturers);
		return "classes/add-class";
	}

	@RequestMapping("/classes/add/submit")
	public String addSubmit(@RequestParam(value = "class_id", required = false) String class_id,
			@RequestParam(value = "major_id", required = false) String major_id,
			@RequestParam(value = "course_id", required = false) String course_id,
			@RequestParam(value = "class_name", required = false) String class_name,
			@RequestParam(value = "schedule", required = false) String schedule,
			@RequestParam(value = "classroom", required = false) String classroom,
			@RequestParam(value = "lecturer", required = false) String lecturer,
			@RequestParam(value = "id_term", required = false) int id_term) {
		ClassesModel classes = new ClassesModel(class_id, major_id, course_id, class_name, schedule,
				classroom, lecturer, id_term);
		classesDAO.addClass(classes);

		return "classes/success-add-class";
	}
}
