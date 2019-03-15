package org.mql.models;

public class Address {

	private String ville;
	private String rue;
	private int postal;
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getPostal() {
		return postal;
	}
	public void setPostal(int postal) {
		this.postal = postal;
	}
	@Override
	public String toString() {
		return "Address [ville=" + ville + ", rue=" + rue + ", postal=" + postal + "]";
	}
	
	
	
}
