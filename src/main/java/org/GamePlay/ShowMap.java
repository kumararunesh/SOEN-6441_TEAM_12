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
   
    /**
     * This method is used to add element to the adjacency matrix which is used for representing the country and its neighbours.
     * @param p_row represents the row number of the 2D Matrix.
     * @param p_col represents the column number of the 2D Matrix.
     * @param p_element represents the data to be added at that specific index.
     */
    public void l_addElement(int p_row, int p_col, String p_element)
    {
        ADJACENT_NEIGHBOURS[p_row][p_col]=p_element;
    }
   
   
    /**
     * Method which is used to print all the details of the country which includes country name, its continent,
     * its owner, armies deployed on that country. It also shows the country and its neighbouring country by X and O.
     * "X" means that the country on Y-axis is connected with the country on the X-axis.
     * while the "O" (oh) represents that the country is not connected.
     */
    public void check() {
        ADJACENT_NEIGHBOURS = new String[COU.COUNTRIESLIST.size()+1][COU.COUNTRIESLIST.size()+1];
        d_details = new String[COU.COUNTRIESLIST.size()][4];
        ArrayList<String> l_allCountries = new ArrayList<>(COU.COUNTRIESLIST.keySet());
        int l_row=0;
        for(String l_countries: COU.COUNTRIESLIST.keySet())
        {
            d_details[l_row][0]= l_countries;
            d_details[l_row][1]= COU.COUNTRIESLIST.get(l_countries).d_owner;
            d_details[l_row][2]= COU.COUNTRIESLIST.get(l_countries).d_continent;
            if(COU.COUNTRIESLIST.get(l_countries).d_numOfArmiesPlaced !=null) {
                d_details[l_row][3] = COU.COUNTRIESLIST.get(l_countries).d_numOfArmiesPlaced.toString();
            }else
            {
                d_details[l_row][3] ="0";
            }
            l_row+=1;
        }
       ADJACENT_NEIGHBOURS[0][0]=" ";
        l_row=1;
        for(String l_country: COU.COUNTRIESLIST.keySet())
        {
            ADJACENT_NEIGHBOURS[0][l_row] = l_country;
            l_row+=1;
        }
        l_row=1;
        for(String l_country:COU.COUNTRIESLIST.keySet())
        {
            ADJACENT_NEIGHBOURS[l_row][0]=l_country;
            l_row+=1;
        }

        l_row=1;

  }
