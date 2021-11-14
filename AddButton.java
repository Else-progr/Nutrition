import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void preformOperation(String addFood, Connection conn){
        NewTable.setTable();
        try {
            (new Queries(conn.createStatement())).insert(addFood,"davon Zucker", 3.8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
