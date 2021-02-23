package org.GamePlay;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


public class showMap {
    static ConcurrentHashMap <String,Player> PLAYERS_LIST = new ConcurrentHashMap<>();
    static Country COU;
    static String[][] ADJACENTNEIGHBOURS;
    String[][] DETAILS;

    public showMap(ConcurrentHashMap<String ,Player> p_players_list, Country p_cou)
    {
        this.COU = p_cou;
        this.PLAYERS_LIST = p_players_list;
    }


    public void l_addElement(int p_row, int p_col, String p_element)
    {
        ADJACENTNEIGHBOURS[p_row][p_col]=p_element;
    }


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

