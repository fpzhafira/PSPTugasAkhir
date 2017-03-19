package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;

@Mapper
public interface ClassesMapper {
	
	@Select("SELECT * FROM classes")
	List<ClassesModel> viewAllClass();
	
	@Select("SELECT * FROM classes WHERE class_id = #{class_id}")
	ClassesModel viewClassInfo (String class_id);
	
	@Delete("DELETE FROM classes WHERE class_id = #{class_id}")
	void deleteClass (String class_id);
	
	@Update("UPDATE classes SET class_id = #{class_id}, major_id = #{major_id}, course_id = #{course_id}, course_name = #{course_name},"
			+ "class_name = #{class_name}, schedule = #{schedule}, classroom = #{classroom}, lecturer = #{lecturer}, id_term = #{id_term}, class_flag = 1 WHERE class_id = #{class_id}")
	void editClass (ClassesModel classes);
	
	@Insert("INSERT INTO classes (class_id, major_id, course_id, class_name, schedule, classroom, lecturer, id_term, class_flag) VALUES (#{class_id}, #{major_id}, #{course_id}, #{class_name}, #{schedule}, #{classroom}, #{lecturer}, #{id_term}, 1)")
	void addClass (ClassesModel classes);
	
	@Select("SELECT * FROM classes WHERE id_term = #{id_term}")
	List<ClassesModel> viewClassByTerm(Integer id_term);
}
