package dao;

public class Produit {

	private Long idProduit;
	private String libelle;
	private String description;
	private Double prix;
	private int qte;
	private Categorie cat;

	public Produit() {
	}

	public Produit(String libelle, String description, Double prix, int qte) {
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.qte = qte;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public Produit(String libelle, String description, Double prix, int qte,
			Categorie cat) {
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.qte = qte;
		this.cat = cat;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public void show() {
		System.out.println(this.libelle + " - " + this.description + " - "
				+ this.prix.toString() + " - " + this.qte);
	}

	public boolean equals(Produit obj) {
		return (this.idProduit == obj.idProduit);
	}
}
