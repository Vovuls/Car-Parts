package gui;

import java.awt.Color;

import javax.swing.JButton;

public class AddButtons {
	JPanelDatabase jpd;
	public void createButtons(JPanelDatabase ble) {
		jpd = ble;

		JButton addPart = new JButton("Add Part");
		addPart.setBounds(50, 310, 100, 40);
		addPart.setBackground(Color.LIGHT_GRAY);
		jpd.add(addPart);
		
		JButton addCar = new JButton("Add Car");
		addCar.setBounds(1050, 310, 100, 40);
		addCar.setBackground(Color.LIGHT_GRAY);
		jpd.add(addCar);
		

	}
}
