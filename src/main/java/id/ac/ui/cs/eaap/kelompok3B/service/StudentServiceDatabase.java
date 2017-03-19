package id.ac.ui.cs.eaap.kelompok3B.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3B.dao.StudentMapper;
import id.ac.ui.cs.eaap.kelompok3B.domain.CourseClassStudent;
import id.ac.ui.cs.eaap.kelompok3B.domain.Student;

@Service
public class StudentServiceDatabase implements StudentService 
{
	@Autowired
	StudentMapper mapper;

	@Override
	public void addStudent(Student student) {
		mapper.addStudent(student);		
	}
	
	@Override
	public Student getStudent(String student_id) {
		return mapper.getStudent(student_id);
	}
	
	@Override
	public void updateStudent(Student student) {
		mapper.updateStudent(student);		
	}

	@Override
	public void deleteStudent(String student_id) {
		mapper.deleteStudent(student_id);	
	}
	@Override
	public List<Student> getStudentByUnivIdFacultyIdMajorIdAndBatch(
			String id_univ,
			String id_faculty,
			String id_major,
			String batch) {
		return mapper.getStudentByUnivIdFacultyIdMajorIdAndBatch(id_univ, id_faculty, id_major, batch);
	}
	
	@Override
	public void insertStudentCourse(String student_id,
			String class_id,
			String course_id){
		mapper.insertStudentCourse(course_id, class_id, course_id);
	}
	
	@Override
	public List<String> getCourseIdByStudentNpm(String student_id) {
		return mapper.getCourseIdByStudentNpm(student_id);
	}
	
	@Override
	public void assignCurriculumToStudent(String curriculum_id, String student_id) {
		mapper.assignCurriculumToStudent(curriculum_id, student_id);
	}

	@Override
	public List<String> getAllOfStudentBatch(String univ_id, String faculty_id, String major_id) {		
		return mapper.getAllOfStudentBatch(univ_id, faculty_id, major_id);
	}
	
	@Override
	public List<String> getRequiredCourse(String id_course) {
		return mapper.getRequiredCourse(id_course);
	}
	
	@Override
	public List<String> getTakenCourseClassByStudentNpm(String student_id){
		return mapper.getTakenCourseClassByStudentNpm(student_id);
	}
	
	@Override
	public List<CourseClassStudent> getClassCourseStudentByStudentNpm(String student_id) {
		return mapper.getClassCourseStudentByStudentNpm(student_id);
	}

	@Override
	public boolean isStudentExist(String student_id) {
		Student s = mapper.getStudent(student_id);		
		return (s != null) ? true : false;
	}

	@Override
	public List<Student> getAllStudentByUnivFacultyMajor(String univId, String facultyId, String majorId) {
		return mapper.getAllStudentByUnivFacultyMajor(univId, facultyId, majorId);
	}

	@Override
	public Student getStudentByUsername(String username) {
		return mapper.getStudentByUsername(username);
	}	
}
