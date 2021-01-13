package webService.metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webService.utils.ConnectionToDB;

public abstract class IngredientManager {
	public static List<Ingredient> getIngredients(){
		List<Ingredient> result = new ArrayList<Ingredient>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM ingredient;"));
			
			//r�cup�ration des donn�es
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new Ingredient(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (ingr�dient)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 * Remplit la table recipeingredient(quantity,ingredient_id,recipe_id)
	 * @param ingredient
	 * @param quantity
	 * @param recipeId
	 */
	public static void addIngredient(Ingredient ingredient, int quantity, int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `recipeingredient`(`quantity`, `ingredient_id`, `recipe_id`) VALUES (?,?,?);");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, ingredient.getId());
			preparedStatement.setInt(3, recipeId);
			
			// executer la requ�te
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me d'insertion dans la BD (recipeingredient)");
		}finally {
			connection.close();
		}
	}
}
