package client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.metier.account.Account;
import client.metier.account.AccountManager;
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
		
		SecuriteWS stub = new SecuriteService().getSecuriteWSPort();
		
		String password = stub.encrypt(request.getParameter("password"));
		Account account = new Account(password,login,email);

		System.out.println(account.toString());
		AccountManager.addAccount(account);
		//CHECK UNIQUE USERNAME
		this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
	}

	
	public static boolean mailIsValid(String email) {
        if (email.endsWith(".fr") || email.endsWith(".com") ) {
            if (email.indexOf("@")>0) {
                return true;
            }
        }
        return false;
    }
	
}
