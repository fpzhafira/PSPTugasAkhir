package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;

@Mapper
public interface MajorMapper {
	
	@Select("SELECT * FROM major WHERE id_major = #{idMajor} AND flag_active='1'")
	@Results(value = {
			@Result(property="idMajor", column="id_major"),
			@Result(property="majorName", column="name"),
			@Result(property="idFaculty", column="id_faculty")
	})
	MajorModel selectMajor(String idMajor);
	
	@Select("SELECT * FROM major WHERE id_major = #{idMajor}")
	@Results(value = {
			@Result(property="idMajor", column="id_major"),
			@Result(property="majorName", column="name"),
			@Result(property="idFaculty", column="id_faculty")
	})
	MajorModel selectDisabledMajor(String idMajor);
	
	@Select("SELECT name, id_major, flag_active FROM major WHERE name=#{name} AND id_faculty=#{idFaculty}")
	@Results(value = {
			@Result(property="majorName", column="name"),
			@Result(property="idFaculty", column="flag_active"),
			@Result(property="idMajor", column="id_major")
	})
	MajorModel selectMajorByNameAndFaculty(@Param("name") String name, @Param("idFaculty") String idFaculty);
	
	@Select("SELECT id_major FROM major WHERE id_major LIKE #{initial} ORDER BY id_major DESC LIMIT 1")
	@Results(value = {
			@Result(property="idMajor", column="id_major")
	})
	MajorModel getLastId(String initial);
	
	/**
	 * param idUniv sebenernya ga kepake
	 * @param idUniv
	 * @param idFaculty
	 * @return
	 */
	@Select("select id_major, name from major where id_faculty  = #{idFaculty} AND flag_active='1'")
	@Results(value = { @Result(property = "idMajor", column = "id_major"),
			@Result(property = "majorName", column = "name") })
	List<MajorModel> selectAllMajors(String idFaculty);

	@Insert("INSERT INTO major (id_major, name, id_faculty) VALUES "
			+ "(#{idMajor}, #{majorName}, #{idFaculty})")
	void createMajor(MajorModel major);
	
	@Update("UPDATE major SET name=#{majorName}, id_faculty=#{idFaculty} "
			+ "WHERE id_major=#{idMajor}")
	void updateMajor(MajorModel major);
	
	@Update("UPDATE major SET flag_active='0' WHERE id_major=#{idMajor}")
	void deleteMajor(String idMajor);
	
	@Update("UPDATE major SET flag_active='1' WHERE id_major=#{idMajor}")
	void enableMajor(String idMajor);
}
