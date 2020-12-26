package client.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authentication {
	private boolean connection;

	public void acces(HttpServletRequest request) {
		//Se connecter � la BD	
		ConnectionToDB connection = new ConnectionToDB();
		connection.connect();
		
		String userLogin = request.getParameter("login");
		String userPassword = encrypt(request.getParameter("password")); 
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM account"));
			
			//r�cup�ration des donn�es
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
			System.out.println("La BD n'est pas connect�e");
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
	private static String encrypt(String password) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);
			return encoded;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
