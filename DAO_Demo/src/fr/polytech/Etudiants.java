package fr.polytech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


//couche m�tier de l'application
public class Etudiants {
	
	private Connection connection; // la connecxion
	
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public void connect() {
		//chargement du driver MySql..
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver"); // exception surveill�e...
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
					System.out.println("Le driver n'est pas charg�...");
		}
		try {
			// connexion
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/demo_dao", "root", "");
		}catch (SQLException e) {
			System.out.println("La BD n'est pas connect�e");
		}
	}
	
	
	public List<Etudiant> allStudentsDisplay(){
		List<Etudiant> result = new ArrayList<Etudiant>();
		
		
		
		//Se connecter � la BD	
		this.connect();
		Statement statement = null;		// la requ�te SQL
		ResultSet resultSet = null; 	// le r�sultat de la requ�te SQL
		
		try {
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/demo_dao", "root", "");
			statement = connection.createStatement();
			//execution d'une requ�te et r�cup�ration de r�sultat dans l'objet resultSet
			resultSet = statement.executeQuery("SELECT * FROM etudiants");
			
			//r�cup�ration des donn�es
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				result.add(new Etudiant(id, nom, prenom));
			}
			
		} catch (SQLException e) {
			System.out.println("La BD n'est pas connect�e");
		}
		finally {
			try {
				if(connection!=null) connection.close();
				if(statement!=null) statement.close();
				if(resultSet!=null) statement.close();
			} catch (Exception e2) {
				
			}
			
		}
		
		
		return result;
	}
	
	public void addStudient(Etudiant etudiant) {
		this.connect();
		//failles d'injection SQL...
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO `etudiants`(`id`, `nom`, `prenom`) VALUES (?,?,?);");
			preparedStatement.setInt(1, etudiant.getId());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());
			
			// ex�cuter la requ�te
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Probl�me d'insertion dans la BD");
		}
	}
	
    public void modifyStudient(String nom, String prenom, int id) {
    	this.connect();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE `etudiants` SET `nom` = ?, `prenom` = ? WHERE `id` = ?;");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setInt(3, id);
         // ex�cuter la requ�te
         	preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Probl�me de modification dans la BD");
        }
    }
	
    public void deleteStudient(int id) {
    	this.connect();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM `etudiants` WHERE `id` = ?;");
            preparedStatement.setInt(1, id);
         
            // ex�cuter la requ�te
         	preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Probl�me de suppression dans la BD");
        }
    }
}
