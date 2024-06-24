package fr.devbyeloise.gestionHabilitations.habilitations;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Theme;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public interface HabilitationInterface {
	void createUpdateHabilitation(Habilitation habilitation, Theme theme);
	Habilitation getHabilitationById(long id) throws NotFoundException;
	List<Habilitation> getAllHabilitation();
	void deleteHabilitation (long id);

}
