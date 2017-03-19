package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;

public interface ClassesService {
	public List<ClassesModel> viewAllClass();
	public ClassesModel viewClassInfo (String class_id);
	public void deleteClass (String class_id);
	public void editClass (ClassesModel classes);
	public void addClass (ClassesModel classes);
	public List<ClassesModel> viewClassByTerm(Integer id_term);
}
