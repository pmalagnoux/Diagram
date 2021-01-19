package client.metier.recipe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.tag.Tag;
import client.utils.ConnectionToDB;

public abstract class RecipeManager {
	
	/**
	 * Ajoute une recette à la BDD.
	 * @param recipe
	 */
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
	
	/**
	 * Récupère l'id de la dernière recette ajoutée.
	 * @return int
	 */
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
			System.out.println("Probl�me de selection dans la BD (recipe) getLastRecipeId");
		}
		finally {
			connection.close();
		}
		return 0; // G�RER LE RETURN 0
	}
	
	/**
	 * Récoupère la recette en fonction de son id.
	 * @param recipeId
	 * @return Recipe
	 */
	public static Recipe getRecipeById(int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM `recipe` WHERE `id` = '"+recipeId+"';"));
			connection.getResultSet().next();
			
			int id = connection.getResultSet().getInt("id");
			String name = connection.getResultSet().getString("name");
			int preparationTime = connection.getResultSet().getInt("preparationTime");
			int cookingTime = connection.getResultSet().getInt("cookingTime");
			int quantity = connection.getResultSet().getInt("quantity");
			int account_id = connection.getResultSet().getInt("account_id");
			int difficulty_id = connection.getResultSet().getInt("difficulty_id");
			int recipeType_id = connection.getResultSet().getInt("recipeType_id");
			int likeNumber = connection.getResultSet().getInt("likeNumber");
			
			Recipe recipe = new Recipe(id,name,preparationTime,cookingTime,likeNumber,quantity,account_id,difficulty_id,recipeType_id);
			return recipe;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (recipe) getRecipeById");
		}
		finally {
			connection.close();
		}
		return null; 
	}
	
	/**
	 * Selectionne dans la BD les recettes correspondantes aux filtres en param�tres
	 * @param maxDifficulty
	 * @param recipeType
	 * @param maxCookingTime
	 * @return recipes
	 */
	public static List<Recipe> getRecipes(int maxDifficulty, int recipeType, int maxCookingTime, String keyWord){
		List<Recipe> result = new ArrayList<Recipe>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		// ---------- Construction de la requ�te ----------
		
		String req = "SELECT * FROM `recipe`";
		boolean isFirstFilter = true;
		
		// Temps de cuisson
		if(maxCookingTime != 0) { 
			isFirstFilter = false;
			req += " WHERE `preparationTime` + `cookingTime` <= " + maxCookingTime;
		}
		
		// Difficult�
		if(maxDifficulty != 0) {
			if(isFirstFilter)
				req += " WHERE";
			else
				req += " AND";

			isFirstFilter = false;
			req += " `difficulty_id` <= " + maxDifficulty;
		}
		
		// Type de recette
		if(recipeType != 0) {
			if(isFirstFilter)
				req += " WHERE";
			else
				req += " AND";
			
			isFirstFilter = false;
			req += " `recipeType_id` =  " + recipeType;
		}
		
		// Mot-cl�
		if(!keyWord.equals("")) { 
			keyWord = keyWord.replace(" ", ""); // Suppression des espaces parasites
			String[] keyWords = keyWord.split(",");	// D�coupe des mots cl� suivant ","
			
			for (String kw : keyWords) {
				if(isFirstFilter)
					req += " WHERE";
				else
					req += " AND";

				isFirstFilter = false;
				req += " `id` IN ("
						+ "SELECT DISTINCT `recipe`.`id` "
						+ "FROM `ingredient`, `recipe`, `recipeingredient`,`ingredienttype` "
						+ "WHERE `ingredient`.`id`=`recipeingredient`.`ingredient_id` "
						+ "AND `recipe`.`id`=`recipeingredient`.`recipe_id` "
						+ "AND ( "
							+ "`ingredient`.`name` LIKE '%"+kw+"%' "
							+ "OR `recipe`.`name` LIKE '%"+kw+"%' "
							+ "OR `recipeingredient`.`ingredient_id` IN ("
								+ "SELECT `ingredient`.`id` "
								+ "FROM `ingredient`, `ingredienttype` "
								+ "WHERE `ingredient`.`ingredienttype_id`=`ingredienttype`.`id` "
								+ "AND `ingredienttype`.`name` LIKE '%"+kw+"%')))";
			}
		}
		req += ";";
		
		// ---------- Fin de la requ�te ----------
		
		
		// Recherche des recettes sans les tags
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			//r�cup�ration des donn�es
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
			System.out.println("Probl�me de selection dans la BD (recipe)");
			return new ArrayList<Recipe>(); // retourne liste vide si erreur
		}
		// Ajout des tags
		try {

			for(int i = 0; i<result.size();i++) { // pour chaque recette
				//r�cup�ration des tags correspondant la recette i
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
			System.out.println("Probl�me de selection dans la BD (recipetag/tag)");
			return new ArrayList<Recipe>(); // retourne liste vide si erreur
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 * Selectionne un nombre al�atoire de recette dans la BD
	 * @param recipeNumber
	 * @return
	 */
	public static List<Recipe> getRandomRecipes(int recipeNumber){
		List<Recipe> result = new ArrayList<Recipe>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
				
		String req = "SELECT * FROM `recipe` ORDER BY RAND() LIMIT "+recipeNumber+";";
		
		// Recherche des recettes sans les tags
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery(req));
			//r�cup�ration des donn�es
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
			System.out.println("Probl�me de selection dans la BD (recipe)");
			return new ArrayList<Recipe>(); // retourne liste vide si erreur
		}
		// Ajout des tags
		try {

			for(int i = 0; i<result.size();i++) { // pour chaque recette
				//r�cup�ration des tags correspondant la recette i
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
			System.out.println("Probl�me de selection dans la BD (recipetag/tag)");
			return new ArrayList<Recipe>(); // retourne liste vide si erreur
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 * Récupère la liste des recettes créées par un utilisateur en particulier en fonction de l'id du compte.
	 * @param accountId
	 * @return List
	 */
	public static List<Recipe> getRecipesbyAccountId(int accountId){
		List<Recipe> myRecipes = new ArrayList<Recipe>();
	   ConnectionToDB connection = new ConnectionToDB();
	   connection.open();
	   String req = "SELECT * FROM `recipe` WHERE `account_id` = '"+ accountId +"';";
	   try {
		   connection.setStatement(connection.getConnection().createStatement());
		   //execution d'une requête et récupération de résultat dans l'objet resultSet
		   connection.setResultSet(connection.getStatement().executeQuery(req));
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
			   myRecipes.add(new Recipe(id,name,preparationTime,cookingTime,likeNumber,quantity,account_id,difficulty_id,recipeType_id));
		   }
		   
	   }catch (SQLException e) {
		   System.out.println("Problème dans la BD (recipe)");
		   e.printStackTrace();
	   }
	   finally {
		   connection.close();
	   }
	   return myRecipes;
   }
}
