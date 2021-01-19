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

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignInServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/sign_in.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WS stub = new WebServiceSOAPService().getWSPort();

		String userLogin = request.getParameter("login");
		String userPassword = stub.encrypt(request.getParameter("password")); 
		
		if(stub.access(userLogin, userPassword)) { 	// est connecté
			HttpSession session = request.getSession();	
			session.setAttribute("userLogin", userLogin);
			this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
		}
		else {	// n'est pas connecté
			request.setAttribute("wrongLogPass", true);
			doGet(request, response);
		}
			
	}

}
