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
    //@param PLAYERSLIST is the hashmap for the players
    //@param COUNTRY is the hashmap for the country list
    ConcurrentHashMap<String,Player> PLAYERSLIST = new ConcurrentHashMap<>();
    Country COUNTRY;

    /**
     * Parameterised constructor for playGame
     * @param p_player_list list of players playing the game
     * @param p_country the list of countries in the game
     */
    public playGame(ConcurrentHashMap<String, Player> p_player_list, Country p_country)
    {
        this.PLAYERSLIST = p_player_list;
        this.COUNTRY =p_country;
    }

    /**
     * Method for Assignments of the reinforcements
     */
    public void playGameLoop()
    {
        System.out.println("Main game loop: assign reinforcements phase");

        for (String l_player : PLAYERSLIST.keySet()) {
            Player d_player = PLAYERSLIST.get(l_player);
            System.out.println("For Player : "+d_player.getNAME());
            int l_armiesByCountries =(int)Math.floor( d_player.OWNED.size()/3);
            if(l_armiesByCountries < 3)
            {
                l_armiesByCountries = 3;
            }
            int l_nextIndex=1;
            int l_flag_break=0;
            for(int l_j=0;l_j<d_player.OWNED.size();l_j++)
            {
                if(l_nextIndex<d_player.OWNED.size()&&d_player.OWNED.get(l_j).CONTINENT.equalsIgnoreCase(d_player.OWNED.get(l_nextIndex).CONTINENT))
                {
                    l_flag_break=0;
                    continue;
                }
                else
                {
                    l_flag_break+=1;
                    break;
                }
            }
            if(l_flag_break==1)
            {
                d_player.CONTINENTVALUE=0;
            }
            else
            {
                if(d_player.OWNED.size()== COUNTRY.COUNTRIESLIST.get(d_player.OWNED.get(0).COUNTRYID).NUMOFCOUNTRIESINCONTINENT) {
                    d_player.CONTINENTVALUE += (Integer) d_player.OWNED.get(1).CONTINENTBONUS;
                }
                else
                {
                    d_player.CONTINENTVALUE=0;
                }
            }
            d_player.ARMIESNUM = l_armiesByCountries + d_player.CONTINENTVALUE;
            System.out.println("Army count for "+d_player.NAME+"--> "+d_player.ARMIESNUM);
            System.out.println("");
        }
        System.out.println("Main game loop: issue orders phase");
        Boolean l_flag = true;
        int l_i = 0;
        while(l_flag){

            //Loop for iterating until all players give pass
            l_i=0;
            for (String s : PLAYERSLIST.keySet()) {
                Player p = PLAYERSLIST.get(s);
                Boolean l_flag_1 = true;
                while(l_flag_1){

                    //loop for correct input for order until a player inputs correct order
                    System.out.println(p.NAME+" Please issue orders from the below commands");
                    System.out.println("*************************");
                    System.out.println("**Deploy**\n**Pass**\n**ShowMap**");
                    System.out.println("*************************");
                    Scanner d_sc = new Scanner(System.in);
                    String l_command = d_sc.nextLine();
                    String l_commandSplit[] = l_command.split(" ");
                    if(l_commandSplit[0].equalsIgnoreCase("deploy")) {
                        if (l_commandSplit.length == 3) {
                            l_flag_1 = false;
                            String l_countryId = l_commandSplit[1];
                            int l_armiesToPlace = Integer.parseInt(l_commandSplit[2]);
                            Order d_newOrder = new DeployOrder(l_countryId, l_armiesToPlace, COUNTRY);
                            p.issue_order(d_newOrder);
                        }
                        else
                        {
                            System.out.println("Your deploy command should be like 'deploy countryName armyToPlace'\n");
                            continue;
                        }
                    }
                    else if(l_commandSplit[0].equalsIgnoreCase("pass"))
                    {
                        PassOrder d_order = new PassOrder(p, COUNTRY);
                        p.issue_order(d_order);
                        l_i++;
                        l_flag_1=false;
                    }
                    else if(l_commandSplit[0].equalsIgnoreCase("showmap"))
                    {
                        showMap d_map = new showMap(PLAYERSLIST, COUNTRY);
                        d_map.check();
                    }
                    else
                    {
                        System.out.println("Wrong command. Re-enter the correct one");
                    }
                }
                if(l_i == PLAYERSLIST.size())
                {
                    l_flag =false;

                }
            }
        }
        System.out.println("Execute Order Phase\n");
        l_flag = true ;
        int l_p1=0;
        ArrayList<String> l_playersName = new ArrayList<>(PLAYERSLIST.keySet());
        while(l_flag){
            //Loop for iterating until all players give pass
            for (String l_player : l_playersName) {
                Player d_player = PLAYERSLIST.get(l_player);

                if(d_player.ORDERS.size()==0)
                {
                    l_p1+=1;
                    l_playersName.remove(l_player);
                    break;
                }


            }
            if(l_playersName.size()==0)
            {
                l_flag=false;
            }
        }
    }
}