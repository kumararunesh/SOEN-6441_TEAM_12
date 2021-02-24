package org.GamePlay;

import java.util.concurrent.ConcurrentHashMap;

public class DeployOrder extends Order {
   String TYPEOFORDER = "DeployOrder" ;
   String COUNTRYID;
   Integer ARMIESTOPLACE;
   Country COU;
   public DeployOrder(String COUNTRYID, Integer ARMIESTOPLACE, Country COU) {
      this.COUNTRYID = COUNTRYID;
      this.ARMIESTOPLACE = ARMIESTOPLACE;
      this.COU = COU;
   }
   public void Execute(Player p_p)
   {
      int l_index=10000000;
      for(int i = 0; i< p_p.OWNED.size(); i++)
      {
         if(p_p.OWNED.get(i).COUNTRYID.equalsIgnoreCase(COUNTRYID))
         {
            l_index= i;
         }
      }
      if (l_index!=10000000)
      {
         if(ARMIESTOPLACE <= p_p.ARMIESNUM)
         {
            p_p.ARMIESNUM = p_p.ARMIESNUM - ARMIESTOPLACE;

            COU.COUNTRIESLIST.get(COUNTRYID).NUMOFARMIESPLACED += ARMIESTOPLACE;
            COU.COUNTRIESLIST.get(COUNTRYID).OWNER = p_p.NAME;

            System.out.print(p_p.NAME +" your order has been placed. Now your army count is "+ p_p.ARMIESNUM +". ");
            System.out.print(ARMIESTOPLACE +" unit of armies are placed on "+ p_p.OWNED.get(l_index).COUNTRYID);
            System.out.println("");
            ConcurrentHashMap <String,Player> playerList = new ConcurrentHashMap<>();
            playerList.put(p_p.NAME, p_p);
            showMap map = new showMap(playerList, COU);
         }
         else
         {
//            p_p.OWNED.get(l_index).NUMOFARMIESPLACED = ARMIESTOPLACE;
            COU.COUNTRIESLIST.get(COUNTRYID).NUMOFARMIESPLACED += p_p.ARMIESNUM;
            COU.COUNTRIESLIST.get(COUNTRYID).OWNER = p_p.NAME;
            System.out.println(p_p.NAME +" you only own "+ p_p.ARMIESNUM +" armies and all of them are now placed on "+p_p.OWNED.get(l_index).COUNTRYID);

            p_p.ARMIESNUM = 0;
         }
      }
      else
      {
         p_p.ARMIESNUM = p_p.ARMIESNUM - ARMIESTOPLACE;
         if(p_p.ARMIESNUM <0)
         {
            p_p.ARMIESNUM =0;
         }
         System.out.println("You don't own this country. Penalty has been applied. Now your army count is "+ p_p.ARMIESNUM);
      }
   }
   }