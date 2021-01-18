package client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.metier.account.AccountManager;
import client.metier.difficulty.DifficultyManager;
import client.metier.favorite.FavoriteManager;
import client.metier.recipe.RecipeManager;
import client.metier.recipeType.RecipeTypeManager;

/**
 * Servlet implementation class MyRecipiesServlet
 */
@WebServlet("/MyRecipesServlet")
public class MyRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRecipesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();	
		if(session.getAttribute("userLogin") != null) { // Utilisateur est connecté 
			String userLogin = (String) session.getAttribute("userLogin");
			int accountId = AccountManager.getCurrentAccountId(userLogin);
			request.setAttribute("myRecipes", RecipeManager.getRecipesbyAccountId(accountId));
			request.setAttribute("difficulties", DifficultyManager.getDifficulties());
			request.setAttribute("recipeTypes", RecipeTypeManager.getRecipeTypes());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/myRecipes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
