package client.EJBs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import client.utils.ConnectionToDB;

public class AccountManager {
	
	public void addAccount(Account account) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.connect();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `account`(`username`, `password`, `mailAddress`) VALUES (?,?,?);");
			preparedStatement.setString(1, account.getLogin());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setString(3, account.getEmail());
			
			// executer la requête
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème d'insertion dans la BD");
		}finally {
			connection.disconnect();
		}
	}
}
