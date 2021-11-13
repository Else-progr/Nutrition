import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame implements Frame{

    public static final String displayName = "Lebensmittel";

    StartFrame(){
        super(displayName);
        setFrame();
    }

    @Override
    public void setFrame() {
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void addToFrame(Component obj){
        add(obj);
    }
}
