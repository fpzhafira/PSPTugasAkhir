package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.UnivMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UnivServiceDatabase implements UnivService {

	@Autowired
	private UnivMapper univMapper;
	
	@Override
	public UnivModel selectUniv(String idUniv) {
		// TODO Auto-generated method stub
		log.info("select univ with id_univ {}", idUniv);
		UnivModel univ = univMapper.selectUniv(idUniv);
		List<FacultyModel> faculties = univMapper.selectFaculties(idUniv);
		univ.setFaculties(faculties);		
		return univ;
	}

	@Override
	public List<UnivModel> selectAllUnivs() {
		// TODO Auto-generated method stub
		log.info("select all univs");
		return univMapper.selectAllUnivs();
	}

	@Override
	public void createUniv(UnivModel univ) {
		// TODO Auto-generated method stub
		String id = univMapper.getLastUniv().getIdUniv();
		String tmp = id.substring(1, id.length());
		int count = Integer.parseInt(tmp);
		count++;
		if(count < 10) {
			id = "000" + count;
		} else if(count >= 10 && count < 100) {
			id = "00" + count;
		} else if(count >= 100 && count < 1000){
			id = "0" + count;
		} else {
			id = "" + count;
		}
		univ.setIdUniv("U" + id);
		
		log.info("univ "+univ.getUnivName()+" created");
		univMapper.createUniv(univ);		
	}

	@Override
	public void updateUniv(UnivModel univ) {
		// TODO Auto-generated method stub
		log.info("univ "+univ.getUnivName()+" updated");
		try {
			univMapper.updateUniv(univ);
		} catch(Exception e) {
			
		}
		
	}

	@Override
	public void deleteUniv(String idUniv) {
		// TODO Auto-generated method stub
		log.info("univ "+idUniv+" deleted");
		univMapper.deleteUniv(idUniv);
	}

	@Override
	public UnivModel selectUnivByName(String name) {
		// TODO Auto-generated method stub
		log.info("select univ by name = {}", name);
		return univMapper.selectUnivByName(name);
	}

	@Override
	public void enableUniv(String idUniv) {
		// TODO Auto-generated method stub
		log.info("univ {} enabled", idUniv);
		univMapper.enableUniv(idUniv);
	}

	@Override
	public UnivModel selectInitialByName(String name) {
		// TODO Auto-generated method stub
		log.info("select initial univ by name = {}", name);
		return univMapper.selectInitialByName(name);
	}

	@Override
	public UnivModel selectDisabledUniv(String idUniv) {
		// TODO Auto-generated method stub
		log.info("select disabled univ with id {}", idUniv);
		return univMapper.selectDisabledUniv(idUniv);
	}

}
