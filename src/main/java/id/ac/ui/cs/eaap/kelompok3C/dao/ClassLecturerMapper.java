package id.ac.ui.cs.eaap.kelompok3C.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import id.ac.ui.cs.eaap.kelompok3C.domain.ClassLecturerModel;

@Mapper
public interface ClassLecturerMapper {
	
	@Insert ("INSERT INTO class_lecturer (class_id, nip) VALUES (#{class_id}, #{nip})")
	void setLecturer(ClassLecturerModel classLecturer);

	@Select ("SELECT class_id, nip FROM class_lecturer WHERE class_id = #{class_id} AND nip = #{nip}")
	ClassLecturerModel selectLecturerByClass(@Param("class_id") String class_id, @Param ("nip") String nip);
}
