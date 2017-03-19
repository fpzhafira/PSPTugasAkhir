package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;

public interface TermService {

	TermModel selectTerm(String idTerm);
	
	TermModel selectTermByYearAndTermHeld(String year, String termHeld);
	
	List<TermModel> selectAllTerms();
	
	void createTerm(TermModel term);
	
	void updateTerm(TermModel term);
	
	void deleteTerm(String idTerm);

}
