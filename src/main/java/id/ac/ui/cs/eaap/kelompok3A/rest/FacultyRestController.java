package id.ac.ui.cs.eaap.kelompok3A.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.FacultyService;

@RestController
@RequestMapping("/rest")
public class FacultyRestController {
	
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping("faculty/viewall/{idUniv}")
	public List<FacultyModel> viewAllFaculty(@PathVariable(value = "idUniv") String idUniv)
	{
		List<FacultyModel> faculties = facultyService.selectAllFaculties(idUniv);
		return faculties;
	}
	
	
	@RequestMapping("faculty/view/{id}")
	public FacultyModel viewFaculty(@PathVariable(value = "id") String idFaculty)
	{
		FacultyModel faculty = facultyService.selectFaculty(idFaculty);
		return faculty;
	}
}
