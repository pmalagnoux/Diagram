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

@WebServlet("/RecipePrecreationServlet")
public class RecipePrecreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RecipePrecreationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WS stub = new WebServiceSOAPService().getWSPort();
		request.setAttribute("difficulties", stub.getDifficulties());
		request.setAttribute("recipeTypes", stub.getRecipeTypes());
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipePrecreation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		WS stub = new WebServiceSOAPService().getWSPort();
		
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
		request.setAttribute("ustensils", stub.getUstensils());
		request.setAttribute("ingredients", stub.getIngredients());
		request.setAttribute("tags", stub.getTags());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipeCreation.jsp").forward(request, response);
	}

}
