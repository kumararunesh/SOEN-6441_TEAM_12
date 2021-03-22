package org.StatePattern;

public abstract class PlayerInitializationAbstract extends Phase {


    PlayerInitializationAbstract(GameEngine1 p_ge) {
        super(p_ge);
    }

    public void mapshow()
    {
        printInvalidCommandMessage();
    }
    @Override
    public void playGame() {
        printInvalidCommandMessage();
    }

    @Override
    public int playGameLoop() {
        return 0;
    }

    @Override
    public void mainGameLoop() {
        printInvalidCommandMessage();
    }

    @Override
    public void assignCountries() {
        printInvalidCommandMessage();
    }

    @Override
    public void EditMap() throws Exception {
        printInvalidCommandMessage();
    }

    @Override
    public void execute()
    {
        printInvalidCommandMessage();
    }

    @Override
    public void ShowMaps() throws Exception {
        printInvalidCommandMessage();
    }
}
