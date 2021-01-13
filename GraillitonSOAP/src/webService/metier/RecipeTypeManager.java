package webService.metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webService.utils.ConnectionToDB;

public abstract class RecipeTypeManager {
	public static List<RecipeType> getRecipeTypes(){
		List<RecipeType> result = new ArrayList<RecipeType>();
		ConnectionToDB connection = new ConnectionToDB();
		connection.open();
		
		try {
			connection.setStatement(connection.getConnection().createStatement());
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			connection.setResultSet(connection.getStatement().executeQuery("SELECT * FROM recipetype;"));
			
			//r�cup�ration des donn�es
			while(connection.getResultSet().next()) {
				int id = connection.getResultSet().getInt("id");
				String name = connection.getResultSet().getString("name");
				result.add(new RecipeType(id, name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Probl�me de selection dans la BD (recipetype)");
		}
		finally {
			connection.close();
		}
		return result;
	}
}
