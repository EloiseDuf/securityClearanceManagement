package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.HabilitationRepository;

public class HabilitationController implements HabilitationInterface {
	
	HabilitationRepository habilitationRepository = new HabilitationRepository();

	@Override
	public void createHabilitation(Habilitation habilitation) {
		
		habilitationRepository.listHabilitation.add(habilitation);		
	}

	@Override
	public Habilitation getHabilitationById(long id) {
		
		return habilitationRepository.getHabilitationById(id);
	}

	@Override
	public String updateHabilitation(Habilitation habilitation) {
		if(habilitation.getId() < 0) {
			return "Erreur";
		}
		return habilitationRepository.update(habilitation);
	}

	@Override
	public void deleteHabilitation(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Habilitation> getAllHabilitation() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
