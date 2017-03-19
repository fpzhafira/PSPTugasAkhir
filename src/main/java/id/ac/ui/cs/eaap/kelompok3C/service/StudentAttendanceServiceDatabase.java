package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.StudentAttendanceMapper;
import id.ac.ui.cs.eaap.kelompok3C.domain.StudentAttendanceModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentAttendanceServiceDatabase implements StudentAttendanceService {

	@Autowired
	StudentAttendanceMapper studentAttendanceMapper;

	@Override
	public void recordStudentAttendance(String npm, String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Record student attendance with npm {}");
		studentAttendanceMapper.recordStudentAttendance(npm, schedule_id);
	}
	
	@Override
	public void unrecordStudentAttendance(String npm, String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Record student attendance with npm {}");
		studentAttendanceMapper.unrecordStudentAttendance(npm, schedule_id);
	}

	@Override
	public List<StudentAttendanceModel> viewStudentAttendance(String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Select class with schedule_id {}");
		return studentAttendanceMapper.viewStudentAttendance(schedule_id);
	}

	@Override
	public StudentAttendanceModel selectStudentAttendance(String npm, String schedule_id) {
		// TODO Auto-generated method stub
		log.info("Select class with npm {}");
		return studentAttendanceMapper.selectStudentAttendance(npm, schedule_id);
	}
}
