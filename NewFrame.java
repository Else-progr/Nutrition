class NewTable extends Dashboard {

    private static Table addTable;


    NewTable(){
    }


    public  static void setTable(){
        addTable = new Table(addFoodBox.getText(), foodHashMapList.getNutrientName());
        addTable.setVisible(true);
        addTable.setSize( 500, 600 );
    }

}
