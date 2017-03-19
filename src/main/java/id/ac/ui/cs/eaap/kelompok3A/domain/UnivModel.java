package id.ac.ui.cs.eaap.kelompok3A.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnivModel {
	private String idUniv;
	private String univName;
	private String initial;
	private String telephoneNumber;
	private String address;
	private char accreditation;
	private List<FacultyModel> faculties;

}