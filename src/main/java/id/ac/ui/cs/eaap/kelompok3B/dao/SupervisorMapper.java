package id.ac.ui.cs.eaap.kelompok3B.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3B.domain.Supervisor;

@Mapper
public interface SupervisorMapper 
{
	@Select("select * from student_supervisor where student_npm = #{student_id} order by assigned_date desc limit 1")
	@Results(value={
		@Result(property="nip", column="supervisor_nip"),
		@Result(property="assignDate", column="assigned_date")
	})
	Supervisor getSupervisor(@Param("student_id") String student_id);
	
	@Insert("insert into student_supervisor "
			+ "(student_npm, supervisor_nip, assigned_date) values "
			+ "(#{student_id}, #{nip}, #{assignDate})")
	void setSupervisor(@Param("student_id") String student_id, @Param("nip") String nip, @Param("assignDate") Date assignDate);
	
	@Update("UPDATE student_supervisor SET supervisor_nip = #{nip} WHERE student_npm = #{student_id}")
	void updateStudenSuperviorByNpm(@Param("student_id") String student_id, @Param("nip") String nip);
}
