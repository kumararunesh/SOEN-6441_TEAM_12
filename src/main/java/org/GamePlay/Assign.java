package org.GamePlay;

import org.Main.MapTable;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Assign {
    ConcurrentHashMap <String,Player> playersList = new ConcurrentHashMap<>();
    Country cou;
    public Assign(ConcurrentHashMap <String,Player> playersList,Country cou)
    {
        this.playersList=playersList;
        this.cou = cou;
    }

    public void assignCountries(File file)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are " + playersList.size() + " Players");
        int i = 0;
        System.out.println("");
        for (String s : playersList.keySet()) {
            System.out.println("Player " + i + " : " + s);
            i++;
        }
        System.out.println("");
        System.out.println("Starting assigning countries");

        MapTable table = new MapTable();
        HashMap<Integer,String> tempMap= new HashMap<>();
        HashMap <String,String> countryContinent = new HashMap<>();
        HashMap <String, Integer> continentKey = new HashMap<>();
        HashMap <String,ArrayList> countryNeigh  = new HashMap<>();
        try {
            tempMap = table.countryanditskey(file);
            countryContinent = table.countryanditscontinent(file); //String-String
            continentKey = table.continentandvalue(file); //String-Integer
            countryNeigh = table.countryanditsneighbours(file);
        } catch (Exception e) {}

        for(String z: tempMap.values())
        {
            int numberOf
                ntriesInContinent =0;
            for(String country:countryContinent.keySet())
            {
                if(countryContinent.get(country).equalsIgnoreCase(countryContinent.get(z)))
                {
                    numberOfCountriesInContinent+=1;
                }
            }

            if(countryContinent.containsKey(z)) {
                Integer continentControlValue = continentKey.get(countryContinent.get(z));
                cou = new Country(z, countryContinent.get(z),continentControlValue,numberOfCountriesInContinent,countryNeigh.get(z));
                cou.COUNTRIESLIST.put(z, cou);
            }
        }

        ArrayList<String> totalCountries= new ArrayList<>();
        for(String country:cou.countriesList.keySet())
        {
            totalCountries.add(cou.countriesList.get(country).CountryId);
        }
        int numOfCountriesPerPlayer = totalCountries.size()/playersList.size();
        int remainingCountries = totalCountries.size()%playersList.size();

        Random random = new Random();

        for (String playerName1 : playersList.keySet()) {
            int x = 0;
            ArrayList<Country> countriesOwned = new ArrayList<>();
            while (x < numOfCountriesPerPlayer) {
                int randomInt = random.nextInt(totalCountries.size());
                Country o = cou.countriesList.get(totalCountries.get(randomInt));
                countriesOwned.add(o);
                totalCountries.remove(randomInt);
                x += 1;
            }
            Player p = new Player(playerName1);
            for (int f = 0; f < countriesOwned.size(); f++) {
                p.OWNED.add(countriesOwned.get(f));
            }
            playersList.put(playerName1, p);
        }
        if(remainingCountries!=0)
        {
            ArrayList<String> playerNames = new ArrayList<>();
            for(String playername: playersList.keySet())
            {
                playerNames.add(playername);
            }
            for(int j=0;j<remainingCountries;j++)
            {
                int randomPlayerIndex = random.nextInt(playerNames.size());
                int randomCountryIndex = random.nextInt(totalCountries.size());
                Country o = cou.countriesList.get(totalCountries.get(randomCountryIndex));
                playersList.get(playerNames.get(randomPlayerIndex)).OWNED.add(o);
                playerNames.remove(randomPlayerIndex);
                totalCountries.remove(randomCountryIndex);
            }
        }
        for (String player : playersList.keySet()) {
            System.out.print(player + " = ");
            for (int k = 0; k < playersList.get(player).OWNED.size(); k++) {
                System.out.print(playersList.get(player).OWNED.get(k).CountryId + " ");
            }
            System.out.println("");
        }
    }
}
