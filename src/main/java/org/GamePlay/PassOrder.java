package org.GamePlay;

/**
 * This class extends the Order class and called when player want to pass and don't want to give any order.
 * This class just pass the order so as the counter will not ask the same player to order.
 */

public class PassOrder extends Order {
    Player P;
    Country COU;
    public PassOrder(Player p_p,Country p_cou)
    {
        this.P = p_p;
        this.COU = p_cou;
    }
    @Override
    void Execute(Player p) {}
}

