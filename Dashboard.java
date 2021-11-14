import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.*;


public class Dashboard  extends JFrame implements ActionListener {

	public static JFrame frame;
	public static JTextField searchBox;
	public static JTextField addBox;
	public static JLabel tableLabel;
	public static JLabel notExistingLabel;
	public JToolBar toolbar;

	public static JTable nutrientTable;

	public static String[][] nutrientNameValueArray;

	public Connection conn;
	public Statement stmt;


	Dashboard(){
		createWindow();
	}

	Dashboard(Connection conn){
		this.conn=conn;
		createWindow();
	}

	Dashboard(Statement stmt){
		this.stmt = stmt;
		createWindow();
	}

	public void createWindow(){

		frame = new StartFrame();

		createBoxes();
		createButtons();
		createLabels();
		createToolBar();

		frame.setVisible(true);
	}

	public void createBoxes() {
		searchBox = new SearchBox();
			frame.add(searchBox);
		addBox = new AddFoodBox();
			frame.add(addBox);
	}

	public void createLabels(){

		JLabel searchLabel = new SearchLabel();
			frame.add(searchLabel);
		tableLabel = new TableLabel();
			frame.add(tableLabel);
		notExistingLabel = new JLabel();
			notExistingLabel.setBounds(50, 100, 500, 70);
			notExistingLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
			frame.add(notExistingLabel);
	}

	public void createToolBar() {
		toolbar = new JToolBar();
		toolbar.setBounds(150, 80, 300, 30);
		toolbar.setVisible(true);
	}

	public void createButtons(){
		JButton searchbutton = new SearchButton();
			searchBox.getRootPane().setDefaultButton(searchbutton);
			frame.add(searchbutton);
			searchbutton.addActionListener(this);

		JButton button =  new AddButton() ;
			frame.add(button);
			button.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent event) {

		var button = (JButton) event.getSource();

		if (button instanceof WindowButtons) {
			String foodChoice = searchBox.getText();
			((WindowButtons) button).preformOperation(foodChoice,conn);
		}


		if (button instanceof WindowButtons) {
			String addFood = addBox.getText();
			if (!addFood.isEmpty())
				((WindowButtons) button).preformOperation(addFood,conn);
		}

	}

	public static void createNutrientTable(){
		nutrientTable = new JTable(nutrientNameValueArray, new String[]{"Name", "Menge"});
		nutrientTable.setFillsViewportHeight(true);
	}

	public static void createScrollPane(){
		JScrollPane scroll = new JScrollPane(nutrientTable);
		scroll.setBounds(50, 150, 500, 250);
		frame.add(scroll);
	}

	public JFrame getFrame(){
		return Dashboard.frame;
	}

	public JLabel getSearchFoodLabel(){
		return Dashboard.tableLabel;
	}

	public JTable getNutrientTable(){
		return Dashboard.nutrientTable;
	}

}