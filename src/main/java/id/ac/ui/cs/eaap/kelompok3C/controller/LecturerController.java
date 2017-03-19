package id.ac.ui.cs.eaap.kelompok3C.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3C.domain.ClassLecturerModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerModel;
import id.ac.ui.cs.eaap.kelompok3C.service.ClassLecturerService;
import id.ac.ui.cs.eaap.kelompok3C.service.ClassesService;
import id.ac.ui.cs.eaap.kelompok3C.service.LecturerService;

@Controller
@RequestMapping("/sekre")
public class LecturerController {
	@Autowired
	LecturerService lecturerDAO;
	
	@Autowired
	ClassLecturerService classLecturerDAO;
	
	@Autowired
	ClassesService classesDAO;
	
	@RequestMapping("/lecturer/set")
	public String setLecturer(Model model) {
		List<ClassesModel> classes = classesDAO.viewAllClass();
		model.addAttribute("classes", classes);
		
		List<LecturerModel> lecturers = lecturerDAO.selectAllLecturers();
		model.addAttribute("lecturers", lecturers);

		return "lecturer/set-lecturer";
	}

	@RequestMapping(value = "/lecturer/set/submit", method = RequestMethod.POST)
	public String setLecturerSubmit(Model model, @RequestParam(value = "class_id", required = false) String class_id,
			@RequestParam(value = "nip", required = false) String nip,
			@RequestParam(value = "nip2", required = false) String nip2,
			@RequestParam(value = "nip3", required = false) String nip3) {
//		ClassLecturerModel classLecturer = new ClassLecturerModel (class_id, nip);
//		classLecturerDAO.setLecturer(classLecturer);
		
		ClassLecturerModel lecturer1 = null;
		ClassLecturerModel lecturer2 = null;
		ClassLecturerModel lecturer3 = null;
		
		boolean check = true;
		//validasi input
		if (nip != null) {
			ClassLecturerModel lecturerCheck1 = classLecturerDAO.selectLecturerByClass(class_id, nip);
			if (lecturerCheck1 == null) {
				lecturer1 = new ClassLecturerModel (class_id, nip);
				if (nip2 != null) {
					ClassLecturerModel lecturerCheck2 = classLecturerDAO.selectLecturerByClass(class_id, nip2);
					if (lecturerCheck2 == null) {
						lecturer2 = new ClassLecturerModel (class_id, nip2);
						if (nip3 != null) {
							ClassLecturerModel lecturerCheck3 = classLecturerDAO.selectLecturerByClass(class_id, nip3);
							if (lecturerCheck3 == null) {
								lecturer3 = new ClassLecturerModel (class_id, nip3);
							} else {
								check = false;
							}
						}
					} else {
						check = false;
					}
				}
			} else {
				check = false;
			}
		}

		if (check == true) {
			classLecturerDAO.setLecturer(lecturer1);
			if(!nip2.equals("none"))
				classLecturerDAO.setLecturer(lecturer2);
			if(!nip3.equals("none"))
				classLecturerDAO.setLecturer(lecturer3);
			
				
			return "lecturer/success-set-lecturer";
		} else {
			return "lecturer/exist";
				
		}
		
	}
}
