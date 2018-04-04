package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dao.Categorie;
import dao.Client;
import dao.Compte;
import dao.Produit;
import dao.Services;

public class Test {

	public static void main(String[] args) {
		Services services = new Services();
		/*
		 * services.addProduit(new
		 * Produit("Souris","Une souris de marque HP",120.0,3));
		 * services.addProduit(new
		 * Produit("Cle","Une cle usb de 8 GO",60.0,13));
		 * services.addProduit(new
		 * Produit("Ecouteurs","Des ecouteurs",200.0,10));
		 * services.addProduit(new
		 * Produit("Cle","Une cle usb de 16 GO",90.0,12));
		 * 
		 * List<Produit> maList = services.getAllProduits(); for
		 * (Iterator<Produit> iterator = maList.iterator(); iterator.hasNext();)
		 * { Produit produit = (Produit) iterator.next(); produit.show(); }
		 */

		/*Categorie categorie = new Categorie("Electroniques");
		Set<Produit> produits = new HashSet<Produit>();
		produits.add(new Produit("Souris", "Une souris de marque HP", 120.0, 3,
				categorie));
		produits.add(new Produit("Cle", "Une cle usb de 8 GO", 60.0, 13,
				categorie));
		produits.add(new Produit("Ecouteurs", "Des ecouteurs", 200.0, 10,
				categorie));
		produits.add(new Produit("Cle", "Une cle usb de 16 GO", 90.0, 12,
				categorie));

		categorie.setProduits(produits);

		// services.addProduits(produits);
		services.addCategorie(categorie);*/

		// Client client = new Client("Zkara", "Chaimae", "0634861455",
		// "Lot 59 Ouadi Eddahab", "Mohammedia", "zkara.chaimae@gmail.com");

		// services.addListeProduit(categorie, produits);
		/*
		 * List<Produit> maList = services.getAllProduits(); Categorie cat =
		 * services.getCategorie((long) 1);
		 * 
		 * for(Iterator<Produit> iterator = cat.getProduits().iterator();
		 * iterator.hasNext();) { Produit produit = (Produit) iterator.next();
		 * produit.show(); }
		 */

		/*List<Categorie> listCat = services.getAllCategories();
		for (Iterator<Categorie> itCat = listCat.iterator(); itCat.hasNext();) {
			Set<Produit> listProd = itCat.next().getProduits();
			for (Iterator<Produit> itProd = listProd.iterator(); itProd
					.hasNext();) {
				Produit produit = (Produit) itProd.next();
				produit.show();
			}
		}*/

		/*Client client = new Client("Chaimae", "Zkara", "0634861455",
				"Lot 59 Ouadi Eddahab", "Mohammedia", "zkara.chaimae@gmail.com");
		
		Compte compte = new Compte(client, "chaimae123");
		compte.setClient(client);
		services.addClient(client);
		services.addCompte(compte);
		*/
		/*List<Compte> comptes = services.getAllComptes();
		for (Iterator<Compte> itCompte = comptes.iterator(); itCompte.hasNext();) {
			Client c = itCompte.next().getClient();
			System.out.println(c.getNom());
		}*/
		
		Categorie categorie = new Categorie("Fournitures scolaires");
		Set<Produit> produits = new HashSet<Produit>();
		produits.add(new Produit("Stylo vert", "Stylot vert", 3.0, 100,
				categorie));
		produits.add(new Produit("Stylo bleu", "Stylot bleu", 3.0, 100,
				categorie));
		produits.add(new Produit("Stylo rouge", "Stylot rouge", 3.0, 100,
				categorie));

		categorie.setProduits(produits);

		services.addCategorie(categorie);
	}
}
