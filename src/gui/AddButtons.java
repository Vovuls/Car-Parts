package gui;

import java.awt.Color;

import javax.swing.JButton;

public class AddButtons {
	JPanelDatabase jpd;
	JButton addPart = new JButton("Add Part");
	JButton addCar = new JButton("Add Car");
	JButton addCarWithPart = new JButton("Connect car with part");
	JButton delete = new JButton("Delete");
	JButton update = new JButton("Update");
	JButton addImg = new JButton("Add img to car");

	public void createButtons(JPanelDatabase ble) {
		jpd = ble;

		addPart.setBounds(50, 310, 100, 40);
		addPart.setBackground(Color.LIGHT_GRAY);
		jpd.add(addPart);
		
		addCar.setBounds(1050, 310, 100, 40);
		addCar.setBackground(Color.LIGHT_GRAY);
		jpd.add(addCar);
		
		addCarWithPart.setBounds(70, 600, 160, 40);
		addCarWithPart.setBackground(Color.LIGHT_GRAY);
		jpd.add(addCarWithPart);
		
		delete.setBounds(1070, 500, 100, 40);
		delete.setBackground(Color.LIGHT_GRAY);
		jpd.add(delete);
		
		update.setBounds(1070, 580, 100, 40);
		update.setBackground(Color.LIGHT_GRAY);
		jpd.add(update);
		
		addImg.setBounds(1030, 360, 140, 40);
		addImg.setBackground(Color.LIGHT_GRAY);
		jpd.add(addImg);
		

	}
}
