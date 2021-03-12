package org.GamePlay;

import org.Main.*;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Game Engine Class for Stratup Phase and all three game phases of Main game loop
 * Phase 1 : Reinforcement Phase
 * Phase 2 : Issue Order Phase
 * Phase 3 : Execute Order Phase
 */
public class GameEngine {
    /**
     * GLobal List of Players
     */
    static ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .

    /**
     * Global Country Object
     */
    static Country COUNTRY;

    /**
     * Game Startup Phase Implementation
     *
     * @param p_file Map File
     */
    public void startGameEngine(File p_file) {
        Scanner l_sc = new Scanner(System.in);
        String l_player_name = "";
        Boolean l_flag = true;
        System.out.println("*************************");
        System.out.println("Startup Phase");
        while (l_flag) {
            System.out.println("");
            System.out.println("*************************");
            System.out.println("1.Add/Remove Player \n2.Assign countries");
            System.out.println("*************************");
            String l_command = l_sc.nextLine();
            String[] l_command_split = l_command.split("-");
            if (l_command_split[0].equalsIgnoreCase("gameplayer ")&&l_command_split.length>1) {
                for (int l_i = 1; l_i < l_command_split.length; l_i++) {
                    String l_command_split1[] = l_command_split[l_i].split(" ");
                    if (l_command_split1[0].equalsIgnoreCase("add")) {
                        if (PLAYERS_LIST.containsKey(l_command_split1[1])) {
                            System.out.println("Player " + l_command_split1[1] + " already exists Please re-enter your name");
                            break;
                        }
                        PLAYERS_LIST.put(l_command_split1[1], new Player(l_command_split1[1]));
                    } else if (l_command_split1[0].equalsIgnoreCase("remove")) {
                        PLAYERS_LIST.remove(l_command_split1[1]);
                    }
                }
            } else if (l_command_split[0].equalsIgnoreCase("assigncountries")) {
                if (PLAYERS_LIST.size() < 2) {
                    System.out.println("Minimum 2 players are required to play the game");
                    continue;
                } else {
                    l_flag = false;
                    Assign l_assign = new Assign(PLAYERS_LIST, COUNTRY);
                    l_assign.assignCountries(p_file);
                    break;
                }
            } else {
                System.out.println("Wrong command. Please re-check");
            }
            System.out.println("");
            System.out.println("All Players as of now");
            for (String l_s : PLAYERS_LIST.keySet()) {
                System.out.println(PLAYERS_LIST.get(l_s).getD_name());
            }
        }
    }

    /**
     * Main Game loop
     * Phase 1 : Reinforcement Phase
     * Phase 2 : Issue Order Phase
     * Phase 3 : Execute Order Phase
     */
    public static void playGame() {
        Scanner l_sc = new Scanner(System.in);
        while (true) {
            System.out.println("**************************************");
            System.out.println("Enter 'loadmap' command to continue");
            System.out.println("**************************************");
            String l_command = l_sc.nextLine();
            String[] l_com = l_command.split(" ");
            File l_file;
            GameEngine l_game = new GameEngine();
            if (l_com[0].equalsIgnoreCase("loadmap")) {
                if (l_com.length == 2) {
                    if (l_com[1].endsWith(".map")) {
                        String filename = l_com[1];
                        l_file = new File("SOEN-6441_TEAM_12-main\\src\\main\\resources\\maps\\" + filename);
                        if (l_file.exists()) {
                            MapValidation validation = new MapValidation();


                            MapTable l_list = new MapTable();
                            ArrayList<String> l_countries;
                            ArrayList<String> l_continent;
                            HashMap<String, Integer> l_contval;
                            HashMap<Integer, String> l_countrykey;
                            HashMap<String, String> l_countrycont;
                            HashMap<String, ArrayList> l_countryneigh;
                            HashMap<String,Integer>l_country_cont_key;
                            HashMap<String,Integer>l_cont_unique_key;
                            try{
                                l_countries = l_list.countryList(l_file);
                                l_continent = l_list.continentList(l_file);
                                l_contval = l_list.continentandvalue(l_file);
                                l_countrykey= l_list.countryanditskey(l_file);
                                l_countrycont= l_list.countryanditscontinent(l_file);
                                l_countryneigh= l_list.countryanditsneighbours(l_file);
                                l_country_cont_key= l_list.countryanditsuniquecontinent(l_file);
                                l_cont_unique_key = l_list.uniqueKeyanditscountry(l_file);
                                validation.mapValidate(l_file,l_countries,l_continent,l_contval,l_countrykey,l_countrycont,l_countryneigh,l_country_cont_key,l_cont_unique_key);
                            }catch(Exception e)
                            {}

                            if(validation.d_final_flag ==0)
                            {
                                l_game.startGameEngine(l_file);
                                playGame l_playgame = new playGame(PLAYERS_LIST, COUNTRY);
                                l_playgame.playGameLoop();
                                l_playgame.mainGameLoop();
                                System.out.println("Deployment Phase Over!!!!!!!!");
                                System.out.println("");
                                System.out.println("");
                                System.out.println("");
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid Map.");
                                continue;
                            }

                        } else {
                            System.out.println("File you entered doesn't exist\n");
                            continue;
                        }

                    } else {
                        System.out.println("Enter the command with .map extension");
                        continue;
                    }
                } else {
                    System.out.println("Wrong command. Enter 'loadmap filename.map'");
                    continue;
                }
            } else {
                System.out.println("Wrong command. Please retry");
            }
        }
        String l_command;
        while (true) {
            System.out.println("In order to see the map Command is Showmap\nElse type continue");
            l_command = l_sc.nextLine();
            if (l_command.equalsIgnoreCase("showmap")) {
                showMap l_map = new showMap(PLAYERS_LIST, COUNTRY);
                l_map.check();
                break;
            } else if (l_command.equalsIgnoreCase("continue")) {
                break;
            } else {
                System.out.println("You misspelled showmap ");
                continue;
            }
        }
        try {
            for (String l_player : PLAYERS_LIST.keySet()) {
                PLAYERS_LIST.remove(l_player);
            }
            Main.menu();
        } catch (Exception e) {
        }
    }
}
