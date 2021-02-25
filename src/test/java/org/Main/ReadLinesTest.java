package org.Main;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;


/**
 * This is test class which test different methods of ReadLines class.
 */

public class ReadLinesTest {

    /**
     * This method will test whether the number of border and country lines in the map is same as expected or not.
     * If the border and country lines are same as expected then the test case will get pass.
     */

    @Test
    public void TestCountryAndBorderLines()
    {
        ReadLines l_map = new ReadLines();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertEquals(7,l_map.countryandborderline(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method will test whether the number of border and country lines in the map doesn't match.
     * If the border and country lines are different then as expected then the test case will get pass.
     */

    @Test
    public void TestCountryAndBorderLinesNot()
    {
        ReadLines l_map = new ReadLines();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertNotEquals(6,l_map.countryandborderline(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method will test whether the number of continent lines in the map is same as expected or not.
     * If the continent lines are same as expected then the test case will get pass.
     */

    @Test
    public void TestContinentLines()
    {
        ReadLines l_map = new ReadLines();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertEquals(3,l_map.continentline(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method will test whether the number of continent in the map doesn't match.
     * If the continent lines are different then as expected then the test case will get pass.
     */

    @Test
    public void TestContinentLinesNot()
    {
        ReadLines l_map = new ReadLines();
        File l_file = new File(".\\src\\test\\resources\\maps\\h.map");
        try {
            assertNotEquals(4,l_map.continentline(l_file));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
