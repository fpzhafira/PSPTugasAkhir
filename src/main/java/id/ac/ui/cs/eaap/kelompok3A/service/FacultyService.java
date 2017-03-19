package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;

public interface FacultyService {

	FacultyModel selectFaculty(String idFaculty);
	
	FacultyModel selectDisabledFaculty(String idFaculty);
	
	FacultyModel selectFacultyByNameAndGroup(String name, String idGroup);
	
	List<FacultyModel> selectAllFaculties(String idUniv);
	
	void createFaculty(FacultyModel faculty);
	
	void updateFaculty(FacultyModel faculty);
	
	void deleteFaculty(String idFaculty);
	
	void enableFaculty(String idFaculty);
	
}
