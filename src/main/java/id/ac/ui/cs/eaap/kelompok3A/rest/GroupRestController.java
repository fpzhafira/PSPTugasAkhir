package id.ac.ui.cs.eaap.kelompok3A.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.eaap.kelompok3A.domain.GroupModel;
import id.ac.ui.cs.eaap.kelompok3A.service.GroupService;

@RestController
@RequestMapping("/rest")
public class GroupRestController {
	@Autowired
	GroupService groupService;
	
	
	@RequestMapping("group/view/{id}")
	public GroupModel viewGroup(Model model, @PathVariable(value = "id") String idGroup)
	{
		GroupModel group = groupService.selectGroup(idGroup);
		return group;
	}
}
