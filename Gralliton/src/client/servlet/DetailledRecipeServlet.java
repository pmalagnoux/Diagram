package client.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.metier.account.AccountManager;
import client.metier.difficulty.DifficultyManager;
import client.metier.favorite.FavoriteManager;
import client.metier.ingredient.IngredientManager;
import client.metier.recipe.Recipe;
import client.metier.recipe.RecipeManager;
import client.metier.recipeType.RecipeTypeManager;
import client.metier.step.StepManager;
import client.metier.tag.TagManager;
import client.metier.ustensil.UstensilManager;

/**
 * Servlet implementation class DetailledRecipeServlet
 */
@WebServlet("/DetailledRecipeServlet")
public class DetailledRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailledRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("recipeId") != null) {
			
			int recipeId = Integer.parseInt(request.getParameter("recipeId"));
			request.setAttribute("recipe",RecipeManager.getRecipeById(recipeId));
			request.setAttribute("steps",StepManager.getStepsById(recipeId));
			request.setAttribute("difficulty",DifficultyManager.getDifficultyById(recipeId));
			request.setAttribute("tags",TagManager.getTagsById(recipeId));
			request.setAttribute("type",RecipeTypeManager.getTypeById(recipeId));
			request.setAttribute("ingredients",IngredientManager.getIngredientsById(recipeId));
			request.setAttribute("ustensils",UstensilManager.getUstensilsById(recipeId));
			request.setAttribute("account",AccountManager.getAccountById(recipeId));
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailledRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userId = AccountManager.getCurrentAccountId(request);
		
		if(session.getAttribute("userLogin") != null /*&& userId !=0*/) { // Utilisateur est connecté    // Utile de check pour userId !=0 ? car tout le temps != 0
			int recipeId = Integer.parseInt(request.getParameter("recipeId")); // Paramètre jamais nul ici
			List<Recipe> favoriteRecipes = FavoriteManager.getFavorites(userId);
			
			boolean isIn = false;
			for(Recipe recipe : favoriteRecipes) {
				if (recipe.getId() == recipeId) {
					isIn = true;
				}
 			}
			if (!isIn) FavoriteManager.addFavorite(userId,recipeId);
		}
		doGet(request, response);
	}


}
