package org.GamePlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Player Class containing all the stats of the Player Class
 */
public class Player {

    public ArrayList<Country> d_owned = new ArrayList<Country>();
    Queue<Order> d_orders = new LinkedList<Order>();// Queue only
    Integer d_armiesNum;
    String d_name;
    int d_continentValue; // Continent Control Value ;
    ArrayList<String> d_cards = new ArrayList<>();
    ArrayList<String> d_negotiate = new ArrayList<>();
    /**
     * Parameterised Constructor to initilize Player Object by name .
     * @param p_name  Player Name
     */
    public Player(String p_name) {
        this.d_name = p_name;
    }

    /**
     * getter for Player Name.
     * @return Player Name
     */
    public String getD_name() {
        return d_name;
    }

    /**
     *Getter for list of countries owned by the player.
     * @return list of countries owned by the player
     */
    public ArrayList<Country> getD_owned() {
        return d_owned;
    }

    /**
     *setter for owned country by the player
     * @param p_country country won by the player
     */
    public void setD_owned(Country p_country) {
        this.d_owned.add(p_country);
    }

    public void add_card(String cards){
        this.d_cards.add(cards);
    }

    public  void add_negotiator(String player){this.d_negotiate.add(player);}

    /**
     *function to issue order .
     * @param p_order issue order object
     */
    public void issue_order(Order p_order)
    {
        d_orders.add(p_order);
    }

    /**
     * function to fetch next order.
     * @return Order Next Order to be executed
     */
    public Order next_order()
    {
        return this.d_orders.poll(); // FIFO for queue .
    }
}
