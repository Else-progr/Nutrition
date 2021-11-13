import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatabase extends ConnectionDatabase implements SQL {

//    public Connection conn;

    InsertDatabase(){
    }

    @Override
    public void sqlCmd(String foodChoice, String element, int portion) {

        try{
            Statement stmt = conn.createStatement();

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
