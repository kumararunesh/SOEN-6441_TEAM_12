package org.StatePattern;

public abstract class GameStartUpPhase extends Phase {
    GameStartUpPhase(GameEngine1 p_ge)
    {
        super(p_ge);
    }
    public int playGameLoop(){
        printInvalidCommandMessage();
        return 0;
    }
    public void assignCountries()
    {
        printInvalidCommandMessage();
    }

    public void execute()
    {
        printInvalidCommandMessage();
    }

    public void mainGameLoop()
    {
        printInvalidCommandMessage();
    }

    public void EditMap(){
        printInvalidCommandMessage();
    }

    public void mapshow()
    {
        printInvalidCommandMessage();
    }

    public void ShowMaps(){
        printInvalidCommandMessage();
    }
}
