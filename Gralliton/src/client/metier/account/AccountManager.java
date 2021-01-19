package client.metier.account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import client.metier.difficulty.Difficulty;
import client.utils.ConnectionToDB;

public abstract class AccountManager {
	
	/**
	 * Ajoute un compte Utilisateur dans la BDD.
	 * @param account
	 */
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
	
	/**
	 * Retourne l'id du Compte en fonction du Login.
	 * @param userLogin
	 * @return  int
	 */
	public static int getCurrentAccountId(String userLogin) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			
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
		return 0;
	}
	
	/**
	 * Retourne la liste de tous les comptes de la BDD.
	 * @return List
	 */
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
	
	/**
	 * Retourne un tableau de Boolean de la forme [true, false] :
	 * - Le premier est true si l'adresse email est déjà utilisée
	 * - Le deuxième est true si le login est délà utilisé
	 * @param email
	 * @param login
	 * @return  boolean[]
	 */
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
	
	/**
	 * Retourne le Compte du créateur d'une recette grâce à l'id de cette dernière.
	 * @param recipeId
	 * @return Account
	 */
	public static Account getAccountById(int recipeId) {
		Account result ;
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `username` FROM `account`,`recipe` WHERE `account`.`id` = `recipe`.`account_id` AND `recipe`.`id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
				result = new Account(connection.getResultSet().getString("username"));
			
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (account) getAccountById");
		}
		finally {
			connection.close();
		}
		return null;
	}
	

}
