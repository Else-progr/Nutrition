import javax.swing.*;

public class AddFoodBox extends JTextField implements Box{

    public static final int length = 50;

    AddFoodBox(){
        super(length);
        setBox();
    }

    @Override
    public void setBox() {
        setBounds(50, 500, 340, 30);
        setVisible(true);
    }

}
