package client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.metier.account.Account;
import client.metier.account.AccountManager;
import client.metier.favorite.FavoriteManager;
import webservice.SecuriteService;
import webservice.SecuriteWS;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		boolean[] areAvailable = AccountManager.isAvailable(email, login);
		if (!areAvailable[0]) {
			request.setAttribute("emailValid",false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		else if (!areAvailable[1]) {
			request.setAttribute("loginValid",false);
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		
		else {
			SecuriteWS stub = new SecuriteService().getSecuriteWSPort();
			
			String password = stub.encrypt(request.getParameter("password"));
			Account account = new Account(password,login,email);
			AccountManager.addAccount(account);
			
			this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
		}
	}
	
}
