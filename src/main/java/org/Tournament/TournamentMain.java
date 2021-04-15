public class TournamentMain {

    String listOfMapFiles[] ;
    public static ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .
    public static ConcurrentHashMap<String, Country> COUNTRIES = new ConcurrentHashMap<>();
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

    String[] d_playersName;
    String winner;
    
       
