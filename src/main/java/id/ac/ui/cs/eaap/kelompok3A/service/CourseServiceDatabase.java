package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.CourseMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceDatabase implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public CourseModel selectCourse(String idCourse) {
		// TODO Auto-generated method stub
		CourseModel course = courseMapper.selectCourse(idCourse);
		course.setPrecondition(courseMapper.selectPreconditions(idCourse));
		log.info("select course with id_course {}", idCourse);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourses(String idCurriculum) {
		// TODO Auto-generated method stub
		return courseMapper.selectAllCourses(idCurriculum);
	}

	@Override
	public void createCourse(CourseModel course) {
		// TODO Auto-generated method stub
		
		String initialUniv = course.getIdCourse();
		String last = courseMapper.getLastId(initialUniv+"%").getIdCourse();
		int count = Integer.parseInt(last.substring(last.length()-3, last.length()));
		count++;
		if(count < 10) {
			last = initialUniv + "C00" + count;
		} else if(count >= 10 && count < 100) {
			last = initialUniv + "C0" + count;
		} else {
			last = initialUniv + "C" + count;
		}
		course.setIdCourse(last);
		log.info("course " + course.getCourseName() + " created");
		courseMapper.createCourse(course);
	}

	@Override
	public void updateCourse(CourseModel course) {
		// TODO Auto-generated method stub
		log.info("course " + course.getCourseName() + " updated");
		courseMapper.updateCourse(course);
	}

	@Override
	public void deleteCourse(String idCourse) {
		// TODO Auto-generated method stub
		log.info("course " + idCourse + " deleted");
		courseMapper.deleteCourse(idCourse);
	}

	@Override
	public void addPreconditions(String idCourse, String idPreconditions) {
		// TODO Auto-generated method stub
		log.info("assign course " + idPreconditions + " as precondition of " + idCourse);
		courseMapper.addPreconditions(idCourse, idPreconditions);		
	}

	@Override
	public void deletePreconditions(String idCourse, String idPreconditions) {
		// TODO Auto-generated method stub
		log.info("remove course " + idPreconditions + " from precondition of " + idCourse);
		courseMapper.deletePreconditions(idCourse, idPreconditions);
	}

	@Override
	public List<CourseModel> selectCoursesFromUniv(String idCurriculum) {
		// TODO Auto-generated method stub
		String initial = idCurriculum.substring(0, idCurriculum.length()-4);
		log.info("select course from univ with initial {}", initial);
		return courseMapper.selectCoursesFromUniv(initial+"%");
	}

	@Override
	public void enableCourse(String name) {
		// TODO Auto-generated method stub
		log.info("course {} enabled", name);
		courseMapper.enableCourse(name);
	}

	@Override
	public CourseModel selectCourseByNameAndInitial(String name, String initial) {
		// TODO Auto-generated method stub
		log.info("select course with name = {} and univ = {}", name, initial);
		return courseMapper.selectCourseByNameAndInitial(name, initial+"%");
	}

	@Override
	public List<CourseModel> selectAllCourse() {
		// TODO Auto-generated method stub
		log.info("select all courses");
		return courseMapper.selectAllCourse();
	}

}
