package fr.devbyeloise.gestionHabilitations.habilitations.modele;

public class Theme {
	private int id;
	private String name;
	
	public Theme (int id) {
		this.id=id;
	}
	
	public Theme (int id, String name) {
		this.id=id;
		this.name=name;
	}

	public Theme(String name) {
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
