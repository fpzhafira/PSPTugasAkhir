package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;

@Mapper
public interface CourseMapper {

	@Select("SELECT * FROM course WHERE id_course=#{idCourse} AND flag_active = 1")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"),
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	CourseModel selectCourse(String idCourse);
	
	@Select("SELECT * FROM course WHERE name=#{name} AND id_course LIKE #{initial}")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"),
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	CourseModel selectCourseByNameAndInitial(@Param("name") String name, @Param("initial") String initial);
		
	@Select("SELECT * FROM course WHERE id_course LIKE #{initial} AND flag_active = 1")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"),
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List<CourseModel> selectCoursesFromUniv(String initial);
	
	@Select("SELECT id_course, name, sks, sks_required FROM course WHERE flag_active = 1 AND id_course IN "
			+ "(SELECT p.id_course_required FROM pre_condition p WHERE id_course = #{idCourse})")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List<CourseModel> selectPreconditions(String idCourse);
	
	@Select("SELECT id_course FROM course WHERE id_course LIKE #{initial} ORDER BY id_course DESC LIMIT 1")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course")
	})
	CourseModel getLastId(String initial);

	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum=#{idCurriculum})")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List<CourseModel> selectAllCourses(String idCurriculum);
	
	@Insert("INSERT INTO course (id_course, name, sks, sks_required) VALUES (#{idCourse}, #{courseName}, "
			+ "#{sks}, #{sksRequired})")
	void createCourse(CourseModel course);
	
	@Update("UPDATE course SET name=#{courseName}, "
			+ "sks=#{sks}, sks_required=#{sksRequired} "
			+ "WHERE id_course = #{idCourse}")
	void updateCourse(CourseModel course);

	@Update("UPDATE course SET flag_active='0' WHERE id_course=#{idCourse}")
	void deleteCourse(String idCourse);
	
	@Insert("INSERT INTO pre_condition VALUES (#{idCourse}, #{idPreconditions})")
	void addPreconditions (@Param("idCourse") String idCourse, @Param("idPreconditions") String idPreconditions);
	
	@Delete("DELETE FROM pre_condition WHERE id_course=#{idCourse} AND id_course_required=#{idPreconditions}")
	void deletePreconditions (@Param("idCourse") String idCourse, @Param("idPreconditions") String idPreconditions);
	
	@Update("UPDATE course SET flag_active='1' WHERE name=#{name}")
	void enableCourse(String name);

	@Select("SELECT * FROM course WHERE flag_active='1'")
	List<CourseModel> selectAllCourse();
}
