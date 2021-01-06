package client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.EJBs.DifficultyManager;
import client.EJBs.IngredientManager;
import client.EJBs.RecipeTypeManager;
import client.EJBs.TagManager;
import client.EJBs.UstensilManager;

/**
 * Servlet implementation class RecipeCreationServlet
 */
@WebServlet("/RecipePrecreationServlet")
public class RecipePrecreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipePrecreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("difficulties", DifficultyManager.getDifficulties());
		request.setAttribute("recipeTypes", RecipeTypeManager.getRecipeTypes());
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipePrecreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	

		session.setAttribute("title", request.getParameter("title"));
		session.setAttribute("preparationTime", request.getParameter("preparationTime"));
		session.setAttribute("cookingTime", request.getParameter("cookingTime"));
		session.setAttribute("personCount", request.getParameter("personCount"));
		session.setAttribute("difficulty", request.getParameter("difficulty"));
		session.setAttribute("recipeType", request.getParameter("recipeType"));

		request.setAttribute("utensilsCount", request.getParameter("utensilsCount"));
		request.setAttribute("tagsCount", request.getParameter("tagsCount"));
		request.setAttribute("ingredientsCount", request.getParameter("ingredientsCount"));
		request.setAttribute("stepsCount", request.getParameter("stepsCount"));
		request.setAttribute("ustensils", UstensilManager.getUstensils());
		request.setAttribute("ingredients", IngredientManager.getIngredients());
		request.setAttribute("tags", TagManager.getTags());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipeCreation.jsp").forward(request, response);
	}

}
