package client.metier.account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import client.utils.ConnectionToDB;

public abstract class AccountManager {
	public static void addAccount(Account account) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `account`(`username`, `password`, `mailAddress`) VALUES (?,?,?);");
			preparedStatement.setString(1, account.getLogin());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setString(3, account.getEmail());
			
			// executer la requête
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème d'insertion dans la BD (account)");
		}finally {
			connection.close();
		}
	}
	
	public static int getCurrentAccountId(HttpServletRequest request) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			
			//Récupération du login depuis la session
			HttpSession session = request.getSession();	
			String userLogin = (String) session.getAttribute("userLogin");
			connection.setResultSet(connection.getStatement().executeQuery("SELECT `id` FROM `account` WHERE `username` = '"+ userLogin +"';"));
			connection.getResultSet().next();
			return connection.getResultSet().getInt("id");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (account)");
		}
		finally {
			connection.close();
		}
		return 0; // gestion
	}
	
	public static List<Account> getAccounts(){
		List<Account> result = new ArrayList<Account>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT `id`, `username` FROM `account`;"));
			//récupération des données
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String username = connection.getResultSet().getString("username");
				result.add(new Account(id,username));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (account)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	public static boolean[] isAvailable(String email, String login) {
		boolean[] result = new boolean[] {false,false};
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		try {
			String req = "SELECT COUNT(*)as nb FROM `account` WHERE `username` = '"+ login +"';";
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
			if(connection.getResultSet().getInt("nb")==0) result[1] = true;

				
				
			req ="SELECT COUNT(*) as nb FROM `account` WHERE `mailAddress` = '"+ email +"';";
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
			if(connection.getResultSet().getInt("nb")==0) result[0] = true;
			
		} catch (SQLException e) {
			System.out.println("Erreur de connection (account)");
			return new boolean[]{false,false};
		}
		finally {
			connection.close();
		}
		 
		return result;
	}
	

}
