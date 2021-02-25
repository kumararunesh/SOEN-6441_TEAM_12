package org.Main;

import java.io.File;
import java.util.*;
import java.util.HashMap;

/**
 * This class checks whether the given .map file is CONNECTED or NOT.
 */

public class GraphConnected{
    static File FILE;
    MapTable d_borders = new MapTable();
    HashMap<Integer,ArrayList> d_countryNeigh;
    List<Integer> d_realNodes;
    List<Integer> d_country_index;
    Stack<Integer> d_stack;
    ArrayList<Integer> d_connections;
    int d_max;
    boolean[] d_visited;
    boolean[] d_scan;

    /**
     * Simple Constructor throwing exception.
     * @param p_file is the object of the file.
     * @throws Exception whether the file exists or not.
     */
    public GraphConnected(File p_file) throws Exception {
        this.FILE = p_file;
        d_countryNeigh = d_borders.CountryAndItsNeighbours(FILE);
        d_country_index = d_borders.list(FILE);
        d_realNodes = d_borders.max(FILE);
        d_stack = new Stack<>();
        d_connections = new ArrayList<>();
        d_max = Collections.max(d_realNodes,null);
        d_visited = new boolean[d_max +1];
        d_scan = new boolean[d_max + 1];
    }

    /**
     * This function is modifying the Hashmap of the .map file values, to its relevant form.
     * @return Hashmap which has each country unique id and in its values is..
     * Arraylist of neighbouring countries unique id's.
     */
    public HashMap<Integer,ArrayList> complete(){
        ArrayList<Integer> l_empty = new ArrayList<>();

        d_scan[0] = true;
        for (int l_i = 0; l_i<d_country_index.size(); l_i++){
            d_scan[d_country_index.get(l_i)]= true;
        }
        for (int l_j = 0; l_j<d_realNodes.size(); l_j++){
            if(d_scan[d_realNodes.get(l_j)]==false){
                int l_note = d_realNodes.get(l_j);
                d_countryNeigh.put(l_note,l_empty);
            }
        }

        return  d_countryNeigh;

    }

    /**
     * This method implements Depth First Search Algorithm in order to traverse the given graph.
     * And checks whether all the nodes are visited or not.
     * @param p_value variable p_value is integer value which determines from where the graph traversing should start.
     */
    public void dfs(int p_value) {
        d_stack.push(p_value);
        d_visited[p_value] = true;
        complete();
        int l_count = 0;
        while (true) {
            if(d_stack.isEmpty() == true){
                break;
            }
            Integer l_node = d_stack.pop();
            d_connections = d_countryNeigh.get(l_node);
            if(!d_connections.isEmpty()){
                for (Integer l_neighbour : d_connections) {
                    if (!d_visited[l_neighbour]) {
                        d_stack.push(l_neighbour);
                        d_visited[l_neighbour] = true;
                    }
                }
            }
            l_count++;
        }
    }

    /**
     * This method finally checks the visited boolean array and sees if any value is false in it.
     * If yes that means our graph is not connected and if no our graph is connected.
     * @return boolean variable boolean which is simple true or false.
     */
    public boolean ifGraphConnected() {
        int l_key_1 = d_countryNeigh.keySet().stream().findFirst().get();
        int p_start = l_key_1;
        dfs(p_start);
        d_visited[0] = true;
        for (int l_i = 0; l_i < d_realNodes.size(); l_i++) {
            int l_check = d_realNodes.get(l_i);
            boolean l_comp = d_visited[l_check];
            if(l_comp == false){
                return false;
            }
            }
        return true;
        }
}
