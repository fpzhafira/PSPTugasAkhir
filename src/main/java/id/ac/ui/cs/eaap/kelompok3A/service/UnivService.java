package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;

public interface UnivService {
	
	UnivModel selectUniv(String idUniv);
	
	UnivModel selectDisabledUniv(String idUniv);
	
	UnivModel selectUnivByName(String name);
	
	List<UnivModel> selectAllUnivs();
	
	void createUniv(UnivModel univ);
	
	void updateUniv(UnivModel univ);
	
	void deleteUniv(String idUniv);

	void enableUniv(String idUniv);
	
	UnivModel selectInitialByName(String name);
}
