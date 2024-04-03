package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.HabilitationRepository;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public class HabilitationController implements HabilitationInterface {
	
	HabilitationRepository habilitationRepository = new HabilitationRepository();

	@Override
	public void createHabilitation(Habilitation habilitation) {
		
		if(habilitation.getName().isEmpty()) {
			System.out.println("Le nom ne peut pas être vide");
		}
		
		habilitationRepository.createHabilitation(habilitation);		
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
	public void updateHabilitation(Habilitation habilitation) {
		habilitationRepository.updateHabilitation(habilitation);
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
