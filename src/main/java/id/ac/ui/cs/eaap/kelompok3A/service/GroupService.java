package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import id.ac.ui.cs.eaap.kelompok3A.domain.GroupModel;

public interface GroupService {

	GroupModel selectGroup(String idGroup);
	
	GroupModel selectDisabledGroup(String idGroup);
	
	GroupModel selectGroupByNameAndUniv(String name, String idUniv);
	
	List<GroupModel> selectAllGroups(String idUniv);
	
	void createGroup(GroupModel group);
	
	void updateGroup(GroupModel group);
	
	void deleteGroup(String idGroup);
	
	void enableGroup(String idGroup);
}
