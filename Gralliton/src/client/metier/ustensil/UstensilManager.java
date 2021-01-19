package client.metier.ustensil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import client.metier.tag.Tag;
import client.utils.ConnectionToDB;

public abstract class UstensilManager {
	
	/**
	 * Retourne la liste de tous les ustensiles.
	 * @return List
	 */
	public static List<Ustensil> getUstensils(){
		List<Ustensil> result = new ArrayList<Ustensil>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requête et récupération de résultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM ustensil;"));
			
			//récupération des données
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new Ustensil(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (ustensil)");
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	/**
	 * Remplit la table recipeustensil(quantity,recipe_id,ustensil_id)
	 * @param ustensil
	 * @param quantity
	 * @param recipeId
	 */
	public static void addUstensil(Ustensil ustensil, int quantity, int recipeId) {
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO `recipeustensil`(`quantity`, `recipe_id`, `ustensil_id`) VALUES (?,?,?);");
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, recipeId);
			preparedStatement.setInt(3, ustensil.getId());
			
			// executer la requête
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème d'insertion dans la BD (recipeustensil)");
		}finally {
			connection.close();
		}
	}
	
	/**
	 * Retourne la liste d'ustensiles nécessaire pour une recette en fonction de l'id de cette dernière.
	 * @param recipeId
	 * @return List
	 */
	public static List<Ustensil> getUstensilsById(int recipeId) {
		List<Ustensil> result = new ArrayList<Ustensil>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			String req = "SELECT `name` FROM `ustensil`, `recipeustensil` WHERE `ustensil`.`id` = `recipeustensil`.`ustensil_id` AND `recipeustensil`.`recipe_id` = '"+recipeId+"';";
			connection.setResultSet(connection.getStatement().executeQuery(req));
			while(connection.getResultSet().next()) {
				result.add( new Ustensil(connection.getResultSet().getString("name")));
			}
			return result;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème de selection dans la BD (Ustensil) getUstensilsById");
		}
		finally {
			connection.close();
		}
		return null;
	}
	
	
	
	
	
}
