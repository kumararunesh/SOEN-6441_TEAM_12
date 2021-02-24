package org.Main;

import java.io.File;
import java.util.*;
import java.util.HashMap;

/**
 * This class checks whether the given .map file is CONNECTED or NOT.
 */

public class GraphConnected{
    static File FILE;
    MapTable BORDERS = new MapTable();
    HashMap<Integer,ArrayList> COUNTRYNEIGH;
    List<Integer> p_RealNodes;
    Stack<Integer> STACK;
    ArrayList<Integer> CONNECTIONS;
    int MAX;
    boolean[] VISITED;

    /**
     * Simple Constructor throwing exception.
     * @throws Exception whether the file exists or not.
     */
    public GraphConnected(File p_file) throws Exception {
        this.FILE = p_file;
        COUNTRYNEIGH =BORDERS.CountryAndItsNeighbours(FILE);
        p_RealNodes = BORDERS.max(FILE);
        STACK = new Stack<>();
        CONNECTIONS = new ArrayList<>();
        MAX = Collections.max(p_RealNodes,null);
        VISITED = new boolean[MAX+1];
    }

    /**
     * This method implements Depth First Search Algorithm in order to traverse the given graph.
     * And checks whether all the nodes are visited or not.
     * @param p_value variable p_value is integer value which determines from where the graph traversing should start.
     */
    public void dfs(int p_value) {

        STACK.push(p_value);
        VISITED[p_value] = true;
        int count = 0;


        while (true) {

            if(STACK.isEmpty() == true){
                break;
            }

            Integer l_node = STACK.pop();


            CONNECTIONS = COUNTRYNEIGH.get(l_node);

            if(!CONNECTIONS.isEmpty()){
                for (Integer neighbour : CONNECTIONS) {

                    if (!VISITED[neighbour]) {
                        STACK.push(neighbour);
                        VISITED[neighbour] = true;

                    }
                }

            }


            count++;
        }

    }

    /**
     * This method finally checks the visited boolean array and sees if any value is false in it.
     * If yes that means our graph is not connected and if no our graph is connected.
     * @return boolean variable boolean which is simple true or false.
     */

    public boolean ifGraphConnected() {

        int l_key_1 = COUNTRYNEIGH.keySet().stream().findFirst().get();

        int l_start = l_key_1;


        dfs(l_start);

        VISITED[0] = true;

        for (int i = 0; i <p_RealNodes.size(); i++) {

            int l_check = p_RealNodes.get(i);
            boolean l_comp = VISITED[l_check];

            if(l_comp == false){
                return false;
            }

            }
        return true;


        }


}




