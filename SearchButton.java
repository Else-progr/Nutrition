import javax.swing.*;

public class SearchButton extends JButton implements WindowButtons {

    public static final String displayName = "Suche";


    //Constructor
    SearchButton( /* String inputBox */ ){
        super(displayName);
        setPlace();
    }

    @Override
    public void setPlace(){
        setBounds(460, 50, 100, 30);
        setVisible(true);
    }

    //Search
    @Override
    public void preformOperation(String foodChoice){
        ShowNutritions.show(foodChoice);
    }
}
