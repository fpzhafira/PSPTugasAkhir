package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.LecturerAttendanceMapper;
import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerAttendanceModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LeccturerAttendanceServiceDatabase implements LecturerAttendanceService {

	@Autowired
	LecturerAttendanceMapper lecturerAttendanceMapper;

	@Override
	public void recordLecturerAttendance(String nik, String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Record student attendance with nik {}");
		lecturerAttendanceMapper.recordLecturerAttendance(nik, schedule_id);
	}

	@Override
	public void unrecordLecturerAttendance(String nik, String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Record student attendance with nik {}");
		lecturerAttendanceMapper.unrecordLecturerAttendance(nik, schedule_id);
	}
	
	@Override
	public List<LecturerAttendanceModel> viewLecturerAttendance(String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Select class with schedule_id {}");
		return lecturerAttendanceMapper.viewLecturerAttendance(schedule_id);
	}

	@Override
	public LecturerAttendanceModel selectLecturerAttendance(String nik, String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Select class with npm {}");
		return lecturerAttendanceMapper.selectLecturerAttendance(nik, schedule_id);
	}
}
