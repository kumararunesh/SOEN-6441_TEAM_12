package Test.Main;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Main.MapTable;

/**
 * This class is a test class which test different methods of MapTable class
 */

public class MapTableTest {

    /**
     * This method test whether the continents present in a map is same as expected or not.
     */

    @Test
    public void testConitnentName()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("a","b"));
        	
            assertEquals(l_ans,d_map.continentList(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the continents present in a map are different than expected.
     * If the continent names are different then expected than this test will get pass.
     */

    @Test
    public void testContinentNameNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("b","b"));
        	
        	assertNotEquals(l_ans,d_map.continentList(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries present in a map is same as expected or not.
     */

    @Test
    public void testCountryName()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("c","d","e","f","g","y"));
        	
        	assertEquals(l_ans,d_map.countryList(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries present in a map are different than expected.
     * If the countries names are different then expected than this test will get pass.
     */

	@Test
    public void testCountryNameNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	ArrayList<String> l_ans = new ArrayList<>(Arrays.asList("d","d","e","f","g","y"));
        	
        	assertNotEquals(l_ans,d_map.countryList(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the continents and their control value present in a map is same as expected or not.
     */

	@Test
    public void testContinentAndValue()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,Integer> l_contval = new HashMap<>(); 
        	l_contval.put("a", 5);
        	l_contval.put("b", 5);
        	
        	assertEquals(l_contval,d_map.continentandvalue(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the continents and their control value present in a map are different than expected.
     * If the countries names with their control values are different then expected than this test will get pass.
     */

    @Test
    public void testContinentAndValueNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,Integer> l_contval = new HashMap<>(); 
        	l_contval.put("b", 5);
        	l_contval.put("b", 5);
        	
        	assertNotEquals(l_contval,d_map.continentandvalue(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their unique key present in a map is same as expected or not.
     */
	
	@Test
    public void testCountryAndItsKey()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<Integer,String> l_contkey = new HashMap<>(); 
        	l_contkey.put(1,"c");
        	l_contkey.put(2,"d");
        	l_contkey.put(3,"e");
        	l_contkey.put(4,"f");
        	l_contkey.put(5,"g");
        	l_contkey.put(6,"y");
        	
        	assertEquals(l_contkey,d_map.countryanditskey(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their unique key present in a map are different than expected.
     * If the countries names with their unique key are different then expected than this test will get pass.
     */

	@Test
    public void testCountryAndItsKeyNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<Integer,String> l_contkey = new HashMap<>(); 
        	l_contkey.put(2,"c");
        	l_contkey.put(2,"d");
        	l_contkey.put(3,"c");
        	l_contkey.put(4,"f");
        	l_contkey.put(5,"g");
        	l_contkey.put(6,"y");
        	
        	assertNotEquals(l_contkey,d_map.countryanditskey(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and the continent to which they belong present in a map is same as expected or not.
     */
	
	@Test
    public void testCountryAndContinent()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,String> l_countcont = new HashMap<>(); 
        	l_countcont.put("c","a");
        	l_countcont.put("d","a");
        	l_countcont.put("e","b");
        	l_countcont.put("f","b");
        	l_countcont.put("g","b");
        	l_countcont.put("y","a");
        	
        	assertEquals(l_countcont,d_map.countryanditscontinent(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and the continent to which they belong present in a map are different than expected.
     * If the countries and the continent to which they belong are different then expected than this test will get pass.
     */
	
	@Test
    public void testCountryAndContinentNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,String> l_countcont = new HashMap<>(); 
        	l_countcont.put("a","a");
        	l_countcont.put("d","a");
        	l_countcont.put("e","c");
        	l_countcont.put("f","b");
        	l_countcont.put("g","b");
        	l_countcont.put("y","a");
        	
        	assertNotEquals(l_countcont,d_map.countryanditscontinent(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their neighbors present in a map is same as expected or not.
     */
	
	@Test
    public void testCountryAndItsNeighbors()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,ArrayList> l_countryNeigh = new HashMap<>(); 
        	l_countryNeigh.put("c",new ArrayList(Arrays.asList("d","e","f","g","y")));
        	l_countryNeigh.put("d",new ArrayList(Arrays.asList("c","e")));
        	l_countryNeigh.put("e",new ArrayList(Arrays.asList("f","c","d")));
        	l_countryNeigh.put("f",new ArrayList(Arrays.asList("d","c")));
        	l_countryNeigh.put("g",new ArrayList(Arrays.asList("d","c")));
        	l_countryNeigh.put("y",new ArrayList(Arrays.asList("d","e")));
        	
        	assertEquals(l_countryNeigh,d_map.countryanditsneighbours(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their neighbors present in a map are different than expected.
     * If the countries and their neighbors are different then expected than this test will get pass.
     */
    
	@Test
    public void testCountryAndItsNeighborsNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,ArrayList> l_countryNeigh = new HashMap<>(); 
        	l_countryNeigh.put("c",new ArrayList(Arrays.asList("e","e","f","g","y")));
        	l_countryNeigh.put("d",new ArrayList(Arrays.asList("c","e")));
        	l_countryNeigh.put("e",new ArrayList(Arrays.asList("a","c","d")));
        	l_countryNeigh.put("f",new ArrayList(Arrays.asList("d","c")));
        	l_countryNeigh.put("g",new ArrayList(Arrays.asList("d","c")));
        	l_countryNeigh.put("y",new ArrayList(Arrays.asList("d","e")));
        	
        	assertNotEquals(l_countryNeigh,d_map.countryanditsneighbours(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and the continent's unique key to which that country belongs present in a map is same as expected or not.
     */
    
	@Test
    public void testCountryAndItsUniqueContinent()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,Integer> l_countcontkey = new HashMap<>(); 
        	l_countcontkey.put("c", 1);
        	l_countcontkey.put("d", 1);
        	l_countcontkey.put("e", 2);
        	l_countcontkey.put("f", 2);
        	l_countcontkey.put("g", 2);
        	l_countcontkey.put("y", 1);
        	
        	assertEquals(l_countcontkey,d_map.countryanditsuniquecontinent(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether countries and the continent's unique key to which that country belongs present in a map are different than expected.
     * If the countries and the continent's unique key to which that country belongs are different then expected than this test will get pass.
     */

    @Test
    public void testCountryAndItsUniqueContinentNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,Integer> l_countcontkey = new HashMap<>(); 
        	l_countcontkey.put("q", 1);
        	l_countcontkey.put("d", 1);
        	l_countcontkey.put("e", 2);
        	l_countcontkey.put("v", 2);
        	l_countcontkey.put("g", 2);
        	l_countcontkey.put("y", 1);
        	
        	assertNotEquals(l_countcontkey,d_map.countryanditsuniquecontinent(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the countries and their unique key present in a map is same as expected or not.
     */

    @Test
    public void testUniqueKeyAndItsCountry()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,Integer> l_keycount = new HashMap<>(); 
        	l_keycount.put("c", 1);
        	l_keycount.put("d", 2);
        	l_keycount.put("e", 3);
        	l_keycount.put("f", 4);
        	l_keycount.put("g", 5);
        	l_keycount.put("y", 6);
        	
        	assertEquals(l_keycount,d_map.uniqueKeyanditscountry(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether countries and their unique key present in a map are different than expected.
     * If the countries and their unique key are different then expected than this test will get pass.
     */


    @Test
    public void testUniqueKeyAndItsCountryNot()
    {
        File d_file = new File(".\\src\\Main\\test\\h.map");
        MapTable d_map= new MapTable();
        try{
        	HashMap<String,Integer> l_keycount = new HashMap<>(); 
        	l_keycount.put("c", 1);
        	l_keycount.put("d", 2);
        	l_keycount.put("e", 3);
        	l_keycount.put("d", 4);
        	l_keycount.put("g", 7);
        	l_keycount.put("y", 6);
        	
        	assertNotEquals(l_keycount,d_map.uniqueKeyanditscountry(d_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
}
