package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.LecturerDAO;
import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LecturerServiceRest implements LecturerService {

	@Autowired
	LecturerDAO lecturerDAO;
	
	@Override
	public LecturerModel selectLecturer(String nip) {
		// TODO Auto-generated method stub
		log.info("select lecturer with nip{}", nip);
		return lecturerDAO.selectLecturer(nip);
	}

	@Override
	public List<LecturerModel> selectAllLecturers() {
		// TODO Auto-generated method stub
		log.info("select all lecturers");
		return lecturerDAO.selectAllLecturers();
	}

}
