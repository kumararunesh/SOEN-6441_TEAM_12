package org.StatePattern;

import org.GamePlay.GameEngine;

public class PlayerInitializationMain extends PlayerInitializationAbstract{

    GameEngine d_ge;
    GameEngine1 d_ge1;
    PlayerInitializationMain(GameEngine1 p_ge,GameEngine p_ge1) {
        super(p_ge);
        this.d_ge1 = p_ge;
        this.d_ge = p_ge1;
    }

    @Override
    public void startGameEngine() {
        d_ge.startGameEngine(d_ge.FILE);
    }

    public void next() {
        boolean l_temp=true;
        try{
            if(d_ge.PLAYERS_LIST.size()>=2)
            {
                l_temp=false;
            }
        }catch (Exception e)
        {}
        if(l_temp==false)
        {
            d_ge1.setPhase(new AssignCountriesMain(d_ge1, d_ge.PLAYERS_LIST, d_ge.COUNTRY, d_ge.FILE));
        }
        else
        {
            System.out.println("There must be at least 2 players to continue");
        }
    }
}
