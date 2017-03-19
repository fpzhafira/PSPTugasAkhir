package id.ac.ui.cs.eaap.kelompok3C.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.eaap.kelompok3C.domain.LecturerAttendanceModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.ScheduleModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.StudentAttendanceModel;
import id.ac.ui.cs.eaap.kelompok3C.service.LecturerAttendanceService;
import id.ac.ui.cs.eaap.kelompok3C.service.ScheduleService;
import id.ac.ui.cs.eaap.kelompok3C.service.StudentAttendanceService;

@Controller

@RequestMapping("/sekre")
public class AttendanceController {

	@Autowired
	StudentAttendanceService studentAttendanceDAO;
	
	@Autowired
	LecturerAttendanceService lecturerAttendanceDAO;
	
	@Autowired
	ScheduleService scheduleDAO;
	
	@RequestMapping("/schedule/viewAll")
	public String viewAllClass(Model model) {
		List<ScheduleModel> schedule = scheduleDAO.viewAllSchedule();
		model.addAttribute("schedule", schedule);
		return "classes/view-all-schedule";
	}
	
	@RequestMapping("/schedule/student-attendance/{schedule_id}")
	public String studentAttendance(@PathVariable(value = "schedule_id") String schedule_id, Model model) {
		ScheduleModel schedule = scheduleDAO.viewScheduleInfo(schedule_id);
		List<StudentAttendanceModel> studentAttendance = studentAttendanceDAO.viewStudentAttendance(schedule_id);
		model.addAttribute("schedule", schedule);
		model.addAttribute("studentAttendance", studentAttendance);
		return "classes/student-attendance";
	}
	
	@RequestMapping("/schedule/student-attendance/{schedule_id}/{npm}")
    public String recordStudentAttendance (@PathVariable(value = "npm") String npm, @PathVariable(value = "schedule_id") String schedule_id, Model model)
    {
		StudentAttendanceModel student = studentAttendanceDAO.selectStudentAttendance(npm, schedule_id);
		ScheduleModel schedule = scheduleDAO.viewScheduleInfo(schedule_id);
		
		if (student.isAtt_flag_student()) {
			studentAttendanceDAO.unrecordStudentAttendance(student.getNpm(), student.getSchedule_id());
		} else {
			studentAttendanceDAO.recordStudentAttendance(student.getNpm(), student.getSchedule_id());
		}
		
		List<StudentAttendanceModel> studentAttendance = studentAttendanceDAO.viewStudentAttendance(schedule_id);
		model.addAttribute("schedule", schedule);
		model.addAttribute("studentAttendance", studentAttendance);
	    return "classes/student-attendance";
    }
	
	@RequestMapping("/schedule/lecturer-attendance/{schedule_id}")
	public String LecturerAttendance(@PathVariable(value = "schedule_id") String schedule_id, Model model) {
		ScheduleModel schedule = scheduleDAO.viewScheduleInfo(schedule_id);
		List<LecturerAttendanceModel> lecturerAttendance = lecturerAttendanceDAO.viewLecturerAttendance(schedule_id);
		model.addAttribute("schedule", schedule);
		model.addAttribute("lecturerAttendance", lecturerAttendance);
		return "classes/lecturer-attendance";
	}
	
	@RequestMapping("/schedule/lecturer-attendance/{schedule_id}/{nik}")
    public String recordLecturerAttendance (@PathVariable(value = "nik") String nik, @PathVariable(value = "schedule_id") String schedule_id, Model model)
    {
		LecturerAttendanceModel lecturer = lecturerAttendanceDAO.selectLecturerAttendance(nik, schedule_id);
		ScheduleModel schedule = scheduleDAO.viewScheduleInfo(schedule_id);
		
		if (lecturer.isAtt_flag_lecturer()) {
			lecturerAttendanceDAO.unrecordLecturerAttendance(lecturer.getNik(), lecturer.getSchedule_id());
		} else {
			lecturerAttendanceDAO.recordLecturerAttendance(lecturer.getNik(), lecturer.getSchedule_id());
		}
		
		List<LecturerAttendanceModel> lecturerAttendance = lecturerAttendanceDAO.viewLecturerAttendance(schedule_id);
		model.addAttribute("schedule", schedule);
		model.addAttribute("lecturerAttendance", lecturerAttendance);
	    return "classes/lecturer-attendance";
    }
}
