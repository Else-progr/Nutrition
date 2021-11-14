import java.sql.Statement;

public interface WindowButtons {


    void setPlace();

    void preformOperation(String choice, Statement stmt);
}
