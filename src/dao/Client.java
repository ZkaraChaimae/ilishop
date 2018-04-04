package dao;

import java.util.Set;

public class Client {
	private Long idClient;
	private String nom;
	private String prenom;
	private String telephone;
	private String Adresse;
	private String Ville;
	private String email;
	
	private Compte compte; // Reference vers compte
	private Set<Commande> commandes;
	
	public Client(){}
	
	public Client(String nom, String prenom, String telephone, String adresse,
			String ville, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		Adresse = adresse;
		Ville = ville;
		this.email = email;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
}
