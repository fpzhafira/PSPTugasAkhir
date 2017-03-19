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
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.FacultyService;

@RestController
@RequestMapping("/rest")
public class CurriculumRestController {
	
	@Autowired
	CurriculumService curriculumService;
	
	
	/*@RequestMapping("curriculum/viewall")
	public List<CurriculumModel> viewAllCurr()
	{
		List<CurriculumModel> curr = curriculumService.selectAllCurriculums(idMajor);
		return faculty;
	}*/
	
	@RequestMapping("curriculum/view/{id}")
	public CurriculumModel viewCurr(@PathVariable(value = "id") String idCurriculum)
	{
		CurriculumModel curr = curriculumService.selectCurriculum(idCurriculum);
		return curr;
	}
	
	
	@RequestMapping("curriculum/viewall/{idMajor}")
	public List<CurriculumModel> viewAllCurriculum(@PathVariable(value = "idMajor") String idMajor)
	{
		List<CurriculumModel> currs = curriculumService.selectAllCurriculums(idMajor);
		return currs;
	}
}
