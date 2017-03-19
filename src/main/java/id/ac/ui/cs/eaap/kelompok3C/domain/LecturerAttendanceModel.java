package id.ac.ui.cs.eaap.kelompok3C.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LecturerAttendanceModel {
	private String schedule_id;
	private String nik;
	private boolean att_flag_lecturer; 
	private Date date;
}
