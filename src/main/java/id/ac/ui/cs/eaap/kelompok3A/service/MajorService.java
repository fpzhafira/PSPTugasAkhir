package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;

public interface MajorService {

	MajorModel selectMajor(String idMajor);
	
	MajorModel selectDisabledMajor(String idMajor);
	
	MajorModel selectMajorByNameAndFaculty(String name, String idFaculty);
	
	List<MajorModel> selectAllMajors(String idFaculty);
	
	void createMajor(MajorModel major);
	
	void updateMajor(MajorModel major);
	
	void deleteMajor(String idMajor);
	
	void enableMajor(String idMajor);
}
