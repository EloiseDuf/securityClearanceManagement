package fr.devbyeloise.gestionHabilitations.habilitations;


import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.HabilitationEmployee;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public interface HabilitationEmployeeInterface {

	void createUpdateEmployeeHabilitation(HabilitationEmployee employeeHabilitation);

	List<HabilitationEmployee> getAllHabilitationEmployee();

	List<HabilitationEmployee> getHabilitationEmployeeByIdEmployeeWithFullInformations(Long employeeId)
			throws NotFoundException;

	List<HabilitationEmployee> getHabilitationEmployeeByIdEmployeeWithLessInformations(Long employeeId)
			throws NotFoundException;
	
	void deleteHabilitationEmployee(long employeeId, long habilitationId);

	HabilitationEmployee getHabilitationEmployeeByIdEmployeeAndIdHabilitation(Long employeeId, Long habilitationId)
			throws NotFoundException;

	
}
