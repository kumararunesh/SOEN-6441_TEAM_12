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
     * @return l_armiesByCountries which is used for the testing the number of armies given to the player
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

    public void mainGameLoop() {
        System.out.println("Main game loop: issue orders phase");
        Boolean l_flag = true;
        int l_i = 0;
        while (l_flag) {      //Loop for iterating until all players give pass
            l_i = 0;
            for (String s : d_playerList.keySet()) {
                Player p = d_playerList.get(s);
                Boolean l_flag_1 = true;
                while (l_flag_1) {  //loop for correct input for order until a player inputs correct order
                    System.out.println(p.d_name + " Please issue orders from the below commands");
                    System.out.println("*************************");
                    System.out.println("**Deploy**\n**Pass**\n**ShowMap**");
                    System.out.println("*************************");
                    Scanner d_sc = new Scanner(System.in);
                    String l_command = d_sc.nextLine();
                    String l_commandSplit[] = l_command.split(" ");
                    if (l_commandSplit[0].equalsIgnoreCase("deploy")) {
                        if (l_commandSplit.length == 3) {
                            String l_countryId = l_commandSplit[1];
                            if (d_country.COUNTRIESLIST.containsKey(l_countryId)) {
                                String regex = "\\d+";
                                if (l_commandSplit[2].matches(regex)) {
                                    int l_armiesToPlace = Integer.parseInt(l_commandSplit[2]);
                                    if (l_armiesToPlace > 0) {
                                        l_flag_1 = false;
                                        Order d_newOrder = new DeployOrder(l_countryId, l_armiesToPlace, d_country);
                                        p.issue_order(d_newOrder);
                                    } else {
                                        System.out.println("Negative Army count not allowed");
                                        continue;
                                    }
                                } else {
                                    System.out.println("The army number should be an integer");
                                    continue;
                                }
                            } else {
                                System.out.println("The country that you entered doesn't exist in the Map");
                                continue;
                            }
                        } else {
                            System.out.println("Your deploy command should be like 'deploy countryName armyToPlace'\n");
                            continue;
                        }
                    } else if (l_commandSplit[0].equalsIgnoreCase("pass")) {
                        PassOrder d_order = new PassOrder(p, d_country);
                        p.issue_order(d_order);
                        l_i++;
                        l_flag_1 = false;
                    } else if (l_commandSplit[0].equalsIgnoreCase("showmap")) {
/*                        showMap map = new showMap(playersList,cou);
                        map.mapShow()*/
                        ;
                        showMap d_map = new showMap(d_playerList, d_country);
                        d_map.check();
                    } else {
                        System.out.println("Wrong command. Re-enter the correct one");
                    }
                }
                if (l_i == d_playerList.size()) {
                    l_flag = false; //for outer loop
                }
            }
        }
        System.out.println("Execute Order Phase\n");
        l_flag = true;
        int l_p1 = 0;
        ArrayList<String> l_playersName = new ArrayList<>(d_playerList.keySet());
        while (l_flag) {      //Loop for iterating until all players give pass
            for (String l_player : l_playersName) {
                Player d_player = d_playerList.get(l_player);

                if (d_player.d_orders.size() == 0) {
                    l_p1 += 1;
                    l_playersName.remove(l_player);
                    break;
                }


                int l_maxArmiesToDeploy = d_player.d_armiesNum;
                Order d_nextOrder = d_player.next_order();
                if (d_nextOrder instanceof DeployOrder) {
                    System.out.println("Executing Order For Player : " + d_player.getD_name());
                    d_nextOrder.Execute(d_player);
                    System.out.println("");
                } else {
                    System.out.println("Passing order for Player: " + d_player.d_name);
                    d_nextOrder.Execute(d_player);
                }
            }
            if (l_playersName.size() == 0) {
                l_flag = false;
            }
        }
    }
}
