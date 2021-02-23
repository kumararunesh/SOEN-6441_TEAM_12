package org.GamePlay;

import java.util.concurrent.ConcurrentHashMap;

public class showMap {
    static ConcurrentHashMap<String,Player> playersList = new ConcurrentHashMap();
    static Country cou;
    public showMap(ConcurrentHashMap playersList, Country cou)
    {
        this.playersList = playersList;
        this.cou = cou;
    }

    public void mapShow() {
        System.out.println("Country and number of Armies");
        for(String country:cou.countriesList.keySet())
        {
            if(cou.countriesList.get(country).numOfArmiesPlaced==null) {
                System.out.println(country + "--> 0");
            }
            else
            {
                System.out.println(country + "--> " + cou.countriesList.get(country).numOfArmiesPlaced);
            }
        }
        System.out.println("Country and its Continent");
        for(String country:cou.countriesList.keySet())
        {
            System.out.println(country+"-->"+cou.countriesList.get(country).continent);
        }
        System.out.println("Countries and its owner");
        for(String country:cou.countriesList.keySet())
        {
            for(String player:playersList.keySet())
            {
                for(int i=0;i<playersList.get(player).owned.size();i++) {
                    if (playersList.get(player).owned.get(i).CountryId.equalsIgnoreCase(country)) {
                        System.out.println(country + "-->" + player);
                    }
                }
            }

        }
    }
}