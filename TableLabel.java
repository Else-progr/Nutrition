import javax.swing.*;
import java.awt.*;

public class TableLabel extends JLabel implements Label{

    //Constructor
    TableLabel(){
        super();
        setLabel();
    }

    @Override
    public void setLabel() {
        setBounds(50, 100, 500, 70);
        setFont(new Font("SansSerif", Font.BOLD, 14));
    }
}
