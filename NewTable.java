class NewTable extends Dashboard {

    private static Table newTable;


     NewTable(){
    }


    public  static void setTable(){
        newTable = new Table(addFoodBox.getText(), foodHashMapList.getNutrientName());
        newTable.setVisible(true);
        newTable.setSize( 500, 600 );
    }

}
