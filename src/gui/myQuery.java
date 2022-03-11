package gui;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class myQuery {
	
	public static String executeTask(String tableName, String columnName, int rowOFTable) {
		String doneTask = "";
		String url = "jdbc:postgresql://localhost/Samochody";
		try {
			Connection conn = DriverManager.getConnection(url, "postgres", "admin");
			Statement st = conn.createStatement();
			String rowOfTableString = Integer.toString(rowOFTable);
			String myQueryString = "SELECT " + columnName +" FROM " + tableName + " WHERE ID = "+ rowOfTableString+";";
					System.out.println(myQueryString);
			ResultSet rsQuery = st.executeQuery(myQueryString);
			while (rsQuery.next()) {
			doneTask = rsQuery.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doneTask;
	}
	
	public static void update (String queryToExecute) {
		try {
			String url = "jdbc:postgresql://localhost/Samochody";
			Connection conn = DriverManager.getConnection(url, "postgres", "admin");
			Statement st = conn.createStatement();
			st.executeUpdate(queryToExecute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Add Image to DATABASE - To Finish
	public static void addImages(File file,FileInputStream fis,int idCarIntPanel) {
		try {
			String url = "jdbc:postgresql://localhost/Samochody";
			Connection conn = DriverManager.getConnection(url, "postgres", "admin");
			Statement st = conn.createStatement();
		
			//st.executeUpdate(queryToExecute);
			
			//("INSERT INTO images VALUES (?, ?)")
			PreparedStatement ps = conn.prepareStatement("UPDATE Car SET img = "+ "?" + " WHERE ID = "+idCarIntPanel+ ";");
			//ps.setString(1, file.getName());
			ps.setBinaryStream(1, fis, file.length());
			ps.executeUpdate();
			ps.close();
			// in JPanelDatabase we only call this addImages function 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}