package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.ScheduleModel;

public interface ScheduleService {
	public ScheduleModel viewScheduleInfo (String schedule_id);
	public List<ScheduleModel> viewAllSchedule();
}
