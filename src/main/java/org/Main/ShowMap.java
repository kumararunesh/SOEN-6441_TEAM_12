package org.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is to display the map in the form of text.
 */

public class ShowMap {

    File FILE;

    /**
     * This method initially check whether there is any predefined maps. If the file is empty then it will ask the user to create a new map.
     * Else this method will show the list of maps and ask to user to select a map which user want to see.
     * After that it will go back to the main menu.
     * @throws Exception If the map name entered by user is wrong or incorrect, this will throw exception.
     */

    public void mapshow() throws Exception {
        while (true) {
            try {
                Scanner d_sc = new Scanner(System.in);
                File d_directoryPath = new File("src\\Main\\test");
                String l_contents[] = d_directoryPath.list();
                if(l_contents.length == 0){
                    System.out.println("There are no predefined maps");
                    System.out.println("Let's create a new map");
                    Main.EditMap();
                    break;
                }
                System.out.println("Here are the list of maps");
                System.out.println("");
                System.out.println("*************************");
                for (int l_i = 0; l_i < l_contents.length; l_i++) {
                    System.out.println(l_contents[l_i]);
                }
                System.out.println("*************************");
                System.out.println("");
                System.out.println("Enter the name of the map you want to select (Don't use extension)");
                String l_x = d_sc.nextLine();
                FILE = new File("src\\Main\\test\\" + l_x + ".map");

                MapTable d_list = new MapTable();
                ArrayList<String> l_countries = d_list.countryList(FILE);
                ArrayList<String> l_continent = d_list.continentList(FILE);
                HashMap<String, Integer> l_contval = d_list.continentandvalue(FILE);
                HashMap<Integer, String> l_countrykey = d_list.countryanditskey(FILE);
                HashMap<String, String> l_countrycont = d_list.countryanditscontinent(FILE);
                HashMap<String, ArrayList> l_countryneigh = d_list.countryanditsneighbours(FILE);

                System.out.println("************** COUNTRIES **************");
                for (int l_i = 0; l_i < l_countries.size(); l_i++) {
                    System.out.print(l_countries.get(l_i) + " ");
                }
                System.out.println("");
                System.out.println("****************************");
                System.out.println("");

                System.out.println("************** CONTINENTS **************");
                for (int l_i = 0; l_i < l_continent.size(); l_i++) {
                    System.out.print(l_continent.get(l_i) + " ");
                }
                System.out.println("");
                System.out.println("****************************");
                System.out.println("");

                System.out.println("************** CONTINENTS and their initial ARMY VALUE **************");
                for (
                        Map.Entry l_mapElement : l_contval.entrySet()) {
                    String l_key = (String) l_mapElement.getKey();
                    int l_value = (int) l_mapElement.getValue();
                    System.out.println(l_key + " = " + l_value);
                }
                System.out.println("****************************");
                System.out.println("");

                System.out.println("************** COUNTRIES with their UNIQUE KEY **************");
                for (Map.Entry l_mapElement : l_countrykey.entrySet()) {
                    Integer l_key = (Integer) l_mapElement.getKey();
                    String l_value = (String) l_mapElement.getValue();
                    System.out.println(l_key + " = " + l_value);
                }
                System.out.println("****************************");
                System.out.println("");

                System.out.println("************** COUNTRY and its CONTINENT **************");
                for (Map.Entry l_mapElement : l_countrycont.entrySet()) {
                    String l_key = (String) l_mapElement.getKey();
                    String l_value = (String) l_mapElement.getValue();
                    System.out.println(l_key + " = " + l_value);
                }
                System.out.println("****************************");
                System.out.println("");

                System.out.println("************** COUNTRY and its NEIGHBOURING COUNTRIES **************");
                for (Map.Entry<String, ArrayList> l_mapElement : l_countryneigh.entrySet()) {
                    String l_key = (String) l_mapElement.getKey();
                    ArrayList l_value = l_mapElement.getValue();
                    System.out.println(l_key + " = " + l_value);
                }
                break;
            } catch (Exception p_e) {
                System.out.println("Enter valid map name");
            }
        }
        System.out.println("");
        Main.menu();
    }
}