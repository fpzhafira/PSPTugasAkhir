package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;

public interface CourseService {

	CourseModel selectCourse(String idCourse);
	
	CourseModel selectCourseByNameAndInitial(String name, String initial);
	
	List<CourseModel> selectAllCourse();
	
	List<CourseModel> selectAllCourses(String idCurriculum);
	
	List<CourseModel> selectCoursesFromUniv(String initial);
	
	void createCourse(CourseModel course);
	
	void updateCourse(CourseModel course);
	
	void deleteCourse(String idCourse);
	
	void addPreconditions (String idCourse, String idPreconditions);
	
	void deletePreconditions (String idCourse, String idPreconditions);
	
	void enableCourse(String name);
}