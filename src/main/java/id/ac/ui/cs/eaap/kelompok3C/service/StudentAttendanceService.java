package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.StudentAttendanceModel;

public interface StudentAttendanceService {
	public void recordStudentAttendance(String npm, String schedule_id);
	public void unrecordStudentAttendance(String npm, String schedule_id);
	public List<StudentAttendanceModel> viewStudentAttendance (String schedule_id);
	public StudentAttendanceModel selectStudentAttendance (String npm, String schedule_id);
}
