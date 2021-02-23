package org.GamePlay;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class playGame {
    ConcurrentHashMap<String,Player> playersList = new ConcurrentHashMap<>();
    Country cou;
    public playGame(ConcurrentHashMap<String, Player> playerList, Country cou)
    {
        this.playersList = playerList;
        this.cou=cou;
    }

        System.out.println("Main game loop: issue orders phase");
        Boolean flag = true;
        int i = 0;
        while(flag){      //Loop for iterating until all players give pass
            for (String s : playersList.keySet()) {
                Player p = playersList.get(s);
                Boolean flag_1 = true;
                while(flag_1){  //loop for correct input for order until a player inputs correct order
                    System.out.println(p.name+" Please issue orders from the below commands");
                    System.out.println("*************************");
                    System.out.println("**Deploy**\n**Pass**\n**ShowMap**");
                    System.out.println("*************************");
                    Scanner sc = new Scanner(System.in);
                    String command = sc.nextLine();
                    String commandSplit[] = command.split(" ");
                    if(commandSplit[0].equalsIgnoreCase("deploy")) {
                        if (commandSplit.length == 3) {
                            flag_1 = false;
                            String countryId = commandSplit[1];
                            int armiesToPlace = Integer.parseInt(commandSplit[2]);
                            Order newOrder = new DeployOrder(countryId, armiesToPlace, cou);
                            p.issue_order(newOrder);

                        }
                        else
                        {
                            System.out.println("Your deploy command should be like 'deploy countryName armyToPlace'\n");
                            continue;
                        }
                    }
                    else if(commandSplit[0].equalsIgnoreCase("pass"))
                    {
                        i++;
                        flag_1=false;
                    }
                    else if(commandSplit[0].equalsIgnoreCase("showmap"))
                    {
                        showMap map = new showMap(playersList,cou);
                        map.mapShow();
                    }
                    else
                    {
                        System.out.println("Wrong command. Re-enter the correct one");
                    }
                }
                if(i == playersList.size())
                {
                    flag =false; //for outer loop
                }
            }
        }
        System.out.println("Execute Order Phase\n");
        flag = true ;
        int p1=0;
        while(flag){      //Loop for iterating until all players give pass
            for (String s : playersList.keySet()) {
                Player p = playersList.get(s);
                if(p.orders.size()==0)
                {
                    p1+=1;
                    break;
                }
                System.out.println("Executing Order For Player : " + p.getName());
                int maxArmiesToDeploy = p.armiesNum;
                DeployOrder nextOrder =(DeployOrder) p.next_order();
                nextOrder.Execute(p);
                System.out.println("");
            }
            if(p1==playersList.size())
            {
                break;
            }
        }
    }
}