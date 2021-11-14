import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDatabase implements SQL{

    public ConnectionDatabase db;
    public JTextField jTextField1;
    public JTextField jTextField2;
    public JTextField jTextField3;
    public Statement stmt;

    ReadDatabase(){

    }

    ReadDatabase(Statement stmt){
        this.stmt = stmt;
    }


    @Override
    public void read(String choice) {

        try{
            String cmd = "SELECT \"el_ID\", \"lm_ID\", \"Anteil\" "
                        + "FROM public.\"Zusammensetzung\" "
                        + "WHERE \"Name\"="
                        + "'" + choice + "'";

            ResultSet rs =  stmt.executeQuery( cmd );

            int el_ID  = rs.findColumn("el_ID");
            int lm_ID   = rs.findColumn("lm_ID");
            int portion   = rs.findColumn("Anteil");

            while( rs.next() ){
                el_ID = rs.getInt( el_ID );
                lm_ID = rs.getInt( lm_ID );
                portion = rs.getInt( portion );

//                jTextField1.setText("" + el_ID);//displaying product el in a jTextField1
//                jTextField2.setText("" + lm_ID);//displaying product lm in a jTextField2
//                jTextField3.setText("" + portion);//displaying product lm in a jTextField3

                System.out.print("" + el_ID);
                System.out.print("   " + lm_ID);
                System.out.println("   " + portion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String choice, String el, int port) {
    }
}
