package client.EJBs;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import client.utils.ConnectionToDB;

public abstract class RecipeManager {
	public static void addRecipe(Recipe recipe) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `recipe`(`name`, `preparationTime`, `cookingTime`, `quantity`, `account_id`, `difficulty_id`, `recipeType_id`) VALUES (?,?,?,?,?,?,?);");
			preparedStatement.setString(1, recipe.getName());
			preparedStatement.setInt(2, recipe.getPreparationTime());
			preparedStatement.setInt(3, recipe.getCookingTime());
			preparedStatement.setInt(4, recipe.getQuantity());
			preparedStatement.setInt(5, recipe.getAccount());
			preparedStatement.setInt(6, recipe.getDifficulty());
			preparedStatement.setInt(7, recipe.getType());
			
			// executer la requ�te
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Probl�me d'insertion dans la BD (recipe)");
		}finally {
			connection.close();
		}
	}
	
	public static int getLastRecipeId() {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			
			connection.setResultSet(connection.getStatement().executeQuery("SELECT MAX(id) FROM `recipe`;"));
			connection.getResultSet().next();
			return connection.getResultSet().getInt("MAX(id)");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (recipe)");
		}
		finally {
			connection.close();
		}
		return 0; // G�RER LE RETURN 0
	}
}
