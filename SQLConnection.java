import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class SQLConnection {

    public String url;
    public String user;
    public String pw;

    public Connection getConnection(){

        Connection conn = null;
        HashMap<String,String> logInDataMap = new HashMap<>();

        // auto close connection
        try {
            Scanner scan = new Scanner(new FileReader("src/LogInData.txt"));
            while( scan.hasNext() ) {
                String line = scan.nextLine();
                String[] logInDataString = line.split(" "); // uses Blanc-space as separator
                logInDataMap.put(logInDataString[0], logInDataString[1]);
            }
            url = logInDataMap.get("url:");
            user = logInDataMap.get("user:");
            pw = logInDataMap.get("pw:");


            conn = DriverManager.getConnection( url , user, pw );

            if (conn != null) {
                System.out.println("Connected to the database!");

            } else {
                System.out.println("Failed to make connection!");
                System.exit(-1);
            }

        } catch(FileNotFoundException e) {
            System.out.println("File Not Found.");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return conn;
    }



}
