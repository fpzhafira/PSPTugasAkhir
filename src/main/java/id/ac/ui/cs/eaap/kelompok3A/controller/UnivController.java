package id.ac.ui.cs.eaap.kelompok3A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.FacultyService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;

@Controller
@RequestMapping("/sekre")
public class UnivController {

	@Autowired
	UnivService univservice;

	@Autowired
	FacultyService facultyservice;

	@RequestMapping("/univ/viewall")
	public String viewAllUniv(Model model) {
		List<UnivModel> univs = univservice.selectAllUnivs();

		model.addAttribute("univs", univs);

		return "kurikulum/view-alluniv";
	}

	@RequestMapping("/univ/view/{id}")
	public String viewUniv(Model model, @PathVariable(value = "id") String idUniv) {
		UnivModel univ = univservice.selectUniv(idUniv);
		model.addAttribute("univ", univ);

		return "kurikulum/view-univ";
	}
	
	@RequestMapping("/univ/view-disabled/{id}")
	public String viewDisabledUniv(Model model, @PathVariable(value = "id") String idUniv) {
		UnivModel univ = univservice.selectDisabledUniv(idUniv);

		String disable = "(tidak aktif)";
		model.addAttribute("univ", univ);
		model.addAttribute("disable", disable);

		return "kurikulum/view-disabled-univ";
	}

	@RequestMapping("/univ/add")
	public String addUniv() {
		return "kurikulum/add-univ";
	}

	@PostMapping("/univ/add/submit")
	public String addUnivSubmit(Model model, @ModelAttribute UnivModel univ) {
		UnivModel univNameCheck = univservice.selectUnivByName(univ.getUnivName());
		UnivModel univInitCheck = univservice.selectInitialByName(univ.getInitial());
		
		if(univNameCheck != null) {
			String category = "add";
			String entity = "university";
			String link = "sekre/univ/add";
			String linkView = "";
			if(univNameCheck.getTelephoneNumber().equalsIgnoreCase("1")) {
				linkView = "sekre/univ/view/" + univNameCheck.getIdUniv();
			} else {
				linkView = "sekre/univ/view-disabled/" + univNameCheck.getIdUniv();
			}
			String exist= "university with name '" + univNameCheck.getUnivName() + "'";
			
			model.addAttribute("exist", exist);
			model.addAttribute("category", category);
			model.addAttribute("entity", entity);
			model.addAttribute("link", link);
			model.addAttribute("linkView", linkView);
			
			return "kurikulum/exist";
			
		} else if(univInitCheck != null) {
			String category = "add";
			String entity = "university";
			String link = "sekre/univ/add";
			String linkView = "";
			if(univInitCheck.getTelephoneNumber().equalsIgnoreCase("1")) {
				linkView = "sekre/univ/view/" + univInitCheck.getIdUniv();
			} else {
				linkView = "sekre/univ/view-disabled/" + univInitCheck.getIdUniv();
			}
			String exist= "university with initial '" + univInitCheck.getInitial() + "'";
			
			model.addAttribute("exist", exist);
			model.addAttribute("category", category);
			model.addAttribute("entity", entity);
			model.addAttribute("link", link);
			model.addAttribute("linkView", linkView);
			
			return "kurikulum/exist";
			
		} else {
			univservice.createUniv(univ);
			List<UnivModel> univs = univservice.selectAllUnivs();
			model.addAttribute("univs", univs);
			return "kurikulum/view-alluniv";
		}
	}
	

	@RequestMapping("/univ/update/{id}")
	public String updateUniv(Model model, @PathVariable(value = "id") String idUniv) {
		UnivModel univ = univservice.selectUniv(idUniv);

		model.addAttribute("univ", univ);

		return "kurikulum/update-univ";
	}

	@PostMapping("/univ/update/submit")
	public String updateUnivSubmit(Model model, @ModelAttribute UnivModel univ) {
//		UnivModel univCheck = univservice.selectUnivByName(univ.getUnivName());
//		if (univCheck != null) {
//			String category = "update";
//			String entity = "university";
//			String link = "sekre/univ/update/" + univ.getIdUniv();
//			model.addAttribute("category", category);
//			model.addAttribute("entity", entity);
//			model.addAttribute("link", link);
//			String exist = "university name";
//			model.addAttribute("exist", exist);
			
//			return "kurikulum/existing";
//		}
//		else{
		univservice.updateUniv(univ);
		UnivModel univ2 = univservice.selectUniv(univ.getIdUniv());
		model.addAttribute("univ", univ2);
		return "kurikulum/view-univ";
	}

	@RequestMapping("/univ/delete/{id}")
	public String deleteUniv(Model model, @PathVariable(value = "id") String idUniv) {
		UnivModel univ = univservice.selectUniv(idUniv);
		String name = univ.getUnivName();
		String id = univ.getIdUniv();
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		univservice.deleteUniv(idUniv);

		String link = "sekre/univ/viewall";
		model.addAttribute("link", link);

		return "kurikulum/delete";
	}
	
	@RequestMapping("/univ/active/{id}")
	public String activeUniv(Model model, @PathVariable(value = "id") String idUniv) {
		univservice.enableUniv(idUniv);
		
		UnivModel univ = univservice.selectUniv(idUniv);
		model.addAttribute("univ", univ);

		return "kurikulum/view-univ";
	}
}
