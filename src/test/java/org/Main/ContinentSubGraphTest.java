package org.Main;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is the test class for checking whether the continents are connected or not.
 */
public class ContinentSubGraphTest {

    /**
     *This function creates the object of ContinentsConnected and calls the continent connected function.
     */
    @Test
    public void ifContinentsConnectedTrue() {

        try {
            File l_file= new File(".\\src\\test\\resources\\maps\\h.map");
            ContinentsConnected l_obj = new ContinentsConnected(l_file);
            assertEquals(true,l_obj.ifContinentsConnected());


    } catch (Exception p_e) {
            p_e.printStackTrace();
        }

    }}
