package org.GamePlay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player {

    ArrayList<Country> OWNED = new ArrayList<Country>();
    Queue<Order> ORDERS = new LinkedList<Order>();// Queue only
    Integer ARMIESNUM;
    String NAME;
    int CONTINENTVALUE; // Continent Control Value ;

    public Player(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public ArrayList<Country> getOWNED() {
        return OWNED;
    }

    public void setOWNED(Country country) {
        this.OWNED.add(country);
    }

   public void issue_order(Order order)
   {
       ORDERS.add(order);
   }

   public Order next_order()
   {
        return this.ORDERS.poll(); // FIFO for queue .
   }
}
