import javax.swing.*;
import java.awt.*;

public class SearchLabel extends JLabel implements Label {

    public static final String displayName = "Lebensmittel";

    //Constructor
    SearchLabel(){
        super(displayName);
        setLabel();
    }


    @Override
    public void setLabel() {
        setFont(new Font("Verdana", Font.PLAIN, 14));
        setBounds(50, 50, 300, 30);
    }
}
