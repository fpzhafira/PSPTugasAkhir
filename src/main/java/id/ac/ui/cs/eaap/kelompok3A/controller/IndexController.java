package id.ac.ui.cs.eaap.kelompok3A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.SearchEngineService;

@Controller
@RequestMapping("/sekre")
public class IndexController implements ErrorController{
	
	@Autowired
	SearchEngineService pageservice;
	
	@RequestMapping("/3A")
	public String index()
	{
		return "kurikulum/index";
	}

	@RequestMapping("/search/course")
	public String searchCourse()
	{
		return "kurikulum/search-course";
	}
	
	@PostMapping("/search/course/result")
	public String searchCourseResult(Model model, 	@RequestParam(value = "name", required = false) String name,
													@RequestParam(value = "sks", required = false) String sks,
													@RequestParam(value = "sksRequired", required = false) String sksRequired)
	{
		List<CourseModel> results = pageservice.searchCourse(name, sks, sksRequired);
		
		if (results.size() > 0)
		{
			model.addAttribute("results", results);
			
			return "kurikulum/search-course-result";
		}
			
		else
		{
			return "kurikulum/search-notfound";
		}
	}
	
	@RequestMapping("/search/univ")
	public String searchUniv()
	{
		return "kurikulum/search-univ";
	}
	
	@PostMapping("/search/univ/result")
	public String searchUnivResult(Model model, @RequestParam(value = "name", required = false) String name)
	{
		List<UnivModel> univs = pageservice.searchUniv(name);
		
		if (univs.size() > 0)
		{
			model.addAttribute("univs", univs);
			
			return "kurikulum/search-univ-result";
		}
			
		else
		{
			return "kurikulum/search-notfound";
		}
	}
	
	@RequestMapping("/search/faculty")
	public String searchFaculty()
	{
		return "kurikulum/search-faculty";
	}
	
	@PostMapping("/search/faculty/result")
	public String searchFacultyResult(Model model, @RequestParam(value = "name", required = false) String name)
	{
		List<FacultyModel> faculties = pageservice.searchFaculty(name);
		
		if (faculties.size() > 0)
		{
			model.addAttribute("faculties", faculties);
			
			return "kurikulum/search-faculty-result";
		}
			
		else
		{
			return "kurikulum/search-notfound";
		}
	}
	
	@RequestMapping("/search/major")
	public String searchMajor()
	{
		return "kurikulum/search-major";
	}
	
	@PostMapping("/search/major/result")
	public String searchMajorResult(Model model, @RequestParam(value = "name", required = false) String name)
	{
		List<MajorModel> majors = pageservice.searchMajor(name);
		
		if (majors.size() > 0)
		{
			model.addAttribute("majors", majors);
			
			return "kurikulum/search-major-result";
		}
			
		else
		{
			return "kurikulum/search-notfound";
		}
	}
	
	/**
	 * Section for handling error
	 */
	
	private static final String PATH = "/error";
	
	@RequestMapping("/error")
    public String error ()
    {
        return "kurikulum/error";
    }
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

}
