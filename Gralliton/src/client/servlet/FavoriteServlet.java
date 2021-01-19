package client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservice.WS;
import webservice.WebServiceSOAPService;


@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FavoriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();	
		WS stub = new WebServiceSOAPService().getWSPort();
		
		if(session.getAttribute("userLogin") != null) { // Utilisateur est connecté 
			String userLogin = (String) session.getAttribute("userLogin");
			int accId = stub.getCurrentAccountId(userLogin);
			request.setAttribute("favoriteRecipes", stub.getFavorites(accId));
			request.setAttribute("difficulties", stub.getDifficulties());
			request.setAttribute("recipeTypes", stub.getRecipeTypes());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/favorite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
