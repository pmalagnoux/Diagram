package client.metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import client.utils.ConnectionToDB;

public abstract class StepManager {
	public static void addStep(Step step, int order, int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		//failles d'injection SQL...
		try {
			//Insertion dans la table step
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `step`(`content`) VALUES (?);");
			preparedStatement.setString(1, step.getContent());
			preparedStatement.executeUpdate();
			
			//Insertion dans la table recipestep
			preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `recipestep`(`stepOrder`, `recipe_id`, `step_id`) VALUES (?,?,?);");
			preparedStatement.setInt(1, order);
			preparedStatement.setInt(2, recipeId);
			preparedStatement.setInt(3, getLastStepId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me d'insertion/selection dans la BD (step/recipestep)");
		}finally {
			connection.close();
		}
	}
	
	public static int getLastStepId() {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			
			connection.setResultSet(connection.getStatement().executeQuery("SELECT MAX(id) FROM `step`;"));
			connection.getResultSet().next();
			//r�cup�ration des donn�es
			return connection.getResultSet().getInt("MAX(id)");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (step)");
		}
		finally {
			connection.close();
		}
		return 0; // G�RER LE RETURN 0
	}
}
