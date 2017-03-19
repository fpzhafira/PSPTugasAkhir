package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerAttendanceModel;

@Mapper
public interface LecturerAttendanceMapper {

	@Update ("UPDATE lecturer_attendance SET lecturer = 1 WHERE nik = #{nik} and schedule_id = #{schedule_id}")
	void recordLecturerAttendance(@Param("nik") String nik, @Param("schedule_id") String schedule_id);

	@Update ("UPDATE lecturer_attendance SET lecturer = 0 WHERE nik = #{nik} and schedule_id = #{schedule_id}")
	void unrecordLecturerAttendance(@Param("nik") String nik, @Param("schedule_id") String schedule_id);
	
	@Select("SELECT * FROM lecturer_attendance WHERE schedule_id = #{schedule_id}")
	List<LecturerAttendanceModel> viewLecturerAttendance(@Param("schedule_id") String schedule_id);

	@Select("SELECT * FROM lecturer_attendance WHERE nik = #{nik} and schedule_id = #{schedule_id}")
	LecturerAttendanceModel selectLecturerAttendance(@Param("nik") String nik, @Param("schedule_id") String schedule_id);
}
