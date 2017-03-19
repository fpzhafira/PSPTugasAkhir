package id.ac.ui.cs.eaap.kelompok3B.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3B.domain.CourseClassStudent;
import id.ac.ui.cs.eaap.kelompok3B.domain.Student;

@Mapper
public interface StudentMapper 
{
	//addStudent
	@Insert("INSERT INTO student (name, npm, id_univ, id_faculty, id_major) "
			+ "VALUES (#{name}, #{npm}, #{univId}, #{facultyId}, #{majorId})")
	void addStudent(Student student);
	
	// getStudent
	@Select("select name, npm, id_univ, id_faculty, id_major, id_curriculum "
			+ "from student "
			+ "where npm = #{npm} and deleted = 0")
	@Results(value = {
			@Result(property = "name", column = "name"),
			@Result(property = "npm", column = "npm"),
			@Result(property = "univId", column = "id_univ"),
			@Result(property = "facultyId", column = "id_faculty"),
			@Result(property = "majorId", column = "id_major"),			
			@Result(property = "curriculumId", column = "id_curriculum"),			
	})
	Student getStudent(@Param("npm") String npm);
	
	//update student
	@Update("UPDATE student "
			+ "set id_curriculum = #{curriculumId} where npm = #{npm}")
	void updateStudent(Student student); 
	
	//delete student
	@Update("UPDATE student set deleted = 1 where npm = #{npm}")
	void deleteStudent(@Param("npm") String npm);	
	
	@Select("SELECT id, npm, name, id_univ,id_faculty, id_major, id_curriculum "
			+ "FROM student "
			+ "where id_univ = #{id_univ} and "
			+ "id_faculty = #{id_faculty} and "
			+ "id_major = #{id_major} and "
			+ "npm LIKE #{batch} and "
			+ "deleted = 0")
	@Results(value = {
			@Result(property="npm",column="npm"),
			@Result(property="name",column="name"),
			@Result(property="univId",column="id_univ"),
			@Result(property="facultyId",column="id_faculty"),
			@Result(property="majorId",column="id_major"),
			@Result(property="curriculumId",column="id_curriculum"),
	})
	List<Student> getStudentByUnivIdFacultyIdMajorIdAndBatch(
		@Param("id_univ") String id_univ,
		@Param("id_faculty") String id_faculty,
		@Param("id_major") String id_major,
		@Param("batch") String batch);
	
	@Insert("INSERT INTO course_class_student (student_npm, id_course, id_class) VALUES (#{student_id}, #{course_id}, #{class_id})")
	void insertStudentCourse(@Param("student_id") String student_id,
			@Param("class_id") String class_id,
			@Param("course_id") String course_id);
	
	@Select("SELECT id_course FROM course_class_student WHERE student_npm = #{student_id}")	
	List<String> getCourseIdByStudentNpm(@Param("student_id") String student_id);
	
	@Update("update student "
			+ "set "
			+ "id_curriculum = #{cur_id}"
			+ "where npm = #{student_id}")
	void assignCurriculumToStudent(@Param("cur_id") String cur_id, @Param("student_id") String student_id);
	
	@Select("select distinct left(npm, 2) "
			+ "from student "
			+ "where id_univ = #{univ_id} and id_faculty = #{faculty_id} and id_major = #{major_id}")
	List<String> getAllOfStudentBatch(
			@Param("univ_id") String univ_id, 
			@Param("faculty_id") String faculty_id, 
			@Param("major_id") String major_id);
	
	@Select("SELECT id_course_required "
			+ "FROM pre_condition "
			+ "WHERE id_course = #{id_course}")
	List<String> getRequiredCourse(@Param("id_course") String id_course);
	
	@Select("SELECT id_course "
			+ "FROM course_class_student "
			+ "WHERE student_npm = #{student_id} AND course_status = 1")
	List<String> getTakenCourseClassByStudentNpm(@Param("student_id") String student_id);
	
	@Select("SELECT * "
			+ "FROM course_class_student "
			+ "WHERE student_npm = #{student_id} AND course_status = 1")
	@Results(value = {
					@Result(property="student_npm",column="student_npm"),
					@Result(property="class_id",column="id_class"),
					@Result(property="course_id",column="id_course"),
					@Result(property="grade",column="grade"),
					@Result(property="course_status",column="course_status"),
	})
	List<CourseClassStudent> getClassCourseStudentByStudentNpm(@Param("student_id") String student_id);	
	
	@Select("SELECT npm, name, id_univ, id_faculty, id_major, id_curriculum "
			+ "FROM student "
			+ "where username = #{username} and "
			+ "deleted = 0")
	@Results(value = {
			@Result(property="npm",column="npm"),
			@Result(property="name",column="name"),
			@Result(property="univId",column="id_univ"),
			@Result(property="facultyId",column="id_faculty"),
			@Result(property="majorId",column="id_major"),
			@Result(property="curriculumId",column="id_curriculum"),
	})
	Student getStudentByUsername(@Param("username") String username);
	
	@Select("select supervisor_nip "
			+ "from student_supervisor "
			+ "where student_npm = #{student_id} "
			+ "order by assigned_date desc "
			+ "limit 1")
	@Results(value={
			@Result(property="nip", column="supervisor_nip"),
			@Result(property="assignDate", column="assigned_date")
	})
	String getStudentCurrentSupervisor(@Param("student_id") String student_id);
	
	@Select("select name, npm, id_univ, id_faculty, id_major "
			+ "from student "
			+ "where id_univ = #{univId} and "
			+ "id_faculty = #{facultyId} and "
			+ "id_major = #{majorId} and "
			+ "deleted = 0")
	@Results(value = {
			@Result(property="npm",column="npm"),
			@Result(property="name",column="name"),
			@Result(property="univId",column="id_univ"),
			@Result(property="facultyId",column="id_faculty"),
			@Result(property="majorId",column="id_major")			
	})
	List<Student> getAllStudentByUnivFacultyMajor(
			@Param("univId") String univId, 
			@Param("facultyId") String facultyId, 
			@Param("majorId") String majorId);
}
