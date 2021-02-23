package org.Main;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class will get the details of the map after user edit some changes in the map and then this will validate the map on some conditions.
 * If the map is validated, then the file will get saved else it will show that the file in not correct.
 */
public class MapValidation {

    /**
     * This method will get the details of the map after user edit some changes in the map and then it will validate the map on some conditions.
     * If the map is validated, then the file will get saved else it will show that the file in not correct.
     * @param p_file This is the map file where all the details of the map will be saved.
     * @param p_countries This parameter is an arraylist which contains the list of countries.
     * @param p_continent This parameter is an arraylist which contains the list of the continents.
     * @param p_cont_val This is a hashmap data structure which contains the continent name as the key and their control value as the hashmap value.
     * @param p_country_key This is a hashmap which contains the unique ID of country as the key and name of the country as the hashmap value.
     * @param p_country_cont This is a hashmap which contains the name of the country as the key and the continent to which it belong as the value of the hashmap.
     * @param p_country_neighbour This is a hashmap which contains a string as the key which contains the name of the country and an arraylist as the value of the hashmap which contains the list of neighboring countries of that key country.
     * @param p_country_cont_key This hashmap contains the name of the country as it's key and the continent unique ID as the value of the hashmap.
     * @param p_cont_unique_key This hashmap contains the name of the country as it's key and the country's unique ID as the value of the hashmap.
     * @throws Exception If file doesn't found at the directed path then this will throw exception.
     */
    String[] arr= new String[1];
    public  String[] mapValidate(File p_file,ArrayList<String> p_countries,ArrayList<String> p_continent,HashMap<String, Integer> p_cont_val, HashMap<Integer, String> p_country_key,HashMap<String, String> p_country_cont,HashMap<String, ArrayList> p_country_neighbour,HashMap<String, Integer> p_country_cont_key,HashMap<String, Integer> p_cont_unique_key) throws Exception {
        int l_final_flag = 0;
        for (int l_i = 0; l_i < p_countries.size(); l_i++) {
            for(int l_j=l_i+1; l_j < p_countries.size()-1;l_j++){
                if(p_countries.get(l_i).equalsIgnoreCase(p_countries.get(l_j))){
                    System.out.println("Countries cannot be of same name");
                    l_final_flag = 1;
                    break;
                }
            }
        }

    return 0;
    }
}
