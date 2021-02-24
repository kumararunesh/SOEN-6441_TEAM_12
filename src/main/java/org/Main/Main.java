package org.Main;

import java.io.File;
import java.util.*;

import static org.GamePlay.GameEngine.playGame;

/***
 * This class is the Main file from where the game starts.
 */

public class Main {

    /**
     * FILE is the object which is used to store the path of the map.
     */

    static File FILE;
    /**
     * SC is the object of scanner class used to get input from the user.
     */
    public static Scanner SC;

    /***
     * This method allows the user to select between two phases of game i.e Map Editor and Game Play.
     * Implemented using switch cases.
     * @throws Exception If the command entered by user is wrong, this will throw exception.
     */
    public static void menu() throws Exception{

        SC = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("* 1- MAP EDITOR *");
        System.out.println("* 2- GAME PLAY  *");
        System.out.println("*************************\n");
        System.out.println("Enter your option");
        while(true) {
            int l_option = SC.nextInt();
            SC.nextLine();
            switch (l_option) {
                case (1):
                    MapEditor();
                    break;

                case (2):
                    playGame();
                    break;

                default:
                    System.out.println("Enter Valid Command\n");
            }
        }
    }
    
    /***
     * This method allows user to select whether user wants to see the map or edit the map.
     * Implemented using switch cases.
     * @throws Exception If the command entered by user is wrong, this will throw exception.
     */
    public static void MapEditor() throws Exception {

        SC = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("* 1- showmap    *");
        System.out.println("* 2- editmap    *");
        System.out.println("*************************\n");
        System.out.println("");
        System.out.println("Do you want to see map or editmap? ");
        System.out.println("Enter you command ");
        while (true){
            String l_option = SC.nextLine();
            switch (l_option){
                case("showmap"):
                    mapShow();
                    break;

                case("editmap"):
                    EditMap();
                    break;

                default:
                    System.out.println("Enter Valid Command\n");
            }
        }
    }

    /***
     * This method edit the map initially by asking the user to enter the file name.
     * If file doesn't exixts then it will ask the user to create a new map, else it will allow user to interact with the map and edit it.
     */
    public static void EditMap() {
        int l_flag =0;
        while(true) {
            System.out.println("Enter edit filename command to edit map");
            SC = new Scanner(System.in);
            String l_filename = SC.nextLine();
            String[] l_text = l_filename.split(" ");
            try {
                if (l_text[0].equalsIgnoreCase("edit")) {
                    String l_file = null;
                    File l_directoryPath = new File("src\\main\\resources\\maps");
                    String l_contents[] = l_directoryPath.list();

                    for (int l_i = 0; l_i < l_contents.length; l_i++) {
                        if (l_text[1].equals(l_contents[l_i])) {
                            l_file = l_text[1];
                            l_flag = 1;
                        }
                    }

                    if (l_flag == 0 || l_contents == null) {
                        System.out.println("File does not exits! Let's build a new map");
                        File l_file1 = new File(l_text[1]);
                        createMapByUser(l_file1);
                    }

                    if (l_flag == 1) {
                        EditMap l_edit = new EditMap();
                        l_edit.editMap(l_file);
                    }
                    break;
                }
                else{
                    System.out.println("Enter correct command\n");
                }
            } catch (Exception p_e) {
                p_e.printStackTrace();
            }
        }
    }

    /**
     * This method is called if user want to edit the map and map doesn't exists.
     * This method allows user to create the map from the scratch.
     * @param p_file1 This is the name of the map which user will create.
     * @throws Exception If file does not found at the path mentioned, this will throw exception.
     */

    public static void createMapByUser(File p_file1) throws Exception {
        FILE = new File("src\\main\\resources\\maps" + p_file1);
        MapCreate l_create = new MapCreate();
        l_create.createMap(FILE);
    }

    /**
     * This method shows the map in the form of text.
     * @throws Exception If file does not found at the path mentioned at ShowMap file, this will throw exception.
     */
    public static void mapShow() throws Exception {
        ShowMap l_show  = new ShowMap();
        l_show.mapshow();
    }

    /**
     * This is the main function from where game starts.
     * @param args This contains the supplied command-line arguments as an array of String objects.
     * @throws Exception If there is some error or entered command at menu method is wrong, it will throw exception.
     */
    public static void main(String[] args) throws Exception {
        menu();
    }
}
