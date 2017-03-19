package id.ac.ui.cs.eaap.kelompok3C.service;

import id.ac.ui.cs.eaap.kelompok3C.domain.ClassLecturerModel;

public interface ClassLecturerService {
	void setLecturer(ClassLecturerModel classLecturer);
	
	ClassLecturerModel selectLecturerByClass (String class_id, String nip);
}
