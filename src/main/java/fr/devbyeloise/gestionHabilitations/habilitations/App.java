package fr.devbyeloise.gestionHabilitations.habilitations;

import fr.devbyeloise.gestionHabilitations.habilitations.controller.HabilitationController;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Habilitation chariot = new Habilitation();
        chariot.setId(1);
        chariot.setName("Chariot");
        chariot.setFrequency(60);
        chariot.setSubdomain("Conduite");
        
        HabilitationController habilitationController = new HabilitationController();
        habilitationController.createHabilitation(chariot);
        
        // System.out.println("Une habilitation " + chariot.getName() + " a été crée");
        
    	Habilitation sauveteurSecouriste = new Habilitation();
    	sauveteurSecouriste.setId(2);
    	sauveteurSecouriste.setName("Sauveteur");
    	sauveteurSecouriste.setFrequency(24);
    	sauveteurSecouriste.setSubdomain("Santé");
        
    	//System.out.println(sauveteurSecouriste);
    	
        habilitationController.createHabilitation(sauveteurSecouriste);
        
        sauveteurSecouriste.setId(50);
        sauveteurSecouriste.setName("Salutttt!!!");
        System.out.println("1" + sauveteurSecouriste);
//        
 System.out.println("2"+ habilitationController.updateHabilitation(sauveteurSecouriste));
//        
//        System.out.println(habilitationController.getHabilitation(50));
    }
}
