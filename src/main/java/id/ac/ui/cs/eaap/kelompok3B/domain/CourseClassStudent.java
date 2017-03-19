package id.ac.ui.cs.eaap.kelompok3B.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseClassStudent {
	private String studentNpm;
	private String classId;
	private String courseId;
	private int grade;
	private int courseStatus;
}
