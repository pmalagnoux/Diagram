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


@WebServlet("/DetailledRecipeServlet")
public class DetailledRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailledRecipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("recipeId") != null) {
			
			WS stub = new WebServiceSOAPService().getWSPort();
			
			int recipeId = Integer.parseInt(request.getParameter("recipeId"));
			request.setAttribute("recipe",stub.getRecipeById(recipeId));
			request.setAttribute("steps",stub.getStepsById(recipeId));
			request.setAttribute("difficulty",stub.getDifficultyById(recipeId));
			request.setAttribute("tags",stub.getTagsById(recipeId));
			request.setAttribute("type",stub.getTypeById(recipeId));
			request.setAttribute("ingredients",stub.getIngredientsById(recipeId));
			request.setAttribute("ustensils",stub.getUstensilsById(recipeId));
			request.setAttribute("account",stub.getAccountById(recipeId));
			
			HttpSession session = request.getSession();
			String userLogin = (String) session.getAttribute("userLogin");
			
			if(userLogin != null) { // est connecté
				if(stub.isFavorite(stub.getCurrentAccountId(userLogin), recipeId)) {	// est déjà dans les favoris
					request.setAttribute("isFavorite",true);
				}
				else request.setAttribute("isFavorite",false);
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailledRecipe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userLogin = (String) session.getAttribute("userLogin");
		WS stub = new WebServiceSOAPService().getWSPort();
		
		int userId = stub.getCurrentAccountId(userLogin);
		
		if(userLogin != null && request.getParameter("recipeIdAdd") != null) { // Utilisateur est connectï¿½ et ajoutï¿½ favoris et selectionnï¿½
			int recipeId = Integer.parseInt(request.getParameter("recipeIdAdd")); 
			
			if(!stub.isFavorite(stub.getCurrentAccountId(userLogin), recipeId))
				stub.addFavorite(userId,recipeId);
		}
		else if(userLogin != null && request.getParameter("recipeIdDel") != null) { // Utilisateur est connectï¿½ et suppression favoris et selectionnï¿½
			
			int recipeId = Integer.parseInt(request.getParameter("recipeIdDel")); 
			
			if(stub.isFavorite(stub.getCurrentAccountId(userLogin), recipeId))
				stub.removeFavorite(userId,recipeId);
		}
		doGet(request, response);
	}


}
