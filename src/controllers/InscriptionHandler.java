package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Client;
import dao.Compte;
import dao.Services;

/**
 * Servlet implementation class InscriptionHandler
 */
@WebServlet("/InscriptionHandler")
public class InscriptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionHandler() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Si non connecté :
		if (request.getSession().getAttribute("compte") == null)
			this.getServletContext()
					.getRequestDispatcher("/pages/inscription.jsp")
					.forward(request, response);
		else
			this.getServletContext().getRequestDispatcher("/pages/index.jsp")
					.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("tel");
		String email = request.getParameter("email");
		String addresse = request.getParameter("adr");
		String ville = request.getParameter("ville");
		String mdp = request.getParameter("psd");

		System.out.println(nom + " " + prenom + " " + telephone + " " + email
				+ " " + addresse + " " + ville + " " + mdp);

		Services services = new Services();
		List<Compte> comptes = services.getAllComptes();
		int trouve = 0;
		for (Iterator<Compte> itC = comptes.iterator(); itC.hasNext();) {
			Client client = itC.next().getClient();
			if (client.getEmail().equals(email))
				trouve = 1;
		}
		if (trouve == 1) {
			request.setAttribute("CompteExistant",
					"Vous avez deja un compte ! Veuillez vous connecter !");
			this.getServletContext()
					.getRequestDispatcher("/pages/inscription.jsp")
					.forward(request, response);

		} else {
			Client c = new Client(nom, prenom, telephone, addresse, ville,
					email);
			Compte cpt = new Compte(c, mdp);
			services.addClient(c);
			services.addCompte(cpt);
			request.getSession().setAttribute("compte", cpt);
			// Si panier plein ==> rediriger vers panier.jsp
			if (request.getSession().getAttribute("panier") != null)
				this.getServletContext()
						.getRequestDispatcher("/pages/panier.jsp")
						.forward(request, response);
			else
				this.getServletContext()
						.getRequestDispatcher("/pages/index.jsp")
						.forward(request, response);
		}
	}

}
