package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import engine.DBconnection;

public class JPanelDatabase extends JPanel {
	String queryToExecute = "";
	DBconnection panelConnection = new DBconnection();
	public static DefaultTableModel modelTableParts;
	public static DefaultTableModel modelTableCars;
	public static DefaultTableModel modelTableCarsAndParts;
	public JPanelDatabase(AddTextFields myTextField, AddButtons myButtons, AddJLabels myLabels) {
		setLayout(null);
		
		myTextField.createTextFields(this);
		myButtons.createButtons(this);
		myLabels.createLabels(this);
	/////// CALENDAR //////////////
		JDateChooser myCalendarPart = new JDateChooser();
		myCalendarPart.setBounds(50, 170, 100, 40);
		add(myCalendarPart);
		
		JDateChooser myCalendarCar = new JDateChooser();
		myCalendarCar.setBounds(1050, 240, 100, 40);
		add(myCalendarCar);
		
	/////// Parts Table ////////////
		
			Object[][] rowDataParts = {};
			Object[] columnNamesParts = { "IDPart", "Name", "YearProd.", "Price" };
			modelTableParts = new DefaultTableModel(rowDataParts, columnNamesParts);
			JTable myTableParts = new JTable();
			myTableParts.setModel(modelTableParts);
			modelTableParts.addTableModelListener(myTableParts);
			myTableParts.setBackground(Color.LIGHT_GRAY);
			JScrollPane sp = new JScrollPane(myTableParts);
			sp.setBounds(170, 100, 350, 250);
			myTableParts.getColumnModel().getColumn(0).setPreferredWidth(50);
			myTableParts.getColumnModel().getColumn(1).setPreferredWidth(150);
			add(sp);
			
	/////// Car Table ////////////
			Object[][] rowDataCars = {};
			Object[] columnNamesCars = { "IDCar", "Brand", "Model", "Year", "img" };
			modelTableCars = new DefaultTableModel(rowDataCars, columnNamesCars);
			JTable myTableCars = new JTable(){
				public Class getColumnClass (int column) {
					return (column == 4) ? Icon.class : Object.class;
				}
			};
			myTableCars.setRowHeight(80);
			myTableCars.setModel(modelTableCars);
			modelTableCars.addTableModelListener(myTableCars);
			myTableCars.setBackground(Color.LIGHT_GRAY);
			JScrollPane spCar = new JScrollPane(myTableCars);
			spCar.setBounds(540, 100, 500, 250);
			myTableCars.getColumnModel().getColumn(0).setPreferredWidth(20);
			myTableCars.getColumnModel().getColumn(3).setPreferredWidth(30);
			add(spCar);
	/////// CarsAndParts Table ////////////
					Object[][] rowDataCarsAndParts = {};
					Object[] columnNamesCarsAndParts = { "ID", "IDCar", "IDPart.", "Brand", "NamePart" };
					modelTableCarsAndParts = new DefaultTableModel(rowDataCarsAndParts, columnNamesCarsAndParts);
					JTable myTableCarsAndPart = new JTable();
					myTableCarsAndPart.setModel(modelTableCarsAndParts);
					modelTableCarsAndParts.addTableModelListener(myTableCarsAndPart);
					myTableCarsAndPart.setBackground(Color.LIGHT_GRAY);
					JScrollPane spCarAndPart = new JScrollPane(myTableCarsAndPart);
					spCarAndPart.setBounds(300, 450, 600, 250);
					myTableCarsAndPart.getColumnModel().getColumn(0).setPreferredWidth(67);
					myTableCarsAndPart.getColumnModel().getColumn(1).setPreferredWidth(66);
					myTableCarsAndPart.getColumnModel().getColumn(2).setPreferredWidth(66);
					myTableCarsAndPart.getColumnModel().getColumn(3).setPreferredWidth(200);
					myTableCarsAndPart.getColumnModel().getColumn(4).setPreferredWidth(200);
					add(spCarAndPart);
		
		myButtons.addCarWithPart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DBconnection.whichQuery = 3;
				modelTableCarsAndParts.setRowCount(0);
				int idCarINT = Integer.parseInt(myTextField.carID.getText());
				int idPartINT = Integer.parseInt(myTextField.partID.getText());
				String brandOfCar = myQuery.executeTask("Car", "Brand", idCarINT);
				String nameOfPart = myQuery.executeTask("Part", "Name", idPartINT);
				queryToExecute = "INSERT INTO CarsAndParts VALUES (DEFAULT," + idCarINT + "," + idPartINT +  ",'" + brandOfCar + "', '" + nameOfPart+"')";
				panelConnection.executeQuery(queryToExecute);
				
			}
			
		});
		
		myButtons.addCar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DBconnection.whichQuery = 2;
				modelTableCars.setRowCount(0);
				Date yearINT = myCalendarCar.getDate(); 
				queryToExecute = "INSERT INTO Car VALUES (DEFAULT," + "'" + myTextField.brand.getText() + "'," + "'" + myTextField.model.getText() + "','"+ yearINT + "')";
				panelConnection.executeQuery(queryToExecute);
				
			}
			
		});
		
		myButtons.addPart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DBconnection.whichQuery = 1;
				modelTableParts.setRowCount(0);  
				Date yearDate = myCalendarPart.getDate();
				int priceINT = Integer.parseInt(myTextField.pricePart.getText());
				queryToExecute = "INSERT INTO Part VALUES (DEFAULT," + "'" + myTextField.namePart.getText() + "'," +"'" + yearDate + "'," + priceINT+")";
				panelConnection.executeQuery(queryToExecute);
				
			}
			
		});
		
		myButtons.delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelTableCarsAndParts.setRowCount(0);
				DBconnection.whichQuery = 3;
				int IdInt;
				IdInt = Integer.parseInt(myTextField.IDUpdate.getText());
				queryToExecute = "DELETE FROM CarsAndParts WHERE ID = " + IdInt + ";";
				myQuery.update(queryToExecute); // delete is one of a form of "update"
				panelConnection.executeQuery("");
			}
			
		});
		
		myButtons.update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelTableCarsAndParts.setRowCount(0);
				DBconnection.whichQuery = 3;
				
				int IdInt;
				IdInt = Integer.parseInt(myTextField.IDUpdate.getText());
				int idCarINT = Integer.parseInt(myTextField.IDCarUpdate.getText());
				int idPartINT = Integer.parseInt(myTextField.IDPartUpdate.getText());
				String brandOfCar = myQuery.executeTask("Car", "Brand", idCarINT);
				String nameOfPart = myQuery.executeTask("Part", "Name", idPartINT);
				
				queryToExecute = "UPDATE CarsAndParts SET IDCar = " +idCarINT+ ", IDPart = " + idPartINT+ ", Brand = '" + brandOfCar+"', NamePart = '"+ nameOfPart+"'" + "WHERE ID = " + IdInt +";";
				myQuery.update(queryToExecute);
				panelConnection.executeQuery("");
			}
			
		});
		
		myButtons.addImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = "";
				File myFile = new File("carsImages\\");
				File mydata = null ;
				JFileChooser chooser = new JFileChooser(myFile, FileSystemView.getFileSystemView());
				int theChosenOne = chooser.showSaveDialog(null);
				if (theChosenOne == JFileChooser.APPROVE_OPTION ) {
					path = chooser.getSelectedFile().getName();
					mydata = chooser.getSelectedFile();
					System.out.println(path);
				}

				int idCarIntPanel = Integer.parseInt(myTextField.IdCarAddImg.getText()) - 1;
				Image myImage = new ImageIcon("carsImages\\"+path).getImage();
				Image imageScaled = myImage.getScaledInstance(120, 80, Image.SCALE_DEFAULT);
				ImageIcon imageIcon = new ImageIcon(imageScaled);
				modelTableCars.setValueAt(imageIcon, idCarIntPanel, 4);
				
				
				// to database
				FileInputStream fis = null;
				try {
					fis = new FileInputStream("carsImages\\"+path);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//queryToExecute = ;
				myQuery.addImages(mydata,fis,idCarIntPanel);
				//panelConnection.executeQuery("");
				try {
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			};
			
		});
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1200, 800);
	}

}
