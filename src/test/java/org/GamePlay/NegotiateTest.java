package org.GamePlay;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

public class NegotiateTest {

    Country d_con1 , d_con2 , d_con3 ,dcon4;
    Cards card1 , card2;
    Player p1,p2,p3;
    ConcurrentHashMap<String,Player> d_playerList = new ConcurrentHashMap<>();

    @Before
    public void startUpPhase(){

        p1 = new Player("Manjit");
        p1.add_card("NEGOTIATE");

        p2 = new Player("Manish");
        p2.add_card("NEGOTIATE");

        p3 = new Player("Nitpreet");

        d_playerList.put("Manjit" , p1);
        d_playerList.put("Manish" , p2);
        d_playerList.put("Nitpreet" , p3);

        d_con1 = new Country("d","b",5,3,new ArrayList<>(Arrays.asList("d","e","f")));
        d_con2 = new Country("e","c",5,3,new ArrayList<>(Arrays.asList("d","e","f")));
        d_con3 = new Country("f","a",5,3,new ArrayList<>(Arrays.asList("d","e","f")));

        d_con3.COUNTRIESLIST.put("d", d_con1);
        d_con3.COUNTRIESLIST.put("e", d_con2);

        d_con1.d_numOfArmiesPlaced = 20;
        d_con2.d_numOfArmiesPlaced = 10;

        p1.d_owned.add(d_con1);
        p2.d_owned.add(d_con2);
        p3.d_owned.add(d_con3);

        card1 = new Cards(p2.d_name, "negotiate" , d_playerList);
        card2 = new Cards(p1.d_name, "negotiate" , d_playerList);

        p1.issue_order(card1);
        p2.issue_order(card2);
    }

    @Test
    public void NegotiatePass(){
        card1.Execute(p1);

        assertEquals(true, p1.d_negotiate.contains(p2.d_name));
    }

    @Test
    public void NegotiateFail(){
        card2.Execute(p1);

        assertEquals(false , p2.d_negotiate.contains(p3.d_name));
    }
}
