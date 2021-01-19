package metier.recipeType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.ConnectionToDB;

public abstract class RecipeTypeManager {
	
	
	
	/**
	 * Récupère la liste des types de recette.
	 * @return List
	 */
	public static List<RecipeType> getRecipeTypes(){
		List<RecipeType> result = new ArrayList<RecipeType>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM recipetype;"));
			
			//récupération des données
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new RecipeType(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (recipetype)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 * Retourne le type en fonction de son id.
	 * @param recipeId
	 * @return RecipeType
	 */
	public static RecipeType getTypeById(int recipeId) {
		RecipeType result ;
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `recipetype`.`name` as name FROM `recipetype`, `recipe` WHERE `recipetype`.`id` = `recipe`.`recipeType_id` AND `recipe`.`id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
				result = new RecipeType(connection.getResultSet().getString("name"));
			
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (recipeType) getTypeById");
		}
		finally {
			connection.close();
		}
		return null;
	}
}
