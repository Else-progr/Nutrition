import java.sql.Connection;

public class MainNutrition {


    public static void main(String[] args) {

        ConnectionDatabase db = new ConnectionDatabase();
        new Dashboard( db );
    }
}