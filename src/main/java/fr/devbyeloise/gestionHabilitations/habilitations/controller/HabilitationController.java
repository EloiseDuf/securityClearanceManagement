package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.HabilitationRepository;

public class HabilitationController implements HabilitationInterface {
	
	HabilitationRepository habilitationRepository = new HabilitationRepository();

	@Override
	public void createHabilitation(Habilitation habilitation) {
		
		habilitationRepository.listHabilitation.add(habilitation);
		System.out.println(habilitationRepository.listHabilitation.size());
		
	}

	@Override
	public Habilitation getHabilitation(long id) {
		
		return habilitationRepository.getHabilitationById(id);
	}

	@Override
	public String updateHabilitation(Habilitation habilitation) {
		if(habilitation.getId() < 0) {
			return "Erreur";
		}
		return habilitationRepository.update(habilitation);
		//return "L'habilitation " + habilitation.getName() + " a bien été mis à jour.";
	}

	@Override
	public void deleteHabilitation(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
