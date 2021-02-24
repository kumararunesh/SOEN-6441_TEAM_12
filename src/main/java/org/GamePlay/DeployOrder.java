package org.GamePlay;

import java.util.concurrent.ConcurrentHashMap;

/**
 * DeployOrder class extends the abstract class orders.
 * In this class orders issued by an each individual player are being executed.
 * In a Round-Robin Fashion.
 */
public class DeployOrder extends Order {

   String TYPEOFORDER = "DeployOrder" ;
   String p_country_id;
   Integer p_armies_to_place;
   Country p_country;

   /**
    * This is constructor of the class DeployOrder
    * @param pcountryid this is the country on which the player wants to deploy armies.
    * @param p_armies_to_place this is the exact count of armies an individual players wants to deploy.
    * @param p_country this is the country class object which contains the states of each and avery country.
    */
   public DeployOrder(String pcountryid, Integer p_armies_to_place, Country p_country) {
      this.p_country_id = pcountryid;
      this.p_armies_to_place = p_armies_to_place;
      this.p_country = p_country;
   }
   public void Execute(Player p_player)
   {
      int l_index=10000000;
      for(int l_i=0;l_i<p_player.owned.size();l_i++)
      {
         if(p_player.owned.get(l_i).CountryId.equalsIgnoreCase(p_country_id))
         {
            l_index= l_i;
         }
      }
      if (l_index!=10000000)
      {
         if(p_armies_to_place <=p_player.armiesNum)
         {
            p_player.armiesNum = p_player.armiesNum- p_armies_to_place;
            p_player.owned.get(l_index).numOfArmiesPlaced= p_armies_to_place;

            p_country.countriesList.get(p_country_id).numOfArmiesPlaced= p_armies_to_place;
            p_country.countriesList.get(p_country_id).owner = p_player.name;

            System.out.print(p_player.name+" your order has been placed. Now your army count is "+p_player.armiesNum+". ");
            System.out.print(p_player.owned.get(l_index).numOfArmiesPlaced+" unit of armies are placed on "+p_player.owned.get(l_index).CountryId);
            System.out.println("");
            ConcurrentHashMap <String,Player> p_player_list = new ConcurrentHashMap<>();
            p_player_list.put(p_player.name,p_player);
            showMap d_map = new showMap(p_player_list, p_country);
         }
         else
         {
            System.out.println(p_player.name+" you only own "+p_player.armiesNum+" armies but as the result of penalty it has been reduced to 0");
            p_player.armiesNum = 0;
         }
      }
      else
      {
         p_player.armiesNum= p_player.armiesNum- p_armies_to_place;
         if(p_player.armiesNum<0)
         {
            p_player.armiesNum=0;
         }
         System.out.println("You don't own this country. Penalty has been applied. Now your army count is "+p_player.armiesNum);
      }
   }
   }