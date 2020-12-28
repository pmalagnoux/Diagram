package client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.EJBs.AccountManager;
import client.EJBs.Ingredient;
import client.EJBs.IngredientManager;
import client.EJBs.Recipe;
import client.EJBs.RecipeManager;
import client.EJBs.Step;
import client.EJBs.StepManager;
import client.EJBs.Tag;
import client.EJBs.TagManager;
import client.EJBs.Ustensil;
import client.EJBs.UstensilManager;

/**
 * Servlet implementation class RecipeCreation
 */
@WebServlet("/RecipeCreationServlet")
public class RecipeCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeCreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipeCreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	

		String title = (String) session.getAttribute("title");
		int preparationTime = Integer.parseInt((String) session.getAttribute("preparationTime"));
		int cookingTime = Integer.parseInt((String) session.getAttribute("cookingTime"));
		int personCount = Integer.parseInt((String) session.getAttribute("personCount"));
		int difficulty = Integer.parseInt((String) session.getAttribute("difficulty"));
		int recipeType = Integer.parseInt((String) session.getAttribute("recipeType"));
		Recipe recipe = new Recipe(title, preparationTime, cookingTime, personCount, AccountManager.getCurrentAccountId(request), difficulty, recipeType);
		//Insertion BD
		RecipeManager.addRecipe(recipe);
		
		//Vider la session
		session.removeAttribute("preparationTime");
		session.removeAttribute("cookingTime");
		session.removeAttribute("personCount");
		session.removeAttribute("difficulty");
		session.removeAttribute("recipeType");
		
		int i = 1;
		// Steps
		while(request.getParameter("step"+i) != null) {
			Step step = new Step((String) request.getParameter("step"+i));
			StepManager.addStep(step, i, RecipeManager.getLastRecipeId());
			i++;
		}
		
		i = 1;
		// Ingrédients
		while(request.getParameter("ingredient"+i) != null) {
			Ingredient ingredient = new Ingredient(Integer.parseInt(request.getParameter("ingredient"+i)));
			int quantity = Integer.parseInt(request.getParameter("ingredient" + i + "Qty"));
			IngredientManager.addIngredient(ingredient, quantity, RecipeManager.getLastRecipeId());
			i++;
		}
		
		i = 1;
		// Ustensiles
		while(request.getParameter("ustensil"+i) != null) {
			Ustensil ustensil = new Ustensil(Integer.parseInt(request.getParameter("ustensil"+i)));
			int quantity = Integer.parseInt(request.getParameter("ustensil" + i + "Qty"));
			UstensilManager.addUstensil(ustensil, quantity, RecipeManager.getLastRecipeId());
			i++;
		}
		
		// Tags
		i = 1;
		while(request.getParameter("tag"+i) != null) {
			Tag tag = new Tag(Integer.parseInt(request.getParameter("tag"+i)));
			int quantity = Integer.parseInt(request.getParameter("ustensil" + i + "Qty"));
			TagManager.addUstensil(tag, RecipeManager.getLastRecipeId());
			i++;
		}
		this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
	}

}
