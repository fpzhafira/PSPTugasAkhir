package id.ac.ui.cs.eaap.kelompok3C.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.ClassLecturerMapper;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassLecturerModel;

@Service
public class ClassLecturerServiceDatabase implements ClassLecturerService{

	@Autowired
	ClassLecturerMapper classLecturerMapper;
	
	@Override
	public void setLecturer(ClassLecturerModel classLecturer) {
		// TODO Auto-generated method stub
		classLecturerMapper.setLecturer(classLecturer);
	}

	@Override
	public ClassLecturerModel selectLecturerByClass(String class_id, String nip) {
		// TODO Auto-generated method stub
		return classLecturerMapper.selectLecturerByClass(class_id, nip);
	}

}
