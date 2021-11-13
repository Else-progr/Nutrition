import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDatabase extends ConnectionDatabase implements SQL{

//    public Connection conn;

    ReadDatabase(){
    }

    @Override
    public void sqlCmd(String choice, String element, int portion) {

        try{
            Statement stmt = conn.createStatement();

            String cmd = "SELECT public.\"Zusammensetzung\"( \"el_ID\", \"lm_ID\", \"Anteil\" )"
                            + "VALUES ( "
                            + "(select \"el_ID\" from public.\"Nährstoffe\" where \"Name\"="
                            + "'"+"mehrfach ungesättigte FS" + "'"
                            + "),"
                            + "(select \"lm_ID\" from public.\"Lebensmittel\" where \"Name\"="
                            + "'" + choice + "'"
                            + "),"
                            + "7.0"
                            + ")";


            stmt.executeUpdate( cmd );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
