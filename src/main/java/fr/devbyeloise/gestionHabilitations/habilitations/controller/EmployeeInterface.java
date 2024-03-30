package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public interface EmployeeInterface {
	void createEmployee (Employee employee);
	Employee getEmployeeById(long id) throws NotFoundException;
	List<Employee> getAllEmployee();
	String updateEmployee (Employee employee);
	void deleteEmployee (long id);

}
