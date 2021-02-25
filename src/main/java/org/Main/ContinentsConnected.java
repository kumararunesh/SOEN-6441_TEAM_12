package org.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class check whether the continents are connected to each other or not.
 */
public class ContinentsConnected {

    static File d_file;

    /**
     * This is the constructor of the class which just intialises the file.
     * @param p_file This is the file which is being used to check whether the continents in it are connected or not.
     */
    public ContinentsConnected(File p_file) {

        this.d_file = p_file;

    }

    /**
     * This function uses the continentsKey and CountriesContinent fuctions from map table and actually..
     * decides whether continents are disconnected or not. This puts all continents unique ids in continentsKey Arraylist..
     * and each countries continent id in CountriesContinent and then is sorted and compared with continentsKey arraylist..
     * if both are equal the continents are connected and if not the not connected.
     * @return boolean value whether a particulars maps continents are connected or not.
     * @throws Exception
     */
    public boolean ifContinentsConnected() throws Exception {

        MapTable l_obj = new MapTable();
        ArrayList<Integer> l_ContinentAndKey = l_obj.continentsKey(d_file);
        ArrayList<Integer> l_ContId = l_obj.CountriesContinent(d_file);
        Collections.sort(l_ContId);
        GraphConnected l_check = new GraphConnected(d_file);
        System.out.println(l_check);
        if (l_check.ifGraphConnected() == true) {

            if (l_ContinentAndKey.equals(l_ContId)==true){
                return true;
            }


        }
        return false;
    }

    public HashMap<Integer,ArrayList> ifContinentCountriesConnected() throws Exception {
        MapTable l_obj = new MapTable();

        ArrayList<Integer> copy = new ArrayList<>();
        HashMap<Integer,ArrayList> nodes = new HashMap<>();
        HashMap<Integer,Integer> l_connect = l_obj.cont(d_file);
        ArrayList<Integer> l_ContinentAndKey = l_obj.continentsKey(d_file);
        System.out.println(l_ContinentAndKey);
        System.out.println(l_connect);

        for(int i =0 ; i<l_ContinentAndKey.size() ; i++){
            ArrayList<Integer> countries = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry: l_connect.entrySet()){

                if(entry.getValue()== l_ContinentAndKey.get(i)){
                    countries.add(entry.getKey());
                    copy = countries;
                    nodes.put(l_ContinentAndKey.get(i),copy);

                    }

        }

        }

        return nodes;
    }
}
