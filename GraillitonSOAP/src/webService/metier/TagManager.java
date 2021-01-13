package webService.metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import webService.ConnectionToDB;

@WebService(name="TagManagerWS")
public abstract class TagManager {
	@WebMethod(operationName="getTags")
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
	@WebMethod(operationName="addTag")
	public static void addTag(@WebParam(name="tag") Tag tag, @WebParam(name="recipeId") int recipeId) {
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
}
