package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public interface HabilitationInterface {
	void createHabilitation (Habilitation habilitation);
	Habilitation getHabilitationById(long id) throws NotFoundException;
	List<Habilitation> getAllHabilitation();
	void updateHabilitation (Habilitation habilitation);
	void deleteHabilitation (long id);
}
