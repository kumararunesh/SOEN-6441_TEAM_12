package org.StatePattern;


/**
 * Abstract class to execute the orders.
 */
public abstract class ExecuteAbstract extends Phase{
    /**
     * Constructor to call the super constructor.
     * @param p_ge object of GameEngine1 class
     */
    ExecuteAbstract(GameEngine1 p_ge) {
        super(p_ge);
    }

    /**
     * Method to print Invalid command Error if user enters playGame command in between the execute order phase.
     */
    @Override
    public void playGame() {
        printInvalidCommandMessage();
    }

    @Override
    public void mainGameLoop() {

    }

    @Override
    public void assignCountries() {

    }


    @Override
    public void EditMap() throws Exception {

    }

    @Override
    public void ShowMaps() throws Exception {

    }

}
