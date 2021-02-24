package org.GamePlay;

import java.util.concurrent.ConcurrentHashMap;

/**
 *Child class extending the Order Class , it deals with only deploy Order command
 */
public class DeployOrder extends Order {
   String d_typeOfOrder = "DeployOrder";
   String d_countryId;
   Integer d_armiesToPlace;
   Country d_cou;

   /**
    *Constructor to initialize the DeployOrder Object.
    * @param p_countryId Country Name
    * @param p_armiesToPlace No. of Armies to Deploy
    * @param p_cou Country
    */
   public DeployOrder(String p_countryId, Integer p_armiesToPlace, Country p_cou) {
      this.d_countryId = p_countryId;
      this.d_armiesToPlace = p_armiesToPlace;
      this.d_cou = p_cou;
   }

   /**
    * Implementation of Execute in Deploy Order
    * @param p_p Player
    */
   public void Execute(Player p_p)
   {
      int l_index=10000000;
      for(int i = 0; i< p_p.d_owned.size(); i++)
      {
         if(p_p.d_owned.get(i).d_countryId.equalsIgnoreCase(d_countryId))
         {
            l_index= i;
         }
      }
      if (l_index!=10000000)
      {
         if(d_armiesToPlace <= p_p.d_armiesNum)
         {
            p_p.d_armiesNum = p_p.d_armiesNum - d_armiesToPlace;

            d_cou.COUNTRIESLIST.get(d_countryId).d_numOfArmiesPlaced += d_armiesToPlace;
            d_cou.COUNTRIESLIST.get(d_countryId).d_owner = p_p.d_name;

            System.out.print(p_p.d_name +" your order has been placed. Now your army count is "+ p_p.d_armiesNum +". ");
            System.out.print(d_armiesToPlace +" unit of armies are placed on "+ p_p.d_owned.get(l_index).d_countryId);
            System.out.println("");
            ConcurrentHashMap <String,Player> playerList = new ConcurrentHashMap<>();
            playerList.put(p_p.d_name, p_p);
            showMap map = new showMap(playerList, d_cou);
         }
         else
         {
//            p_p.OWNED.get(l_index).NUMOFARMIESPLACED = ARMIESTOPLACE;
            d_cou.COUNTRIESLIST.get(d_countryId).d_numOfArmiesPlaced += p_p.d_armiesNum;
            d_cou.COUNTRIESLIST.get(d_countryId).d_owner = p_p.d_name;
            System.out.println(p_p.d_name +" you only own "+ p_p.d_armiesNum +" armies and all of them are now placed on "+p_p.d_owned.get(l_index).d_countryId);

            p_p.d_armiesNum = 0;
         }
      }

   }
}