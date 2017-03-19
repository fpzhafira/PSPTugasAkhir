package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import org.springframework.web.client.RestTemplate;


import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerModel;

@Service
public class LecturerDAOImpl implements LecturerDAO {

	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public LecturerModel selectLecturer(String nip) {
		// TODO Auto-generated method stub
		LecturerModel lecturer = restTemplate.getForObject("http://localhost:8181/rest/dosen/view/"+nip, LecturerModel.class);
        return lecturer;
	}

	@Override
	public List<LecturerModel> selectAllLecturers() {
		// TODO Auto-generated method stub
		List<LecturerModel> lecturers = restTemplate.getForObject("http://localhost:8181/rest/dosen/viewall", List.class);
		return lecturers;
	}

}
