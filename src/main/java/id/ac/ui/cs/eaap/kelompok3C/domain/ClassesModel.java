package id.ac.ui.cs.eaap.kelompok3C.domain;


import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesModel {
	
	private String class_id;
	private String major_id;
	private String course_id;
	//private String id_univ;
	private String class_name;
	private String schedule;
	private String classroom;
	private String lecturer;
	private int id_term;
}
