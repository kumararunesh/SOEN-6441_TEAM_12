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