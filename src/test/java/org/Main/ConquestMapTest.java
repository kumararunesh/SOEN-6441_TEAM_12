package org.Main;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 *This is a class which contains test cases to test the GraphConnected.
 */
public class ConquestMapTest{

    /**
     * Asserts if the graph is connected then assert true.
     */
    @Test
    public void ifGraphConnectedTrue() {
        File l_file= new File(".\\src\\test\\resources\\maps\\conquest.map");

        try {
            GraphConnectedConquest l_check = new GraphConnectedConquest(l_file);
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
        File l_file= new File(".\\src\\test\\resources\\maps\\hnp.map");

        try {
            GraphConnectedConquest l_check = new GraphConnectedConquest(l_file);
            assertEquals(false,l_check.ifGraphConnected());
        } catch (Exception p_e) {
            p_e.printStackTrace();
        }

    }

}