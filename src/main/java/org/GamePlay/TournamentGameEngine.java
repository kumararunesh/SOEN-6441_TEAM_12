public class TournamentGameEngine {
  /**
     * GLobal List of Players
     */
    public static ConcurrentHashMap<String, Player> PLAYERS_LIST = new ConcurrentHashMap<String, Player>(); // concurrent only - thread safe .
    public static ArrayList<String> Behaviours = new ArrayList<String>();
    public void set_Behaviour(){
        Behaviours.add("random");
        Behaviours.add("human");
        Behaviours.add("aggressive");
        Behaviours.add("cheater");
        Behaviours.add("benevolent");
    }
}
