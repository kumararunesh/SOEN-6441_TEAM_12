package org.StatePattern;

public abstract class ShowMapAbstract extends Phase{

        ShowMapAbstract(GameEngine1 p_ge) {
            super(p_ge);
        }
    public void playGame(){
            printInvalidCommandMessage();
    }
    public void startGameEngine(){
        printInvalidCommandMessage();
    }

    public void EditMap(){
        printInvalidCommandMessage();
    }

    public int playGameLoop(){
        printInvalidCommandMessage();
        return 0;
    }

    public void mainGameLoop(){
        printInvalidCommandMessage();
    }
    public void assignCountries(){
        printInvalidCommandMessage();
    }
    public void execute(){

    }
    public void mapshow(){
        printInvalidCommandMessage();
    }
}

