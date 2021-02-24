package org.GamePlay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

public class playGameTest {

    playGame d_playGame,d_playGame1;
    ConcurrentHashMap<String,Player> d_playerList = new ConcurrentHashMap<>();
    Country d_cou, d_country1,d_country2,d_country3;

    ConcurrentHashMap<String,Player> d_playerList1 = new ConcurrentHashMap<>();
    Country d_cou1, d_country11,d_country21,d_country31;

    @org.junit.Before
    public void setUp() throws Exception {

        d_country1 = new Country("c","a",5,3,new ArrayList<>(Arrays.asList("d","e")));
        d_country1.d_owner="Nitpreet";

        d_country2 = new Country("d","a",5,3,new ArrayList<>(Arrays.asList("c","e")));
        d_country2.d_owner="Nitpreet";

        d_country3 = new Country("y","a",5,3,new ArrayList<>(Arrays.asList("d","e")));
        d_country3.d_owner="Nitpreet";

        d_cou.COUNTRIESLIST.put("c",d_country1);
        d_cou.COUNTRIESLIST.put("d",d_country2);
        d_cou.COUNTRIESLIST.put("y",d_country3);

        Player d_player = new Player("Nitpreet");
        d_player.d_owned.add(d_country1);
        d_player.d_owned.add(d_country2);
        d_player.d_owned.add(d_country3);

        d_playerList.put("Nitpreet",d_player);
        d_playGame = new playGame(d_playerList,d_cou);
	 }

    @org.junit.Test
    public void playGameLoop() {

        assertEquals(8,d_playGame.playGameLoop());
    }