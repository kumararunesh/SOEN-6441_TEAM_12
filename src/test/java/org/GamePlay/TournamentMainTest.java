package org.Tournament;

import org.Tournament.TournamentMain;

import static org.junit.Assert.assertEquals;

public class TournamentMainTest {

    TournamentMain tournamentMain ;
    @org.junit.Before
    public void setUp() throws Exception {
        tournamentMain = new TournamentMain();

    }

    @org.junit.Test
    public void runTestCompleteFail() {

        assertEquals("Wrong command",tournamentMain.run("tournamdfbdbrent -m n.map  -p aggressive cheater  -g 5 -d 10"));
    }

    @org.junit.Test
    public void runTestMap() {

        assertEquals("Enter correct map command",tournamentMain.run("tournament -t n.map  -p random cheater  -g 5 -d 10"));
    }

    @org.junit.Test
    public void runTestPlayer() {

        assertEquals("Enter correct Player command",tournamentMain.run("tournament -m n.map  -l random cheater  -g 5 -d 10"));
    } @org.junit.Test
    public void runTestGame() {

        assertEquals("Enter correct Game command",tournamentMain.run("tournament -m n.map  -p random cheater  -f 5 -d 10"));
    } @org.junit.Test
    public void runTestTurns() {

        assertEquals("Enter correct no of turns command",tournamentMain.run("tournament -m n.map  -p random cheater  -g 5 -u 10"));
    }
    @org.junit.Test
    public void runTest5() {

        assertEquals("Tournament Over",tournamentMain.run("tournament -m n.map  -p random cheater  -g 5 -d 10"));
    }





}
