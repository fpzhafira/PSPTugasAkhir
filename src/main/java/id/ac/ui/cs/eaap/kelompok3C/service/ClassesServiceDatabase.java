package id.ac.ui.cs.eaap.kelompok3C.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3C.dao.ClassesMapper;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClassesServiceDatabase implements ClassesService {

	@Autowired
	ClassesMapper classesMapper;
	
	@Override
	public List<ClassesModel> viewAllClass() {
		// TODO Auto-generated method stub
		log.info("Select all classes");
		return classesMapper.viewAllClass();
	}

	@Override
	public ClassesModel viewClassInfo(String class_id) {
		// TODO Auto-generated method stub
		log.info("Select class with class_id {}");
		return classesMapper.viewClassInfo(class_id);
	}

	@Override
	public void deleteClass(String class_id) {
		// TODO Auto-generated method stub
		log.info("Delete class with class_id {}");
		classesMapper.deleteClass(class_id);
		
	}

	@Override
	public void editClass(ClassesModel classes) {
		// TODO Auto-generated method stub
		log.info("Edit class with class_id {}");
		classesMapper.editClass(classes);
	}

	@Override
	public void addClass(ClassesModel classes) {
		// TODO Auto-generated method stub
		log.info("Add class with class_id {}");
		classesMapper.addClass(classes);
	}

	@Override
	public List<ClassesModel> viewClassByTerm(Integer id_term) {
		// TODO Auto-generated method stub
		return classesMapper.viewClassByTerm(id_term);
	}

}
