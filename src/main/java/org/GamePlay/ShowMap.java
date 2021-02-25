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
  }
