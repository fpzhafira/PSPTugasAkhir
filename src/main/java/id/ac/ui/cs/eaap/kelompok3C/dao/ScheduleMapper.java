package id.ac.ui.cs.eaap.kelompok3C.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import id.ac.ui.cs.eaap.kelompok3C.domain.ScheduleModel;

@Mapper
public interface ScheduleMapper {

	@Select("SELECT * FROM schedule")
	List<ScheduleModel> viewAllSchedule();

	@Select("SELECT * FROM schedule WHERE schedule_id = #{schedule_id}")
	ScheduleModel viewScheduleInfo(String schedule_id);
}
