package client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webservice.Ingredient;
import webservice.Recipe;
import webservice.Step;
import webservice.Tag;
import webservice.Ustensil;
import webservice.WS;
import webservice.WebServiceSOAPService;


@WebServlet("/RecipeCreationServlet")
public class RecipeCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecipeCreationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipeCreation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userLogin = (String) session.getAttribute("userLogin");
		WS stub = new WebServiceSOAPService().getWSPort();
		
		String title = (String) session.getAttribute("title");
		int preparationTime = Integer.parseInt((String) session.getAttribute("preparationTime"));
		int cookingTime = Integer.parseInt((String) session.getAttribute("cookingTime"));
		int personCount = Integer.parseInt((String) session.getAttribute("personCount"));
		int difficulty = Integer.parseInt((String) session.getAttribute("difficulty"));
		int recipeType = Integer.parseInt((String) session.getAttribute("recipeType"));
		Recipe recipe = stub.getRecipe2(title, preparationTime, cookingTime, personCount, stub.getCurrentAccountId(userLogin), difficulty, recipeType);
		//Insertion BD
		stub.addRecipe(recipe);
		
		//Vider la session
		session.removeAttribute("preparationTime");
		session.removeAttribute("cookingTime");
		session.removeAttribute("personCount");
		session.removeAttribute("difficulty");
		session.removeAttribute("recipeType");
		
		int i = 1;
		// Steps
		while(request.getParameter("step"+i) != null) {
			Step step = stub.getStep1((String) request.getParameter("step"+i));
			stub.addStep(step, i, stub.getLastRecipeId());
			i++;
		}
		
		i = 1;
		// Ingrédients
		while(request.getParameter("ingredient"+i) != null) {
			Ingredient ingredient = stub.getIngredient1(Integer.parseInt(request.getParameter("ingredient"+i)));
			int quantity = Integer.parseInt(request.getParameter("ingredient" + i + "Qty"));
			stub.addIngredient(ingredient, quantity, stub.getLastRecipeId());
			i++;
		}
		
		i = 1;
		// Ustensiles
		while(request.getParameter("ustensil"+i) != null) {
			Ustensil ustensil = stub.getUstensil1(Integer.parseInt(request.getParameter("ustensil"+i)));
			int quantity = Integer.parseInt(request.getParameter("ustensil" + i + "Qty"));
			stub.addUstensil(ustensil, quantity, stub.getLastRecipeId());
			i++;
		}
		
		// Tags
		i = 1;
		while(request.getParameter("tag"+i) != null) {
			Tag tag = stub.getTag1(Integer.parseInt(request.getParameter("tag"+i)));
			stub.addTag(tag, stub.getLastRecipeId());
			i++;
		}
		this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
	}

}
