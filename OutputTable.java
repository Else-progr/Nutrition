import javax.swing.*;
import java.awt.*;

public class OutputTable {

    List foodList;
    String foodChoice;
    JLabel foodLabel;
    JTable table;
    JFrame window;


    OutputTable(Dashboard board){

        this.foodList = board.getFoodList();
        this.foodChoice = board.getFoodChoice();
        this.foodLabel = board.getFoodLabel();
        this.window = board.getWindow();
        this.table = board.getTable();

        outputTable();
    }



    public void outputTable() {

        foodLabel.setText("Nährwerte für " + foodChoice + ": ");
        foodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        NutrientValue value = foodList.food.get(foodChoice);

        String[][] nutrientNameValue = new String[value.nutrientValues.size()][2];
        int counter = 0;

        for (String i : value.nutrientValues.keySet()) {
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
