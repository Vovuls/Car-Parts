package engine;

import javax.swing.JFrame;

import gui.AddButtons;
import gui.AddJLabels;
import gui.AddTextFields;
import gui.JPanelDatabase;

public class MainDatabaseCarParts {

	public static void main(String[] args) {
		DBconnection myConnection = new DBconnection();
		myConnection.executeQuery("");
		
		AddTextFields myTextField = new AddTextFields();
		AddButtons myButtons = new AddButtons();
		AddJLabels myLabels = new AddJLabels();
		JPanelDatabase myp = new JPanelDatabase(myTextField, myButtons, myLabels);
		
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setTitle("Database GUI Car Parts");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(myp);
		window.pack();
	}

}
