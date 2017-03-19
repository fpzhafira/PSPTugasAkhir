package id.ac.ui.cs.eaap.kelompok3A.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3A.domain.GroupModel;

@Mapper
public interface GroupMapper {

	@Select("SELECT * FROM groups WHERE id_group=#{idGroup} AND flag_active='1'")
	@Results(value = {
			@Result(property="idGroup", column="id_group"),
			@Result(property="groupName", column="name"),
			@Result(property="idUniv", column="id_univ"),
	})
	GroupModel selectGroup(String idGroup);
	
	@Select("SELECT * FROM groups WHERE id_group=#{idGroup}")
	@Results(value = {
			@Result(property="idGroup", column="id_group"),
			@Result(property="groupName", column="name"),
			@Result(property="idUniv", column="id_univ"),
	})
	GroupModel selectDisabledGroup(String idGroup);
	
	@Select("SELECT name, id_group, flag_active FROM groups WHERE name=#{name} AND id_univ=#{idUniv}")
	@Results(value = {
			@Result(property="groupName", column="name"),
			@Result(property="idGroup", column="id_group"),
			@Result(property="idUniv", column="flag_active")
	})
	GroupModel selectGroupByNameAndUniv(@Param("name") String name, @Param("idUniv") String idUniv);
	
	@Select("SELECT * FROM groups WHERE id_univ=#{idUniv} AND flag_active='1'")
	@Results(value = {
			@Result(property="idGroup", column="id_group"),
			@Result(property="groupName", column="name"),
			@Result(property="idUniv", column="id_univ"),
	})
	List<GroupModel> selectAllGroups(String idUniv);
	
	@Insert("INSERT INTO groups (id_group, name, id_univ) "
			+ "VALUES (#{idGroup}, #{groupName}, #{idUniv})")
	void createGroup(GroupModel group);
	
	@Update("UPDATE groups SET name=#{groupName}, "
			+ "id_univ=#{idUniv} WHERE id_group=#{idGroup}")
	void updateGroup(GroupModel group);
	
	@Update("UPDATE groups SET flag_active='0' WHERE id_group=#{idGroup}")
	void deleteGroup(String idGroup);
	
	@Update("UPDATE groups SET flag_active='1' WHERE id_group=#{idGroup}")
	void enableGroup(String idGroup);
}
