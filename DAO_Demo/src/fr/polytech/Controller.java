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
		// TODO Auto-generated method stub
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		etudiants.add(new Etudiant(1,"A","B"));
		etudiants.add(new Etudiant(2,"C","C"));
		etudiants.add(new Etudiant(3,"E","F"));
		etudiants.add(new Etudiant(4,"G","H"));
		
		//cr�er un objet de la classe m�tier....
		//dans cette classe �tudiant, on va avoir une m�thode qui permet de retourner une liste d'�tudiants
		//(on renvoie un objet m�tier)
		request.setAttribute("etudiants", etudiants);
		
		Etudiants etudiantsList = new Etudiants();
		request.setAttribute("resultat", etudiantsList.allStudentsDisplay());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dao2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on d�finit un objet de la classe m�tier... on fait apprel � la m�thode addStudiant(Etudiant etudiant)
		
		Etudiant e = new Etudiant();
		e.setId(Integer.parseInt(request.getParameter("id")));
		e.setNom(request.getParameter("nom"));
		e.setPrenom(request.getParameter("prenom"));
		
		Etudiants listeEtu = new Etudiants();
		listeEtu.addStudient(e);
		
		doGet(request, response);
	}

}
