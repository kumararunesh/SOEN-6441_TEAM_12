package org.Main;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 *This is a class which contains test cases to test the GraphConnected.
 */
public class GraphConnectedTest{

    /**
     * Asserts if the graph is connected then assert true.
     */
    @Test
    public void ifGraphConnectedTrue() {
        File l_file= new File(".\\src\\test\\resources\\maps\\h.map");

        try {
            GraphConnected l_check = new GraphConnected(l_file);
            assertEquals(true,l_check.ifGraphConnected());
        } catch (Exception p_e) {
            p_e.printStackTrace();
        }

    }

    /**
     * Asserts if the graph is not connected then assert false.
     */
    @Test
    public void ifGraphConnectedFalse() {
        File l_file= new File(".\\src\\test\\resources\\maps\\bigeurope.map");

        try {
            GraphConnected l_check = new GraphConnected(l_file);
            assertNotEquals(false,l_check.ifGraphConnected());
        } catch (Exception p_e) {
            p_e.printStackTrace();
        }

    }

}