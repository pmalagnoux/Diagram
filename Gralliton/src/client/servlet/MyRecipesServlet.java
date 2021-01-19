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

@WebServlet("/MyRecipesServlet")
public class MyRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyRecipesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WS stub = new WebServiceSOAPService().getWSPort();
		HttpSession session = request.getSession();	
		if(session.getAttribute("userLogin") != null) { // Utilisateur est connecté 
			String userLogin = (String) session.getAttribute("userLogin");
			int accountId = stub.getCurrentAccountId(userLogin);
			request.setAttribute("myRecipes", stub.getRecipesbyAccountId(accountId));
			request.setAttribute("difficulties", stub.getDifficulties());
			request.setAttribute("recipeTypes", stub.getRecipeTypes());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/myRecipes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
