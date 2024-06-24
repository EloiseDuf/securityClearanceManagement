package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.ArrayList;
import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.HabilitationEmployeeInterface;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.HabilitationEmployee;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.HabilitationEmployeeRepository;

import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public class HabilitationEmployeeController implements HabilitationEmployeeInterface{
	HabilitationEmployeeRepository habilitationEmployeeRepository = new HabilitationEmployeeRepository();

	@Override
	public void createUpdateEmployeeHabilitation(HabilitationEmployee habilitationEmployee) {
		
		List<String> errors = new ArrayList<>();
		
		try {
			if(habilitationEmployee.getExpirationDate()==null) {
				errors.add("La date ne peut pas être vide");
			}
			
			if(habilitationEmployee.getTrainingDate()==null) {
				errors.add("La date ne peut pas être vide");
			}
			
			if(habilitationEmployee.getEmployee()==null) {
				errors.add("Le salarié est obligatoire");
			}
			
			if(habilitationEmployee.getHabilitation()==null) {
				errors.add("L'habilitation est obligatoire");
			}
			
			if(!errors.isEmpty()) {
				throw new ValidationDataException(null, errors);
			}
			
			if(habilitationEmployee.getEmployee()!= null || habilitationEmployee.getHabilitation() != null ) {
			habilitationEmployeeRepository.createHabilitationEmployee(habilitationEmployee);
			} else {
				habilitationEmployeeRepository.updateHabilitationEmployee(habilitationEmployee);
			}
			
		}catch (ValidationDataException e){
			List<String> errorMessages = e.getErrorMessages();
			System.out.println("Erreur de création d'habilitation : ");
			for (String errorMessage : errorMessages) {
	            System.out.println(errorMessage);
	        }
			
		}		
	}

	@Override
	public List<HabilitationEmployee> getHabilitationEmployeeByIdEmployeeWithFullInformations(Long employeeId) throws NotFoundException {
		
		List<HabilitationEmployee> habilitationEmployee = habilitationEmployeeRepository.getHabilitationEmployeeByIdEmployeeWithFullInformations(employeeId);
	    
	    if (habilitationEmployee != null) {
	        return habilitationEmployee;
	    } else {
	        throw new NotFoundException("Aucun employé trouvée avec l'ID " + employeeId);
	    }
	}
	
	@Override
	public List<HabilitationEmployee> getHabilitationEmployeeByIdEmployeeWithLessInformations(Long employeeId) throws NotFoundException {
		
		List<HabilitationEmployee> habilitationEmployee = habilitationEmployeeRepository.getHabilitationEmployeeByIdEmployeeWithLessInformations(employeeId);
	    
	    if (habilitationEmployee != null) {
	        return habilitationEmployee;
	    } else {
	        throw new NotFoundException("Aucun employé trouvée avec l'ID " + employeeId);
	    }
	}
	
	@Override
	public HabilitationEmployee getHabilitationEmployeeByIdEmployeeAndIdHabilitation(Long employeeId, Long habilitationId) throws NotFoundException {
		
		HabilitationEmployee habilitationEmployee = habilitationEmployeeRepository.getHabilitationEmployeeByIdEmployeeAndIdHabilitation(employeeId,habilitationId);
	    if (habilitationEmployee != null) {
	        return habilitationEmployee;
	    } else {
	        throw new NotFoundException("Aucune donnée trouvée");
	    }
	}

	@Override
	public void deleteHabilitationEmployee(long employeeId,long habilitationId) {
		habilitationEmployeeRepository.deleteHabilitationEmployee(employeeId,habilitationId);	
	}

	@Override
	public List<HabilitationEmployee> getAllHabilitationEmployee() {
		return habilitationEmployeeRepository.getAllEmployeeHabilitations();
	}
}
	
