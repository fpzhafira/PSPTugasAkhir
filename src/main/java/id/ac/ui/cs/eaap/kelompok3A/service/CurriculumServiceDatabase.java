package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.CurriculumMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CurriculumServiceDatabase implements CurriculumService {
	
	@Autowired
	private CurriculumMapper curriculumMapper;

	@Override
	public CurriculumModel selectCurriculum(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("select curriculum with id {}", idCurriculum);
		CurriculumModel curriculum = curriculumMapper.selectCurriculum(idCurriculum);
		List<CourseModel> courses = curriculumMapper.selectCourses(idCurriculum);
		curriculum.setCourses(courses);
		return curriculum;
	}

	@Override
	public List<CurriculumModel> selectAllCurriculums(String idMajor) {
		// TODO Auto-generated method stub
		log.info("select all curriculum in major {}", idMajor);
		return curriculumMapper.selectAllCurriculums(idMajor);
	}

	@Override
	public void createCurriculum(CurriculumModel curriculum) {
		// TODO Auto-generated method stub
		String initial = curriculum.getIdMajor();
		initial = initial.substring(0, initial.length()-4);
		String last = curriculumMapper.getLastId(initial+"%").getIdCurriculum();
		int count = Integer.parseInt(last.substring(last.length()-3, last.length()));
		count++;
		if(count < 10) {
			last = initial + "K00" + count;
		} else if(count >= 10 && count < 100) {
			last = initial + "K0" + count;
		} else {
			last = initial + "K" + count;
		}
		curriculum.setIdCurriculum(last);
		log.info("curriculum " + curriculum.getYear() + " created");
		curriculumMapper.createCurriculum(curriculum);
	}

	@Override
	public void updateCurriculum(CurriculumModel curriculum) {
		// TODO Auto-generated method stub
		log.info("curriculum " + curriculum.getYear() + " updated");
		curriculumMapper.updateCurriculum(curriculum);
	}

	@Override
	public void deleteCurriculum(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("curriculum " + idCurriculum + " deleted");
		curriculumMapper.deleteCurriculum(idCurriculum);
	}

	@Override
	public List<CourseModel> selectCourseOnTerm(@Param("idCurriculum") String idCurriculum, @Param("idTerm") String idTerm) {
		// TODO Auto-generated method stub
		log.info("select all courses in curriculum {} available on term {}", idCurriculum, idTerm);
		return curriculumMapper.selectCourseOnTerm(idCurriculum, idTerm);
	}

	@Override
	public List<CourseModel> selectAllObligatoryCourses(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("select all obligatory courses in curriculum {}", idCurriculum);
		return curriculumMapper.selectAllObligatoryCourses(idCurriculum);
	}

	@Override
	public List<CourseModel> selectUnivObligatoryCourses(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("select all univ obligatory courses in curriculum {}", idCurriculum);
		return curriculumMapper.selectUnivObligatoryCourses(idCurriculum);
	}

	@Override
	public List<CourseModel> selectGroupObligatoryCourses(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("select all group obligatory courses in curriculum {}", idCurriculum);
		return curriculumMapper.selectGroupObligatoryCourses(idCurriculum);
	}

	@Override
	public List<CourseModel> selectFacultyObligatoryCourses(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("select all faculty obligatory courses in curriculum {}", idCurriculum);
		return curriculumMapper.selectFacultyObligatoryCourses(idCurriculum);
	}

	@Override
	public List<CourseModel> selectMajorObligatoryCourses(String idCurriculum) {
		// TODO Auto-generated method stub
		log.info("select all major obligatory courses in curriculum {}", idCurriculum);
		return curriculumMapper.selectMajorObligatoryCourses(idCurriculum);
	}

	@Override
	public void addCourse(String idCourse, String idCurriculum, String obligatory) {
		// TODO Auto-generated method stub
		log.info("course with id {} assigned to curriculum {} with obligatory {}", idCourse, idCurriculum, obligatory);
		curriculumMapper.addCourse(idCourse, idCurriculum, obligatory);
	}

}
