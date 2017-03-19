package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.CurriculumMapper;
import id.ac.ui.cs.eaap.kelompok3A.dao.MajorMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MajorServiceDatabase implements MajorService {

	@Autowired
	private MajorMapper majorMapper;
	
	@Autowired
	private CurriculumMapper curriculumMapper;

	@Override
	public MajorModel selectMajor(String idMajor) {
		// TODO Auto-generated method stub
		MajorModel major = majorMapper.selectMajor(idMajor);
		if(major != null) {
			List<CurriculumModel> currs = curriculumMapper.selectAllCurriculums(idMajor);
			major.setCurriculums(currs);
		}
		log.info("select major with id_major {}", idMajor);
		return major;
	}

	@Override
	public List<MajorModel> selectAllMajors(String idFaculty) {
		// TODO Auto-generated method stub
		log.info("select all majors with id_faculty {}", idFaculty);
		return majorMapper.selectAllMajors(idFaculty);
	}

	@Override
	public void createMajor(MajorModel major) {
		// TODO Auto-generated method stub
		String initial = major.getIdFaculty().substring(0, major.getIdFaculty().length()-3);
		String last = majorMapper.getLastId(initial+"%").getIdMajor();
		int count = Integer.parseInt(last.substring(last.length()-3, last.length()));
		count++;
		if(count < 10) {
			last = initial + "M00" + count;
		} else if(count >= 10 && count < 100) {
			last = initial + "M0" + count;
		} else {
			last = initial + "M" + count;
		}
		major.setIdMajor(last);
		
		log.info("major " + major.getMajorName() + " created");
		majorMapper.createMajor(major);
	}

	@Override
	public void updateMajor(MajorModel major) {
		// TODO Auto-generated method stub
		log.info("major " + major.getMajorName() + " updated");
		majorMapper.updateMajor(major);
	}

	@Override
	public void deleteMajor(String idMajor) {
		// TODO Auto-generated method stub
		log.info("major with id_major {} deleted", idMajor);
		majorMapper.deleteMajor(idMajor);
	}

	@Override
	public MajorModel selectMajorByNameAndFaculty(String name, String idFaculty) {
		// TODO Auto-generated method stub
		log.info("select major with name= {} and idFaculty= {}", name, idFaculty);
		return majorMapper.selectMajorByNameAndFaculty(name, idFaculty);
	}

	@Override
	public void enableMajor(String idMajor) {
		// TODO Auto-generated method stub
		log.info("major {} enabled", idMajor);
		majorMapper.enableMajor(idMajor);
	}

	@Override
	public MajorModel selectDisabledMajor(String idMajor) {
		// TODO Auto-generated method stub
		log.info("select disabled major with id {}", idMajor);
		return majorMapper.selectDisabledMajor(idMajor);
	}
}