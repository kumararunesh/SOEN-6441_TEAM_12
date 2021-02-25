package org.GamePlay;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is used to display all the details while playing the Game. It will display details like countries, and its continents,
 * armies deployed on that particular country, the owner of that country and the adjacency matrix for the neighbouring countries.
 */
public class showMap {
    /**
     * PLAYERS_LIST is the Hashmap used to store all the name of the different players as the String and the
     * Player object is stored as the value. It is basically used to store all the details about the Player
     */
    static ConcurrentHashMap <String,Player> PLAYERS_LIST = new ConcurrentHashMap<>();
    /**
     * COU is the object of the country.
     */
    static Country COU;
    /**
     * ADJACENTNEIGHBOURS is the 2D matrix used to store all the neighbours in the form of Adjacency Matrix.
     * If there's the link between the countries, then it will be represented by X.
     */
    static String[][] ADJACENTNEIGHBOURS;
    /**
     * Details is the 2D matrix used to store all the details about the various Countries. It include countries,
     * owner,continent and number of armies placed at that country.
     */
    String[][] d_details;;

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
        ADJACENTNEIGHBOURS[p_row][p_col]=p_element;
    }

    /**
     * Method which is used to print all the details of the country which includes country name, its continent,
     * its owner, armies deployed on that country. It also shows the country and its neighbouring country by X and O.
     * "X" means that the country on Y-axis is connected with the country on the X-axis.
     * while the "O" (oh) represents that the country is not connected.
     */
    public void check() {
        ADJACENTNEIGHBOURS = new String[COU.COUNTRIESLIST.size()+1][COU.COUNTRIESLIST.size()+1];
        DETAILS = new String[COU.COUNTRIESLIST.size()][4];
        ArrayList<String> l_allCountries = new ArrayList<>(COU.COUNTRIESLIST.keySet());
        int l_row=0;
        for(String l_countries: COU.COUNTRIESLIST.keySet())
        {
            DETAILS[l_row][0]= l_countries;
            DETAILS[l_row][1]= COU.COUNTRIESLIST.get(l_countries).OWNER;
            DETAILS[l_row][2]= COU.COUNTRIESLIST.get(l_countries).CONTINENT;
            if(COU.COUNTRIESLIST.get(l_countries).NUMOFARMIESPLACED!=null) {
                DETAILS[l_row][3] = COU.COUNTRIESLIST.get(l_countries).NUMOFARMIESPLACED.toString();
            }else
            {
                DETAILS[l_row][3] ="0";
            }
            l_row+=1;
        }

        ADJACENTNEIGHBOURS[0][0]=" ";
        l_row=1;
        for(String l_country: COU.COUNTRIESLIST.keySet())
        {
            ADJACENTNEIGHBOURS[0][l_row] = l_country;
            l_row+=1;
        }
        l_row=1;
        for(String l_country:COU.COUNTRIESLIST.keySet())
        {
            ADJACENTNEIGHBOURS[l_row][0]=l_country;
            l_row+=1;
        }

        l_row=1;

        for(String l_country:COU.COUNTRIESLIST.keySet())
        {

            for(String l_neighbour : COU.COUNTRIESLIST.get(l_country).NEIGHBOURS)
            {
                int l_temp = l_allCountries.indexOf(l_neighbour);
                l_addElement(l_row,l_temp+1,"X");
            }
            for(int l_index = 0; l_index< ADJACENTNEIGHBOURS[l_row].length; l_index++)
            {
                if(ADJACENTNEIGHBOURS[l_row][l_index]==null)
                {
                    l_addElement(l_row,l_index,"O");
                }
            }
            l_addElement(l_row,l_row,"X");
            l_row+=1;
        }

        System.out.println("The details are: ");
        l_row=0;
        int l_col =0;
        System.out.println("Country\t Owner\t Continent\t Armies");
        for(l_row=0; l_row< DETAILS.length; l_row++)
        {
            for(l_col=0;l_col<4;l_col++)
            {
                System.out.print(DETAILS[l_row][l_col]+"\t");
            }
            System.out.println("");
        }

        System.out.println("Adjacency matrix: ");
        l_row=0;
        l_col=0;
        for(l_row=0; l_row< ADJACENTNEIGHBOURS.length; l_row++)
        {
            for(l_col=0; l_col< ADJACENTNEIGHBOURS[l_row].length; l_col++)
            {
                System.out.print(ADJACENTNEIGHBOURS[l_row][l_col]+" ");
            }
            System.out.println(" ");
        }
    }
}

