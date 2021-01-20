package client.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Account;
import webservice.GetAccount3;
import webservice.WS;
import webservice.WebServiceSOAPService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WS stub = new WebServiceSOAPService().getWSPort();
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		List<Boolean> areAvailable = stub.isAvailable(email, login);

		if (!areAvailable.get(0)) { 	// vérification que l'adresse mail est libre
			request.setAttribute("emailNotAvailable",true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		else if (!areAvailable.get(1)) {	// vérification que le login est libre
			request.setAttribute("loginNotAvailable",true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		else if (!stub.mailIsValid(email)) {	// vérification que l'adresse mail est valide
			request.setAttribute("emailNotValid",true);
			this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		else {
			
			String password = stub.encrypt(request.getParameter("password")); // cryptage du mdp
			Account account = stub.getAccount3(password,login,email);
			stub.addAccount(account);	// ajout du compte sur la BD
			
			this.getServletContext().getRequestDispatcher("/accueil").forward(request, response);
		}
	}
	
}
