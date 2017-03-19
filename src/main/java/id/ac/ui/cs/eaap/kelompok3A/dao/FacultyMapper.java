package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;

@Mapper
public interface FacultyMapper {

	@Select("SELECT * FROM faculty WHERE id_faculty=#{idFaculty} AND flag_active='1'")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
			@Result(property="facultyName", column="name"),
			@Result(property="idGroup", column="id_group"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="accreditation", column="accreditation"),
			@Result(property="idUniv", column="id_univ")
	})
	FacultyModel selectFaculty(String idFaculty);
	
	@Select("SELECT * FROM faculty WHERE id_faculty=#{idFaculty}")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
			@Result(property="facultyName", column="name"),
			@Result(property="idGroup", column="id_group"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="accreditation", column="accreditation"),
			@Result(property="idUniv", column="id_univ")
	})
	FacultyModel selectDisabledFaculty(String idFaculty);
	
	@Select("SELECT id_faculty, name, id_group, flag_active FROM faculty WHERE name=#{name} AND id_group=#{idGroup}")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
			@Result(property="facultyName", column="name"),
			@Result(property="idGroup", column="id_group"),
			@Result(property="telephoneNumber", column="flag_active")
	})
	FacultyModel selectFacultyByNameAndGroup(@Param("name") String name, @Param("idGroup") String idGroup);
	
	@Select("SELECT id_faculty FROM faculty WHERE id_faculty LIKE #{initial} ORDER BY id_faculty DESC LIMIT 1")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
	})
	FacultyModel getLastId(String initial);
	
	@Select("SELECT id_major, major.name FROM major JOIN faculty ON "
			+ "major.id_faculty = faculty.id_faculty "
			+ "WHERE faculty.id_faculty=#{idFaculty} AND major.flag_active='1'")
	@Results(value = {
			@Result(property="idMajor", column="id_major"),
			@Result(property="majorName", column="name")
	})
	List<MajorModel> selectMajors(String idFaculty);
	
	@Select("SELECT f.id_faculty, f.name, f.id_group, f.telephone_number, "
			+ "f.accreditation FROM faculty f join univ u "
			+ "ON f.id_univ=u.id_univ WHERE u.id_univ=#{idUniv} AND f.flag_active='1'")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
			@Result(property="facultyName", column="name"),
			@Result(property="idGroup", column="id_group"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="accreditation", column="accreditation")
	})
	List<FacultyModel> selectAllFaculties(String idUniv);
	
	@Insert("INSERT INTO faculty (id_faculty, name, telephone_number, accreditation, id_group, id_univ)VALUES "
			+ "(#{idFaculty}, #{facultyName}, #{telephoneNumber}, #{accreditation}, "
			+ "#{idGroup}, #{idUniv})")
	void createFaculty(FacultyModel faculty);
	
	@Update("UPDATE faculty SET name=#{facultyName}, "
			+ "telephone_number=#{telephoneNumber}, accreditation=#{accreditation}, "
			+ "id_group=#{idGroup}, id_univ=#{idUniv} "
			+ "WHERE id_faculty = #{idFaculty}")
	void updateFaculty(FacultyModel faculty);
	
	@Update("UPDATE faculty SET flag_active='0' WHERE id_faculty=#{idFaculty}")
	void deleteFaculty(String idFaculty);
	
	@Update("UPDATE faculty SET flag_active='1' WHERE id_faculty=#{idFaculty}")
	void enableFaculty(String idFaculty);
}
