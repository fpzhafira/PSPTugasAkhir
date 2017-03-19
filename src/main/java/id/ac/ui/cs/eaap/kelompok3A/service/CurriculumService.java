package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;

public interface CurriculumService {

	CurriculumModel selectCurriculum(String idCurriculum);
	
	List<CurriculumModel> selectAllCurriculums(String idMajor);
	
	void createCurriculum(CurriculumModel curriculum);
	
	void updateCurriculum(CurriculumModel curriculum);
	
	void deleteCurriculum(String idCurriculum);
	
	void addCourse(String idCourse, String idCurriculum, String obligatory);

	/**
	 * 
	 * @param idMajor
	 * @param idTerm
	 * @return all courses assigned to a major in a specific term
	 */
	//List<CourseModel> selectCourseOnTerm(String idCurriculum, String idTerm);
	List<CourseModel> selectCourseOnTerm(String idTerm, String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all obligatory (univ, groups, faculty, major) courses 
	 */
	List<CourseModel> selectAllObligatoryCourses(String idCurriculum);

	/**
	 * 
	 * @param idMajor
	 * @return all univ obligatory courses
	 */
	List <CourseModel> selectUnivObligatoryCourses(String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all group obligatory courses
	 */
	List <CourseModel> selectGroupObligatoryCourses(String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all faculty obligatory courses
	 */
	List <CourseModel> selectFacultyObligatoryCourses(String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all major obligatory courses
	 */
	List <CourseModel> selectMajorObligatoryCourses(String idCurriculum);

}
