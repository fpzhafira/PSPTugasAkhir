package id.ac.ui.cs.eaap.kelompok3C.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleModel {
	private String schedule_id;
	private String day;
	private String time_start;
	private String time_end;
}
