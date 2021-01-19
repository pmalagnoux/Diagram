package client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.WS;
import webservice.WebServiceSOAPService;

@WebServlet("/RecipeSearchServlet")
public class RecipeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RecipeSearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cookingTime = 0;
        int difficulty = 0;
        int recipeType = 0;
        String keyWord = "";
        WS stub = new WebServiceSOAPService().getWSPort();
        
        if(request.getParameter("cookingTime") != null) {
            cookingTime = Integer.parseInt(request.getParameter("cookingTime"));
        }
        if(request.getParameter("difficulty") != null) {
            difficulty = Integer.parseInt(request.getParameter("difficulty"));
        }
        if(request.getParameter("recipeType") != null) {
            recipeType = Integer.parseInt(request.getParameter("recipeType"));
        }
        if(request.getParameter("keyWord") != null) {
            keyWord = request.getParameter("keyWord");
        }
        
        request.setAttribute("recipes", stub.getRecipes(difficulty,recipeType,cookingTime,keyWord));
        request.setAttribute("difficulties", stub.getDifficulties());
        request.setAttribute("recipeTypes", stub.getRecipeTypes());
        request.setAttribute("accounts", stub.getAccounts());
        this.getServletContext().getRequestDispatcher("/WEB-INF/recipeSearch.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
