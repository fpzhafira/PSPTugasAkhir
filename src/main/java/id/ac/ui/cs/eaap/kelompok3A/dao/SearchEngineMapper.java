package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;

@Mapper
public interface SearchEngineMapper {

	/*
	 * methods for search course
	 */
	@Select("select * from course where name like #{name} AND sks = #{sks} AND sks_required = #{sksRequired} "
			+ "AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourse(@Param("name") String name, @Param("sks") String sks, @Param("sksRequired") String sksRequired);
	
	@Select("select * from course where name like #{name} AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourseByName(@Param("name") String name);
	
	@Select("select * from course where name like #{name} AND sks = #{sks} AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourseByNameAndSks(@Param("name") String name, @Param("sks") String sks);
	
	@Select("select * from course where name like #{name} AND sks_required = #{sksRequired} AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourseByNameAndSksRequired(@Param("name") String name, @Param("sksRequired") String sksRequired);
	
	@Select("select * from course where sks = #{sks} AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourseBySks(@Param("sks") String sks);
	
	@Select("select * from course where sks = #{sks} AND sks_required = #{sksRequired} AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourseBySksAndSksRequired(@Param("sks") String sks, @Param("sksRequired") String sksRequired);
	
	@Select("select * from course where sks_required = #{sksRequired} AND flag_active='1'")
	@Results(value = {
				@Result(property="idCourse", column="id_course"),
				@Result(property="courseName", column="name"),
				@Result(property="sks", column="sks"),
				@Result(property="sksRequired", column="sks_required")
			})
	List<CourseModel> searchCourseBySksRequired(@Param("sksRequired") String sksRequired);
	
	/*
	 * methods for search univ	
	 */
	@Select("SELECT * FROM univ WHERE name LIKE #{name} AND flag_active='1'")
	@Results(value = {
			@Result(property="idUniv", column="id_univ"),
			@Result(property="univName", column="name"),
			@Result(property="initial", column="initial_univ"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="address", column="address"),
			@Result(property="accreditation", column="accreditation")
	})
	List<UnivModel> searchUniv(@Param("name") String name);
	
	/*
	 * methods for search faculty	
	 */
	@Select("SELECT * FROM faculty WHERE name LIKE #{name} AND flag_active='1'")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
			@Result(property="facultyName", column="name"),
			@Result(property="idGroup", column="id_group"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="accreditation", column="accreditation"),
			@Result(property="idUniv", column="id_univ")
	})
	List<FacultyModel> searchFaculty(@Param("name") String name);
	
	/*
	 * methods for search major	
	 */
	@Select("SELECT * FROM major WHERE name LIKE #{name} AND flag_active='1'")
	@Results(value = {
			@Result(property="idMajor", column="id_major"),
			@Result(property="majorName", column="name"),
			@Result(property="idFaculty", column="id_faculty")
	})
	List<MajorModel> searchMajor(@Param("name") String name);
}
