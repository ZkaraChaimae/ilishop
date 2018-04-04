package dao;

public class LignePanier {
	private Panier panier;
	private Produit produit;
	private int qte;

	public LignePanier() {
	}

	public LignePanier(Panier panier, Produit produit, int qte) {
		this.panier = panier;
		this.produit = produit;
		this.qte = qte;
	}
	
	public LignePanier(Produit produit, int qte) {
		this.produit = produit;
		this.qte = qte;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
}
