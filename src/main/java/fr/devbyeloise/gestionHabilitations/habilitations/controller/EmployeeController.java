package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.ArrayList;
import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;

import fr.devbyeloise.gestionHabilitations.habilitations.repository.EmployeeRepository;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public class EmployeeController implements EmployeeInterface {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeController() {
		this.employeeRepository = new EmployeeRepository();
	}

	@Override
	public void createEmployee(Employee employee) throws ValidationDataException {
		
	List<String> errors = new ArrayList<>();
		
	try {
		if(employee.getName()==null||employee.getName().isEmpty()) {
			errors.add("Le nom ne peut pas être vide");
		}
		
		if(employee.getFirstName()==null||employee.getFirstName().isEmpty()) {
			errors.add("Le prénom ne peut pas être vide");
		}
		
		if(!errors.isEmpty()) {
			throw new ValidationDataException(null, errors);
		}
		
		employeeRepository.createEmployee(employee);
		
	}catch (ValidationDataException e){
		List<String> errorMessages = e.getErrorMessages();
		System.out.println("Erreur de création d'employé : ");
		for (String errorMessage : errorMessages) {
            System.out.println(errorMessage);
        }
		
	}
			

	}

	@Override
	public Employee getEmployeeById(long id) throws NotFoundException {
		Employee employee = employeeRepository.getEmployeeById(id);
	    
	    if (employee != null) {
	        return employee;
	    } else {
	        throw new NotFoundException("Aucun employé trouvée avec l'ID " + id);
	    }
	}

	@Override
	public void updateEmployee(Employee employee)throws NotFoundException {
		employeeRepository.updateEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.deleteEmployee(id);

	}

	@Override
	public List<Employee> getAllEmployee() throws NotFoundException {
		
		List<Employee> allEmployees = employeeRepository.getAllEmployee();
		
		if (allEmployees != null) {
	        return employeeRepository.getAllEmployee();
	    } else {
	        throw new NotFoundException("La liste des employés est vide");
	    }

		
	}

}
