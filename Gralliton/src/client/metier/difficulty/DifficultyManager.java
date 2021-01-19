package client.metier.difficulty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.ingredient.Ingredient;
import client.utils.ConnectionToDB;

public abstract class DifficultyManager {
	
	
	/**
	 * Retourne la liste compl�te des difficult�s.
	 * @return List
	 */
	public static List<Difficulty> getDifficulties(){
		List<Difficulty> result = new ArrayList<Difficulty>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM `difficulty`;"));
			
			//r�cup�ration des donn�es
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new Difficulty(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (difficult�)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 *  Retourne la difficult� associ� � une recette gr�ce � l'id de cette derni�re.
	 * @param recipeId
	 * @return Difficulty
	 */
	public static Difficulty getDifficultyById(int recipeId) {
		Difficulty result ;
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `difficulty`.`name` FROM `difficulty`, `recipe` WHERE `difficulty`.`id` = `recipe`.`difficulty_id` AND `recipe`.`id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
			result = new Difficulty(connection.getResultSet().getString("name"));
			
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (difficulty) getdifficultyById");
		}
		finally {
			connection.close();
		}
		return null;
	}
	
}
