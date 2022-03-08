package gui;

import java.awt.Color;

import javax.swing.JTextField;

public class AddTextFields {
	JPanelDatabase jpd;
	public void createTextFields(JPanelDatabase ble) {
		jpd = ble;
		
		JTextField namePart = new JTextField("Name of Part");
		namePart.setBounds(50, 100, 100, 40);
		namePart.setBackground(Color.WHITE);
		jpd.add(namePart);
		
		JTextField productionYear = new JTextField("Production-Year");
		productionYear.setBounds(50, 170, 100, 40);
		jpd.add(productionYear);
		
		JTextField pricePart = new JTextField("Price");
		pricePart.setBounds(50, 240, 100, 40);
		jpd.add(pricePart);

		JTextField brand = new JTextField("Brand");
		brand.setBounds(1050, 100, 100, 40);
		brand.setBackground(Color.WHITE);
		jpd.add(brand);
		
		JTextField model = new JTextField("Model");
		model.setBounds(1050, 170, 100, 40);
		jpd.add(model);
		
		JTextField year = new JTextField("Year");
		year.setBounds(1050, 240, 100, 40);
		jpd.add(year);

	}

}
