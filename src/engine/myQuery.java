package engine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
	
		public static void addImages(int idCarIntPanel, String path) throws IOException {
			idCarIntPanel += 1;
		try {
			String url = "jdbc:postgresql://localhost/Samochody";
			Connection conn = DriverManager.getConnection(url, "postgres", "admin");
			Statement st = conn.createStatement();
			st.executeUpdate("UPDATE Car SET img ="+ "pg_read_binary_file('C:/Users/Public/carsImages/"+path+"')" + " WHERE ID = "+idCarIntPanel+ ";");
			ResultSet rsCar = st.executeQuery("SELECT * FROM Car ORDER BY ID ASC");
			while (rsCar.next()) {
				System.out.println(rsCar.getString(1) + " " + rsCar.getString(2) + " " + rsCar.getString(3)
						+ " " + rsCar.getString(4) + " " + rsCar.getString(5));
			}
			// in JPanelDatabase we only call this addImages function 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}