package fr.devbyeloise.gestionHabilitations.habilitations.controller;

import java.util.List;

import fr.devbyeloise.gestionHabilitations.habilitations.modele.Employee;
import fr.devbyeloise.gestionHabilitations.habilitations.repository.NotFoundException;

public interface EmployeeInterface {
	void createEmployee (Employee employee) throws ValidationDataException;
	Employee getEmployeeById(long id) throws NotFoundException;
	List<Employee> getAllEmployee() throws NotFoundException;
	void updateEmployee (Employee employee) throws NotFoundException;
	void deleteEmployee (long id);

}
