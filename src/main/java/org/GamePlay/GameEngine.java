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
    public static ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .

    /**
     * Global Country Object
     */
    public static Country COUNTRY;
    /**
     * Global variable for File
     */
    public File FILE;
    /**
     * Global variable for storing the message.
     */
    public String d_message;
    String d_filename;
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
            System.out.println("1.Add/Remove Player");
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
                        l_flag=false;
                    } else if (l_command_split1[0].equalsIgnoreCase("remove")) {
                        PLAYERS_LIST.remove(l_command_split1[1]);
                        l_flag=false;
                    }
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
    public void playGame() {
        Scanner l_sc = new Scanner(System.in);
        if(FILE==null) // This if-else is just for testing (MapValidation.java file in Testing-->Gameplay).
        {
            while (true) {
                System.out.println("**************************************");
                System.out.println("Enter 'loadmap' command to continue");
                System.out.println("**************************************");
                String l_command = l_sc.nextLine();
                String[] l_com = l_command.split(" ");

                GameEngine l_game = new GameEngine();
                if (l_com[0].equalsIgnoreCase("loadmap")) {
                    if (l_com.length == 2) {
                        if (l_com[1].endsWith(".map")) {
                            d_filename = l_com[1];
                            FILE = new File("src/main/resources/maps/" + d_filename);
                            if (FILE.exists()) {
                                MapValidation l_validation = new MapValidation();

                                MapTable l_list = new MapTable();
                                ArrayList<String> l_countries;
                                ArrayList<String> l_continent;
                                HashMap<String, Integer> l_contval;
                                HashMap<Integer, String> l_countrykey;
                                HashMap<String, String> l_countrycont;
                                HashMap<String, ArrayList> l_countryneigh;
                                HashMap<String, Integer> l_country_cont_key;
                                HashMap<String, Integer> l_cont_unique_key;
                                try {
                                    l_countries = l_list.countryList(FILE);
                                    l_continent = l_list.continentList(FILE);
                                    l_contval = l_list.continentandvalue(FILE);
                                    l_countrykey = l_list.countryanditskey(FILE);
                                    l_countrycont = l_list.countryanditscontinent(FILE);
                                    l_countryneigh = l_list.countryanditsneighbours(FILE);
                                    l_country_cont_key = l_list.countryanditsuniquecontinent(FILE);
                                    l_cont_unique_key = l_list.uniqueKeyanditscountry(FILE);
                                    l_validation.mapValidate(FILE, l_countries, l_continent, l_contval, l_countrykey, l_countrycont, l_countryneigh, l_country_cont_key, l_cont_unique_key);
                                } catch (Exception e) {
                                }

                                if (l_validation.d_final_flag == 0) {
                                    d_message = "Map Validated";
                                    break;
                                } else {
                                    System.out.println("Invalid Map.");
                                    d_message = "Invalid Map";
                                    continue;
                                }

                            } else {
                                System.out.println("File you entered doesn't exist\n");
                                d_message = "File you entered doesn't exist";
                                continue;
                            }

                        } else {
                            System.out.println("Enter the command with .map extension");
                            d_message = "Enter the command with .map extension";
                            continue;
                        }
                    } else {
                        System.out.println("Wrong command. Enter 'loadmap filename.map'");
                        d_message = "Wrong command. Enter 'loadmap filename.map'";
                        continue;
                    }
                } else {
                    d_message = "Wrong Command";
                    System.out.println("Wrong command. Please retry");
                }
            }
        }
        else
        {
            if (FILE.exists()) {
                MapValidation l_validation = new MapValidation();

                MapTable l_list = new MapTable();
                ArrayList<String> l_countries;
                ArrayList<String> l_continent;
                HashMap<String, Integer> l_contval;
                HashMap<Integer, String> l_countrykey;
                HashMap<String, String> l_countrycont;
                HashMap<String, ArrayList> l_countryneigh;
                HashMap<String, Integer> l_country_cont_key;
                HashMap<String, Integer> l_cont_unique_key;
                try {
                    l_countries = l_list.countryList(FILE);
                    l_continent = l_list.continentList(FILE);
                    l_contval = l_list.continentandvalue(FILE);
                    l_countrykey = l_list.countryanditskey(FILE);
                    l_countrycont = l_list.countryanditscontinent(FILE);
                    l_countryneigh = l_list.countryanditsneighbours(FILE);
                    l_country_cont_key = l_list.countryanditsuniquecontinent(FILE);
                    l_cont_unique_key = l_list.uniqueKeyanditscountry(FILE);
                    l_validation.mapValidate(FILE, l_countries, l_continent, l_contval, l_countrykey, l_countrycont, l_countryneigh, l_country_cont_key, l_cont_unique_key);
                } catch (Exception e) {
                }

                if (l_validation.d_final_flag == 0) {
                    d_message = "Map Validated";
                } else {
                    System.out.println("Invalid Map.");
                    d_message = "Invalid Map";
                }

            } else {
                System.out.println("File you entered doesn't exist\n");
                d_message = "File you entered doesn't exist";
            }
        }
    }
}
