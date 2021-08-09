import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard implements ActionListener{

	private JFrame window;
	private JTextField inputBox;
	private JTextArea output;
	private JButton search;
	private JLabel foodLabel;
	List foodList;
	private JTable table;

	
	Dashboard(List food){

		this.foodList = food;
		
		window = new JFrame("Lebensmittel");
		window.setSize(600, 600);
		window.setLayout(null);
		
		JLabel inputBoxLabel = new JLabel("Lebensmittel");
		inputBoxLabel.setBounds(50, 50, 300, 30);
        window.add(inputBoxLabel);

        // TODO InputBox zusätzlich mit Auswahlfeld Choice
		inputBox = new JTextField(25);
		inputBox.setBounds(150, 50, 300, 30);
		inputBox.setVisible(true);
		window.add(inputBox);
		
		search = new JButton("Suche");
		search.setBounds(460, 50, 100, 30);
		search.setVisible(true);
		window.add(search);
		
		foodLabel = new JLabel();
		foodLabel.setBounds(50, 80, 300, 70);
		window.add(foodLabel);

//		output = new JTextArea();
//		output.setBounds(50, 150, 500, 700);
//		window.add(output);
		
		window.setVisible(true);
		
		search.addActionListener(this);
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent event) {

//		output.setText("");

		String foodChoice = null;

		if( event.getSource() == this.search ) {
			foodChoice = inputBox.getText();
		}

		// TODO Schrift größer + fetter
		foodLabel.setText("Nährwerte für "+foodChoice+": ");

		NutrientValue value = foodList.food.get(foodChoice);

		String[][] nutrientNameValue = new String[value.nutrientValues.size()][2];
		int counter = 0;
		System.out.println(value.nutrientValues.size());

		// TODO Ausgabe in Tabelle anordnen
		for ( String i : value.nutrientValues.keySet() ) {
			nutrientNameValue[counter][0] = i;
			nutrientNameValue[counter][1] = String.valueOf(value.nutrientValues.get(i));
			counter++;
//			output.setText(output.getText() + "" + i + ": " + value.nutrientValues.get(i) + "\n\n");
		}

		table = new JTable(nutrientNameValue, new String[]{"Name", "Menge"});
//		table.setBounds(50, 150, 500, 300);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 150, 500, 300);
		table.setFillsViewportHeight(true);
		window.add(scroll);
	}
	
}
