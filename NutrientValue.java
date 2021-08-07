import java.util.*;

public class NutrientValue {

    LinkedHashMap<String,Double> nutrientValues = new LinkedHashMap<>();
    Nutrient nutrients;


    NutrientValue(String values[], Nutrient n) {

        this.nutrients = n;
        String[] nutrientName = n.getNutrientNames();

        for ( int i = 1 ; i < values.length ; i++) {
            if ( values[i] != "" )
                nutrientValues.put(nutrientName[i], Double.parseDouble(values[i]));
        }
    }

}