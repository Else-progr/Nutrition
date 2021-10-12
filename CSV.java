import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CSV extends HashMapList {

    String insert;

    CSV(String[] data){
        this.insert = Arrays.stream(data)
                .map(x -> (x == null ? "" : x))
                .collect(Collectors.joining(","));
        this.insert = this.insert.substring(0,this.insert.length()-1);

    }

    public void addToCSV(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/testing.csv",true));
            writer.newLine();
            writer.append(this.insert);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
