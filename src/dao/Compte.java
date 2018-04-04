package dao;

import java.util.Date;

public class Compte {
	private Long idCompte;
	private Client client; // Reference vers client
	private String password;
	private Date derniereConnex;

	public Compte() {
	}

	public Compte(Client client, String password) {
		this.client = client;
		this.password = password;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDerniereConnex() {
		return derniereConnex;
	}

	public void setDerniereConnex(Date derniereConnex) {
		this.derniereConnex = derniereConnex;
	}
}
