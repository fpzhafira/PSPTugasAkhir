package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;

@Mapper
public interface CurriculumMapper {

	@Select("SELECT * FROM curriculum WHERE id_curriculum=#{idCurriculum} AND flag_active='1'")
	@Results(value = {
			@Result(property="idCurriculum", column="id_curriculum"),
			@Result(property="year", column="curriculum_year"),
			@Result(property="idMajor", column="id_major")
	})
	CurriculumModel selectCurriculum(String idCurriculum);
		
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum = #{idCurriculum})")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List<CourseModel> selectCourses(String idCurriculum);
	
	/*
	 * harusnya all curriculum dalam satu major ga si? solved
	 */
	@Select("SELECT * FROM curriculum WHERE id_major=#{idMajor} AND flag_active='1'")
	@Results(value = {
			@Result(property="idCurriculum", column="id_curriculum"),
			@Result(property="year", column="curriculum_year"),
			@Result(property="idMajor", column="id_major")
	})
	List<CurriculumModel> selectAllCurriculums(String idMajor);
	
	@Select("SELECT id_curriculum FROM curriculum WHERE id_curriculum LIKE #{initial} "
			+ "ORDER BY id_curriculum DESC LIMIT 1")
	@Results(value = {
			@Result(property="idCurriculum", column="id_curriculum")
	})
	CurriculumModel getLastId(@Param("initial") String initial);
	
	@Insert("INSERT INTO curriculum (id_curriculum, curriculum_year, id_major)"
			+ " VALUES (#{idCurriculum}, #{year}, #{idMajor})")
	void createCurriculum(CurriculumModel curriculum);
	
	@Update("UPDATE curriculum SET curriculum_year=#{year}, "
			+ "id_major=#{idMajor} WHERE id_curriculum = #{idCurriculum}")
	void updateCurriculum(CurriculumModel curriculum);
	
	@Update("UPDATE curriculum SET flag_active='0' WHERE id_curriculum=#{idCurriculum}")
	void deleteCurriculum(String idCurriculum);
	
	@Insert("INSERT INTO curriculum_course(id_course, id_curriculum, obligatory_flag) VALUES "
			+ "(#{idCourse}, #{idCurriculum}, #{obligatory})")
	void addCourse(@Param("idCourse") String idCourse, @Param("idCurriculum") String idCurriculum, 
			@Param("obligatory") String obligatory);
	

	/**
	 * 
	 * @param idMajor
	 * @param idTerm
	 * @return all courses assigned to a major in a specific term
	 * mungkin query-nya masi bisa dioptimasiin lagi, tp baru ini yang kepikiran
	 */
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT c.id_course FROM curriculum_course c "
			+ "JOIN course_availability a ON a.id_course=c.id_course "
			+ "WHERE c.id_curriculum=#{idCurriculum} AND a.id_term=#{idTerm})")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List<CourseModel> selectCourseOnTerm(@Param("idCurriculum") String idCurriculum, @Param("idTerm") String idTerm);
	
	/**
	 * 
	 * @param idMajor
	 * @return all obligatory (univ, groups, faculty, major) courses 
	 */
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum=#{idCurriculum} AND obligatory_flag<>'0000')")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List<CourseModel> selectAllObligatoryCourses(String idCurriculum);

	/**
	 * 
	 * @param idMajor
	 * @return all univ obligatory courses
	 */
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum=#{idCurriculum} AND obligatory_flag='1000')")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List <CourseModel> selectUnivObligatoryCourses(String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all group obligatory courses
	 */
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum=#{idCurriculum} AND obligatory_flag='0100')")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List <CourseModel> selectGroupObligatoryCourses(String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all faculty obligatory courses
	 */
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum=#{idCurriculum} AND obligatory_flag='0010')")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List <CourseModel> selectFacultyObligatoryCourses(String idCurriculum);
	
	/**
	 * 
	 * @param idMajor
	 * @return all major obligatory courses
	 */
	@Select("SELECT * FROM course WHERE flag_active='1' AND id_course IN "
			+ "(SELECT id_course FROM curriculum_course "
			+ "WHERE id_curriculum=#{idCurriculum} AND obligatory_flag='0001')")
	@Results(value = { 
			@Result(property = "idCourse", column = "id_course"),
			@Result(property = "courseName", column = "name"), 
			@Result(property = "sks", column = "sks"),
			@Result(property = "sksRequired", column = "sks_required")
	})
	List <CourseModel> selectMajorObligatoryCourses(String idCurriculum);
}
