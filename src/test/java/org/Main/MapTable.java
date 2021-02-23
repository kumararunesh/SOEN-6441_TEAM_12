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