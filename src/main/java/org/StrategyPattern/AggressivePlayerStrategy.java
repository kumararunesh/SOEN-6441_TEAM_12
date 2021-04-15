package org.StrategyPattern;

import org.GamePlay.*;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class AggressivePlayerStrategy extends PlayerStrategy{

    Country country;
    public AggressivePlayerStrategy(Player p_player, ConcurrentHashMap<String, Country> Countries, Country country){
        super(p_player, Countries);
        this.country=country;
    }

    @Override
    protected Country toAttack() {
        int num=0;
        Country attack =null;
        for(Country c :d_player.d_owned){
            for(String n: c.d_neighbours){
                if(num>=country.COUNTRIESLIST.get(n).d_numOfArmiesPlaced && d_player.d_owned.contains(country.COUNTRIESLIST.get(n))){
                    attack = country.COUNTRIESLIST.get(n);
                    num = country.COUNTRIESLIST.get(n).d_numOfArmiesPlaced;
                }
            }
        }
        if(attack==null){
            attack = country.COUNTRIESLIST.get(country.COUNTRIESLIST.keySet().stream().findFirst().get());
        }
        return attack;
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
        int num = 0;
        Country defend = null;
        for(Country c : d_player.d_owned){
            if( num <= c.d_numOfArmiesPlaced){
                defend = c;
                num = c.d_numOfArmiesPlaced;
            }
        }
        return defend;
    }

    @Override
    public Order createOrder() {
        Random rand = new Random();
        int rnd_num_of_armies = rand.nextInt(d_player.d_armiesNum);
        if (rand.nextInt(5) != 0) {
            switch (rand.nextInt(2)) {
                case (0):
                    return new DeployOrder(d_player.getD_name(), rnd_num_of_armies, toDefend());

                case (1):
                    return new AdvanceArmies(toDefend().d_countryId, toAttack().d_countryId, rnd_num_of_armies, country, "advance");
            }
        }
        return new AdvanceArmies(toDefend().d_countryId, toAttack().d_countryId, rnd_num_of_armies, country, "advance");
    }
}
