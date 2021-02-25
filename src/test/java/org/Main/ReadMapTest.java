package org.Main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;

/**
 * This class test the different method of ReadMap class.
 */

public class ReadMapTest {

    /**
     * This method test whether the total number of lines in map is same as expected or not.
     * If the total number of lines present in map is same as expected then this test will get pass.
     */

    @Test
    public void testTotalLines()
    {
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        ReadMap l_map= new ReadMap();
        try{
            assertEquals(26,l_map.totallines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of lines in map is different then expected.
     * If the total number of lines present in map is different as expected then this test will get pass.
     */

    @Test
    public void testTotalLinesNot()
    {
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        ReadMap l_map= new ReadMap();
        try{
            assertNotEquals(2,l_map.totallines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of Country lines in map is same as expected or not.
     * If the total number of country lines present in map is same as expected then this test will get pass.
     */

    @Test
    public void testCountryLines()
    {
        ReadMap l_map = new ReadMap();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertEquals(6,l_map.continentlines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of country lines in map is different then expected.
     * If the total number of country lines present in map is different as expected then this test will get pass.
     */

    @Test
    public void testCountryLinesNot()
    {
        ReadMap l_map = new ReadMap();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertNotEquals(16,l_map.continentlines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of border lines in map is same as expected or not.
     * If the total number of border lines present in map is same as expected then this test will get pass.
     */

    @Test
    public void testBorderLines()
    {
        ReadMap l_map = new ReadMap();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertEquals(16,l_map.borderlines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of border lines in map is different then expected.
     * If the total number of border lines present in map is different as expected then this test will get pass.
     */

    @Test
    public void testBorderLinesNot()
    {
        ReadMap l_map = new ReadMap();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertNotEquals(296,l_map.borderlines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of continent lines in map is same as expected or not.
     * If the total number of continent lines present in map is same as expected then this test will get pass.
     */

    @Test
    public void testContinentLines()
    {
        ReadMap l_map = new ReadMap();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertEquals(6,l_map.continentlines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method test whether the total number of continent lines in map is different then expected.
     * If the total number of continent lines present in map is different as expected then this test will get pass.
     */

    @Test
    public void testContinentLinesNot()
    {
        ReadMap l_map = new ReadMap();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertNotEquals(296,l_map.continentlines(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}