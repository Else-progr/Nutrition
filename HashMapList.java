import java.util.*;
import java.io.*;

public class HashMapList {

	public BufferedReader buffer = null;
	private String line= "";
	public LinkedHashMap<String, NutrientValues> foodHashMap = new LinkedHashMap<>();
	int counter = 0;
	boolean booleanIsNutrientNamesSet = false;
	NutrientNames nutrientNamesHashMap;
	
	
	HashMapList() {
		
		try {
			buffer = new BufferedReader(new FileReader("src/testing.csv"));
			while( (line = buffer.readLine()) != null ) {
				String[] product = line.split(","); // uses comma as separator

				if ( !booleanIsNutrientNamesSet ) {
					nutrientNamesHashMap = new NutrientNames(product);
					booleanIsNutrientNamesSet = true;
				}else {
					String name = product[0];
					// TODO product[0] löschen
					foodHashMap.put(name, new NutrientValues(product, nutrientNamesHashMap));
					counter++;
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("File Not Found.");
		} catch(IOException e) {
			System.out.println("Index Error");
		}

	}


	String[] getNutrientName(){
		return nutrientNamesHashMap.getNutrientNamesHashMap();
	}

}
