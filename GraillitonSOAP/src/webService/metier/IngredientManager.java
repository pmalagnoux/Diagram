package webService.metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import webService.ConnectionToDB;


@WebService(name="IngredientManagerWS")
public abstract class IngredientManager {
	
	@WebMethod(operationName="getIngredients")
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
	@WebMethod(operationName="addIngredient")
	public static void addIngredient(@WebParam(name="ingredient")Ingredient ingredient, @WebParam(name="quantity")int quantity, @WebParam(name="recipeId")int recipeId) {
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
}
