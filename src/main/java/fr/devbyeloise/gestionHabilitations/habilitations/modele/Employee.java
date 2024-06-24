package fr.devbyeloise.gestionHabilitations.habilitations.modele;

import java.util.List;

public class Employee {
	private long id;
	private String name;
	private String firstName;
	private String company;
	private String direction;
	private String team;
	private List<HabilitationEmployee> habilitationsEmployee;
	
	
	public Employee(long id) {
		this.id = id;
	}

	public Employee(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
	}

	public Employee(long id, String name, String firstName) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
	}
	
	public Employee(long id, String name, String firstName, String company, String direction, String team) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.company = company;
		this.direction = direction;
		this.team = team;
	}
	
	public Employee(long id, String name, String firstName, String company, String direction, String team,
			List<HabilitationEmployee> habilitationsEmployee) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.company = company;
		this.direction = direction;
		this.team = team;
		this.habilitationsEmployee = habilitationsEmployee;
	}

	public Employee(Long id, String name, String firstName) {
		this.id=id;
		this.name=name;
		this.firstName=firstName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public List<HabilitationEmployee> getHabilitations() {
		return habilitationsEmployee;
	}
	public void setHabilitations(List<HabilitationEmployee> habilitationsEmployee) {
		this.habilitationsEmployee = habilitationsEmployee;
	}
	
	
	
	
}
