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
    
        public void run() {
        gameEngine = new TournamentGameEngine();
        System.out.println("Enter command to start the tournament mode");
        Scanner sc = new Scanner(System.in);
        String l_command = sc.nextLine();
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
                System.out.println("Wrong command.");
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
