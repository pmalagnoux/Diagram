package client.metier.difficulty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.ingredient.Ingredient;
import client.utils.ConnectionToDB;

public abstract class DifficultyManager {
	public static List<Difficulty> getDifficulties(){
		List<Difficulty> result = new ArrayList<Difficulty>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM `difficulty`;"));
			
			//récupération des données
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new Difficulty(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (difficulté)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	public static Difficulty getDifficultyById(int recipeId) {
		Difficulty result ;
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `name` FROM `difficulty`, `recipe` WHERE `ingredient`.`id` = `recipe`.`difficulty_id` AND `recipe`.`id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			connection.getResultSet().next();
				result = new Difficulty(connection.getResultSet().getString("name"));
			
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (difficulty) getdifficultyById");
		}
		finally {
			connection.close();
		}
		return null;
	}
	
}
