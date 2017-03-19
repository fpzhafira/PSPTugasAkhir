package id.ac.ui.cs.eaap.kelompok3C.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceModel {
	private String schedule_id;
	private String npm;
	private boolean att_flag_student; 
	private Date date;
}
