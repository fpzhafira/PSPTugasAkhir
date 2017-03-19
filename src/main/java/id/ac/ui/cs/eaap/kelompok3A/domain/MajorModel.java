package id.ac.ui.cs.eaap.kelompok3A.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorModel {
	private String idMajor;
	private String majorName;
	private String idFaculty;
	private List<CurriculumModel> curriculums;
}