import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class ConnectionDatabase {

    public Connection conn = null;
    public HashMap<String,String> logInDataMap = new HashMap<>();

    ConnectionDatabase(){

        try {
            Scanner scan = new Scanner(new FileReader("src/LogInData.txt"));
            while( scan.hasNext() ) {
                String line = scan.nextLine();
                String[] logInDataString = line.split(" "); // uses Blanc-space as separator
                logInDataMap.put(logInDataString[0], logInDataString[1]);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found.");
        }

        // auto close connection
        try (  Connection conn = DriverManager.getConnection(
                logInDataMap.get("url:"), logInDataMap.get("user:"), logInDataMap.get("password:"))   )
        {
            this.conn = conn;

            if (conn != null) {

                System.out.println("Connected to the database!");

//                Statement stmt = conn.createStatement();
//
//                    String insert = "INSERT INTO public.\"Zusammensetzung\"( \"el_ID\", \"lm_ID\", \"Anteil\" )"
//                            + "VALUES ( "
//                            + "(select \"el_ID\" from public.\"Nährstoffe\" where \"Name\"="
//                            + "'"+"mehrfach ungesättigte FS" + "'"
//                            + "),"
//                            + "(select \"lm_ID\" from public.\"Lebensmittel\" where \"Name\"="
//                            + "'" + "Goldleinsamen" + "'"
//                            + "),"
//                            + "7.0"
//                            + ")";
//
//                stmt.executeUpdate( insert );

            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
