import java.util.*;

public class NutrientValues {

    LinkedHashMap<String,Double> nutrientValuesHashMap = new LinkedHashMap<>();
    NutrientNames nutrientNamesHashMap;
    String[] nutrientNamesArray;


    NutrientValues(String[] values, NutrientNames n) {
        this.nutrientNamesHashMap = n;
        nutrientNamesArray = n.getNutrientNamesHashMap();
        setNutrientValuesHashMap(values);
    }


    public void setNutrientValuesHashMap(String[] values){
        for ( int i = 1 ; i < values.length ; i++) {
            if (!Objects.equals(values[i], ""))
                nutrientValuesHashMap.put(nutrientNamesArray[i], Double.parseDouble(values[i]));
        }
    }


    String[] getNutrientNamesArray(){
        return nutrientNamesArray;
    }

}