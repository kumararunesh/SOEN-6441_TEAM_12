package org.GamePlay;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Country {
    static ConcurrentHashMap<String, Country> COUNTRIESLIST = new ConcurrentHashMap<>();
    int NUMOFCOUNTRIESINCONTINENT;
    String COUNTRYID;
    Integer NUMOFARMIESPLACED=0;
    ArrayList<String> NEIGHBOURS = new ArrayList();
    String CONTINENT;
    String OWNER;
    int CONTINENTBONUS;
    public Country(String COUNTRYID, String CONTINENT, int CONTINENTBONUS, int NUMOFCOUNTRIESINCONTINENT, ArrayList NEIGHBOURS)
    {
        this.COUNTRYID = COUNTRYID;
        this.CONTINENT = CONTINENT;
        this.CONTINENTBONUS = CONTINENTBONUS;
        this.NUMOFCOUNTRIESINCONTINENT = NUMOFCOUNTRIESINCONTINENT;
        this.NEIGHBOURS = NEIGHBOURS;
    }



}
