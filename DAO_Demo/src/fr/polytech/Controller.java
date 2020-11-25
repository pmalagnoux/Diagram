package fr.polytech;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Etudiants etudiantsList = new Etudiants();
        request.setAttribute("resultat", etudiantsList.allStudentsDisplay());
		this.getServletContext().getRequestDispatcher("/WEB-INF/dao2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on définit un objet de la classe métier... on fait apprel à la méthode addStudiant(Etudiant etudiant)
		Etudiants listeEtu = new Etudiants();
		if(request.getParameter("form").equals("create")) {
			Etudiant e = new Etudiant();
			e.setId(Integer.parseInt(request.getParameter("idCreate")));
			e.setNom(request.getParameter("nomCreate"));
			e.setPrenom(request.getParameter("prenomCreate"));
			
			listeEtu.addStudient(e);
		}else if(request.getParameter("form").equals("modif")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			listeEtu.modifyStudient(nom, prenom, id);
			
		}else if(request.getParameter("form").equals("delete")) {
			int id = Integer.parseInt(request.getParameter("suppr"));
			listeEtu.deleteStudient(id);
			
		}else if(request.getParameter("form").equals("search")) {
			String searchEtu = request.getParameter("search");
			request.setAttribute("searchEtu", listeEtu.findStudient(searchEtu));
			
		}
		
		
		doGet(request, response);
	}

}
