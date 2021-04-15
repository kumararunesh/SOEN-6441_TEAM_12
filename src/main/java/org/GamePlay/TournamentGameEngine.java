package org.GamePlay;

import org.ObserverBasedLogging.LogEntryBuffer;
import org.ObserverBasedLogging.LogFile;
import org.StrategyPattern.*;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Game Engine Class for Stratup Phase and all three game phases of Main game loop
 * Phase 1 : Reinforcement Phase
 * Phase 2 : Issue Order Phase
 * Phase 3 : Execute Order Phase
 */
public class TournamentGameEngine {
  /**
     * GLobal List of Players
     */
    public static ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .
    public static ArrayList<String> Behaviours = new ArrayList<String>();
    public void set_Behaviour(){
        Behaviours.add("random");
        Behaviours.add("human");
        Behaviours.add("aggressive");
        Behaviours.add("cheater");
        Behaviours.add("benevolent");
    }
   public playGame play;
    public Assign assign;
    public Order order;
  /**
     * Global Country Object
     */
    public static Country COUNTRY;
    /**
     * Global variable for File
     */
    public File FILE;
    /**
     * Global variable for storing the message.
     */
    public String d_message;
}
public void executeAllOrders() {
       public void executeAllOrders() {
        System.out.println("===============BEGIN EXECUTING ALL ORDERS=================");
        Order order;
        boolean still_more_orders = false;
        do {
            still_more_orders = false;
            for (String l_s : PLAYERS_LIST.keySet()) {
                Player p = PLAYERS_LIST.get(l_s);
                order = p.next_order();
                if (order != null) {
                    still_more_orders = true;
                    order.Execute(p);
                }
            }
