class NewTable extends Dashboard {


    NewTable(){
    }


    public  static void setTable(){
        Table newTable = new Table(addFoodBox.getText());
        newTable.setVisible(true);
        newTable.setSize( 500, 600 );
    }

}
