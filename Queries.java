import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {

    public JTextField jTextField1;
    public JTextField jTextField2;
    public JTextField jTextField3;
    public Statement stmt;


    Queries(Statement stmt){
        this.stmt = stmt;
    }


    public void read(String choice) {

        try{
            String cmd = "SELECT \"L\".\"Name\" AS \"Lname\", \"N\".\"Name\" AS \"Nname\", \"Z\".\"Anteil\" " +
                        "FROM public.\"Zusammensetzung\" AS \"Z\" " +
                        "INNER JOIN public.\"Lebensmittel\" AS \"L\" " +
                        "ON \"Z\".\"lm_ID\" = \"L\".\"lm_ID\" " +
                        "INNER JOIN public.\"Nährstoffe\" AS \"N\" " +
                        "ON \"Z\".\"el_ID\" = \"N\".\"el_ID\" " +
                        "WHERE \"L\".\"Name\" = " +
                        "'" + choice + "'";

            ResultSet rs =  stmt.executeQuery( cmd );

            int el_ID_ColNr  = rs.findColumn("Lname");
            int lm_ID_ColNr   = rs.findColumn("Nname");
            int portion_ColNr   = rs.findColumn("Anteil");

            boolean nameSet = false;
            while( rs.next() ){
                String el_ID = rs.getString( el_ID_ColNr  );
                String lm_ID = rs.getString( lm_ID_ColNr );
                double portion = rs.getDouble( portion_ColNr  );

//                jTextField1.setText("" + el_ID);//displaying product el in a jTextField1
//                jTextField2.setText("" + lm_ID);//displaying product lm in a jTextField2
//                jTextField3.setText("" + portion);//displaying product lm in a jTextField3

                if(!nameSet) {
                    System.out.println("" + el_ID + ":");
                    nameSet =true;
                }
                System.out.printf("%s\t%s%n", lm_ID, portion);


            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(String foodChoice, String element, double portion) {

        try{

            String cmd = "INSERT INTO public.\"Zusammensetzung\"( \"el_ID\", \"lm_ID\", \"Anteil\" )"
                    + "VALUES ( "
                    + "(select \"el_ID\" from public.\"Nährstoffe\" where \"Name\"="
                    + "'"+ element + "'"
                    + "),"
                    + "(select \"lm_ID\" from public.\"Lebensmittel\" where \"Name\"="
                    + "'" + foodChoice + "'"
                    + "),"
                    + portion
                    + ")";


            stmt.executeUpdate( cmd );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
