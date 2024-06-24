package fr.devbyeloise.gestionHabilitations.habilitations.modele;

import java.time.LocalDate;

public class HabilitationEmployee {

	private Employee employee;
	private Habilitation habilitation;
	private LocalDate trainingDate;
	private LocalDate expirationDate;
	
	
	public HabilitationEmployee(Employee employee, Habilitation habilitation, LocalDate trainingDate,
			LocalDate expirationDate) {
		this.employee = employee;
		this.habilitation = habilitation;
		this.trainingDate = trainingDate;
		this.expirationDate = expirationDate;
	}
	
	public void CalculateExpirationDate (){
		if(trainingDate!= null && habilitation != null) {
			this.expirationDate=trainingDate.plusMonths(habilitation.getFrequency());
		}
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Habilitation getHabilitation() {
		return habilitation;
	}
	public void setHabilitation(Habilitation habilitation) {
		this.habilitation = habilitation;
	}
	public LocalDate getTrainingDate() {
		return trainingDate;
	}
	public void setTrainingDate(LocalDate trainingDate) {
		this.trainingDate = trainingDate;
	}
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
}
