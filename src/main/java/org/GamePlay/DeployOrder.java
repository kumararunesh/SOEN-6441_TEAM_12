package org.GamePlay;

import java.util.concurrent.ConcurrentHashMap;

/**
 * DeployOrder class extends the abstract class orders.
 * In this class orders issued by an each individual player are being executed.
 * In a Round-Robin Fashion.
 */
public class DeployOrder extends Order {

   String typeOfOrder = "DeployOrder" ;
   String CountryId ;
   Integer armiesToPlace;
   Country cou;

   /**
    * This is constructor of the class DeployOrder
    * @param countryId this is the country on which the player wants to deploy armies.
    * @param armiesToPlace this is the exact count of armies an individual players wants to deploy.
    * @param cou this is the country class object which contains the states of each and avery country.
    */
   public DeployOrder(String countryId, Integer armiesToPlace,Country cou) {
      this.CountryId = countryId;
      this.armiesToPlace = armiesToPlace;
      this.cou = cou;
   }
   public void Execute(Player p)
   {
      int index=10000000;
      for(int i=0;i<p.owned.size();i++)
      {
         if(p.owned.get(i).CountryId.equalsIgnoreCase(CountryId))
         {
            index= i;
         }
      }
      if (index!=10000000)
      {
         if(armiesToPlace<=p.armiesNum)
         {
            p.armiesNum = p.armiesNum-armiesToPlace;
            p.owned.get(index).numOfArmiesPlaced=armiesToPlace;

            cou.countriesList.get(CountryId).numOfArmiesPlaced=armiesToPlace;
            cou.countriesList.get(CountryId).owner = p.name;

            System.out.print(p.name+" your order has been placed. Now your army count is "+p.armiesNum+". ");
            System.out.print(p.owned.get(index).numOfArmiesPlaced+" unit of armies are placed on "+p.owned.get(index).CountryId);
            System.out.println("");
            ConcurrentHashMap <String,Player> playerList = new ConcurrentHashMap<>();
            playerList.put(p.name,p);
            showMap map = new showMap(playerList,cou);
         }
         else
         {
            System.out.println(p.name+" you only own "+p.armiesNum+" armies but as the result of penalty it has been reduced to 0");
            p.armiesNum = 0;
         }
      }
      else
      {
         p.armiesNum= p.armiesNum-armiesToPlace;
         if(p.armiesNum<0)
         {
            p.armiesNum=0;
         }
         System.out.println("You don't own this country. Penalty has been applied. Now your army count is "+p.armiesNum);
      }
   }
   }