import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard  extends JFrame implements ActionListener {

	public static JFrame frame;
	public static JTextField inputBox;
	public static JTextField addFoodBox;
	public static JLabel searchFoodLabel;
	public static JLabel notExistingLabel;
	public JToolBar toolbar;

	public static JTable nutrientTable;

//	public static String foodChoice = null;
	public static HashMapList foodHashMapList;
	public static String[][] nutrientNameValueArray;

	public ConnectionDatabase db;

	Dashboard(){
	}

	Dashboard(ConnectionDatabase db){
		this.db = db;
		createWindow();
	}

	Dashboard(HashMapList foodHashMapList){
		Dashboard.foodHashMapList = foodHashMapList;
		createWindow();
	}

	public void createWindow(){
		createFrame();
		createInputBox();
		createLabels();
		createToolBar();
		createSearchButton();
		createAddFoodBox();
		createAddFoodButton();
		frame.setVisible(true);
	}


	public void createFrame() {
		frame = new JFrame("Lebensmittel");
		frame.setSize(600, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void createInputBox() {
		// TODO InputBox zusätzlich mit Auswahlfeld Choice
		inputBox = new JTextField(50);
		inputBox.setBounds(150, 50, 300, 30);
		inputBox.setVisible(true);
		frame.add(inputBox);
	}

	public void createLabels(){
		createInputBoxLabel();
		createFoodLabel();
		createNotExistingLabel();
	}

	public void createInputBoxLabel() {
		JLabel inputBoxLabel = new JLabel("Lebensmittel:");
		inputBoxLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		inputBoxLabel.setBounds(50, 50, 300, 30);
		frame.add(inputBoxLabel);
	}

	public void createFoodLabel() {
		searchFoodLabel = new JLabel();
		searchFoodLabel.setBounds(50, 100, 500, 70);
		searchFoodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		frame.add(searchFoodLabel);
	}

	public void createNotExistingLabel(){
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

	public void createSearchButton(){
		JButton button = new SearchButton();
		inputBox.getRootPane().setDefaultButton(button);
		frame.add(button);
		button.addActionListener(this);
	}

	public void createAddFoodBox() {
		addFoodBox = new JTextField(25);
		addFoodBox.setBounds(50, 500, 340, 30);
		addFoodBox.setVisible(true);
		frame.add(addFoodBox);
	}

	public void createAddFoodButton(){
		JButton button =  new AddButton() ;
		frame.add(button);
		button.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent event) {

		var button = (JButton) event.getSource();

		if( button instanceof WindowButtons) {
			String foodChoice = inputBox.getText();
			((WindowButtons) button).preformOperation(foodChoice);
		}


		if( button instanceof WindowButtons) {
			String addFood = addFoodBox.getText();
			if( !addFood.isEmpty() )
			((WindowButtons) button).preformOperation(addFood);
		}

	}


//	public static void output(){
//
//		if ( !inputBox.getText().isEmpty()) {
//
//			notExistingLabel.setText("");
//			searchFoodLabel.setText("Nährwerte für " + foodChoice + ": ");
//
//			NutrientValues value = foodHasMapList.foodHashMap.get(foodChoice);
//
//			try {
//				setNutrientNameValueArray(value);
//				createNutrientTable();
//				createScrollPane();
//			}
//			catch (Exception e){
//				searchFoodLabel.setText("");
//				if( nutrientTable != null )
//					nutrientTable.setVisible(false);
//				notExistingLabel.setText("\""+inputBox.getText()+"\" ist nicht in der Liste enthalten!");
//			}
//		}
//	}




	public static void setNutrientNameValueArray(NutrientValues value){

		int arrayRows = value.nutrientValuesHashMap.size();
		int arrayColumns = 2;
		nutrientNameValueArray = new String[arrayRows][arrayColumns];

		int counter = 0;
		for (String i : value.nutrientValuesHashMap.keySet()) {
			nutrientNameValueArray[counter][0] = i;
			nutrientNameValueArray[counter][1] = String.valueOf(value.nutrientValuesHashMap.get(i));
			counter++;
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

	public HashMapList getFoodHasMapList(){
		return Dashboard.foodHashMapList;
	}

//	public String getFoodChoice(){
//		return this.foodChoice;
//	}

	public JFrame getFrame(){
		return Dashboard.frame;
	}

	public JLabel getSearchFoodLabel(){
		return Dashboard.searchFoodLabel;
	}

	public JTable getNutrientTable(){
		return Dashboard.nutrientTable;
	}

}