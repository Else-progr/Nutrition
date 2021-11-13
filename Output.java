
public class Output extends Dashboard{


    Output(){
    }


    public static void setOutput(String foodChoice){

        if ( !inputBox.getText().isEmpty()) {

            notExistingLabel.setText("");
            searchFoodLabel.setText("Nährwerte für " + foodChoice + ": ");

            try {
                createNutrientTable();
                createScrollPane();
            }
            catch (Exception e){
                searchFoodLabel.setText("");
                if( nutrientTable != null )
                    nutrientTable.setVisible(false);
                notExistingLabel.setText("\""+inputBox.getText()+"\" ist nicht in der Liste enthalten!");
            }
        }
    }

}
