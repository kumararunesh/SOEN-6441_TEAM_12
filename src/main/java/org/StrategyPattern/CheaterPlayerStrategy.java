package org.StrategyPattern;

import org.GamePlay.Country;
import org.GamePlay.Order;
import org.GamePlay.Player;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class CheaterPlayerStrategy{

    ConcurrentHashMap <String,Country> d_countries;
    Player d_player;
    ConcurrentHashMap<String,Player> d_playerList;

    public CheaterPlayerStrategy(Player p_player, ConcurrentHashMap<String, Country> Countries, ConcurrentHashMap<String, Player> p_playerList )
    {
        super(p_player, Countries);
        this.d_countries = Countries;
        this.d_player = p_player;
        this.d_playerList = p_playerList;
    }
	    protected Country toAttack() {

        return null;
    }
	protected Country toAttackFrom() {
        return null;
    }
	    protected Country toMoveFrom() {
        return null;
    }

    protected Country toDefend() {
        return null;
    }
	    public Order createOrder() {
        ArrayList<Country> l_tempList = new ArrayList<>();
        for(Country l_country : d_player.d_owned)
        {

            for (String l_neighbour : l_country.d_neighbours)
            {

                Country l_tempNeighCountry = l_country.COUNTRIESLIST.get(l_neighbour);
                if(!d_player.d_owned.contains(l_tempNeighCountry) ) {
                    String l_oldOwnerName = l_tempNeighCountry.d_owner;
                    Player d_tempOldPlayer = d_playerList.get(l_oldOwnerName);
                    d_tempOldPlayer.d_owned.remove(l_tempNeighCountry);
                    d_playerList.put(l_oldOwnerName,d_tempOldPlayer);
                    l_tempNeighCountry.d_owner = d_player.d_name;
                    l_tempList.add(l_tempNeighCountry);
                    l_tempNeighCountry.d_numOfArmiesPlaced = 2 * l_tempNeighCountry.d_numOfArmiesPlaced;
                    System.out.println("");
                }

            }

        }
		return null;
		}
}
