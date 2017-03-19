package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.ScheduleMapper;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.ScheduleModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduleServiceDatabase implements ScheduleService {

	@Autowired
	ScheduleMapper scheduleMapper;

	@Override
	public List<ScheduleModel> viewAllSchedule() {
		// TODO Auto-generated method stub
		log.info("Select all classes");
		return scheduleMapper.viewAllSchedule();
	}
	
	@Override
	public ScheduleModel viewScheduleInfo(String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Select class with class_id {}");
		return scheduleMapper.viewScheduleInfo(schedule_id);
	}
	
	
}
