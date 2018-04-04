package dao;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	private Client client;
	private List<LignePanier> lignesPanier = new ArrayList<>();

	public Panier() {
		
	}

	public Panier(Client client, List<LignePanier> lignesPanier) {
		this.client = client;
		this.lignesPanier = lignesPanier;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LignePanier> getLignesPanier() {
		return lignesPanier;
	}

	public void setLignesPanier(List<LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}
}
