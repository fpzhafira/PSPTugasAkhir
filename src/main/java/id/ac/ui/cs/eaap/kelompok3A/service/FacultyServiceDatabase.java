package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.FacultyMapper;
import id.ac.ui.cs.eaap.kelompok3A.dao.UnivMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FacultyServiceDatabase implements FacultyService {

	@Autowired
	private FacultyMapper facultyMapper;
	
	@Autowired
	private UnivMapper univMapper;
	
	@Override
	public FacultyModel selectFaculty (String idFaculty) {
		// TODO Auto-generated method stub
		log.info("select faculty with id_faculty {}", idFaculty);
		FacultyModel faculty = facultyMapper.selectFaculty(idFaculty);
		if(faculty!=null) {
			faculty.setMajors(facultyMapper.selectMajors(idFaculty));
		}		
		return faculty;
	}

	@Override
	public List<FacultyModel> selectAllFaculties(String idUniv) {
		// TODO Auto-generated method stub
		log.info("select all faculties with id_univ {}", idUniv);
		return facultyMapper.selectAllFaculties(idUniv); 
	}

	@Override
	public void createFaculty(FacultyModel faculty) {
		// TODO Auto-generated method stub
		String inisial = univMapper.selectUniv(faculty.getIdUniv()).getInitial();
		String lastId = facultyMapper.getLastId(inisial+"%").getIdFaculty();
		lastId = lastId.substring(lastId.length()-2, lastId.length());		
		int count = Integer.parseInt(lastId);
		count++;
		
		if(count < 10) {
			lastId = inisial + "F0" + count;
		} else if(count >= 10) {
			lastId = inisial + "F" + count;
		}
		faculty.setIdFaculty(lastId);
		
		log.info("faculty " + faculty.getFacultyName() + " created");
		facultyMapper.createFaculty(faculty);
	}

	@Override
	public void updateFaculty(FacultyModel faculty) {
		// TODO Auto-generated method stub
		log.info("faculty " + faculty.getFacultyName() + " updated");
		facultyMapper.updateFaculty(faculty);
	}

	@Override
	public void deleteFaculty(String idFaculty) {
		// TODO Auto-generated method stub
		log.info("faculty with id {}" + idFaculty + " deleted");
		facultyMapper.deleteFaculty(idFaculty);
	}

	@Override
	public FacultyModel selectFacultyByNameAndGroup(String name, String idGroup) {
		// TODO Auto-generated method stub
		log.info("select faculty with name= {} and idGroup= {}", name, idGroup);
		return facultyMapper.selectFacultyByNameAndGroup(name, idGroup);
	}

	@Override
	public void enableFaculty(String name) {
		// TODO Auto-generated method stub
		log.info("faculty {} enabled", name);
		facultyMapper.enableFaculty(name);		
	}

	@Override
	public FacultyModel selectDisabledFaculty(String idFaculty) {
		// TODO Auto-generated method stub
		log.info("select disabled faculty with id {}", idFaculty);
		return facultyMapper.selectDisabledFaculty(idFaculty);
	}

}
