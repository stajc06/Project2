package clanmelee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class creates a hashmap of clans with their unique ID as the key
 * and the name of the clan as the value.
 */

public class TotalWinsOfClans {
    private HashMap<Integer, ClanWins> totalWinsOfClans = new HashMap<>();
    private int maxNameWidth = 0;

    /**
     *
     * @return int - the number of clans in the HashMap
     */
    public int clanCount() {
        return totalWinsOfClans.size();
    }

    /**
     * Adds a clan to the HashMap
     * @param clanID - integer ID number for the clan being added
     * @param clanName - name of the clan that is being created
     */
    public void addClan(int clanID, String clanName) {
        totalWinsOfClans.put(clanID, new ClanWins(clanName));
        if (clanName.length() > maxNameWidth)
            maxNameWidth = clanName.length();
    }

    /**
     * Adds a win to the number of wins for a victorious clan
     * @param victorID - integer ID of the winning clan
     */
    public void addWin(int victorID) {
        totalWinsOfClans.get(victorID).addWin();
    }

    /**
     * Prints out the name of each clan and its corresponding number of wins
     */
    public void print() {
        ArrayList<ClanWins> arrayWins = new ArrayList<>();
        arrayWins.addAll(totalWinsOfClans.values());
        Collections.sort(arrayWins);
        String line = "+";
        for (int i = 0; i < maxNameWidth + 6; i++) // creates box around the clans in the round
            line += "-";
        line += "+";
        System.out.println(line);
        for (ClanWins wins : arrayWins) {
            System.out.println(String.format("| %" + maxNameWidth + "s: %-3s|",
                    wins.getName(), wins.getWins())); //prints the clan with its corresponding number of wins
        }
        System.out.println(line);
    }
}
