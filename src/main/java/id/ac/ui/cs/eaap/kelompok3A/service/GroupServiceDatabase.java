package id.ac.ui.cs.eaap.kelompok3A.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3A.dao.GroupMapper;
import id.ac.ui.cs.eaap.kelompok3A.domain.GroupModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GroupServiceDatabase implements GroupService {

	@Autowired
	private GroupMapper groupMapper;
	
	@Override
	public GroupModel selectGroup(String idGroup) {
		// TODO Auto-generated method stub
		log.info("select group with id_group {}", idGroup);
		return groupMapper.selectGroup(idGroup);
	}

	@Override
	public List<GroupModel> selectAllGroups(String idUniv) {
		// TODO Auto-generated method stub
		log.info("select all groups with id_univ {}", idUniv);
		return groupMapper.selectAllGroups(idUniv);
	}

	@Override
	public void createGroup(GroupModel group) {
		// TODO Auto-generated method stub
		log.info("group " + group.getGroupName() + " created");
		groupMapper.createGroup(group);
	}

	@Override
	public void updateGroup(GroupModel group) {
		// TODO Auto-generated method stub
		log.info("group " + group.getGroupName() + " updated");
		groupMapper.updateGroup(group);
	}

	@Override
	public void deleteGroup(String idGroup) {
		// TODO Auto-generated method stub
		log.info("group " + idGroup + " deleted");
		groupMapper.deleteGroup(idGroup);
	}

	@Override
	public GroupModel selectGroupByNameAndUniv(String name, String idUniv) {
		// TODO Auto-generated method stub
		log.info("select group by name= {} and idUniv= {}", name, idUniv);
		return groupMapper.selectGroupByNameAndUniv(name, idUniv);
	}

	@Override
	public void enableGroup(String idGroup) {
		// TODO Auto-generated method stub
		log.info("group {} enabled", idGroup);
		groupMapper.enableGroup(idGroup);
	}

	@Override
	public GroupModel selectDisabledGroup(String idGroup) {
		// TODO Auto-generated method stub
		log.info("select disabled group with id {}", idGroup);
		return groupMapper.selectDisabledGroup(idGroup);
	}
}