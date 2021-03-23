package org.StatePattern;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import org.GamePlay.Country;
import org.GamePlay.Player;
import org.ObserverBasedLogging.LogWriter;

public class GameEngine1 {

    /**
     * State object of the GameEngine
     */
    private Phase d_gamePhase;

    public int MYSTART;
    public String MYCOMMAND;

    /**
     * Method that allows the GameEngine object to change its state.
     *
     * @param p_phase new state to be set for the GameEngine object.
     */
    public void setPhase(Phase p_phase) {
        d_gamePhase = p_phase;
        if(!(p_phase instanceof End)) {
            System.out.println("new phase: " + p_phase.getClass().getSimpleName());
        }
    }

    /**
     * This method will ask the user:
     * 1. What part of the game they want to start with (edit map or play game).
     * Depending on the choice, the state will be set to a different object,
     * which will set different behavior.
     * 2. What command they want to execute from the game.
     * Depending on the state of the GameEngine, each command will potentially
     * have a different behavior.
     */
    public void start() throws Exception {
        Scanner l_keyboard = new Scanner(System.in);
        do {
            LogWriter l_log = new LogWriter();
            System.out.println("1. Edit Map");
            System.out.println("2. Play Game");
            System.out.println("3. Quit");
            System.out.println("Where do you want to start?: ");
            MYSTART = l_keyboard.nextInt();
            switch (MYSTART) {

                case 1:
                    MapEditor l_map = new MapEditor(this);
                    setPhase(l_map);
                    break;

                case 2:
                    GameStartUpPhaseMain l_ge = new GameStartUpPhaseMain(this);
                    setPhase(l_ge);
                    break;
                case 3:
                    System.out.println("Bye!");
                    return;
            }
            int l_i=0;
            l_keyboard.nextLine();
        do {
            System.out.println(" =================================================");
            System.out.println("| #   PHASE                   : command           |");
            System.out.println(" =================================================");
            System.out.println("| 1.  Show Map                : showmap           |");
            System.out.println("| 2.  Edit Map                : editmap           |");
            System.out.println("| 3.  GamePlay : load map     : loadmap           |");
            System.out.println("| 4.  GamePlay: set Player    : gameplayer        |");
            System.out.println("| 5.  Play:PlaySetup          : assign countries  |");
            System.out.println("| 6.  Play:Issue Order        : order             |");
            System.out.println("| 7.  Play:Execute Order      : execute           |");
            System.out.println("| 7.  Play:mapshow            : mapshow           |");
            System.out.println("| 9.  Any Phase               : end game          |");
            System.out.println("| 10. Any Phase               : next phase        |");
            System.out.println(" =================================================");
            System.out.println("enter a " + d_gamePhase.getClass().getSimpleName() + " phase command: ");
            MYCOMMAND = l_keyboard.nextLine();
            System.out.println(" =================================================");

            switch (MYCOMMAND) {
                case ("showmap"):
                    d_gamePhase.ShowMaps();
                    break;
                case ("editmap"):
                    d_gamePhase.EditMap();
                    break;
                case ("exit"):
                    l_i=1;
                    break;
                case ("loadmap"):
                    d_gamePhase.playGame();
                    break;
                case("gameplayer"):
                    d_gamePhase.startGameEngine();
                    break;
                case("assigncountries"):
                    d_gamePhase.assignCountries();
                    break;
                case("order"):
                    d_gamePhase.playGameLoop();
                    break;
                case("execute"):
                    d_gamePhase.execute();
                    break;
                case ("next"):
                    d_gamePhase.next();
                    break;
                case ("mapshow"):
                    d_gamePhase.mapshow();
                    break;
                case("end"):
                {
                    d_gamePhase = new End(new GameEngine1());
                }
                default:
                    System.out.println("this command does not exist");
            }
            if(l_i==1){
                break;
            }
            l_i=0;
             } while (!(d_gamePhase instanceof End));
        } while (MYSTART != 3);
        l_keyboard.close();
    }
}