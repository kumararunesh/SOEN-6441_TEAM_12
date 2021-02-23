package org.GamePlay;

import org.Main.MapTable;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class showMap {
    static ConcurrentHashMap <String,Player> playersList = new ConcurrentHashMap<>();
    static Country cou;
    static String[][] adjacentNeighbours;
    String[][] details;
    public showMap(ConcurrentHashMap<String ,Player> playersList,Country cou)
    {
        this.cou = cou;
        this.playersList = playersList;
    }

    public void addElement(int row, int col, String element)
    {
        adjacentNeighbours[row][col]=element;
    }

    public void check() {
        adjacentNeighbours = new String[cou.countriesList.size()+1][cou.countriesList.size()+1];
        details = new String[cou.countriesList.size()][4];
        ArrayList<String> allCountries = new ArrayList<>(cou.countriesList.keySet());
        int row=0;
        for(String countries: cou.countriesList.keySet())
        {
            details[row][0]= countries;
            details[row][1]= cou.countriesList.get(countries).owner;
            details[row][2]= cou.countriesList.get(countries).continent;
            if(cou.countriesList.get(countries).numOfArmiesPlaced!=null) {
                details[row][3] = cou.countriesList.get(countries).numOfArmiesPlaced.toString();
            }else
            {
                details[row][3] ="0";
            }
            row+=1;
        }

        adjacentNeighbours[0][0]=" ";
        row=1;
        for(String country: cou.countriesList.keySet())
        {
            adjacentNeighbours[0][row] = country;
            row+=1;
        }
        row=1;
        for(String country:cou.countriesList.keySet())
        {
            adjacentNeighbours[row][0]=country;
            row+=1;
        }

        row=1;

        for(String country:cou.countriesList.keySet())
        {

            for(String neighbour:cou.countriesList.get(country).neighbours)
            {
                int temp = allCountries.indexOf(neighbour);
                addElement(row,temp+1,"X");
            }
            for(int  i=0;i<adjacentNeighbours[row].length;i++)
            {
                if(adjacentNeighbours[row][i]==null)
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
        for(row=0;row<details.length;row++)
        {
            for(col=0;col<4;col++)
            {
                System.out.print(details[row][col]+"\t");
            }
            System.out.println("");
        }

        System.out.println("Adjacency matrix: ");
        row=0;
        col=0;
        for(row=0;row<adjacentNeighbours.length;row++)
        {
            for(col=0;col<adjacentNeighbours[row].length;col++)
            {
                System.out.print(adjacentNeighbours[row][col]+" ");
            }
            System.out.println(" ");
        }
    }
}