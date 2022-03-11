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
		
		JLabel carID = new JLabel("carID");
		carID.setBounds(100, 430, 100, 20);
		jpd.add(carID);
		
		JLabel partID = new JLabel("partID");
		partID.setBounds(100, 510, 100, 20);
		jpd.add(partID);
		
		JLabel IDUpdate = new JLabel("ID");
		IDUpdate.setBounds(950, 450, 100, 20);
		jpd.add(IDUpdate);
		
		JLabel IDCarUpdate = new JLabel("ID Car");
		IDCarUpdate.setBounds(950, 520, 100, 20);
		jpd.add(IDCarUpdate);
		
		JLabel IDPartUpdate = new JLabel("ID Part");
		IDPartUpdate.setBounds(950, 590, 100, 20);
		jpd.add(IDPartUpdate);
		
		JLabel AddImg = new JLabel("Enter Id car for which you want to add an image:");
		AddImg.setBounds(690, 370, 280, 20);
		jpd.add(AddImg);
	}
}
