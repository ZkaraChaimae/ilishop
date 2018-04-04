package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Categorie;
import dao.LignePanier;
import dao.Panier;
import dao.Produit;
import dao.Services;

/**
 * Servlet implementation class IndexHandler
 */
@WebServlet("/IndexHandler")
public class IndexHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Services services = new Services();
	private Panier panier;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Produit> produits = services.getAllProduits();
		List<Categorie> categories = services.getAllCategories();
		request.setAttribute("produits", produits);
		request.setAttribute("categories", categories);
		String action = "";
		action = request.getParameter("action");
		if (action != null && action.equals("addToCart")) {
			System.out.println("action : " + action + " idp : "
					+ request.getParameter("id"));
			// Chercher produit par id :
			Produit p = services.getProduit(Long.parseLong(request
					.getParameter("id")));
			System.out.println("Produit " + p.getLibelle());
			// Recuperer le panier :
			HttpSession session = request.getSession();
			if (session.getAttribute("panier") == null) {
				System.out.println("Panier n'existe pas !");
				panier = new Panier();
				panier.getLignesPanier().add(new LignePanier(p, 1));
				session.setAttribute("panier", panier);
			} else {
				System.out.println("Panier existe !");
				panier = (Panier) request.getSession().getAttribute("panier");
				List<LignePanier> lignes = panier.getLignesPanier();
				int trouve = 0;
				for(Iterator<LignePanier> itL = lignes.iterator(); itL.hasNext();)	{
					Produit produit = itL.next().getProduit();
					if(produit.getIdProduit() == p.getIdProduit()) trouve = 1;
				}
				System.out.println("Trouve : "+trouve);
				if(trouve == 0)
					panier.getLignesPanier().add(new LignePanier(p, 1));
				session.setAttribute("panier", panier);
			}
		} else if(action != null && action.equals("categorie"))	{
			// Chercher la categorie :
			Categorie cat = services.getCategorie(Long.parseLong(request.getParameter("id")));
			// Chercher les produits qui sont de categorie cat :
			produits = services.getProduitsByCategorie(cat);
			categories = services.getAllCategories();
			request.setAttribute("produits", produits);
			request.setAttribute("categories", categories);
		}
		this.getServletContext().getRequestDispatcher("/pages/index.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
