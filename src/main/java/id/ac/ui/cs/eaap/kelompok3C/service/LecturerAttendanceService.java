package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerAttendanceModel;

public interface LecturerAttendanceService {
	public void recordLecturerAttendance(String nik, String schedule_id);
	public void unrecordLecturerAttendance(String nik, String schedule_id);
	public List<LecturerAttendanceModel> viewLecturerAttendance (String schedule_id);
	public LecturerAttendanceModel selectLecturerAttendance (String nik, String schedule_id);
}
