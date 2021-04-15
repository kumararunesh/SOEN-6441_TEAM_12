public class TournamentMain {

    String listOfMapFiles[] ;
    public static ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .
    public static ConcurrentHashMap<String, Country> COUNTRIES = new ConcurrentHashMap<>();
    public HashMap<String,String> gameState = new HashMap<>();
    Country d_country;
    File d_file;
