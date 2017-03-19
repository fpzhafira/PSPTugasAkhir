package id.ac.ui.cs.eaap.kelompok3B.service;

import id.ac.ui.cs.eaap.kelompok3B.domain.Supervisor;

public interface SupervisorService 
{
	Supervisor getSupervisor(String student_id);
	
	void setSupervisor(String student_id, Supervisor supervisor);
	
	void updateStudenSuperviorByNpm(String student_id, String nip);
}
