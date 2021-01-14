package client.metier.recipe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.tag.Tag;
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
			
			// executer la requête
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Problème d'insertion dans la BD (recipe)");
		}finally {
			connection.close();
		}
	}
	
	public static int getLastRecipeId() {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			
			connection.setResultSet(connection.getStatement().executeQuery("SELECT MAX(id) FROM `recipe`;"));
			connection.getResultSet().next();
			return connection.getResultSet().getInt("MAX(id)");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (recipe)");
		}
		finally {
			connection.close();
		}
		return 0; // GéRER LE RETURN 0
	}
	
	/**
	 * 
	 * @param maxDifficulty
	 * @param recipeType
	 * @param maxCookingTime
	 * @return recipes
	 */
	public static List<Recipe> getRecipes(int maxDifficulty, int recipeType, int maxCookingTime, String keyWord){
		List<Recipe> result = new ArrayList<Recipe>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		keyWord = keyWord.replace(" ", ""); // Suppression des espaces parasites
		String[] keyWords = keyWord.split(",");	// Découpe des mots clé suivant ","
		
		// ---------- Construction de la requète ----------
		String req = "SELECT * FROM `recipe`";
		int firstCriterion = 0;
		if(maxCookingTime == 0 && recipeType == 0 && maxDifficulty == 0 && keyWord.equals("")) { // aucun filtre
			req += ";";
			
		}else { // au moins 1 filtre 
			req += " WHERE";
			
			// ----- Premier critère -----
			// Mot-clé
			if(!keyWord.equals("")) { 
				firstCriterion = 1;
				req += " `id` IN ("
							+ "SELECT DISTINCT `recipe`.`id` "
							+ "FROM `ingredient`, `recipe`, `recipeingredient`,`ingredienttype` "
							+ "WHERE `ingredient`.`id`=`recipeingredient`.`ingredient_id` "
							+ "AND `recipe`.`id`=`recipeingredient`.`recipe_id` "
							+ "AND ( "
								+ "`ingredient`.`name` LIKE '%"+keyWord+"%' "
								+ "OR `recipe`.`name` LIKE '%"+keyWord+"%' "
								+ "OR `recipeingredient`.`ingredient_id` IN ("
									+ "SELECT `ingredient`.`id` "
									+ "FROM `ingredient`, `ingredienttype` "
									+ "WHERE `ingredient`.`ingredienttype_id`=`ingredienttype`.`id` "
									+ "AND `ingredienttype`.`name` LIKE '%"+keyWord+"%')))";
			}
			// Temps de cuisine
			if(maxCookingTime != 0) { 
				firstCriterion = 2;
				req += " `preparationTime` + `cookingTime` <= " + maxCookingTime;
			}
			// Type de recette
			else if(recipeType != 0) {
				firstCriterion = 3;
				req += " `recipeType_id` =  " + recipeType;
			}
			// Difficulté
			else if(maxDifficulty != 0) {
				firstCriterion = 4;
				req += " `difficulty_id` <= " + maxDifficulty;
			}
			
			// ----- Autre(s) critère(s) -----
			// Mot-clé
			if(firstCriterion != 1 && !keyWord.equals("")) {
				req += " AND `id` IN ("
							+ "SELECT DISTINCT `recipe`.`id` "
							+ "FROM `ingredient`, `recipe`, `recipeingredient`,`ingredienttype` "
							+ "WHERE `ingredient`.`id`=`recipeingredient`.`ingredient_id` "
							+ "AND `recipe`.`id`=`recipeingredient`.`recipe_id` "
							+ "AND ( "
								+ "`ingredient`.`name` LIKE '%"+keyWord+"%' "
								+ "OR `recipe`.`name` LIKE '%"+keyWord+"%' "
								+ "OR `recipeingredient`.`ingredient_id` IN ("
									+ "SELECT `ingredient`.`id` "
									+ "FROM `ingredient`, `ingredienttype` "
									+ "WHERE `ingredient`.`ingredienttype_id`=`ingredienttype`.`id` "
									+ "AND `ingredienttype`.`name` LIKE '%"+keyWord+"%')))";
				
			}
			// Temps de cuisine
			if(firstCriterion != 2 && maxCookingTime != 0) {
				req += " AND `preparationTime` + `cookingTime` <= " + maxCookingTime;
			}
			// Type de recette
			if(firstCriterion != 3 && recipeType != 0) {
				req += " AND `recipeType_id` =  " + recipeType;
			}
			// Difficulté
			if(firstCriterion != 4 && maxDifficulty != 0) {
				req += " AND `difficulty_id` <= " + maxDifficulty;
			}
			req += ";";
		}
		
		// ---------- Fin de la requète ----------
		
		// SELECT * FROM `recipe` WHERE `id` IN (SELECT DISTINCT `recipe`.`id` FROM `ingredient`, `recipe`, `recipeingredient`,`ingredienttype` WHERE `ingredient`.`id`=`recipeingredient`.`ingredient_id` AND `recipe`.`id`=`recipeingredient`.`recipe_id` AND( `ingredient`.`name` LIKE '%fromage%' OR `recipe`.`name` LIKE '%fromage%' OR `recipeingredient`.`ingredient_id` IN (SELECT `ingredient`.`id` FROM `ingredient`, `ingredienttype` WHERE `ingredient`.`ingredienttype_id`=`ingredienttype`.`id` AND `ingredienttype`.`name` LIKE '%fromage%')))
		
		// Recherche des recettes sans les tags
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
		// Ajout des tags
		try {

			for(int i = 0; i<result.size();i++) { // pour chaque recette
				//récupération des tags correspondant la recette i
				connection.setResultSet(connection.getStatement().executeQuery("SELECT `tagName`, `id` FROM `tag`,`recipetag` WHERE `tag_id`=`id` AND `recipe_id`="+result.get(i).getId()+";"));
				List<Tag> tagsID = new ArrayList<Tag>();
				while(connection.getResultSet().next()) {
					String tagName = connection.getResultSet().getString("tagName");
					int tagID = connection.getResultSet().getInt("id");
					tagsID.add(new Tag(tagID, tagName));
				}
				result.get(i).setTags(tagsID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (recipetag/tag)");
			return new ArrayList<Recipe>(); // retourne liste vide si erreur
		}
		finally {
			connection.close();
		}
		return result;
	}
}
