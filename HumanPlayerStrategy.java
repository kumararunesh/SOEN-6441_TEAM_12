package org.StrategyPattern;

import org.GamePlay.Country;
import org.GamePlay.Order;
import org.GamePlay.Player;
import org.GamePlay.playGame;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class HumanPlayerStrategy extends PlayerStrategy {

    ConcurrentHashMap <String,Country> d_countries;
    Player d_player;
    ConcurrentHashMap<String,Player> d_playerList;
    Country country;

    public HumanPlayerStrategy(Player p_player, ConcurrentHashMap<String, Country> Countries, ConcurrentHashMap<String, Player> p_playerList , Country country)
    {
        super(p_player, Countries);
        this.d_countries = Countries;
        this.d_player = p_player;
        this.d_playerList = p_playerList;
        this.country = country;
    }


    @Override
    protected Country toAttack() {

        return null;
    }

    @Override
    protected Country toAttackFrom() {
        return null;
    }

    @Override
    protected Country toMoveFrom() {
        return null;
    }

    @Override
    protected Country toDefend() {
        return null;
    }

    @Override
    public Order createOrder() {

        playGame humanPlay = new playGame(d_playerList,country);
        Order order = humanPlay.mainGameLoop();
        return order;

    }
}

