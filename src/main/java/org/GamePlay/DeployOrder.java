package org.GamePlay;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Child class extending the Order Class , it deals with only deploy Order command
 */
public class DeployOrder extends Order implements Serializable {
    private static final long serialVersionUID = 2113471175527832670L;
    String d_countryId;
    Integer d_armiesToPlace;
    Country d_cou;
    String d_temp = "";

    /**
     * Constructor to initialize the DeployOrder Object.
     *
     * @param p_countryId     Country Name
     * @param p_armiesToPlace No. of Armies to Deploy
     * @param p_cou           Country
     */
    public DeployOrder(String p_countryId, Integer p_armiesToPlace, Country p_cou) {
        this.d_countryId = p_countryId;
        this.d_armiesToPlace = p_armiesToPlace;
        this.d_cou = p_cou;
    }

    /**
     * Implementation of Execute in Deploy Order
     *
     * @param p_p Player
     */
    public void Execute(Player p_p) {

        int l_index = 10000000;
        for (int i = 0; i < p_p.d_owned.size(); i++) {
            if (p_p.d_owned.get(i).d_countryId.equalsIgnoreCase(d_countryId)) {
                l_index = i;
            }
        }
		}
		}
