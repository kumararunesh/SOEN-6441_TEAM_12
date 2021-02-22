package org.GamePlay;

import org.Main.*;
import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GameEngine {
    static ConcurrentHashMap<String, Player> playersList = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .
    static Country cou;
    public void startGameEngine(File file) {
        Scanner sc = new Scanner(System.in);
        String playerName = "";
        Boolean flag = true;
        System.out.println("*************************");
        System.out.println("Startup Phase");
        while (flag) {
            System.out.println("");
            System.out.println("*************************");
            System.out.println("1.Add/Remove Player \n2.Assign countries");
            System.out.println("*************************");
            String command = sc.nextLine();
            String[] commandSplit = command.split("-");
            if(commandSplit[0].equalsIgnoreCase("gameplayer "))
            {
                for(int i=1;i<commandSplit.length;i++)
                {
                    String commandSplit1[] = commandSplit[i].split(" ");
                    if(commandSplit1[0].equalsIgnoreCase("add"))
                    {
                        if(playersList.containsKey(commandSplit1[1]))
                        {
                            System.out.println("Player "+commandSplit1[1]+" already exists Please re-enter your name");
                            break;
                        }
                        playersList.put(commandSplit1[1],new Player(commandSplit1[1]));
                    }
                    else if(commandSplit1[0].equalsIgnoreCase("remove"))
                    {
                        playersList.remove(commandSplit1[1]);
                    }
                }
            }
            else if(commandSplit[0].equalsIgnoreCase("assigncountries"))
            {
                if (playersList.size() < 2) {
                    System.out.println("There is only one player , Please input at least one more to play ");
                    continue;
                }
                else {
                    flag = false;
                    Assign assign = new Assign(playersList,cou);
                    assign.assignCountries(file);
                    break;
                }
            }
            else
            {
                System.out.println("Wrong command. Please re-check");
            }
            System.out.println("");
            System.out.println("All Players as of now");
            for (String s : playersList.keySet()) {
                System.out.println(playersList.get(s).getName());
            }
        }
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("**************************************");
            System.out.println("Enter 'loadmap' command to continue");
            System.out.println("**************************************");
            String command = sc.nextLine();
            String[] com=command.split(" ");
            File file;
            GameEngine game = new GameEngine();
            if (com[0].equalsIgnoreCase("loadmap")) {
                if(com.length==2) {
                    if (com[1].endsWith(".map")) {
                        String filename = com[1];
                        file = new File("src//main//resources//maps//" + filename);
                        if(file.exists())
                        {
                            game.startGameEngine(file);
                            playGame pGame = new playGame(playersList,cou);
//                            test pGame = new test(playersList,cou);
                            pGame.playGameLoop();
                            System.out.println("Deployment Phase Over!!!!!!!!");
                            System.out.println("");
                            System.out.println("");
                            System.out.println("");
                            break;
                        }
                        else
                        {
                            System.out.println("File you entered doesn't exist\n");
                            continue;
                        }

                    } else {
                        System.out.println("Enter the command with .map extension");
                        continue;
                    }
                }
                else
                {
                    System.out.println("Wrong command. Enter 'loadmap filename.map'");
                    continue;
                }
            } else {
                System.out.println("Wrong command. Please retry");
            }
        }
        String command;
        while(true)
        {
            System.out.println("In order to see the map Command is Showmap\nElse type continue");
            command  = sc.nextLine();
            if(command.equalsIgnoreCase("showmap"))
            {
                showMap map = new showMap(playersList,cou);
                map.mapShow();
                break;
            }
            else if(command.equalsIgnoreCase("continue"))
            {
                break;
            }
            else
            {
                System.out.println("You misspelled showmap ");
                continue;
            }
        }
        try {
            Main.menu();
        } catch (Exception e) {}
    }
}
