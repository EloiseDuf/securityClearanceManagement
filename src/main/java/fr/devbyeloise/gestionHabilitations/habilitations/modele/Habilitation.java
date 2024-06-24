package fr.devbyeloise.gestionHabilitations.habilitations.modele;

public class Habilitation {
	private long id;
	private String name;
	private int frequency;
	private Theme theme;
	
	
	public Habilitation (long id) {
		this.id=id;
	}
	
	public Habilitation (long id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public Habilitation (Long id,String name, Theme theme) {
		this.id=id;
		this.name=name;
		this.theme=theme;
	}
	
	public Habilitation (String name, Theme theme) {
		this.name=name;
		this.theme=theme;
	}
	
	public Habilitation (long id, String name, int frequency, Theme theme) {
		this.id=id;
		this.name=name;
		this.frequency= frequency;
		this.theme=theme;
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
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

//	@Override
//	public String toString() {
//		return "Habilitation [id=" + id + ", name=" + name + ", frequency=" + frequency + ", subdomain=" + subdomain
//				+ "]";
//	}
	
	
	
}
