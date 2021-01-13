package webService.metier.ustensil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import webService.ConnectionToDB;

@WebService(name="UstensilManagerWS")
public class UstensilManager {
	@WebMethod(operationName="getUstensils")
	public List<Ustensil> getUstensils(){
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
	@WebMethod(operationName="addUstensil")
	public void addUstensil(@WebParam(name="ustensil")Ustensil ustensil,@WebParam(name="quantity") int quantity,@WebParam(name="recipeId") int recipeId) {
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
}
