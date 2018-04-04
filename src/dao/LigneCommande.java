package dao;

public class LigneCommande {
	private Long idLigneCommande;
	private int qte;
	private Double prixUnitaire;

	private Commande cmd;
	private Produit produit;

	public LigneCommande() {
	}

	public LigneCommande(int qte, Commande cmd, Produit produit) {
		this.qte = qte;
		this.cmd = cmd;
		this.produit = produit;
		this.prixUnitaire = this.produit.getPrix();
	}

	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Commande getCmd() {
		return cmd;
	}

	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
}
