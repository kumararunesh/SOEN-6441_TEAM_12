package org.StatePattern;

public abstract class AssignCountriesAbstract extends Phase {
    AssignCountriesAbstract(GameEngine1 p_ge) {
        super(p_ge);
    }

    @Override
    public void playGame() {
    printInvalidCommandMessage();
    }

    @Override
    public void startGameEngine() {
    printInvalidCommandMessage();
    }

    @Override
    public int playGameLoop() {
        printInvalidCommandMessage();
        return 0;
    }

    @Override
    public void mainGameLoop() {
    printInvalidCommandMessage();
    }

    @Override
    public void EditMap() throws Exception {
    printInvalidCommandMessage();
    }

    @Override
    public void ShowMaps() throws Exception {
    printInvalidCommandMessage();
    }
    public void execute()
    {
        printInvalidCommandMessage();
    }
    public void mapshow()
    {
        printInvalidCommandMessage();
    }
}
