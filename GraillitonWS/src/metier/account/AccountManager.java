package metier.account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.ConnectionToDB;

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
	 * Retourne une List de Boolean de la forme [true, false] :
	 * - Le premier est true si l'adresse email est déjà utilisée
	 * - Le deuxième est true si le login est délà utilisé
	 * @param email
	 * @param login
	 * @return  List
	 */
	public static List<Boolean> isAvailable(String email, String login) {
		System.out.println("1");
		List<Boolean> result = new ArrayList<Boolean>();
		result.add(false);
		result.add(false);
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		try {
			String req = "SELECT COUNT(*)as nb FROM `account` WHERE `username` = '"+ login +"';";
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
			if(connection.getResultSet().getInt("nb")==0) result.set(1,true);

				System.out.println("2");
				
			req ="SELECT COUNT(*) as nb FROM `account` WHERE `mailAddress` = '"+ email +"';";
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
			if(connection.getResultSet().getInt("nb")==0) result.set(0,true);
			
		} catch (SQLException e) {
			System.out.println("Erreur de connection (account)");
			result = new ArrayList<Boolean>();
			result.clear();
			result.add(false);
			result.add(false);
			System.out.println("3");
			return result;
		}
		finally {
			connection.close();
		}
		System.out.println("4");
		return result;
		// L'utilisation d'une liste est obligatoire ici car le WebService ne permet pas l'envoi de tableaux
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
