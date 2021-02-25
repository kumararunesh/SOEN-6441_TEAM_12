package org.GamePlay;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is used to display all the details while playing the Game. It will display details like countries, and its continents,
 * armies deployed on that particular country, the owner of that country and the adjacency matrix for the neighbouring countries.
 */
public class showMap {
   /**
     * Global Player List
     */
    static ConcurrentHashMap <String,Player> PLAYERS_LIST = new ConcurrentHashMap<>();

    /**
     * Country Object
     */
    static Country COU;

    /**
     *Adjacency Matrix for Map representation of country and its countries.
     */
    static String[][] ADJACENT_NEIGHBOURS;

    String[][] d_details;
   
   
    /**
     * Constructor used to initialize the global variables
     * @param p_players_list is the HashMap containing all the Name of the players as the String and its value containing the Player Object
     * @param p_cou is the object of the Country Class from where we can have complete detail of the Country.
     */
    public showMap(ConcurrentHashMap<String ,Player> p_players_list, Country p_cou)
    {
        this.COU = p_cou;
        this.PLAYERS_LIST = p_players_list;
    }
  }
