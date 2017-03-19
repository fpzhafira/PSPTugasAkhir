package id.ac.ui.cs.eaap.kelompok3A.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;

@RestController
@RequestMapping("/rest")
public class UniversityRestController {
	
	@Autowired
	UnivService univService;
	
	@RequestMapping("univ/viewall")
	public List<UnivModel> viewAllUniv(Model model)
	{
		List<UnivModel> univ = univService.selectAllUnivs();
		return univ;
	}
	
	@RequestMapping("univ/view/{id}")
	public UnivModel viewUniv(Model model, @PathVariable(value = "id") String idUniv)
	{
		UnivModel univ = univService.selectUniv(idUniv);
		return univ;
	}
}
