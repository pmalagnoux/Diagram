package client.utils;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authentication {
	private boolean connection;

	public void acces(HttpServletRequest request) {
		//Se connecter à la BD	
		ConnectionToDB connection = new ConnectionToDB();
		connection.connect();
		
		String userLogin = request.getParameter("login");
		String userPassword = request.getParameter("password"); 
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM account"));
			
			//récupération des données
			while(connection.getResultSet().next()) {
				String loginDB = connection.getResultSet().getString("username");
				String passwordDB = connection.getResultSet().getString("password");
				if(loginDB.equals(userLogin) && passwordDB.equals(userPassword)) {
					this.connection=true;
					HttpSession session = request.getSession();	
					session.setAttribute("userLogin", userLogin);
					break;
				}
				else {
					this.connection=false; 
				}
			}
			
		} catch (SQLException e) {
			System.out.println("La BD n'est pas connectée");
		}
		finally {
			connection.disconnect();
		}
	}
	
	public Authentication() {
		super();
	}

	public boolean isConnexion() {
		return connection;
	}

	public void setConnexion(boolean connexion) {
		this.connection = connexion;
	}
}
