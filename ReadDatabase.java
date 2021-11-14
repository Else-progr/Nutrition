import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDatabase implements SQL{

    public SQLConnection db;
    public JTextField jTextField1;
    public JTextField jTextField2;
    public JTextField jTextField3;
    public Connection conn;

    ReadDatabase(){

    }

    ReadDatabase(Connection conn) {
        this.conn = conn;
    }

//    ReadDatabase(Statement stmt){
//        this.stmt = stmt;
//    }


    @Override
    public void read(String choice) {

        try{
            Statement stmt = conn.createStatement();

            Queries quer = new Queries(stmt);
            quer.read(choice);

//            ResultSet rs =  stmt.executeQuery( cmd );
//
//            int el_ID  = rs.findColumn("el_ID");
//            int lm_ID   = rs.findColumn("lm_ID");
//            int portion   = rs.findColumn("Anteil");
//
//            while( rs.next() ){
//                el_ID = rs.getInt( el_ID );
//                lm_ID = rs.getInt( lm_ID );
//                portion = rs.getInt( portion );
//
//                System.out.print("" + el_ID);
//                System.out.print("   " + lm_ID);
//                System.out.println("   " + portion);
//
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String choice, String el, int port) {
    }
}
