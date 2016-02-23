package br.com.fabricadeprogramador.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection(){
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","1234");
		} catch (SQLException e) {
			//Relan�ar a exception
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}

}
