package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.ArrayList;
import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.HabilitationInterface;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Theme;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.HabilitationRepository;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public class HabilitationController implements HabilitationInterface {
	
	HabilitationRepository habilitationRepository = new HabilitationRepository();

	@Override
	public void createUpdateHabilitation(Habilitation habilitation, Theme theme) {
		
		List<String> errors = new ArrayList<>();
		
		try {
			if(habilitation.getName()==null||habilitation.getName().isEmpty()) {
				errors.add("Le nom ne peut pas être vide");
			}
			
			if(habilitation.getFrequency()==0) {
				errors.add("La fréquence ne peut pas être vide ou égale à 0");
			}
			
			if(habilitation.getTheme().getId()==0) {
				errors.add("Le sous domaine est obligatoire");
			}
			
			if(habilitation.getId()<0) {
				errors.add("L'id ne peut pas être négatif");
			}
			
			if(!errors.isEmpty()) {
				throw new ValidationDataException(null, errors);
			}
			
			if(habilitation.getId()==0) {
			habilitationRepository.createHabilitation(habilitation,theme);
			} else {
			habilitationRepository.updateHabilitation(habilitation, theme);
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
	public Habilitation getHabilitationById(long id) throws NotFoundException {
		
		Habilitation habilitation = habilitationRepository.getHabilitationById(id);
	    
	    if (habilitation != null) {
	        return habilitation;
	    } else {
	        throw new NotFoundException("Aucun employé trouvée avec l'ID " + id);
	    }
	}

	@Override
	public void deleteHabilitation(long id) {
		habilitationRepository.deleteHabilitation(id);

		
	}

	@Override
	public List<Habilitation> getAllHabilitation() {
		return habilitationRepository.getAllHabilitations();
	}
	

}
