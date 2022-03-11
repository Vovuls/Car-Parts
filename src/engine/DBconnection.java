package engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gui.JPanelDatabase;



public class DBconnection {
	boolean initFirst = true;
	String queryToExecute = "";
	public static int whichQuery = 0;
	public void executeQuery(String queryToExecute) {
		
		String url = "jdbc:postgresql://localhost/Samochody";
		try {
			Connection conn = DriverManager.getConnection(url, "postgres", "admin");
			Statement st = conn.createStatement();
			
			if (initFirst) {
			st.executeUpdate("DROP TABLE IF EXISTS CarsAndParts");
			st.executeUpdate("DROP TABLE IF EXISTS Part");
			st.executeUpdate("DROP TABLE IF EXISTS Car");
			st.executeUpdate("CREATE TABLE Part (ID SERIAL , Name varchar(30), YearProduction DATE, Price int, PRIMARY KEY (ID))");
			st.executeUpdate("CREATE TABLE Car (ID SERIAL , Brand varchar(30), Model varchar(30), Year DATE, img BYTEA, PRIMARY KEY (ID))");
			st.executeUpdate("CREATE TABLE CarsAndParts (ID SERIAL, IDCar int, IDPart int, Brand varchar(30), NamePart varchar(30), PRIMARY KEY (ID),"
					+ "    FOREIGN KEY (IDPart) REFERENCES Part(ID), FOREIGN KEY (IDCar) REFERENCES Car(ID))");
			initFirst = false;
			}
			st.executeUpdate(queryToExecute);
			// Adding Parts
			ResultSet rsPart = st.executeQuery("SELECT * FROM Part ORDER BY ID ASC");
			while (rsPart.next() && whichQuery == 1) {
				System.out.println(rsPart.getString(1) + " " + rsPart.getString(2) + " " + rsPart.getString(3)
						+ " " + rsPart.getString(4));
				// Adding to Part Table
				Object[][] rowDataTwo = { { rsPart.getString(1), rsPart.getString(2), rsPart.getString(3), rsPart.getString(4) } };
				JPanelDatabase.modelTableParts.addRow(rowDataTwo[0]);	
				JPanelDatabase.modelTableParts.fireTableDataChanged();
				// END Part TABLE
			}
			
			// Adding Cars
			ResultSet rsCar = st.executeQuery("SELECT * FROM Car ORDER BY ID ASC");
			while (rsCar.next() && whichQuery == 2) {
				System.out.println(rsCar.getString(1) + " " + rsCar.getString(2) + " " + rsCar.getString(3)
						+ " " + rsCar.getString(4) + " " + rsCar.getString(5));
				// Addin to Part Table
				Object[][] rowDataTwo = { { rsCar.getString(1), rsCar.getString(2), rsCar.getString(3), rsCar.getString(4), rsCar.getString(5) } };
				JPanelDatabase.modelTableCars.addRow(rowDataTwo[0]);	
				JPanelDatabase.modelTableCars.fireTableDataChanged();
				// END Part TABLE
			}
			// Adding Connections
			ResultSet rsCarwithParts = st.executeQuery("SELECT * FROM CarsAndParts ORDER BY ID ASC");
			while (rsCarwithParts.next() && whichQuery == 3) {
				System.out.println(rsCarwithParts.getString(1) + " " + rsCarwithParts.getString(2) + " " + rsCarwithParts.getString(3)
						+ " " + rsCarwithParts.getString(4)+ " " + rsCarwithParts.getString(5));
				// Adding to Part Table
				Object[][] rowDataTwo = { { rsCarwithParts.getString(1), rsCarwithParts.getString(2), rsCarwithParts.getString(3), rsCarwithParts.getString(4),rsCarwithParts.getString(5) } };
				JPanelDatabase.modelTableCarsAndParts.addRow(rowDataTwo[0]);	
				JPanelDatabase.modelTableCarsAndParts.fireTableDataChanged();
				// END Part TABLE
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
