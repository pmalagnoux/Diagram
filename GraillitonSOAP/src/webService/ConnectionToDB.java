package webService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService(name="ConnectionToDBWS")
public class ConnectionToDB {
	private Connection connection; // la connecxion
	private Statement statement = null;		// la requète SQL
	private ResultSet resultSet = null; 	// le résultat de la requète SQL
	
	@WebMethod(operationName="getConnection")
	public Connection getConnection() {
		return connection;
	}
	@WebMethod(operationName="setConnection")
	public void setConnection(@WebParam(name="connection") Connection connection) {
		this.connection = connection;
	}
	@WebMethod(operationName="getStatement")
	public Statement getStatement() {
		return statement;
	}
	@WebMethod(operationName="setStatement")
	public void setStatement(@WebParam(name="statement") Statement statement) {
		this.statement = statement;
	}
	@WebMethod(operationName="getResultSet")
	public ResultSet getResultSet() {
		return resultSet;
	}
	@WebMethod(operationName="setResultSet")
	public void setResultSet(@WebParam(name="resultSet") ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	@WebMethod(operationName="open")
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
	@WebMethod(operationName="getUstensils")
	public void close() {
		try {
			if(this.connection!=null) connection.close();
			if(this.statement!=null) statement.close();
			if(this.resultSet!=null) statement.close();
		} catch (Exception e2) {
		}
	}
}
