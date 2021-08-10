import java.util.*;

class Nutrient {

    public LinkedHashMap<String,Integer> nutrient = new LinkedHashMap<>();

    Nutrient(){
    }

    Nutrient(String name[]){
        for( int i = 0; i < name.length; i++)
            nutrient.put(name[i], i);
    }


    String[] getNutrientNames(){

        return nutrient.keySet().toArray(new String[nutrient.size()]);
    }

}
