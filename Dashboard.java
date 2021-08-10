import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard implements ActionListener {

	private JFrame window;
	private JTextField inputBox;
	private JTextField addFoodBox;
	private JLabel foodLabel;
	private JToolBar toolbar;

	private JButton search;
	private JButton addFood;

	private JTable table;

	private String foodChoice = null;
	private List foodList;
	private String[][] nutrientNameValue;






	Dashboard(List food){

		this.foodList = food;

		createWindow();
	}

	Dashboard(List food, String choice, JFrame window, JLabel label, JTable table){

		this.foodLabel = label;
		this.foodList = food;
		this.foodChoice = choice;
		this.table = table;
		this.window = window;
	}


	@Override
	public void actionPerformed(ActionEvent event) {

		if( event.getSource() == this.search ) {
			foodChoice = inputBox.getText();
			output();
//			new OutputTable( new Dashboard(this.foodList, this.foodChoice, this.window, this.foodLabel, this.table) );
		}

		if( event.getSource() == this.addFood ) {

			if( !addFoodBox.getText().isEmpty() ) {

				JFrame addFoodWindow = new JFrame("Lebensmittel hizufügen");
				JTable addFoodTable;

				Nutrient names = this.foodList.nutrients;
				for (String i: names.getNutrientNames()) {
					System.out.println(i);
				}


			}
		}


	}



	public void createWindow(){

		window = new JFrame("Lebensmittel");
		window.setSize(600, 600);
		window.setLayout(null);

		JLabel inputBoxLabel = new JLabel("Lebensmittel:");
		inputBoxLabel.setFont(new Font("Verdana", Font.PLAIN, 14));

		inputBoxLabel.setBounds(50, 50, 300, 30);
		window.add(inputBoxLabel);

		// TODO InputBox zusätzlich mit Auswahlfeld Choice
		inputBox = new JTextField(50);
		inputBox.setBounds(150, 50, 300, 30);
		inputBox.setVisible(true);
		window.add(inputBox);

		toolbar = new JToolBar();
		toolbar.setBounds( 150, 80, 300, 30);
		toolbar.setVisible(true);

		search = new JButton("Suche");
		search.setBounds(460, 50, 100, 30);
		search.setVisible(true);
		inputBox.getRootPane().setDefaultButton(search);
		window.add(search);

		foodLabel = new JLabel();
		foodLabel.setBounds(50, 100, 300, 70);
		window.add(foodLabel);

		addFoodBox = new JTextField(25);
		addFoodBox.setBounds(50, 500, 340, 30);
		addFoodBox.setVisible(true);
		window.add(addFoodBox);

		addFood = new JButton("hinzufügen");
		addFood.setBounds(400, 500, 150, 30);
		addFood.setVisible(true);
//		addFoodBox.getRootPane().setDefaultButton(addFood);
		window.add(addFood);

//		Nutrient names = food.nutrients;
//		for (String i: names.getNutrientNames()) {
//			System.out.println(i);
//		}

		window.setVisible(true);

		search.addActionListener(this);
		addFood.addActionListener(this);

	}


	public List getFoodList(){

		return this.foodList;
	}

	public String getFoodChoice(){

		return this.foodChoice;
	}

	public JFrame getWindow(){

		return this.window;
	}

	public JLabel getFoodLabel(){

		return this.foodLabel;
	}

	public JTable getTable(){

		return this.table;
	}


	public void output(){

		foodLabel.setText("Nährwerte für "+foodChoice+": ");
		foodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

		NutrientValue value = foodList.food.get(foodChoice);

		nutrientNameValue = new String[value.nutrientValues.size()][2];
		int counter = 0;

		for ( String i : value.nutrientValues.keySet() ) {
			nutrientNameValue[counter][0] = i;
			nutrientNameValue[counter][1] = String.valueOf(value.nutrientValues.get(i));
			counter++;
		}

		table = new JTable(nutrientNameValue, new String[]{"Name", "Menge"});
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 150, 500, 250);
		table.setFillsViewportHeight(true);
		window.add(scroll);
	}
}