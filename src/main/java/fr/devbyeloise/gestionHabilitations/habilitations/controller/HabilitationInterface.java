package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;

public interface HabilitationInterface {
	void createHabilitation (Habilitation habilitation);
	Habilitation getHabilitation(long id);
	String updateHabilitation (Habilitation habilitation);
	void deleteHabilitation (Long id);
}
