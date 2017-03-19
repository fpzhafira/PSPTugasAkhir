package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerModel;

public interface LecturerService {
	LecturerModel selectLecturer(String nip);

	List<LecturerModel> selectAllLecturers();
}
