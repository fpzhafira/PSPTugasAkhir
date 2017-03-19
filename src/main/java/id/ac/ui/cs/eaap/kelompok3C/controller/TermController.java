package id.ac.ui.cs.eaap.kelompok3C.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;
import id.ac.ui.cs.eaap.kelompok3C.service.TermService;

@Controller

@RequestMapping("/sekre")
public class TermController {

	@Autowired
	TermService termservice;

	@RequestMapping("/term/add")
	public String addTerm() {
		return "kurikulum/add-term";
	}

	@PostMapping("/term/add/submit")
	public String addTermSubmit(Model model, @ModelAttribute TermModel term) {
		TermModel termCheck = termservice.selectTermByYearAndTermHeld(term.getYears().toString(), term.getTermHeld() + "");
		if (termCheck != null) {
			String category = "add";
			String entity = "term";
			String link = "sekre/term/add";
			model.addAttribute("category", category);
			model.addAttribute("entity", entity);
			model.addAttribute("link", link);
			return "kurikulum/existing";
		} else {
			termservice.createTerm(term);

			model.addAttribute("term", term);
			return "kurikulum/view-term";
		}
	}

	@RequestMapping("/term/update/{id}")
	public String updateTerm(Model model, @PathVariable(value = "id") String idTerm) {
		TermModel term = termservice.selectTerm(idTerm);
		model.addAttribute("term", term);
		return "kurikulum/update-term";
	}


	@RequestMapping("/term/viewall")
	public String viewAllTerm(Model model) {
		List<TermModel> terms = termservice.selectAllTerms();

		model.addAttribute("term", terms);

		return "kurikulum/view-allterms";
	}

	@RequestMapping("/term/delete/{id}")
	public String deleteTerm(Model model, @PathVariable(value = "id") String idTerm) {
		TermModel term = termservice.selectTerm(idTerm);
		int id = term.getIdTerm();
		String name = term.getYears() + " - " + term.getTermHeld();
		String link = "sekre/term/viewall";
		model.addAttribute("link", link);
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		
		
		termservice.deleteTerm(idTerm);
		return "kurikulum/delete";
	}

}
