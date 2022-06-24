package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private final String name;
    private final int capacity;
    private final List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if (this.roster.size()<this.capacity){
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : this.roster){
            if (player.getName().equals(name)){
                return this.roster.remove(player);
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : this.roster){
            if (player.getName().equals(name)){
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : this.roster){
            if (player.getName().equals(name)){
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<Player> inputs = new ArrayList<>();

        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getClazz().equals(clazz)){
                inputs.add(player);
                this.roster.remove(player);
                i--;
            }
        }

        Player[] players = new Player[inputs.size()];
        for (int i = 0; i < players.length; i++) {
            players[i] = inputs.get(i);
        }
        return players;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:",this.name)).append(System.lineSeparator());
        for (int i = 0; i < this.roster.size(); i++) {
            builder.append(this.roster.get(i));
            if (i < this.roster.size()-1){
                builder.append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
