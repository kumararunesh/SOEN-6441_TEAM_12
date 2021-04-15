package org.StrategyPattern;

import org.GamePlay.*;

import java.util.concurrent.ConcurrentHashMap;

public class BenevolentPlayerStrategy{
    Player d_player;
    ConcurrentHashMap<String, Country> d_countries;
    Country country;
    public BenevolentPlayerStrategy(Player p_p,ConcurrentHashMap<String,Country> p_countries, Country country)
    {
        super(p_p,p_countries);
        d_player = p_p;
        this.d_countries = p_countries;
        this.country = country;
    }
    protected Country toAttack() {
        return null;
    }
    protected Country toAttackFrom() {
        return null;
    }

    protected Country toMoveFrom() {
        return null;
    }
}
