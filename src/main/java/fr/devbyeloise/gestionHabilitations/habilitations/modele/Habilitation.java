package fr.devbyeloise.gestionHabilitations.habilitations.modele;

public class Habilitation {
	private long id;
	private String name;
	private int frequency;
	private String subdomain;
	
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
	public String getSubdomain() {
		return subdomain;
	}
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
//	@Override
//	public String toString() {
//		return "Habilitation [id=" + id + ", name=" + name + ", frequency=" + frequency + ", subdomain=" + subdomain
//				+ "]";
//	}
	
	
	
}
