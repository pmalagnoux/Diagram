package client.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import client.EJBs.DifficultyManager;
import client.EJBs.IngredientManager;
import client.EJBs.RecipeManager;
import client.EJBs.RecipeTypeManager;
import client.EJBs.TagManager;
import client.EJBs.UstensilManager;

/**
 * Servlet implementation class RecipeCreationServlet
 */
@WebServlet("/RecipePrecreationServlet")
@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5,
maxRequestSize = 1024 * 1024 * 5 * 5)
public class RecipePrecreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String IMAGES_FOLDER = "/images/recipies";
    public String uploadPath;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath(IMAGES_FOLDER);
        File uploadDir = new File(uploadPath);
        if (! uploadDir.exists()) uploadDir.mkdir();
    }
    
    
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
		request.setAttribute("tags", TagManager.getRecipeTags());
		
		 for ( Part part : request.getParts() ) {
	            String fileName = getFileName( part );
	            String fullPath = uploadPath + File.separator + fileName;
	            part.write( fullPath );
	        }
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/recipeCreation.jsp").forward(request, response);
	}
	
	 private String getFileName( Part part ) {
	        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( content.trim().startsWith( "filename" ) )
	                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
	        }
	        return "Default.file";
	    }

}
