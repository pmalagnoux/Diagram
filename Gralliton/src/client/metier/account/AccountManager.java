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
			Account userAccount = (Account) session.getAttribute("userAccount");
			connection.setResultSet(connection.getStatement().executeQuery("SELECT `id` FROM `account` WHERE `username` = \"" + userAccount.getLogin() + "\";"));
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
}
