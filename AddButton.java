import javax.swing.*;

public class AddButton  extends JButton implements WindowButtons {

    public static final String displayName = "hinzufügen";


    //Constructor
    AddButton( ){
        super(displayName);
        setPlace();
    }

    @Override
    public void setPlace() {
        setBounds(400, 500, 150, 30);
        setVisible(true);
    }


    @Override
    public void preformOperation(String addFood){
        NewTable.setTable();
    }


}
