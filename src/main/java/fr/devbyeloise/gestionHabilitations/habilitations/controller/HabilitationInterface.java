package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;

public interface HabilitationInterface {
	void createHabilitation (Habilitation habilitation);
	Habilitation getHabilitationById(long id);
	List<Habilitation> getAllHabilitation();
	String updateHabilitation (Habilitation habilitation);
	void deleteHabilitation (long id);
}
