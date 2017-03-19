package id.ac.ui.cs.eaap.kelompok3A.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.MajorService;

@RestController
@RequestMapping("/rest")
public class MajorRestController {
	@Autowired
	MajorService majorService;
	
	@RequestMapping("major/view/{id}")
	public MajorModel viewMajor(Model model, @PathVariable(value = "id") String idMajor)
	{
		MajorModel major = majorService.selectMajor(idMajor);
		return major;
	}
	
	@RequestMapping("major/viewall/{idFaculty}")
	public List<MajorModel> viewAllMajors(@PathVariable(value = "idFaculty") String idFaculty)
	{
		List<MajorModel> majors = majorService.selectAllMajors(idFaculty);
		return majors;
	}
	
}
