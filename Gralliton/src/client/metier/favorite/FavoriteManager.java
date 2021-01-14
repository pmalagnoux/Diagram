package client.metier.favorite;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import client.metier.account.AccountManager;
import client.metier.recipe.Recipe;
import client.utils.ConnectionToDB;

public abstract class FavoriteManager {
	
	public static void addFavorite(int accountId, int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();	
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `favoriterecipe`(`account_id`, `recipe_id`) VALUES (?, ?);");
			preparedStatement.setInt(1, accountId);
			preparedStatement.setInt(2, recipeId);
			preparedStatement.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("Problème d'insertion dans la BD (favoriterecipe)");
		}
		finally {
			connection.close();
		}
	}
	public static void removeFavorite(int accountId, int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();	
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("DELETE FROM `favoriterecipe` WHERE `account_id` = ? AND `recipe_id`VALUES = ?;");
			preparedStatement.setInt(1, accountId);
			preparedStatement.setInt(2, recipeId);
			preparedStatement.executeUpdate();	
		} catch (SQLException e) {
			System.out.println("Problème dans la BD (favoriterecipe)");
		}
		finally {
			connection.close();
		}
	}
	
	public static List<Recipe> getFavorites(HttpServletRequest request){
		System.out.println("oui1");
		int accId = AccountManager.getCurrentAccountId(request);
		System.out.println("non");
		List<Favorite> resultid =new ArrayList<Favorite>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		String req = "SELECT * FROM `favoriterecipe` WHERE `account_id` = '"+ accId +"';";
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			while(connection.getResultSet().next()) {
				int recipe_id = connection.getResultSet().getInt("recipe_id");
				resultid.add(new Favorite(accId, recipe_id));
			}
			
			
		} catch(SQLException e) {
			System.out.println("Problème dans la BD (favoriterecipe)");
			e.printStackTrace();
			return new ArrayList<Recipe>(); // retourne liste vide si erreur
		}
		List<Recipe> result = new ArrayList<Recipe>();
		for(Favorite fav : resultid ) {
			req = "SELECT * FROM `recipe` WHERE id = '"+ fav.getRecipe() + "';";

			try {
				connection.setStatement(connection.getConnection().createStatement());
				//execution d'une requête et récupération de résultat dans l'objet resultSet
				connection.setResultSet(connection.getStatement().executeQuery(req));
				//récupération des données
				while(connection.getResultSet().next()) {
					int id = connection.getResultSet().getInt("id");
					String name = connection.getResultSet().getString("name");
					int preparationTime = connection.getResultSet().getInt("preparationTime");
					int cookingTime = connection.getResultSet().getInt("cookingTime");
					int quantity = connection.getResultSet().getInt("quantity");
					int account_id = connection.getResultSet().getInt("account_id");
					int difficulty_id = connection.getResultSet().getInt("difficulty_id");
					int recipeType_id = connection.getResultSet().getInt("recipeType_id");
					int likeNumber = connection.getResultSet().getInt("likeNumber");
					result.add(new Recipe(id,name,preparationTime,cookingTime,likeNumber,quantity,account_id,difficulty_id,recipeType_id));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Problème de selection dans la BD (recipe)");
				return new ArrayList<Recipe>(); // retourne liste vide si erreur
			}
			finally{
				connection.close();
			}
		}	
		return result;
	
	}
	

}
