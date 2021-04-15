package org.StrategyPattern;

import org.GamePlay.Country;
import org.GamePlay.Order;
import org.GamePlay.Player;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *	Strategy of the Strategy pattern
 */
public abstract class PlayerStrategy implements Serializable {

	private static final long serialVersionUID = 6061893153983494157L;
	ConcurrentHashMap<String, Country> d_map;
	Player d_player;
	
	protected abstract Country toAttack();
	protected abstract Country toAttackFrom();
	protected abstract Country toMoveFrom();
	protected abstract Country toDefend();
	public abstract Order createOrder();
	
	PlayerStrategy(Player p_player,ConcurrentHashMap<String, Country> Countries){
		d_player = p_player;
		d_map = Countries;
	}
}
