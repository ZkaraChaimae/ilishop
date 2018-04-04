package controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Compte;
import dao.Services;

/**
 * Servlet implementation class ConnexionHandler
 */
@WebServlet("/ConnexionHandler")
public class ConnexionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Services services = new Services();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionHandler() {
		super();
		// TODO Auto-generated constructor stub
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
					.getRequestDispatcher("/pages/connexion.jsp")
					.forward(request, response);
		else
			this.getServletContext()
					.getRequestDispatcher("/pages/index.jsp")
					.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String psd = request.getParameter("psd");
		System.out.println(login + " " + psd);
		List<Compte> comptes = services.getAllComptes();
		int trouve = 0;
		for (Iterator<Compte> itc = comptes.iterator(); itc.hasNext();) {
			Compte c = itc.next();
			if ((c.getClient().getEmail().equals(login) || c.getClient()
					.getTelephone().equals(login))
					&& c.getPassword().equals(psd)) {
				request.getSession().setAttribute("compte", c);
				trouve = 1;
				break;
			}
		}
		if (trouve == 0) {
			// Erreur :
			request.setAttribute("Erreur",
					"Veuillez entrer un login et/ou un mot de passe valide !");
			this.getServletContext()
					.getRequestDispatcher("/pages/connexion.jsp")
					.forward(request, response);
		} else {
			
			this.getServletContext()
			.getRequestDispatcher("/pages/panier.jsp")
			.forward(request, response);
		}
	}
}
