package org.StatePattern;

import org.GamePlay.GameEngine;

public class GameStartUpPhaseMain extends GameStartUpPhase {
    public GameEngine d_ge;
    GameEngine1 d_ge1;
    public String d_message;
    public GameStartUpPhaseMain(GameEngine1 p_ge)
    {
        super(p_ge);
        this.d_ge1 = p_ge;
    }

    @Override
    public void playGame() {
        d_ge = new GameEngine();
        d_ge.playGame();
    }

    @Override
    public void startGameEngine() {
        printInvalidCommandMessage();
    }
    public void next()
    {
        if(d_ge.FILE==null)
        {
            d_message ="You first need to load the map before going further";
            System.out.println(d_message);
        }
        else
        {
            d_ge1.setPhase(new PlayerInitializationMain(d_ge1, d_ge));
        }
    }
}