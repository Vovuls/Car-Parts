package gui;

import java.awt.Color;

import javax.swing.JTextField;

public class AddTextFields {
	JPanelDatabase jpd;
	JTextField namePart = new JTextField("engine 2.0 HDI");
	//JTextField productionYear = new JTextField("2009");
	JTextField pricePart = new JTextField("12000");
	JTextField brand = new JTextField("Peugeot");
	JTextField model = new JTextField("407");
	//JTextField year = new JTextField("2009");
	JTextField carID = new JTextField("1");
	JTextField partID = new JTextField("1");
	
	JTextField IDUpdate = new JTextField("1");
	JTextField IDCarUpdate = new JTextField("1");
	JTextField IDPartUpdate = new JTextField("1");
	
	JTextField IdCarAddImg = new JTextField("1");
	
	public void createTextFields(JPanelDatabase ble) {
		jpd = ble;
		
		
		namePart.setBounds(50, 100, 100, 40);
		namePart.setBackground(Color.WHITE);
		jpd.add(namePart);
		
		
		//productionYear.setBounds(50, 170, 100, 40);
		//jpd.add(productionYear);
		
		
		pricePart.setBounds(50, 240, 100, 40);
		jpd.add(pricePart);

		
		brand.setBounds(1050, 100, 100, 40);
		brand.setBackground(Color.WHITE);
		jpd.add(brand);
		
		
		model.setBounds(1050, 170, 100, 40);
		jpd.add(model);
		
		
		//year.setBounds(1050, 240, 100, 40);
		//jpd.add(year);

		carID.setBounds(100, 450, 100, 40);
		jpd.add(carID);
		
		partID.setBounds(100, 530, 100, 40);
		jpd.add(partID);
		
		IDUpdate.setBounds(950, 470, 100, 40);
		jpd.add(IDUpdate);
		IDCarUpdate.setBounds(950, 540, 100, 40);
		jpd.add(IDCarUpdate);
		IDPartUpdate.setBounds(950, 610, 100, 40);
		jpd.add(IDPartUpdate);
		
		IdCarAddImg.setBounds(970, 360, 50, 40);
		jpd.add(IdCarAddImg);
	}

}
