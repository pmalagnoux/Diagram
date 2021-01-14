package client.metier.ingredient;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.tag.Tag;
import client.utils.ConnectionToDB;

public abstract class IngredientManager {
	public static List<Ingredient> getIngredients(){
		List<Ingredient> result = new ArrayList<Ingredient>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM ingredient;"));
			
			//récupération des données
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new Ingredient(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (ingrédient)");
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
			
			// executer la requête
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème d'insertion dans la BD (recipeingredient)");
		}finally {
			connection.close();
		}
	}
	
	public static List<Ingredient> getIngredientsById(int recipeId) {
		List<Ingredient> result = new ArrayList<Ingredient>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `name`,`recipeingredient`.`quantity` FROM `ingredient`, `recipeingredient` WHERE `ingredient`.`id` = `recipeingredient`.`ingredient_id` AND `recipeingredient`.`recipe_id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			while(connection.getResultSet().next()) {
				result.add( new Ingredient(connection.getResultSet().getString("name"),connection.getResultSet().getDouble("quantity")));
			}
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (Ingredient) getIngredientssById");
		}
		finally {
			connection.close();
		}
		return null;
	}
	
	
	
}
