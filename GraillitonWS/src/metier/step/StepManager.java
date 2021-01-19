package metier.step;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.ConnectionToDB;

public abstract class StepManager {
	
	
	/**
	 * Ajoute une �tape � une recette.
	 * @param step
	 * @param order
	 * @param recipeId
	 */
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
	
	/**
	 * Retourne l'id de la derni�re �tape enregistr�e dans la BDD.
	 * @return int
	 */
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
	
	/**
	 * Retourne la liste des �tapes d'une recette en fonction de l'id de cette derni�re.
	 * @param recipeId
	 * @return List
	 */
	public static List<Step> getStepsById(int recipeId) {
		List<Step> result = new ArrayList<Step>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `recipestep`.`stepOrder` AS stepOrder, `content` FROM `step`, `recipestep` WHERE `step`.`id` = `recipestep`.`step_id` AND `recipestep`.`recipe_id` = '"+recipeId+"' ORDER BY `recipestep`.`stepOrder`;";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			while(connection.getResultSet().next()) {
				result.add(new Step(connection.getResultSet().getInt("stepOrder"), connection.getResultSet().getString("content")));
			}
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (step) getStepsById");
		}
		finally {
			connection.close();
		}
		return null;
	}
}
