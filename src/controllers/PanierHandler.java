package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Commande;
import dao.Compte;
import dao.LigneCommande;
import dao.LignePanier;
import dao.Panier;
import dao.Produit;
import dao.Services;

/**
 * Servlet implementation class PanierHandler
 */
@WebServlet("/PanierHandler")
public class PanierHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanierHandler() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = "";
		action = request.getParameter("action");
		if (action != null && action.equals("remove")) {
			Panier panier = (Panier) request.getSession().getAttribute("panier");
			Long idp = Long.parseLong(request.getParameter("id"));
			int indice = 0;
			List<LignePanier> lignes = panier.getLignesPanier();
			for(Iterator<LignePanier> itL = lignes.iterator(); itL.hasNext();){
				LignePanier lp = itL.next();
				if(lp.getProduit().getIdProduit() == idp)
					{
						lignes.remove(indice);
						break;
					}
				else indice++;
			}
		}
		this.getServletContext().getRequestDispatcher("/pages/panier.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Recuperer le panier :
		Panier panier = (Panier) request.getSession().getAttribute("panier");
		List<LignePanier> lignes = panier.getLignesPanier();
		for (Iterator<LignePanier> itL = lignes.iterator(); itL.hasNext();) {
			LignePanier lp = itL.next();
			// Get the quantity :
			String qteStr = request.getParameter(lp.getProduit().getIdProduit().toString());
			int qte = Integer.parseInt(qteStr);
			lp.setQte(qte);
		}
		request.getSession().setAttribute("panier", panier);
		// Vérifier connexion :
		Compte c = (Compte) request.getSession().getAttribute("compte");
		if(c != null)	{
			// Connecté == > Enregistrer la commande :
			Date d = new Date();
			Commande cmd = new Commande(d, c.getClient());
			for(Iterator<LignePanier> itL = panier.getLignesPanier().iterator(); itL.hasNext();)	{
				LignePanier lp = itL.next();
				cmd.getLigneCommandes().add(new LigneCommande(lp.getQte(),cmd,lp.getProduit()));
			}
			Services services = new Services();
			// Persister :
			services.addCommande(cmd);
			services.addLigneCommande(cmd.getLigneCommandes());
			// Mise a jour de la quantite :
			for (Iterator<LigneCommande> lp = cmd.getLigneCommandes().iterator(); lp.hasNext();) {
				LigneCommande lc = (LigneCommande) lp.next();
				Produit p = lc.getProduit();
				p.setQte(p.getQte() - lc.getQte());
				services.updateProduit(p);
			}
			// Vider le panier :
			panier = new Panier();
			request.getSession().setAttribute("panier", panier);
			this.getServletContext().getRequestDispatcher("/pages/panier.jsp")
			.forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/pages/connexion.jsp")
			.forward(request, response);
		}
		
	}

}
