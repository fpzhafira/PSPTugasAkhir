package id.ac.ui.cs.eaap.kelompok3B.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3B.domain.CourseClassStudent;
import id.ac.ui.cs.eaap.kelompok3B.domain.Student;

public interface StudentService 
{
	void addStudent(Student student);
	
	Student getStudent(String student_id);
	
	void updateStudent(Student student);
	
	void deleteStudent(String student_id);	
	
	List<Student> getStudentByUnivIdFacultyIdMajorIdAndBatch(String id_univ,
			String id_faculty,
			String id_major,
			String batch);
	
	List<Student> getAllStudentByUnivFacultyMajor(String univId, String facultyId, String majorId);
	
	Student getStudentByUsername(String username);
	
	void insertStudentCourse(String student_id,
			String class_id,
			String course_id);
	
	List<String> getCourseIdByStudentNpm(String student_id);
	
	void assignCurriculumToStudent(String curriculum_id, String student_id);
	
	List<String> getAllOfStudentBatch(String univ_id, String faculty_id, String major_id);
	
	List<String> getRequiredCourse(String id_course);
	
	List<String> getTakenCourseClassByStudentNpm(String student_id);
	
	List<CourseClassStudent> getClassCourseStudentByStudentNpm(String student_id);
	
	boolean isStudentExist(String student_id);
}
