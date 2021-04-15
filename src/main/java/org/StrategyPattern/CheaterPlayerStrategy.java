package org.StrategyPattern;

import org.GamePlay.Country;
import org.GamePlay.Order;
import org.GamePlay.Player;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class CheaterPlayerStrategy extends PlayerStrategy {

    ConcurrentHashMap <String,Country> d_countries;
    Player d_player;
    ConcurrentHashMap<String,Player> d_playerList;

    public CheaterPlayerStrategy(Player p_player, ConcurrentHashMap<String, Country> Countries, ConcurrentHashMap<String, Player> p_playerList )
    {
        super(p_player, Countries);
        this.d_countries = Countries;
        this.d_player = p_player;
        this.d_playerList = p_playerList;
    }
}
