package id.ac.ui.cs.eaap.kelompok3A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.GroupModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.FacultyService;
import id.ac.ui.cs.eaap.kelompok3A.service.GroupService;
import id.ac.ui.cs.eaap.kelompok3A.service.MajorService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;

@Controller
@RequestMapping("/sekre")
public class FacultyController {

	@Autowired
	FacultyService facultyservice;
	
	@Autowired
	UnivService univservice;
	
	@Autowired
	MajorService majorservice;
	
	@Autowired
	GroupService groupservice;
	
	
	@RequestMapping("/faculty/view/{id}")
    public String viewFaculty (Model model, @PathVariable(value = "id") String idFaculty)
    {
       	FacultyModel faculty = facultyservice.selectFaculty(idFaculty);
       	model.addAttribute("faculty", faculty);
       	String idUniv = faculty.getIdUniv();
       	String idGroup = faculty.getIdGroup();
       	//kalau dirasa perlu untuk ada informasi tambahan mengenai univ dan rumpun
       	UnivModel univ = univservice.selectUniv(idUniv);
       	GroupModel group = groupservice.selectGroup(idGroup);
       	model.addAttribute("univ", univ);
       	model.addAttribute("group", group);
       	//end of info tambahan ttg univ dan rumpun
       	
       	return "kurikulum/view-faculty";
    }
	
	@RequestMapping("/faculty/view-disabled/{id}")
    public String viewDisabledFaculty (Model model, @PathVariable(value = "id") String idFaculty)
    {
       	FacultyModel faculty = facultyservice.selectDisabledFaculty(idFaculty);
       	model.addAttribute("faculty", faculty);
       	String idUniv = faculty.getIdUniv();
       	String idGroup = faculty.getIdGroup();
       	//kalau dirasa perlu untuk ada informasi tambahan mengenai univ dan rumpun
       	UnivModel univ = univservice.selectUniv(idUniv);
       	GroupModel group = groupservice.selectGroup(idGroup);
       	model.addAttribute("univ", univ);
       	model.addAttribute("group", group);
       	//end of info tambahan ttg univ dan rumpun
       	
       	return "kurikulum/view-disabled-faculty";
    }
	
	@RequestMapping("/faculty/add/{id}")
	public String addFaculty(Model model, @PathVariable(value = "id") String idUniv)
	{
		
		UnivModel univ = univservice.selectUniv(idUniv);
		model.addAttribute("univ", univ);
		List <GroupModel> group = groupservice.selectAllGroups(idUniv);
		model.addAttribute("group", group);
		return "kurikulum/add-faculty";
	}
	
	@PostMapping("/faculty/add/submit")
	public String addFacultySubmit(Model model, @ModelAttribute FacultyModel faculty)
	{
		FacultyModel facultyCheck = facultyservice.selectFacultyByNameAndGroup(faculty.getFacultyName(), faculty.getIdGroup());
		if (facultyCheck != null) {
			String category = "add";
			String entity = "faculty";
			String link = "sekre/faculty/add/"+faculty.getIdUniv();
			String linkView = "";
			if(facultyCheck.getTelephoneNumber().equals("1")) {
				linkView = "sekre/faculty/view/" + facultyCheck.getIdFaculty();
			} else {
				linkView = "sekre/faculty/view-disabled/" + facultyCheck.getIdFaculty();
			}
			String exist = "faculty with name '" + faculty.getFacultyName() + "'";
			
			model.addAttribute("category", category);
			model.addAttribute("entity", entity);
			model.addAttribute("exist", exist);
			model.addAttribute("link", link);
			model.addAttribute("linkView", linkView);
			return "kurikulum/exist";
		} else {
			facultyservice.createFaculty(faculty);
			FacultyModel faculty2 = facultyservice.selectFaculty(faculty.getIdFaculty());
			model.addAttribute("faculty", faculty2);
			String idUniv = faculty.getIdUniv();
	       	String idGroup = faculty.getIdGroup();
	       	UnivModel univ = univservice.selectUniv(idUniv);
	       	GroupModel group = groupservice.selectGroup(idGroup);
	       	model.addAttribute("univ", univ);
	       	model.addAttribute("group", group);
	       	
	       	List <MajorModel> majors = majorservice.selectAllMajors(faculty.getIdFaculty());
			model.addAttribute("allMajors", majors);
			return "kurikulum/view-faculty";
		}
	}
	
	@RequestMapping("/faculty/update/{id}")
	public String updateFaculty(Model model, @PathVariable(value = "id") String idFaculty)
	{
		
		FacultyModel faculty = facultyservice.selectFaculty(idFaculty);
		String idUniv = faculty.getIdUniv();
		List<GroupModel> group = groupservice.selectAllGroups(idUniv);
		model.addAttribute("group", group);
		model.addAttribute("faculty", faculty);
		return "kurikulum/update-faculty";
	}
	
	@PostMapping("/faculty/update/submit")
	public String updateUnivSubmit(Model model, @ModelAttribute FacultyModel faculty)
	{
		
		FacultyModel faculty2 = facultyservice.selectFaculty(faculty.getIdFaculty());
		model.addAttribute("faculty", faculty2);
		String idUniv = faculty.getIdUniv();
       	String idGroup = faculty.getIdGroup();
       	UnivModel univ = univservice.selectUniv(idUniv);
       	GroupModel group = groupservice.selectGroup(idGroup);
       	model.addAttribute("univ", univ);
       	model.addAttribute("group", group);
       	
       	List <MajorModel> majors = majorservice.selectAllMajors(faculty.getIdFaculty());
		model.addAttribute("allMajors", majors);
		
		return "kurikulum/view-faculty";
		}
	
	@RequestMapping("/faculty/delete/{id}")
	public String deleteFaculty(Model model, @PathVariable(value = "id") String idFaculty)
	{
		FacultyModel faculty = facultyservice.selectFaculty(idFaculty);
		UnivModel univ = univservice.selectUniv(faculty.getIdUniv());
		String name = faculty.getFacultyName() + " - " + univ.getUnivName();
		String id = faculty.getIdFaculty();
		model.addAttribute("name", name);
		model.addAttribute("id", id);	
		
		String idUniv = faculty.getIdUniv();
		String link = "sekre/univ/view/" + idUniv;
		model.addAttribute("link", link);
		
		facultyservice.deleteFaculty(idFaculty);
		return "kurikulum/delete";
	}
	
	@RequestMapping("/faculty/active/{id}")
	public String activeFaculty(Model model, @PathVariable(value = "id") String idFaculty)
	{
		facultyservice.enableFaculty(idFaculty);
		
		FacultyModel faculty = facultyservice.selectFaculty(idFaculty);
       	model.addAttribute("faculty", faculty);
       	String idUniv = faculty.getIdUniv();
       	String idGroup = faculty.getIdGroup();
       	//kalau dirasa perlu untuk ada informasi tambahan mengenai univ dan rumpun
       	UnivModel univ = univservice.selectUniv(idUniv);
       	GroupModel group = groupservice.selectGroup(idGroup);
       	model.addAttribute("univ", univ);
       	model.addAttribute("group", group);
       	//end of info tambahan ttg univ dan rumpun
       	
       	return "kurikulum/view-faculty";
	}
	
}
