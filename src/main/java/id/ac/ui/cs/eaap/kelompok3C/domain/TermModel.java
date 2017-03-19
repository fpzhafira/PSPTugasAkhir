package id.ac.ui.cs.eaap.kelompok3C.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TermModel {
	private int idTerm;
	private String years;
	private char termHeld;
}