package client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.metier.AccountManager;
import client.metier.DifficultyManager;
import client.metier.RecipeManager;
import client.metier.RecipeTypeManager;

/**
 * Servlet implementation class RecipeSearchServlet
 */
@WebServlet("/RecipeSearchServlet")
public class RecipeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cookingTime = 0;
		int difficulty = 0;
		int recipeType = 0;
		
		if(request.getParameter("cookingTime") != null) {
			cookingTime = Integer.parseInt(request.getParameter("cookingTime"));
		}
		if(request.getParameter("difficulty") != null) {
			difficulty = Integer.parseInt(request.getParameter("difficulty"));
		}
		if(request.getParameter("recipeType") != null) {
			recipeType = Integer.parseInt(request.getParameter("recipeType"));
		}
		request.setAttribute("recipes", RecipeManager.getRecipes(difficulty,recipeType,cookingTime));
		request.setAttribute("difficulties", DifficultyManager.getDifficulties());
		request.setAttribute("recipeTypes", RecipeTypeManager.getRecipeTypes());
		request.setAttribute("accounts", AccountManager.getAccounts());
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipeSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
