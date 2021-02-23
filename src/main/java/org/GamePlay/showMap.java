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

    public void addElement(int row, int col, String element)
    {
        ADJACENTNEIGHBOURS[row][col]=element;
    }

    public void check() {
        ADJACENTNEIGHBOURS = new String[COU.COUNTRIESLIST.size()+1][COU.COUNTRIESLIST.size()+1];
        DETAILS = new String[COU.COUNTRIESLIST.size()][4];
        ArrayList<String> allCountries = new ArrayList<>(COU.COUNTRIESLIST.keySet());
        int row=0;
        for(String countries: COU.COUNTRIESLIST.keySet())
        {
            DETAILS[row][0]= countries;
            DETAILS[row][1]= COU.COUNTRIESLIST.get(countries).OWNER;
            DETAILS[row][2]= COU.COUNTRIESLIST.get(countries).CONTINENT;
            if(COU.COUNTRIESLIST.get(countries).NUMOFARMIESPLACED!=null) {
                DETAILS[row][3] = COU.COUNTRIESLIST.get(countries).NUMOFARMIESPLACED.toString();
            }else
            {
                DETAILS[row][3] ="0";
            }
            row+=1;
        }

        ADJACENTNEIGHBOURS[0][0]=" ";
        row=1;
        for(String country: COU.COUNTRIESLIST.keySet())
        {
            ADJACENTNEIGHBOURS[0][row] = country;
            row+=1;
        }
        row=1;
        for(String country:COU.COUNTRIESLIST.keySet())
        {
            ADJACENTNEIGHBOURS[row][0]=country;
            row+=1;
        }

        row=1;

        for(String country:COU.COUNTRIESLIST.keySet())
        {

            for(String neighbour : COU.COUNTRIESLIST.get(country).NEIGHBOURS)
            {
                int temp = allCountries.indexOf(neighbour);
                addElement(row,temp+1,"X");
            }
            for(int i = 0; i< ADJACENTNEIGHBOURS[row].length; i++)
            {
                if(ADJACENTNEIGHBOURS[row][i]==null)
                {
                    addElement(row,i,"O");
                }
            }
            addElement(row,row,"X");
            row+=1;
        }

        System.out.println("The details are: ");
        row=0;
        int col =0;
        System.out.println("Country\t Owner\t Continent\t Armies");
        for(row=0; row< DETAILS.length; row++)
        {
            for(col=0;col<4;col++)
            {
                System.out.print(DETAILS[row][col]+"\t");
            }
            System.out.println("");
        }

        System.out.println("Adjacency matrix: ");
        row=0;
        col=0;
        for(row=0; row< ADJACENTNEIGHBOURS.length; row++)
        {
            for(col=0; col< ADJACENTNEIGHBOURS[row].length; col++)
            {
                System.out.print(ADJACENTNEIGHBOURS[row][col]+" ");
            }
            System.out.println(" ");
        }
    }
}

