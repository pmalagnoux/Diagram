package fr.polytech.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLDemo
 */
@WebServlet("/JSTLDemo")
public class JSTLDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSTLDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		
		String terme1 = request.getParameter("terme1");
		String terme2 = request.getParameter("terme2");
		if(terme1 != null && terme2 != null) {
			int resultat = Integer.parseInt(terme1) + Integer.parseInt(terme2);
			request.setAttribute("resultat", resultat);
		}
		
		
		Etudiant e = new Etudiant(1, "Florian", "miller");
		request.setAttribute("etudiant", e);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JspJstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
