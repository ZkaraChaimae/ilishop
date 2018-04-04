package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Commande {
	private Long idCommande;
	private Date dateCmd;

	private Client client;
	private Set<LigneCommande> ligneCommandes = new HashSet<LigneCommande>();

	public Commande(){
	}
	
	public Commande(Date dateCmd, Client client) {
		this.dateCmd = dateCmd;
		this.client = client;
	}

	public Commande(Date dateCmd, Client client,
			Set<LigneCommande> ligneCommandes) {
		this.dateCmd = dateCmd;
		this.client = client;
		this.ligneCommandes = ligneCommandes;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
}
