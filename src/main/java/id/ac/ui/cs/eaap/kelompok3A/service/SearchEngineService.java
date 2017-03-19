package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;

public interface SearchEngineService {

	List<CourseModel> searchCourse(String name, String sks, String sksRequired);
	
	List<UnivModel> searchUniv(String name);
	
	List<FacultyModel> searchFaculty(String name);
	
	List<MajorModel> searchMajor(String name);
	
}
