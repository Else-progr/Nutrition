import java.util.*;

public class NutrientValues {

    LinkedHashMap<String,Double> nutrientValuesHasMap = new LinkedHashMap<>();
    NutrientNames nutrientNamesHashMap;
    String[] nutrientNamesArray;


    NutrientValues(String values[], NutrientNames n) {
        this.nutrientNamesHashMap = n;
        nutrientNamesArray = n.getNutrientNamesHashMap();
        setNutrientValuesHasMap(values);
    }


    public void setNutrientValuesHasMap(String[] values){
        for ( int i = 1 ; i < values.length ; i++) {
            if ( values[i] != "" )
                nutrientValuesHasMap.put(nutrientNamesArray[i], Double.parseDouble(values[i]));
        }
    }


    String[] getNutrientNamesArray(){
        return nutrientNamesArray;
    }

}