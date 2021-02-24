package org.GamePlay;

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
