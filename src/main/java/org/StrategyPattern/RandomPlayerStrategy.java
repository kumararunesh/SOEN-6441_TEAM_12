package org.StrategyPattern;

import org.GamePlay.*;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 *	ConcreteStrategy of the Strategy pattern
 */
public class RandomPlayerStrategy extends PlayerStrategy {
	Country country;

	public RandomPlayerStrategy(Player p_player, ConcurrentHashMap<String, Country> p_map , Country country) {
		super(p_player, p_map);
		this.country = country;
	}

	/**
	 *	Determines the country to attack/move to. 
	 *	The Random player determines this randomly
	 *	@return random territory
	 */
	protected Country toAttack() {
		Random generator = new Random();
		Object[] values = (Object[]) d_map.values().toArray();
		Country rnd_target_territory = (Country) values[generator.nextInt(values.length+0)];
		return rnd_target_territory;
	}
	
	/**
	 *	Determines the country to attack to. 
	 *	The Random player determines this randomly. 
	 *	@return random territory owned by the player
	 */
	protected Country toDefend() {
		Random rand = new Random();
		int rnd_target_territory;
		rnd_target_territory = rand.nextInt(d_player.d_owned.size()+0);
		return(d_player.d_owned.get(rnd_target_territory));
	}

	/**
	 *	Determines the country to attack from. 
	 *	The Random player does not use this, so it returns null.
	 *	@return null
	 */
	protected Country toAttackFrom() {
		return toDefend();
	}

	/**
	 *	Determines the country to move from. 
	 *	The Random player does not use this, so it returns null.
	 *	@return null
	 */
	protected Country toMoveFrom() {
		return toDefend();
	}
	
	/**
	 *	Creates and order. 
	 *	The Random player can either deploy or advance, determined randomly. .
	 *	@return null
	 */
	public Order createOrder() {
		Random rand = new Random();

		int rnd_num_of_armies = rand.nextInt(d_player.d_armiesNum-1);
		if (rand.nextInt(5) != 0) {
			switch (rand.nextInt(3)) {
				case (0):
					return new DeployOrder(d_player.getD_name(), rnd_num_of_armies, toDefend());

				case (1):
					if(d_player.d_cards.contains("AIRLIFT")){
						return new AdvanceArmies(toDefend().d_countryId, toDefend().d_countryId, rnd_num_of_armies, country, "airlift");
					}
					else {
						return new AdvanceArmies(toDefend().d_countryId, toDefend().d_countryId, rnd_num_of_armies, country, "advance");
					}

				case (2):
					if(d_player.d_cards.contains("BOMB")){
						return new Cards(toAttack().d_countryId,"bomb",country);
					}
					else if(d_player.d_cards.contains("BLOCKADE")){
						return new Cards(toAttack().d_countryId,"blockade",country);
					}
					else {
						return new AdvanceArmies(toDefend().d_countryId, toDefend().d_countryId, rnd_num_of_armies, country, "advance");
					}
			}
		}
		return new AdvanceArmies(toDefend().d_countryId, toDefend().d_countryId, rnd_num_of_armies, country, "advance");
	}
}
