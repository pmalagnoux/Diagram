package client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.metier.account.AccountManager;
import client.metier.difficulty.DifficultyManager;
import client.metier.ingredient.IngredientManager;
import client.metier.recipe.RecipeManager;
import client.metier.recipeType.RecipeType;
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
		//HttpServletRequest.getParameterValues(recipeId);
		
		// TODO Get l'id depuis l'url 
		int recipeId = 0;
		request.setAttribute("recipe",RecipeManager.getRecipeById(recipeId));
		request.setAttribute("steps",StepManager.getStepsById(recipeId));
		request.setAttribute("diffculty",DifficultyManager.getDifficultyById(recipeId));
		request.setAttribute("tags",TagManager.getTagsById(recipeId));
		request.setAttribute("type",RecipeTypeManager.getTypeById(recipeId));
		request.setAttribute("ingredients",IngredientManager.getIngredientsById(recipeId));
		request.setAttribute("ustensils",UstensilManager.getUstensilsById(recipeId));
		request.setAttribute("account",AccountManager.getAccountById(recipeId));

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
