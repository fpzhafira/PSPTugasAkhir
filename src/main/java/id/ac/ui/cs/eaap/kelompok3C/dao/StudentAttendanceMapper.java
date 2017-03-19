package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3C.domain.StudentAttendanceModel;

@Mapper
public interface StudentAttendanceMapper {

	@Update ("UPDATE student_attendance SET att_flag_student = 1 WHERE npm = #{npm} and schedule_id = #{schedule_id}")
	void recordStudentAttendance(@Param("npm") String npm, @Param("schedule_id") String schedule_id);

	@Update ("UPDATE student_attendance SET att_flag_student = 0 WHERE npm = #{npm} and schedule_id = #{schedule_id}")
	void unrecordStudentAttendance(@Param("npm") String npm, @Param("schedule_id") String schedule_id);
	
	@Select("SELECT * FROM student_attendance WHERE schedule_id = #{schedule_id}")
	List<StudentAttendanceModel> viewStudentAttendance(@Param("schedule_id") String schedule_id);

	@Select("SELECT * FROM student_attendance WHERE npm = #{npm} and schedule_id = #{schedule_id}")
	StudentAttendanceModel selectStudentAttendance(@Param("npm") String npm, @Param("schedule_id") String schedule_id);
}
