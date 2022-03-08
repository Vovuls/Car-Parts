package gui;

import java.awt.Dimension;

import javax.swing.JPanel;

public class JPanelDatabase extends JPanel {
	public JPanelDatabase(AddTextFields myTextField, AddButtons myButtons, AddJLabels myLabels) {
		setLayout(null);
		
		myTextField.createTextFields(this);
		myButtons.createButtons(this);
		myLabels.createLabels(this);
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1200, 800);
	}

}
