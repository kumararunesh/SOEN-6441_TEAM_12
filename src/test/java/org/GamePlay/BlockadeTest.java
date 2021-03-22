package org.GamePlay;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BlockadeTest {

    Country d_con1 , d_con2 , d_con3;
    Cards card1 , card2;
    Player p1;

    @Before
    public void startUpPhase(){

        p1 = new Player("Manjit");
        p1.add_card("BLOCKADE");

        d_con1 = new Country("d","b",5,3,new ArrayList<>(Arrays.asList("d","e")));
        d_con2 = new Country("e","b",5,3,new ArrayList<>(Arrays.asList("d","e")));

        d_con3.COUNTRIESLIST.put("d", d_con1);
        d_con3.COUNTRIESLIST.put("e", d_con2);

        d_con1.d_numOfArmiesPlaced = 20;
        d_con2.d_numOfArmiesPlaced = 10;

        p1.d_owned.add(d_con1);

        card1 = new Cards("d" , "blockade" , d_con3);
        card2 = new Cards("e" , "blockade" , d_con3);

        p1.issue_order(card1);
        p1.issue_order(card2);
    }

    @Test
    public void BlockadePass(){
        card1.Execute(p1);

        assertEquals(60, (int) d_con1.COUNTRIESLIST.get("d").d_numOfArmiesPlaced);
    }

    @Test
    public void BlockadeFail(){
        card2.Execute(p1);

        assertEquals(10 , (int) d_con2.COUNTRIESLIST.get("e").d_numOfArmiesPlaced);
    }
}
