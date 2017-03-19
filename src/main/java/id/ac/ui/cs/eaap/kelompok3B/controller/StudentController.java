package id.ac.ui.cs.eaap.kelompok3B.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3A.domain.CourseModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.CurriculumModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.FacultyModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.MajorModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.CourseService;
import id.ac.ui.cs.eaap.kelompok3A.service.CurriculumService;
import id.ac.ui.cs.eaap.kelompok3A.service.FacultyService;
import id.ac.ui.cs.eaap.kelompok3A.service.MajorService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;
import id.ac.ui.cs.eaap.kelompok3B.domain.CourseClassStudent;
import id.ac.ui.cs.eaap.kelompok3B.domain.Student;
import id.ac.ui.cs.eaap.kelompok3B.domain.Supervisor;
import id.ac.ui.cs.eaap.kelompok3B.service.StudentService;
import id.ac.ui.cs.eaap.kelompok3B.service.SupervisorService;
import id.ac.ui.cs.eaap.kelompok3C.domain.ClassesModel;
import id.ac.ui.cs.eaap.kelompok3C.service.ClassesService;

@Controller
public class StudentController 
{	
	@Autowired 
	StudentService studentDAO;
	
	@Autowired
	SupervisorService supervisorDAO;
	
	@Autowired
	ClassesService classDAO;
	
	@Autowired
	UnivService universityDAO;
	
	@Autowired
	FacultyService facultyDAO;
	
	@Autowired
	CurriculumService curriculumDAO;
	
	@Autowired
	CourseService courseDAO;
	
	@Autowired
	MajorService majorDAO;
	
	/**
	 * Get Student profile
	 * by student itself
	 * 
	 * @param model
	 * @param auth
	 * @return
	 */
	@RequestMapping("/student/profile")
	public String viewStudentProfile(Model model, Authentication auth)
	{
		Student student = studentDAO.getStudentByUsername(auth.getName());
		getStudentObjectRelated(model, student);	
						
		return "student/viewstudent";
	}
	
	/**
	 * Get student view by npm
	 * by sekre
	 * 
	 * @param model
	 * @param npm
	 * @return
	 */
	@RequestMapping("/sekre/student/view/{npm}")
	public String viewStudentBySekre(Model model, @PathVariable(value=("npm")) String npm)
	{
		Student student = studentDAO.getStudent(npm);
		
		if (student != null)		
			getStudentObjectRelated(model, student);		
		else		
			model.addAttribute("studentNotFound", npm);	
		
		return "student/viewstudent";
	}
	
	/**
	 * Get student object and another object related to student
	 * Used by view student
	 * 
	 * @param model
	 * @param student
	 */
	public void getStudentObjectRelated(Model model, Student student)
	{
		Supervisor supervisor = supervisorDAO.getSupervisor(student.getNpm());						
		UnivModel university = universityDAO.selectUniv(student.getUnivId());			
		FacultyModel faculty = facultyDAO.selectFaculty(student.getFacultyId());			
		
		MajorModel major = majorDAO.selectMajor(student.getMajorId());
		double gpa = getGpa(student.getNpm());
		
		if (student.getCurriculumId() != null)
		{
			CurriculumModel curriculum = curriculumDAO.selectCurriculum(student.getCurriculumId());
			model.addAttribute("curriculum", curriculum);
		}
		else
		{
			model.addAttribute("curriculum", student.getCurriculumId());
		}				
		
		model.addAttribute("student", student);
		model.addAttribute("supervisor", supervisor);		
		model.addAttribute("faculty", faculty);
		model.addAttribute("university", university);
		model.addAttribute("major", major);
		model.addAttribute("gpa", gpa);
	}
	
	/**
	 * Return view all student view
	 * with universitites model
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/sekre/student/viewall")
	public String viewAllStudent(Model model)
	{		
		List<UnivModel> universities = universityDAO.selectAllUnivs();
		model.addAttribute("universities", universities);
		return "student/viewallstudent";
	}
	
	/**
	 * Return add student view for sekre role
	 * 
	 * @param model
	 * @return student/createstudent view
	 */
	@RequestMapping("/sekre/student/add")
	public String viewAddStudent(Model model)
	{
		List<UnivModel> universities = universityDAO.selectAllUnivs();
		model.addAttribute("universities", universities);
		model.addAttribute("student", new Student());
		model.addAttribute("supervisor", new Supervisor());
		return "student/createstudent"; 
	}
	
	/**
	 * Insert newly created student model to database
	 * including its supervisor
	 * 
	 * @param studentModel
	 */
	@RequestMapping(value="/sekre/addStudent", method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student studentModel, @ModelAttribute("supervisor") Supervisor supervisor)
	{
		// FIXME addStudent
		Random r = new Random();
		String npm = "";
		
		do		
			npm = studentModel.getNpm().substring(2)+"0"+(1000000+r.nextInt(9000000));
		while (studentDAO.isStudentExist(npm));
		
		studentModel.setNpm(npm);			
		supervisor.setAssignDate(new Date());
		
		studentDAO.addStudent(studentModel);
		supervisorDAO.setSupervisor(npm, supervisor);
		
		return "redirect:/sekre/student/view/"+npm;
	}
	
