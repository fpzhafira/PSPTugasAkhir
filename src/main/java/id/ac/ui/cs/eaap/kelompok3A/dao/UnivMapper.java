package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;

@Mapper
public interface UnivMapper {

	@Select("SELECT id_univ, name, telephone_number, address, initial_univ, accreditation "
			+ "FROM univ WHERE id_univ=#{idUniv} AND flag_active='1'")
	@Results(value = {
			@Result(property="idUniv", column="id_univ"),
			@Result(property="univName", column="name"),
			@Result(property="initial", column="initial_univ"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="address", column="address"),
			@Result(property="accreditation", column="accreditation")
	})
	UnivModel selectUniv(String idUniv);
	
	@Select("SELECT id_univ, name, telephone_number, address, initial_univ, accreditation "
			+ "FROM univ WHERE id_univ=#{idUniv}")
	@Results(value = {
			@Result(property="idUniv", column="id_univ"),
			@Result(property="univName", column="name"),
			@Result(property="initial", column="initial_univ"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="address", column="address"),
			@Result(property="accreditation", column="accreditation")
	})
	UnivModel selectDisabledUniv(String idUniv);
	
	@Select("SELECT faculty.id_faculty, faculty.name FROM faculty join univ on "
			+ "faculty.id_univ = univ.id_univ "
			+ "WHERE univ.id_univ=#{idUniv} AND faculty.flag_active='1'")
	@Results(value = {
			@Result(property="idFaculty", column="id_faculty"),
			@Result(property="facultyName", column="name")
	})
	List<FacultyModel> selectFaculties(String idUniv);
	
	@Select("SELECT id_univ, name, telephone_number, address, initial_univ, accreditation FROM univ "
			+ "WHERE flag_active='1'")
	@Results(value = {
			@Result(property="idUniv", column="id_univ"),
			@Result(property="univName", column="name"),
			@Result(property="initial", column="initial_univ"),
			@Result(property="telephoneNumber", column="telephone_number"),
			@Result(property="address", column="address"),
			@Result(property="accreditation", column="accreditation")
	})
	List<UnivModel> selectAllUnivs();
	
	@Select("SELECT id_univ FROM univ ORDER BY id_univ DESC LIMIT 1")
	@Results(value = {
			@Result(property="idUniv", column="id_univ")
	})
	UnivModel getLastUniv();
	
	@Insert("INSERT INTO univ (id_univ, name, telephone_number, address, initial_univ, accreditation) "
			+ "VALUES (#{idUniv}, #{univName}, #{telephoneNumber}, #{address}, #{initial}, #{accreditation})")
	void createUniv(UnivModel univ);
	
	@Update("UPDATE univ SET name=#{univName}, telephone_number=#{telephoneNumber}, "
			+ "address=#{address}, initial_univ=#{initial}, accreditation=#{accreditation} "
			+ "WHERE id_univ=#{idUniv}")
	void updateUniv(UnivModel univ);
	
	@Update("UPDATE univ SET flag_active='0' WHERE id_univ=#{idUniv}")
	void deleteUniv(String idUniv);
	
	@Update("UPDATE univ SET flag_active='1' WHERE id_univ=#{idUniv}")
	void enableUniv(String idUniv);
	
	@Select("SELECT id_univ, initial_univ, flag_active FROM univ WHERE initial_univ=#{name}")
	@Results(value = {
		@Result(property="idUniv", column="id_univ"),
		@Result(property="initial", column="initial_univ"),
		@Result(property="telephoneNumber", column="flag_active") //check enable or disable
	})
	UnivModel selectInitialByName(String name);
	
//	@Select("SELECT id_univ, initial_univ, flag_active FROM univ WHERE initial_univ=#{name}")
//	@Results(value = {
//		@Result(property="idUniv", column="id_univ"),
//		@Result(property="initial", column="initial_univ"),
//		@Result(property="telephoneNumber", column="flag_active") //check enable or disable
//	})
//	UnivModel selectUnivByInitial(String initial);

	@Select("SELECT id_univ, name, flag_active FROM univ WHERE name=#{name}")
	@Results(value = {   
		@Result(property="univName", column="name"),
		@Result(property="idUniv", column="id_univ"),
		@Result(property="telephoneNumber", column="flag_active") //check enable or disable
	})
	UnivModel selectUnivByName(String name);
}