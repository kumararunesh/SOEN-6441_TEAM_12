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
            else{
                System.out.println("Wrong Command.");
            }

            if(l_commandSplit[3].split(" ")[0].equalsIgnoreCase("g"))
            {
                numberofgames= Integer.parseInt(l_commandSplit[3].split(" ")[1]);

            }
            else
            {
                System.out.println("Wrong Command");
            }

            if(l_commandSplit[4].split(" ")[0].equalsIgnoreCase("d"))
            {
                maxnumberofturns = Integer.parseInt(l_commandSplit[4].split(" ")[1]);
            }
            else
            {
                System.out.println("Wrong Command");
            }
        }
        else
        {
            System.out.println("Enter the correct command");
        }
         for (int i = 0; i < 1; i++) {
            System.out.println("Map" + listOfMapFiles[i] + " : ");
            d_file = new File("src/main/resources/maps/" + listOfMapFiles[i]);

            // PLAYERS_LIST.put(players);
            for(int t = 0 ; t<d_playersName.length -1 ; t++)
            {
                PLAYERS_LIST.put(d_playersName[t], new Player(d_playersName[t]));
            }
