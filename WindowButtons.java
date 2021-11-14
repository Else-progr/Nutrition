import java.sql.Connection;

public interface WindowButtons {


    void setPlace();

    void preformOperation(String choice, Connection conn);
}
