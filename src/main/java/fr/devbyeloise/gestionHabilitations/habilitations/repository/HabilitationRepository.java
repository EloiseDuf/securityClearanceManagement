package fr.devbyeloise.gestionHabilitations.habilitations.repository;

import java.util.ArrayList;
import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;

public class HabilitationRepository {
	public List<Habilitation> listHabilitation = new ArrayList<Habilitation>();
	
	public Habilitation getHabilitationById(long id) {

		try{
			for(Habilitation i : listHabilitation) {
				if(i.getId()==id) {
					return i ;
				}
			
			}
			throw new HabilitationNotFoundException("Aucune habilitation trouvée avec l'ID " + id);

		} catch (HabilitationNotFoundException e) {
            e.printStackTrace();
            return null;
		}
	}
	
	public String update(Habilitation habilitation) {
//		if(habilitation.getId() > listHabilitation.size()) {
//			return "Repo Erreur";
//		}
		//listHabilitation.set((int)habilitation.getId()-1, habilitation);
		System.out.println("repo  " + listHabilitation.get(1));
		return "repo Ok";
	}
}