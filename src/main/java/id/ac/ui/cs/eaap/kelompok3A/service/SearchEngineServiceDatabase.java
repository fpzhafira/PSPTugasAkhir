package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.SearchEngineMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SearchEngineServiceDatabase implements SearchEngineService {
	
	@Autowired
	SearchEngineMapper psm;
	
	public List<CourseModel> searchCourse(String name, String sks, String sksRequired)
	{
		if(name.length()>0) {
			if(sks.length()>0) {
				if(sksRequired.length()>0) {
					log.info ("search course where name like {}, sks = {}, sksRequired = {}", name, sks, sksRequired);
					return psm.searchCourse("%" + name + "%", sks, sksRequired);
				} else {
					log.info ("search course where name like {}, sks = {}", name, sks);
					return psm.searchCourseByNameAndSks("%" + name + "%", sks);
				}
			} else if(sksRequired.length()>0) {
				log.info ("search course where name like {}, sksRequired = {}", name, sksRequired);
				return psm.searchCourseByNameAndSksRequired("%" + name + "%", sksRequired);
			} else {
				log.info ("search course where name like {}", name);
				return psm.searchCourseByName("%" + name + "%");
			}
		} else if(sks.length()>0) {
			if(sksRequired.length()>0) {
				log.info ("search course where sks = {}, sksRequired = {}", sks, sksRequired);
				return psm.searchCourseBySksAndSksRequired(sks, sksRequired);
			} else {
				log.info ("search course where sks = {}", sks);
				return psm.searchCourseBySks(sks);
			}
		} else {
			log.info ("search course where sksRequired = {}", sksRequired);
			return psm.searchCourseBySksRequired(sksRequired);
		}
	}

	@Override
	public List<UnivModel> searchUniv(String name) {
		// TODO Auto-generated method stub
		log.info("search univ where name like {}", name);
		return psm.searchUniv("%" + name + "%");
	}

	@Override
	public List<FacultyModel> searchFaculty(String name) {
		// TODO Auto-generated method stub
		log.info("search faculty where name like {}", name);
		return psm.searchFaculty("%" + name + "%");
	}

	@Override
	public List<MajorModel> searchMajor(String name) {
		// TODO Auto-generated method stub
		log.info("search major where name like {}", name);
		return psm.searchMajor("%" + name + "%");
	}
}
