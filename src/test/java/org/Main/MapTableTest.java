package org.Main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This class is a test class which test different methods of MapTable class
 */

public class MapTableTest {

    /**
     * This method test whether the continents present in a map is same as expected or not.
     */

    @Test
    public void testConitnentName() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("a", "b"));

            assertEquals(l_ans, l_map.continentList(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the continents present in a map are different than expected.
     * If the continent names are different then expected than this test will get pass.
     */

    @Test
    public void testContinentNameNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("b", "b"));

            assertNotEquals(l_ans, l_map.continentList(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries present in a map is same as expected or not.
     */

    @Test
    public void testCountryName() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("c", "d", "e", "f", "g", "y"));

            assertEquals(l_ans, l_map.countryList(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries present in a map are different than expected.
     * If the countries names are different then expected than this test will get pass.
     */

    @Test
    public void testCountryNameNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("d", "d", "e", "f", "g", "y"));

            assertNotEquals(l_ans, l_map.countryList(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the continents and their control value present in a map is same as expected or not.
     */

    @Test
    public void testContinentAndValue() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, Integer> l_contval = new HashMap<>();
            l_contval.put("a", 5);
            l_contval.put("b", 5);

            assertEquals(l_contval, l_map.continentandvalue(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the continents and their control value present in a map are different than expected.
     * If the countries names with their control values are different then expected than this test will get pass.
     */

    @Test
    public void testContinentAndValueNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, Integer> l_contval = new HashMap<>();
            l_contval.put("b", 5);
            l_contval.put("b", 5);

            assertNotEquals(l_contval, l_map.continentandvalue(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their unique key present in a map is same as expected or not.
     */

    @Test
    public void testCountryAndItsKey() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<Integer, String> l_contkey = new HashMap<>();
            l_contkey.put(1, "c");
            l_contkey.put(2, "d");
            l_contkey.put(3, "e");
            l_contkey.put(4, "f");
            l_contkey.put(5, "g");
            l_contkey.put(6, "y");

            assertEquals(l_contkey, l_map.countryanditskey(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their unique key present in a map are different than expected.
     * If the countries names with their unique key are different then expected than this test will get pass.
     */

    @Test
    public void testCountryAndItsKeyNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<Integer, String> l_contkey = new HashMap<>();
            l_contkey.put(2, "c");
            l_contkey.put(2, "d");
            l_contkey.put(3, "c");
            l_contkey.put(4, "f");
            l_contkey.put(5, "g");
            l_contkey.put(6, "y");

            assertNotEquals(l_contkey, l_map.countryanditskey(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and the continent to which they belong present in a map is same as expected or not.
     */

    @Test
    public void testCountryAndContinent() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, String> l_countcont = new HashMap<>();
            l_countcont.put("c", "a");
            l_countcont.put("d", "a");
            l_countcont.put("e", "b");
            l_countcont.put("f", "b");
            l_countcont.put("g", "b");
            l_countcont.put("y", "a");

            assertEquals(l_countcont, l_map.countryanditscontinent(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and the continent to which they belong present in a map are different than expected.
     * If the countries and the continent to which they belong are different then expected than this test will get pass.
     */

    @Test
    public void testCountryAndContinentNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, String> l_countcont = new HashMap<>();
            l_countcont.put("a", "a");
            l_countcont.put("d", "a");
            l_countcont.put("e", "c");
            l_countcont.put("f", "b");
            l_countcont.put("g", "b");
            l_countcont.put("y", "a");

            assertNotEquals(l_countcont, l_map.countryanditscontinent(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method test whether the countries and their neighbors present in a map are different than expected.
     * If the countries and their neighbors are different then expected than this test will get pass.
     */

    @Test
    public void testCountryAndItsNeighborsNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, ArrayList> l_countryNeigh = new HashMap<>();
            l_countryNeigh.put("c", new ArrayList(Arrays.asList("e", "e", "f", "g", "y")));
            l_countryNeigh.put("d", new ArrayList(Arrays.asList("c", "e")));
            l_countryNeigh.put("e", new ArrayList(Arrays.asList("a", "c", "d")));
            l_countryNeigh.put("f", new ArrayList(Arrays.asList("d", "c")));
            l_countryNeigh.put("g", new ArrayList(Arrays.asList("d", "c")));
            l_countryNeigh.put("y", new ArrayList(Arrays.asList("d", "e")));

            assertNotEquals(l_countryNeigh, l_map.countryanditsneighbours(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and the continent's unique key to which that country belongs present in a map is same as expected or not.
     */

    @Test
    public void testCountryAndItsUniqueContinent() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, Integer> l_countcontkey = new HashMap<>();
            l_countcontkey.put("c", 1);
            l_countcontkey.put("d", 1);
            l_countcontkey.put("e", 2);
            l_countcontkey.put("f", 2);
            l_countcontkey.put("g", 2);
            l_countcontkey.put("y", 1);

            assertEquals(l_countcontkey, l_map.countryanditsuniquecontinent(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether countries and the continent's unique key to which that country belongs present in a map are different than expected.
     * If the countries and the continent's unique key to which that country belongs are different then expected than this test will get pass.
     */

    @Test
    public void testCountryAndItsUniqueContinentNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, Integer> l_countcontkey = new HashMap<>();
            l_countcontkey.put("q", 1);
            l_countcontkey.put("d", 1);
            l_countcontkey.put("e", 2);
            l_countcontkey.put("v", 2);
            l_countcontkey.put("g", 2);
            l_countcontkey.put("y", 1);

            assertNotEquals(l_countcontkey, l_map.countryanditsuniquecontinent(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their unique key present in a map is same as expected or not.
     */

    @Test
    public void testUniqueKeyAndItsCountry() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, Integer> l_keycount = new HashMap<>();
            l_keycount.put("c", 1);
            l_keycount.put("d", 2);
            l_keycount.put("e", 3);
            l_keycount.put("f", 4);
            l_keycount.put("g", 5);
            l_keycount.put("y", 6);

            assertEquals(l_keycount, l_map.uniqueKeyanditscountry(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether countries and their unique key present in a map are different than expected.
     * If the countries and their unique key are different then expected than this test will get pass.
     */

    @Test
    public void testUniqueKeyAndItsCountryNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            HashMap<String, Integer> l_keycount = new HashMap<>();
            l_keycount.put("c", 1);
            l_keycount.put("d", 2);
            l_keycount.put("e", 3);
            l_keycount.put("d", 4);
            l_keycount.put("g", 7);
            l_keycount.put("y", 6);

            assertNotEquals(l_keycount, l_map.uniqueKeyanditscountry(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the unique ID's of different countries present in a map is same as expected or not.
     */

    @Test
    public void testMax() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            List<Integer> l_list = new ArrayList<>();
            l_list.add(1);
            l_list.add(2);
            l_list.add(3);
            l_list.add(4);
            l_list.add(5);
            l_list.add(6);

            assertEquals(l_list, l_map.max(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether unique ID's of different countries present in a map are different than expected.
     * If the unique ID's of different countries are different then expected than this test will get pass.
     */

    @Test
    public void testMaxNot() {
        File l_file = new File(".\\src\\main\\resources\\maps\\h.map");
        MapTable l_map = new MapTable();
        try {
            List<Integer> l_list = new ArrayList<>();
            l_list.add(1);
            l_list.add(3);
            l_list.add(3);
            l_list.add(4);
            l_list.add(5);
            l_list.add(6);

            assertNotEquals(l_list, l_map.max(l_file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
