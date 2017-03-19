package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.TermMapper;
import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TermServiceDatabase implements TermService {

	@Autowired
	private TermMapper termMapper;
	
	@Override
	public TermModel selectTerm(String idTerm) {
		// TODO Auto-generated method stub
		log.info("select term with id {}", idTerm);
		return termMapper.selectTerm(idTerm);
	}

	@Override
	public List<TermModel> selectAllTerms() {
		// TODO Auto-generated method stub
		log.info("select all term");
		return termMapper.selectAllTerms();
	}

	@Override
	public void createTerm(TermModel term) {
		// TODO Auto-generated method stub
		log.info("term " + term.getYears() + " created");
		termMapper.createTerm(term);
	}

	@Override
	public void updateTerm(TermModel term) {
		// TODO Auto-generated method stub
		log.info("term " + term.getYears() + " updated");
		termMapper.updateTerm(term);
	}

	@Override
	public void deleteTerm(String idTerm) {
		// TODO Auto-generated method stub
		log.info("term " + idTerm + " deleted");
		termMapper.deleteTerm(idTerm);
	}

	@Override
	public TermModel selectTermByYearAndTermHeld(String year, String termHeld) {
		// TODO Auto-generated method stub
		log.info("select term by name= {} and termHeld= {}", year, termHeld);
		return termMapper.selectTermByYearAndTermHeld(year, termHeld);
	}
}
