import java.util.*;
import java.io.*;

public class List {

	private BufferedReader buffer = null;
	private String line= "";
	String splitBy = ",";
	LinkedHashMap<String,NutrientValue> food = new LinkedHashMap();
	int counter = 0;
	boolean setNutrient = true;
	Nutrient nutrients;
	
	
	List() {
		
		try {
			buffer = new BufferedReader(new FileReader("src/Lebensmittelliste.csv"));
			while( (line = buffer.readLine()) != null ) {
				String product[] = line.split(splitBy); // use comma as separator
				if ( setNutrient ) {
					nutrients = new Nutrient(product);
					setNutrient = false;
				}else {
					String name = product[0];
					// TODO product[0] löschen
					food.put(name, new NutrientValue(product, nutrients));
					counter++;
				}
			}
			buffer.close();
		} catch(FileNotFoundException e) {
			System.out.println("File Not Found.");
		} catch(IOException e) {
			System.out.println("Index Error");
		}

	}

}
