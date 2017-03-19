package id.ac.ui.cs.eaap.kelompok3B.domain;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String name;
	private String npm;		
	private String univId;
	private String facultyId;
	private String majorId;
	private String curriculumId;
	private String supervisorId;
	private List<ClassesModel> classes;
	private List<CourseModel> courses;
}
