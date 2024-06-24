package fr.devbyeloise.gestionHabilitations.habilitations;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.controller.HabilitationController;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.HabilitationEmployeeController;
import fr.devbyeloise.gestionHabilitations.habilitations.controller.ValidationDataException;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.HabilitationEmployee;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NotFoundException, ValidationDataException
    {
    	
    	
    	HabilitationInterface habilitationController = new HabilitationController();
 		
 		List<Habilitation> listHabilitations = habilitationController.getAllHabilitation();
 		for (Habilitation habilitation : listHabilitations) {
			System.out.println(habilitation.getName());
			System.out.println(habilitation.getTheme().getName());
		}
 		
 		HabilitationEmployeeInterface habilitationEmployeeController = new HabilitationEmployeeController();
 	
 		HabilitationEmployee habilitationEmployee = habilitationEmployeeController.getHabilitationEmployeeByIdEmployeeAndIdHabilitation(10l, 1l);
 		System.out.println(habilitationEmployee.getHabilitation().getName());
 		
 		List<HabilitationEmployee> listHabilitationsEmployee = habilitationEmployeeController.getHabilitationEmployeeByIdEmployeeWithLessInformations(10l);
 		System.out.println("Le salarié détient : ");
 		for (HabilitationEmployee habilitationOneEmployee : listHabilitationsEmployee) {
			System.out.println(habilitationOneEmployee.getHabilitation().getName()+" qui a été obtenu le "+ habilitationOneEmployee.getTrainingDate());
		}
 		
 		List<HabilitationEmployee> listHabilitationsAllEmployees = habilitationEmployeeController.getAllHabilitationEmployee();
 		System.out.println("Voici la liste des habilitations de tous les salariés : ");
 		for (HabilitationEmployee habilitationOneEmployee : listHabilitationsAllEmployees) {
			System.out.println(habilitationOneEmployee.getEmployee().getFirstName() +" "+ habilitationOneEmployee.getEmployee().getName()+" " +habilitationOneEmployee.getHabilitation().getName()+" "+ habilitationOneEmployee.getTrainingDate());
		}
 		
 		List<HabilitationEmployee> listAllHabilitationsForOneEmployee = habilitationEmployeeController.getHabilitationEmployeeByIdEmployeeWithLessInformations(11l);
 		System.out.println("Voici la liste des habilitations pour le collaborateur : ");
 		for (HabilitationEmployee habilitationOneEmployee : listAllHabilitationsForOneEmployee) {
			System.out.println(habilitationOneEmployee.getEmployee().getFirstName() +" "+ habilitationOneEmployee.getEmployee().getName()+" " +habilitationOneEmployee.getHabilitation().getName()+" "+ habilitationOneEmployee.getTrainingDate());
		}
 			
// 		Habilitation searchHabilitation = habilitationController.getHabilitationById(2);
// 		searchHabilitation.setName("Bip");
//
// 		habilitationController.updateHabilitation(searchHabilitation);
 		
 		
// 		EmployeeInterface empController = new EmployeeController();
// 		
// 		List<Employee> listEmp = empController.getAllEmployee();
// 		for (Employee employee : listEmp) {
//			System.out.println(employee.getName() + " " + employee.getFirstName());
//		}
 		
 		
 		
// 		............................................................
 			
 		
//	        Employee searchEmployee = empController.getEmployeeById(2);
//	        empController.createUpdateEmployee(searchEmployee);

//		.....................................................
	        
//	        Employee newEmployee = new Employee();
//	        newEmployee.setName("DUPONT");
//	        newEmployee.setFirstName("Jules");
//	        empController.createUpdateEmployee(newEmployee);
	        
//	        searchEmployee.setFirstName("Georgette");
//	        empController.updateEmployee(searchEmployee);
	        
//	        empController.deleteEmployee(8);
	        
//	        HabilitationInterface habControler = new HabilitationController();
	        
//	        Habilitation incendie = new Habilitation();
//	        incendie.setName("Incendie");
//	        habControler.createHabilitation(incendie);
	        
//	        empController.deleteEmployee(9);
		
    
}
}
