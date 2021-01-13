package client.utils;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import webservice.SecuriteWS;
import webservice.SecuriteService;

public class Authentication {

	public void access(HttpServletRequest request) {
		//Se connecter � la BD	
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		String userLogin = request.getParameter("login");
		
		SecuriteWS stub1 = new SecuriteService().getSecuriteWSPort();	//WebService Securite
		
		
		String userPassword = stub1.encrypt(request.getParameter("password")); 
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM account"));
			
			//r�cup�ration des donn�es
			while(connection.getResultSet().next()) {
				String loginDB = connection.getResultSet().getString("username");
				String passwordDB = connection.getResultSet().getString("password");
				if(loginDB.equals(userLogin) && passwordDB.equals(userPassword)) {
					HttpSession session = request.getSession();	
					session.setAttribute("userLogin", userLogin);
					break;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("La BD n'est pas connect�e");
		}
		finally {
			connection.close();
		}
	}
	
	public Authentication() {
		super();
	}
}
