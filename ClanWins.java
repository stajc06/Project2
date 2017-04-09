package clanmelee;

/**
 * This class creates one clan with its name
 * and initializes the clans number of wins
 * to zero
 */

public class ClanWins implements Comparable<ClanWins> {
    private String name;
    private Integer wins;

    /**
     * Constructor to create a class with the clan name as a parameter
     * which initializes the number of wins to zero.
     *
     * @param String name - the desired name of the clan being created
     */
    public ClanWins(String name) {
        this.name = name;
        this.wins = 0;
    }

    /**
     * Adds one win to the number of wins for a clan
     */
    public void addWin() {
        wins += 1;
    }

    /**
     * Getter method to get the name of the clan.
     *
     * @return string name - the name of the clan
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to get the number of wins that a clan has.
     *
     * @return int wins - number of wins that particular clan has
     */
    public int getWins() {
        return wins;
    }

    /**
     * Comparison method to compare clans according to the number of wins
     * each one has.
     * CompareTo returns -1 if this.clan has less wins than other.clan
     * CompareTo returns 0 if this.clan has equal wins as other.clan
     * CompareTo returns 1 if this.clan has more wins than other.clan
     *
     * @param ClanWins other - the clan that the current clan is being compared to
     * @return int -1 if this.clan.wins > other.clan.wins
     *         int 0 if this.clan.wins = other.clan.wins
     *         int 1 if this.clan.wins < other.clan.wins
     */
    @Override
    public int compareTo(ClanWins other) {
        return wins.compareTo(other.getWins()) * -1;
    }
}
