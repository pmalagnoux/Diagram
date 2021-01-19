package metier;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

public abstract class Authentication {

	public static boolean access(String userLogin, String password) {
		//Se connecter à la BD	
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT `password` FROM account WHERE `username` = '"+userLogin+"';"));
			
			//récupération des données
			connection.getResultSet().next();	
			String passwordDB = connection.getResultSet().getString("password");
			if(passwordDB.equals(password)) {
				return true;
			}		
		} catch (SQLException e) {
			System.out.println("La BD n'est pas connectée");
		}
		finally {
			connection.close();
		}
		return false;
	}
	
	
	public static String encrypt(String password) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			String encoded = Base64.getEncoder().encodeToString(hash);
			return encoded;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
		}
	
	public static boolean mailIsValid(String email) {
        if (email.endsWith(".fr") || email.endsWith(".com") )
            if (email.indexOf("@")>0)return true;
        return false;
    }
}
