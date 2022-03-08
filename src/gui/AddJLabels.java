package gui;

import javax.swing.JLabel;

public class AddJLabels {
	JPanelDatabase jpd;
	public void createLabels(JPanelDatabase ble) {
		jpd = ble;
		
		JLabel partName = new JLabel("Part Name");
		partName.setBounds(50, 80, 100, 20);
		jpd.add(partName);
		
		JLabel productionYear = new JLabel("Production-Year");
		productionYear.setBounds(50, 150, 100, 20);
		jpd.add(productionYear);
		
		JLabel pricePart = new JLabel("Price");
		pricePart.setBounds(50, 220, 100, 20);
		jpd.add(pricePart);

		JLabel brand = new JLabel("Brand");
		brand.setBounds(1050, 80, 100, 20);
		jpd.add(brand);
		
		JLabel model = new JLabel("Model");
		model.setBounds(1050, 150, 100, 20);
		jpd.add(model);
		
		JLabel year = new JLabel("Year");
		year.setBounds(1050, 220, 100, 20);
		jpd.add(year);
		

	}
}
