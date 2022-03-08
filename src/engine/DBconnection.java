package engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	boolean initFirst = true;
	public void executeQuery() {
		
		String url = "jdbc:postgresql://localhost/Samochody";
		try {
			Connection conn = DriverManager.getConnection(url, "postgres", "admin");
			Statement st = conn.createStatement();
			
			if (initFirst) {
			st.executeUpdate("DROP TABLE IF EXISTS Part");
			st.executeUpdate("DROP TABLE IF EXISTS Car");
			st.executeUpdate("CREATE TABLE Part (ID SERIAL , Name varchar(30), YearProduction int, Price int)");
			st.executeUpdate("CREATE TABLE Car (ID SERIAL , Brand varchar(30), Model varchar(30), Year int)");
			initFirst = false;
			}
			// st.executeUpdate(queryToExecute);
			
			ResultSet rsPeople = st.executeQuery("SELECT * FROM Car ORDER BY ID ASC");
			while (rsPeople.next()) {
				System.out.println(rsPeople.getString(1) + " " + rsPeople.getString(2) + " " + rsPeople.getString(3)
						+ " " + rsPeople.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
