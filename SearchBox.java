import javax.swing.*;

public class SearchBox extends JTextField implements Box{

    public static final int length = 25;

    SearchBox(){
        super(length);
        setBox();
    }

    @Override
    public void setBox() {
        setBounds(150, 50, 300, 30);
        setVisible(true);
    }
}
