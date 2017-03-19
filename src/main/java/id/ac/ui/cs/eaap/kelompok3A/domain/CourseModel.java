package id.ac.ui.cs.eaap.kelompok3A.domain;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.TermModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {
	private String idCourse;
	private String courseName;	
	private List<TermModel> termAvailable;
	private List<CourseModel> precondition;
	private int sks;
	private int sksRequired;
}