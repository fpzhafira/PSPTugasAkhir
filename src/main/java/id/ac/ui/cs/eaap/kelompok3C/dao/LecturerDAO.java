package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerModel;


public interface LecturerDAO {
	LecturerModel selectLecturer(String nip);

	List<LecturerModel> selectAllLecturers();
}
