package org.Tournament;

import org.Tournament.TournamentMain;

import static org.junit.Assert.assertEquals;

/**
 * Tournament Mode
 */
public class TournamentMainTest {

    TournamentMain d_tournamentMain ;

    /**
     * Setup phase
     * @throws Exception
     */
    @org.junit.Before
    public void setUp() throws Exception {
        d_tournamentMain = new TournamentMain();

    }

    /**
     * Wrong command input test
     */
    @org.junit.Test
    public void runTestCompleteFail() {

        assertEquals("Wrong command",d_tournamentMain.run("tournamdfbdbrent -m n.map  -p aggressive cheater  -g 5 -d 10"));
    }

    /**
     * Wrong command input test
     */
    @org.junit.Test
    public void runTestMap() {

        assertEquals("Enter correct map command",d_tournamentMain.run("tournament -t n.map  -p random cheater  -g 5 -d 10"));
    }

    /**
     * Wrong command input test
     */
    @org.junit.Test
    public void runTestPlayer() {

        assertEquals("Enter correct Player command",d_tournamentMain.run("tournament -m n.map  -l random cheater  -g 5 -d 10"));
    }

    /**
     * Wrong command input test
     */
    @org.junit.Test
    public void runTestGame() {

        assertEquals("Enter correct Game command",d_tournamentMain.run("tournament -m n.map  -p random cheater  -f 5 -d 10"));
    }

    /**
     * Wrong command input test
     */
    @org.junit.Test
    public void runTestTurns() {

        assertEquals("Enter correct no of turns command",d_tournamentMain.run("tournament -m n.map  -p random cheater  -g 5 -u 10"));
    }

    /**
     * Wrong command input test
     */
    @org.junit.Test
    public void runTest5() {

        assertEquals("Tournament Over",d_tournamentMain.run("tournament -m n.map  -p random cheater  -g 5 -d 10"));
    }





}