	/**
	 * Get studetn update view
	 * 
	 * @param model
	 * @param npm
	 * @return
	 */
	@RequestMapping("/sekre/student/update/{npm}")
	public String viewUpdateStudent(Model model, @PathVariable(value="npm", required=true) String npm)
	{		
		Student student = studentDAO.getStudent(npm);
				
		if (student != null)
		{
			List<CurriculumModel> curriculum = curriculumDAO.selectAllCurriculums(student.getMajorId());
			
			model.addAttribute("curriculums", curriculum);
			model.addAttribute("studentParam", student);
		}				
		else
		{
			model.addAttribute("studentNotFound", npm);
		}			
		
		return "student/updatestudent";
	}
	
	@RequestMapping("/fillCoursePlan")
	public String viewFillCoursePlan(Model model)
	{
		// FIXME ini ngisi RIS nya siapa yah wkwkwk xD
		return "registrasi/fillcourseplan";
	}
	
	/**
	 * Update student model
	 * 
	 * @param model
	 * @param npm
	 * @param supervisorId
	 * @param curriculumId
	 * @return
	 */
	@RequestMapping(value="/sekre/student/updateStudent", method=RequestMethod.POST)
	public String updateStudent(Model model, 
			@RequestParam(value="npm", required=true) String npm,
			@RequestParam(value="nip", required=true) String supervisorId,
			@RequestParam(value="curriculumId", required=true) String curriculumId) 
	{
		// FIXME updateStudent, masih belum fix
		Student student = studentDAO.getStudent(npm);
		student.setCurriculumId(curriculumId);
		studentDAO.updateStudent(student);
		
		Supervisor supervisor = new Supervisor(supervisorId, new Date());
		supervisorDAO.setSupervisor(npm, supervisor);
		
		return "redirect:/sekre/student/view/"+student.getNpm();
	}
	
	/**
	 * Set student model attribute deleted equal to 1
	 * 
	 * @param npm
	 * @return
	 */
	@RequestMapping(value="/sekre/student/deleteStudent", method=RequestMethod.POST)
	public String deleteStudent(@RequestParam(value="npm", required=false)String npm)
	{
		studentDAO.deleteStudent(npm);
		return "redirect:/sekre/student/viewall";
	}
	
	@RequestMapping(value="/addCoursePlan", method=RequestMethod.POST)
	public void fillCoursePlan(
			@RequestParam(value="", required=true) List<String> classId,
			@RequestParam(value="", required=true) String npm)
	{
		// FIXME fillCoursePlan
		setCoursePlan(npm, classId);
	}
	
	public double getGpa(String npm)
	{
		List<CourseClassStudent> coursesTaken = studentDAO.getClassCourseStudentByStudentNpm(npm);
		double gpa = 0.0;
		double gpaCumulative = 0.0;
		double coursePassedThreshold = 55;
		int creditsTaken = 0;
		
		for (CourseClassStudent courseTaken : coursesTaken) 
		{
			if (courseTaken.getGrade() >= coursePassedThreshold) 
			{
				CourseModel course = courseDAO.selectCourse(courseTaken.getCourseId());
				gpa += course.getSks() * gpaConverter(courseTaken.getGrade());
				creditsTaken += course.getSks();
			}
		}
		
		if (gpa > 0.0)
			gpaCumulative = gpa / creditsTaken;		
		
		return gpaCumulative;
	}
	
	public List<CourseModel> getAllTakenCourse(String npm)
	{
		List<CourseModel> courseModelList = new ArrayList<CourseModel>();	
		List<String> courseIdList = studentDAO.getCourseIdByStudentNpm(npm);
		
		for (String courseId : courseIdList)
			courseModelList.add(courseDAO.selectCourse(courseId));
		
		return courseModelList;
	}
	
	public boolean isPrecondtionSatisfied(String npm, String course_id)
	{ 
		boolean isSatisfied = true;
		
		List<String> coursesRequired = studentDAO.getRequiredCourse(course_id);
		List<String> coursesTaken = studentDAO.getTakenCourseClassByStudentNpm(npm);
		
		for (String courseRequired : coursesRequired) 
		{		
			if (!coursesTaken.contains(courseRequired))
				isSatisfied = false;			
		}

		return isSatisfied;		
	}
	
	public void setCoursePlan(String npm, List<String> class_id)
	{
		for (String classIdItem : class_id) 
		{
			ClassesModel classModel = classDAO.viewClassInfo(classIdItem);
			String courseId = classModel.getCourse_id();//hanya dummy sementara
			studentDAO.insertStudentCourse(npm, classIdItem,courseId);
		}
	}
	
	/**
	 * GPA converter
	 * 
	 * @param grade
	 * @return
	 */
	public double gpaConverter(int grade) 
	{
		if (grade >= 85)
			return 4.0;
		else if (grade >= 80)
			return 3.7;
		else if (grade >= 75)
			return 3.3;
		else if (grade >= 70)
			return 3.0;
		else if (grade >= 65)
			return 2.7;
		else if (grade >= 60)
			return 2.3;
		else if (grade >= 55)
			return 2.0;
		else if (grade >= 50)
			return 1.7;
		else if (grade >= 40)
			return 1.3;
		else
			return 1.0;		
	}
}
