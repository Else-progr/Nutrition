import java.util.*;


class NutrientNames {

    public LinkedHashMap<String,Integer> nutrientNamesHashMap = new LinkedHashMap<>();


    NutrientNames(String name[]){
        setNutrientNamesHashMap(name);
    }


    public void setNutrientNamesHashMap(String name[]) {
        for( int i = 0; i < name.length; i++)
            nutrientNamesHashMap.put(name[i], i);
    }


    String[] getNutrientNamesHashMap(){
//        int NumberOfNutrientNames = getNumberOfNutrientNames();
        return nutrientNamesHashMap.keySet().toArray( new String[0]);
    }

//    int getNumberOfNutrientNames(){
//        return nutrientNamesHashMap.size();
//    }

}
