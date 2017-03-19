package id.ac.ui.cs.eaap.kelompok3A.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyModel {
	private String idFaculty;
	private String facultyName;
	private String idGroup;
	private String telephoneNumber;
	private char accreditation;
	private List<MajorModel> majors;
	private String idUniv;
}