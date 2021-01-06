package client.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authentication {

	public void access(HttpServletRequest request) {
		//Se connecter à la BD	
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		String userLogin = request.getParameter("login");
		String userPassword = encrypt(request.getParameter("password")); 
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM account"));
			
			//récupération des données
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
			System.out.println("La BD n'est pas connectée");
		}
		finally {
			connection.close();
		}
	}
	
	public Authentication() {
		super();
	}

	
	/**
	 * Encrypte une chaine de caractères passée en paramètre et retourne la chaîne encryptée.
	 * @param password
	 * @return
	 */
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
