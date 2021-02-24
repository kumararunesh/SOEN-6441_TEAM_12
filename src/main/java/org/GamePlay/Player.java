package org.GamePlay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Player {

    ArrayList<Country> OWNED = new ArrayList<Country>();
    Queue<Order> ORDERS = new LinkedList<Order>();
    Integer ARMIESNUM;
    String NAME;
    int CONTINENTVALUE; 

    public Player(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME() {
        return NAME;
    }

    public ArrayList<Country> getOWNED() {
        return OWNED;
    }
    
     /**
     *function to issue order .
     * @param p_order issue order object
     */
    public void setOWNED(Country country) {
        this.OWNED.add(country);
    }

      /**
     * function to fetch next order.
     * @return Order Next Order to be executed
     */
   public Order next_order()
   {
        return this.d_orders.poll(); // FIFO for queue .
   }
   public void issue_order(Order order)
   {
       ORDERS.add(order);
   }

   public Order next_order()
   {
        return this.ORDERS.poll(); 
   }
}
