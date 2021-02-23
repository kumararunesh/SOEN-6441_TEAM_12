package Test.Main;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Main.MapTable;

public class MapTableTest {

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

    