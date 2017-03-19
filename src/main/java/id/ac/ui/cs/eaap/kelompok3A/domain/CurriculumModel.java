package id.ac.ui.cs.eaap.kelompok3A.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumModel {
	private String idCurriculum;
	private String year;	
	private String idMajor;
	private List<CourseModel> courses;

}