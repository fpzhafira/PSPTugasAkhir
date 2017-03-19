package id.ac.ui.cs.eaap.kelompok3B.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.kelompok3B.dao.SupervisorMapper;
import id.ac.ui.cs.eaap.kelompok3B.domain.Supervisor;

@Service
public class SupervisorServiceDatabase implements SupervisorService 
{
	@Autowired
	SupervisorMapper mapper;
	
	@Override
	public Supervisor getSupervisor(String student_id) {		
		return mapper.getSupervisor(student_id);
	}

	@Override
	public void setSupervisor(String student_id, Supervisor supervisor) {
		mapper.setSupervisor(student_id, supervisor.getNip(), supervisor.getAssignDate());		
	}
	
	@Override
	public void updateStudenSuperviorByNpm(String student_id, String nip) {
		mapper.updateStudenSuperviorByNpm(student_id,nip);
	}

}
