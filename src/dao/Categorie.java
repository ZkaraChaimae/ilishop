package dao;

import java.util.HashSet;
import java.util.Set;

public class Categorie {
	private Long id_cat;
	private String name;
	private Set<Produit> produits = new HashSet<Produit>();

	public Categorie() {
	}

	public Categorie(String name) {
		this.name = name;
	}

	public Categorie(String name, Set<Produit> produits) {
		this.name = name;
		this.produits = produits;
	}

	public Long getId_cat() {
		return id_cat;
	}

	public void setId_cat(Long id_cat) {
		this.id_cat = id_cat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}
