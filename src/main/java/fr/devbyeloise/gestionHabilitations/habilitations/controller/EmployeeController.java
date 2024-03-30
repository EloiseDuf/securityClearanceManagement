package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;
import fr.devbyeloise.gestionHabilitations.habilitations.modele.Habilitation;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.EmployeeRepository;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public class EmployeeController implements EmployeeInterface {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeController() {
		this.employeeRepository = new EmployeeRepository();
	}

	@Override
	public void createEmployee(Employee employee) {
		
		if(employee.getName().isEmpty()) {
			System.out.println("Le nom ne peut pas être vide");
		}
		
		employeeRepository.createEmployee(employee);

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
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.getAllEmployee();
	}

}
