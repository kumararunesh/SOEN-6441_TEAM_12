package org.Tournament;

import org.GamePlay.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class TournamentMain {

    String listOfMapFiles[] ;
    public  ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .
    public  ConcurrentHashMap<String, Country> COUNTRIES = new ConcurrentHashMap<>();
    public HashMap<String,String> gameState = new HashMap<>();
    Country d_country;
    File d_file;
    public  int numberofgames , j =0;
    public  int maxnumberofturns , k =0;
    public  int noOfMap , i =0;
    static int count ;
    static String winningPlayer ;
    Assign d_assign;
    TournamentGameEngine gameEngine ;
    public playGame play;
    public ArrayList<String> winners = new ArrayList<String>();


    String[] d_playersName;
    String winner;

    public String run() {
        System.out.println("Enter command to start the tournament mode");
        Scanner sc = new Scanner(System.in);
        String l_command = sc.nextLine();
        return run(l_command);
    }

    public String run(String l_command){
        gameEngine = new TournamentGameEngine();
        String[] l_commandSplit= l_command.split("-");
        if(l_commandSplit[0].equalsIgnoreCase("tournament ") && l_commandSplit.length==5)
        {
            listOfMapFiles = new String[l_commandSplit[1].split(" ").length-1];
            int i=0;
            if(l_commandSplit[1].split(" ")[0].equalsIgnoreCase("m")) {
                for (String map : l_commandSplit[1].split(" ")) {
                    if (map.equalsIgnoreCase("m")) {
                        continue;
                    } else {
                        listOfMapFiles[i] = map;
                        i += 1;
                    }
                }
            }
            else
            {
                System.out.println("Enter correct map command.");
                return "Enter correct map command";
            }
            i=0;
            if(l_commandSplit[2].split(" ")[0].equalsIgnoreCase("p"))
            {
                d_playersName= new String[l_commandSplit[2].split(" ").length];
                for(String l_playerName: l_commandSplit[2].split(" "))
                {
                    if(l_playerName.equalsIgnoreCase("p"))
                    {
                        continue;
                    }
                    else {
                        d_playersName[i] = l_playerName;
                        i+=1;
                    }
                }

            }
            else{
                System.out.println("Enter correct Player command.");
                return "Enter correct Player command";
            }

            if(l_commandSplit[3].split(" ")[0].equalsIgnoreCase("g"))
            {
                numberofgames= Integer.parseInt(l_commandSplit[3].split(" ")[1]);

            }
            else
            {
                System.out.println("Enter correct Game command");
                return "Enter correct Game command";
            }

            if(l_commandSplit[4].split(" ")[0].equalsIgnoreCase("d"))
            {
                maxnumberofturns = Integer.parseInt(l_commandSplit[4].split(" ")[1]);
            }
            else
            {
                System.out.println("Enter correct no of turns command");
                return "Enter correct no of turns command";
            }
        }
        else
        {
            System.out.println("Enter the correct command");
            return "Wrong command";
        }

        for (int i = 0; i < listOfMapFiles.length; i++) {
            System.out.println("Map" + listOfMapFiles[i] + " : ");
            d_file = new File("src/main/resources/maps/" + listOfMapFiles[i]);


            for (int j = 0; j < numberofgames; j++) {
                for(int t = 0 ; t<d_playersName.length -1 ; t++)
                {
                    PLAYERS_LIST.put(d_playersName[t], new Player(d_playersName[t]));
                }

                d_assign = new Assign(PLAYERS_LIST,d_country);
                d_assign.assignCountries(d_file);
                COUNTRIES = d_assign.d_country.COUNTRIESLIST;
                d_country = d_assign.d_country;

                play = new playGame(PLAYERS_LIST,d_country);
                play.playGameLoop();
                int k = j+1;
                gameState = gameEngine.gamePlay(d_file,maxnumberofturns,PLAYERS_LIST,d_country,listOfMapFiles[i],gameState);
                winners.add("Winner of game " + k +" on map " + listOfMapFiles[i] + " is " +gameState.get(listOfMapFiles[i]) +"\n");
            }

            System.out.println(winners + "\n");
        }
        return "Tournament Over";
    }



}
