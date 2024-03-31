package fr.devbyeloise.gestionHabilitations.habilitations;

import java.util.ArrayList;
import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.controller.EmployeeController;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.EmployeeInterface;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.HabilitationController;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NotFoundException
    {
    	Habilitation chariot = new Habilitation();
        chariot.setId(1);
        chariot.setName("Chariot");
        chariot.setFrequency(60);
        chariot.setSubdomain("Conduite");
        
        HabilitationController habilitationController = new HabilitationController();
        habilitationController.createHabilitation(chariot);
                
    	Habilitation sauveteurSecouriste = new Habilitation();
    	sauveteurSecouriste.setId(2);
    	sauveteurSecouriste.setName("Sauveteur");
    	sauveteurSecouriste.setFrequency(24);
    	sauveteurSecouriste.setSubdomain("Santé");
    	
        habilitationController.createHabilitation(sauveteurSecouriste);
        
        sauveteurSecouriste.setId(50);
        sauveteurSecouriste.setName("Salutttt!!!");
         		
 		EmployeeInterface empController = new EmployeeController();
 		
 		List<Employee> listEmp = empController.getAllEmployee();
 		for (Employee employee : listEmp) {
			System.out.println(employee.getName() + " " + employee.getFirstName());
		}
 		
// 		............................................................
 		
	        Employee searchEmployee = empController.getEmployeeById(2);
	        System.out.println("L'ID correspond à " + searchEmployee.getFirstName() + " " + searchEmployee.getName());
//		.....................................................
	        
//	        Employee newEmployee = new Employee();
//	        newEmployee.setName("DUPONT");
//	        newEmployee.setFirstName("Jules");
//	        empController.createEmployee(newEmployee);
	        
//	        searchEmployee.setFirstName("Georgette");
//	        empController.updateEmployee(searchEmployee);
	        
	        empController.deleteEmployee(8);
		
    }
}
