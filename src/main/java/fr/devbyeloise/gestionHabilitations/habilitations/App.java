package fr.devbyeloise.gestionHabilitations.habilitations;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.controller.EmployeeController;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.EmployeeInterface;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.HabilitationController;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.HabilitationInterface;
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
    	
    	
    	HabilitationInterface habilitationController = new HabilitationController();
 		
 		List<Habilitation> listHabilitations = habilitationController.getAllHabilitation();
 		for (Habilitation habilitation : listHabilitations) {
			System.out.println(habilitation.getName());
		}
 			
 		Habilitation searchHabilitation = habilitationController.getHabilitationById(2);
 		searchHabilitation.setName("Bip");

 		habilitationController.updateHabilitation(searchHabilitation);
 		
 		
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
