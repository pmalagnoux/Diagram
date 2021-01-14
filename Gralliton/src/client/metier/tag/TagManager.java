package client.metier.tag;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.step.Step;
import client.utils.ConnectionToDB;

public abstract class TagManager {
	public static List<Tag> getTags(){
		List<Tag> result = new ArrayList<Tag>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM `tag`;"));
			//récupération des données
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("tagName");
				result.add(new Tag(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (tag)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 * Remplit la table recipetag(recipe_id,tag_id)
	 * @param tag
	 * @param recipeId
	 */
	public static void addTag(Tag tag, int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `recipetag`(`recipe_id`, `tag_id`) VALUES (?,?);");
			preparedStatement.setInt(1, recipeId);
			preparedStatement.setInt(2, tag.getId());
			
			// executer la requête
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème d'insertion dans la BD (recipeustensil)");
		}finally {
			connection.close();
		}
	}
	
	public static List<Tag> getTagsById(int recipeId) {
		List<Tag> result = new ArrayList<Tag>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `tagName` FROM `tag`, `recipetag` WHERE `tag`.`id` = `recipetag`.`tag_id` AND `recipetag`.`recipe_id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			while(connection.getResultSet().next()) {
				result.add( new Tag(connection.getResultSet().getString("tagName")));
			}
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (Tag) getTagsById");
		}
		finally {
			connection.close();
		}
		return null;
	}
	
}
