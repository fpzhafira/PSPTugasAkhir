package id.ac.ui.cs.eaap.kelompok3A.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.ui.cs.eaap.kelompok3A.domain.GroupModel;
import id.ac.ui.cs.eaap.kelompok3A.domain.UnivModel;
import id.ac.ui.cs.eaap.kelompok3A.service.GroupService;
import id.ac.ui.cs.eaap.kelompok3A.service.UnivService;

@Controller
@RequestMapping("/sekre")
public class GroupController {

	@Autowired
	GroupService groupservice;

	@Autowired
	UnivService univservice;
	
	
	@RequestMapping("/group/add")
	public String addGroup(Model model) {
		List<UnivModel> univs = univservice.selectAllUnivs();
		model.addAttribute("univs", univs);
		return "kurikulum/add-group";
	}

	@PostMapping("/group/add/submit")
	public String addGroupSubmit(Model model, @ModelAttribute GroupModel group) {
		GroupModel groupCheck = groupservice.selectGroupByNameAndUniv(group.getGroupName(), group.getIdUniv());
		if (groupCheck != null) {
			String category = "add";
			String entity = "group";
			String link = "sekre/group/add/";
			String linkView = "";
			
			if(groupCheck.getIdUniv().equals("1")) {
				linkView = "sekre/group/view/" + groupCheck.getIdGroup();
			} else {
				linkView = "sekre/group/view-disabled/" + groupCheck.getIdGroup();
			}
			String exist= "group with name '" + group.getGroupName() + "'";
			
			model.addAttribute("category", category);
			model.addAttribute("entity", entity);
			model.addAttribute("link", link);
			model.addAttribute("linkView", linkView);
			model.addAttribute("exist", exist);
			
			return "kurikulum/exist";
			
		} else {
			groupservice.createGroup(group);

			String idUniv = group.getIdUniv();

			List<GroupModel> groups = groupservice.selectAllGroups(idUniv);

			model.addAttribute("groups", groups);

			return "kurikulum/view-group";
		}
	}

	
	
	@RequestMapping("/group/delete/{id}")
	public String deleteGroup(Model model, @PathVariable(value = "id") String idGroup)
	{
		GroupModel group = groupservice.selectGroup(idGroup);
		String name = group.getGroupName();
		String id = group.getIdGroup();
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		
		String idUniv = group.getIdUniv();
		String link = "sekre/group/viewAll/" + idUniv;
		model.addAttribute("link", link);
		
		groupservice.deleteGroup(idGroup);
		
		return "kurikulum/delete";
	}
	@RequestMapping("/group/view/{id}")
	public String viewGroup(Model model, @PathVariable(value = "id") String idGroup)
	{
		GroupModel group = groupservice.selectGroup(idGroup);
		
		model.addAttribute("group", group);
		
		UnivModel univ = univservice.selectUniv(group.getIdUniv());
		model.addAttribute("univ", univ);
		return "kurikulum/view-group";
	}
	
	@RequestMapping("/group/view-disabled/{id}")
	public String viewDisabledGroup(Model model, @PathVariable(value = "id") String idGroup)
	{
		GroupModel group = groupservice.selectDisabledGroup(idGroup);
		
		model.addAttribute("group", group);
		
		UnivModel univ = univservice.selectUniv(group.getIdUniv());
		model.addAttribute("univ", univ);
		return "kurikulum/view-disabled-group";
	}
	
	@RequestMapping("/group/viewoption")
	public String viewAllGroup(Model model)
	{
		List<UnivModel> univ = univservice.selectAllUnivs();
		model.addAttribute("univ", univ);	
		return "kurikulum/view-allgroupoption";
	}
	
	@RequestMapping("/group/viewAll")
	public String viewAllGroups(Model model, @RequestParam(value = "picker", required = true) String idUniv)
	{
		List<GroupModel> group = groupservice.selectAllGroups(idUniv);
		model.addAttribute("group", group);	
		UnivModel univ = univservice.selectUniv(idUniv);
		model.addAttribute("univ", univ);
		return "kurikulum/view-allgroup";
	}
	
	@RequestMapping("/group/active/{id}")
	public String activeGroup(Model model, @PathVariable(value = "id") String idGroup)
	{
		groupservice.enableGroup(idGroup);
		GroupModel group = groupservice.selectGroup(idGroup);
		
		model.addAttribute("group", group);	
		
		UnivModel univ = univservice.selectUniv(group.getIdUniv());
		model.addAttribute("univ", univ);
		return "kurikulum/view-group";
	}
}
