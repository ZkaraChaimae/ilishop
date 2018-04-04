package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import util.SessionClass;

public class Services {

	public void addClient(Client C)	{
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.save(C);
		session.getTransaction().commit();
	}
	
	public void addCompte(Compte C)	{
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.save(C);
		session.getTransaction().commit();
	}
	
	public void addProduit(Produit p) {
		Session session = SessionClass.getSession();;
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	public void addProduits(Set<Produit> p) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		Iterator<Produit> it = p.iterator();
		while(it.hasNext())
			session.save(it.next());
		session.getTransaction().commit();
	}
	
	public Produit getProduit(Long idP) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		Produit p = (Produit) session.load(Produit.class, idP);
		session.getTransaction().commit();
		return p;
	}

	public List<Produit> getAllProduits() {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		// Name of the POJO, not the name of the database' class :
		List<Produit> malist = session.createQuery("from Produit").list();
		session.getTransaction().commit();
		return malist;
	}

	//////////////////////////////////////////
	
	public void addCategorie(Categorie c) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	
	public Categorie getCategorie(Long idC) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		Categorie p = (Categorie) session.load(Categorie.class, idC);
		session.getTransaction().commit();
		return p;
	}
	
	public List<Categorie> getAllCategories() {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		// Name of the POJO, not the name of the database' class :
		List<Categorie> malist = session.createQuery("from Categorie").list();
		session.getTransaction().commit();
		return malist;
	}
	
	public List<Produit> getProduitsByCategorie(Categorie C) {
		Session session = SessionClass.getSession();
		String hql = "FROM Produit P WHERE P.cat.id_cat = "+C.getId_cat();
		session.beginTransaction();
		// Name of the POJO, not the name of the database' class :
		List<Produit> malist = session.createQuery(hql).list();
		session.getTransaction().commit();
		return malist;
	}
	
	public void addProduitToCategorie(Long idP,Long idC){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		
		Produit p = (Produit) session.load(Produit.class, idP);
		Categorie c = (Categorie) session.load(Categorie.class, idC);
		
		c.getProduits().add(p);
		p.setCat(c);
		
		session.getTransaction().commit();
		///// OBLIGATOIRE ! ==> Kadir des problèmes 
		//session.flush();
		//session.close();
	}
	
	public void addListeProduit(Categorie C, Set<Produit> produits){
		Session session = SessionClass.getSession();
		session.beginTransaction();
		// Join two sets :
		C.getProduits().addAll(produits);
		
		session.getTransaction().commit();
	}
	
	///////////////////////////////////////////////
	public List<Compte> getAllComptes() {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		// Name of the POJO, not the name of the database' class :
		List<Compte> malist = session.createQuery("from Compte").list();
		session.getTransaction().commit();
		return malist;
	}
	
	public void addCommande(Commande c) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
	}
	
	public void addLigneCommande(Set<LigneCommande> lc) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		
		Iterator<LigneCommande> it = lc.iterator();
		while(it.hasNext())
			session.save(it.next());
		
		session.getTransaction().commit();
	}
	////////////////////////////////////////////////
	public void updateCategorie(Categorie c) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	
	public void updateClient(Client c) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	
	public void updateCompte(Compte c) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
	}
	
	public void updateProduit(Produit p) {
		Session session = SessionClass.getSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
	}
}
