package id.ac.ui.cs.eaap.kelompok3A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CourseService;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.FacultyService;
import id.ac.ui.cs.eaap.kelompok3A.service.MajorService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;

@Controller
@RequestMapping("/sekre")
public class MajorController {

	@Autowired
	MajorService majorservice;
	
	@Autowired
	CurriculumService currservice;
	
	@Autowired
	CourseService courseservice;
	
	@Autowired
	FacultyService facultyservice;
	
	@Autowired
	UnivService univservice;
	
	@RequestMapping("major/view/{id}")
	public String viewMajor(Model model, @PathVariable(value = "id") String idMajor)
	{
		MajorModel major = majorservice.selectMajor(idMajor);
		

		List<CurriculumModel> currs = currservice.selectAllCurriculums(idMajor);
		
		model.addAttribute("major", major);
		model.addAttribute("curriculums", currs);
		
		return "kurikulum/view-major";
	}
	
	@RequestMapping("major/view-disabled/{id}")
	public String viewDisabledMajor(Model model, @PathVariable(value = "id") String idMajor)
	{
		MajorModel major = majorservice.selectDisabledMajor(idMajor);
		
		model.addAttribute("major", major);
		
		return "kurikulum/view-disabled-major";
	}
	
	@RequestMapping("/major/update/{id}")
	public String updateMajor(Model model, @PathVariable(value = "id") String idMajor)
	{
		MajorModel major = majorservice.selectMajor(idMajor);
		
		model.addAttribute("major", major);
		
		return "kurikulum/update-major";
	}
	
	@PostMapping("/major/update/submit")
	public String updateMajorSubmit(Model model, @ModelAttribute MajorModel major)
	{
		MajorModel majorCheck = majorservice.selectMajorByNameAndFaculty(major.getMajorName(), major.getIdFaculty());
		if (majorCheck != null) {
			String category = "update";
			String entity = "major";
			String link = "sekre/major/update/" + major.getIdMajor();
			model.addAttribute("category", category);
			model.addAttribute("entity", entity);
			model.addAttribute("link", link);
			return "kurikulum/existing";
		}
		else{
		
		majorservice.updateMajor(major);
		
		List<CurriculumModel> currs = currservice.selectAllCurriculums(major.getIdMajor());
		
		model.addAttribute("major", major);
		model.addAttribute("curriculums", currs);
		
		return "kurikulum/view-major";}
	}
	
	@RequestMapping("/major/add/{id}")
	public String addMajor(Model model, @PathVariable(value = "id") String idFaculty)
	{
		FacultyModel faculty = facultyservice.selectFaculty(idFaculty);
		
		model.addAttribute("faculty", faculty);
		
		return "kurikulum/add-major";
	}
	
	@PostMapping("/major/add/submit")
	public String addMajorSubmit(Model model, @ModelAttribute MajorModel major) {
		String idFaculty = major.getIdFaculty();
		
		MajorModel majorCheck = majorservice.selectMajorByNameAndFaculty(major.getMajorName(), major.getIdFaculty());
		if (majorCheck != null) {
			String category = "add";
			String entity = "major";
			String link = "sekre/major/add/" + idFaculty;
			String linkView = "";
			if(majorCheck.getIdFaculty().equals("1")) {
				linkView = "sekre/major/view/"+majorCheck.getIdMajor();
			} else {
				linkView = "sekre/major/view-disabled/"+majorCheck.getIdMajor();
			}
			String exist = "major with name '" + major.getMajorName() + "'";
			model.addAttribute("category", category);
			model.addAttribute("exist", exist);
			model.addAttribute("entity", entity);
			model.addAttribute("link", link);
			model.addAttribute("linkView", linkView);
			return "kurikulum/exist";
		} else {

			majorservice.createMajor(major);

			MajorModel getMajor = majorservice.selectMajor(major.getIdMajor());
			model.addAttribute("major", getMajor);

			List<CurriculumModel> currs = currservice.selectAllCurriculums(major.getIdMajor());
			model.addAttribute("curriculums", currs);
			return "kurikulum/view-major";
		}
	}
	
	@RequestMapping("/major/delete/{id}")
	public String deleteMajor(Model model, @PathVariable(value = "id") String idMajor)
	{
		MajorModel major = majorservice.selectMajor(idMajor);
		String name = major.getMajorName();
		String id = major.getIdMajor();
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		String idFaculty = major.getIdFaculty();
		String link = "sekre/faculty/view/" + idFaculty;
		model.addAttribute("link", link);
		
		majorservice.deleteMajor(idMajor);
		return "kurikulum/delete";
	}
	
	@RequestMapping("major/active/{id}")
	public String activeMajor(Model model, @PathVariable(value = "id") String idMajor)
	{
		majorservice.enableMajor(idMajor);
		
		MajorModel major = majorservice.selectMajor(idMajor);
		
		List<CurriculumModel> currs = currservice.selectAllCurriculums(idMajor);
		
		model.addAttribute("major", major);
		model.addAttribute("curriculums", currs);
		
		return "kurikulum/view-major";
	}
}
