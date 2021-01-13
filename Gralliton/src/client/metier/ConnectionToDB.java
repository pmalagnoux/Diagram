package client.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
	private Connection connection; // la connecxion
	private Statement statement = null;		// la requète SQL
	private ResultSet resultSet = null; 	// le résultat de la requète SQL
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public void open() {
		//chargement du driver MariaDB..
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver"); // exception surveillée...
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
					System.out.println("Le driver n'est pas chargé...");
		}
		try {
			// connexion
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gralllitondb", "root", "");
		}catch (SQLException e) {
			System.out.println("La BD n'est pas connectée");
		}
	}
	
	public void close() {
		try {
			if(this.connection!=null) connection.close();
			if(this.statement!=null) statement.close();
			if(this.resultSet!=null) statement.close();
		} catch (Exception e2) {
		}
	}
}
