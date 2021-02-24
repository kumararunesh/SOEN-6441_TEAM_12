package org.GamePlay;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is used to assign the troops
 * Deploy the reinforcements
 * show the map
 */
public class playGame {

    ConcurrentHashMap<String, Player> d_playerList = new ConcurrentHashMap<>();
    Country d_country;

    /**
     * Parameterised constructor for playGame
     *
     * @param p_playerList list of players playing the game
     * @param p_cou        the list of countries in the game
     */
    public playGame(ConcurrentHashMap<String, Player> p_playerList, Country p_cou) {
        this.d_playerList = p_playerList;
        this.d_country = p_cou;
    }

    /**
     * Method for Assignments of the reinforcements. This method will ask from the player about the order. And will save it to the the orders queue
     * of the respective player if the user inputs the correct command. There are 3 Main commands.
     * Deploy: Command which is used to deploy the armies on the particular country. The country should be available in the Map.
     * Pass: This command is used to pass the turn to the next player if the player doesn't want to give any deploy order. This function will terminate if all the players give the Pass Command
     * ShowMap: Command which shows the details about the countries.
     */
    public int playGameLoop() {
        int l_armiesByCountries = 0;
        int temp = 0;
        System.out.println("Main game loop: assign reinforcements phase");
        for (String l_player : d_playerList.keySet()) {
            Player d_player = d_playerList.get(l_player);
            System.out.println("For Player : " + d_player.getD_name());
            l_armiesByCountries = (int) Math.floor(d_player.d_owned.size() / 3);
            if (l_armiesByCountries < 3) {
                l_armiesByCountries = 3;
            }
            int l_nextIndex = 1;
            int l_flag_break = 0;
            for (int l_j = 0; l_j < d_player.d_owned.size(); l_j++) {
                if (l_nextIndex < d_player.d_owned.size() && d_player.d_owned.get(l_j).d_continent.equalsIgnoreCase(d_player.d_owned.get(l_nextIndex).d_continent)) {
                    l_flag_break = 0;
                    continue;
                } else {
                    l_flag_break += 1;
                    break;
                }
            }
            if (l_flag_break == 1) {
                d_player.d_continentValue = 0;
            } else {
                if (d_player.d_owned.size() == d_country.COUNTRIESLIST.get(d_player.d_owned.get(0).d_countryId).d_numberOfCountriesInContinent) {
                    d_player.d_continentValue += (Integer) d_player.d_owned.get(1).d_continentBonus;
                } else {
                    d_player.d_continentValue = 0;
                }
            }

            d_player.d_armiesNum = l_armiesByCountries + d_player.d_continentValue;
            temp = d_player.d_armiesNum;
            System.out.println("Army count for " + d_player.d_name + "--> " + d_player.d_armiesNum);
            System.out.println("");
        }
        return temp;
    }
}
