package clanmelee;

/**
 * Class to keep track fo the number of clans, hitPoints for each clan, number of players for each clan,
 * number of warriors and healers for each clan.
 */
public class ClanStats {
    private final int totalClanCount;
    private int[] hitPoints;
    private int[] playerCounts;
    private int[] warriorCounts;
    private int[] healerCounts;

    /**
     * Initializes the length of the Lists of ints to the length of clanCount
     * @param clanCount int - number of clans that are involved
     */
    public ClanStats(int clanCount) {
        this.totalClanCount = clanCount;
        this.hitPoints = new int[clanCount];
        this.playerCounts = new int[clanCount];
        this.warriorCounts = new int[clanCount];
        this.healerCounts = new int[clanCount];
    }

    /**
     * Adds a ClanMember to playCounts and healerCounts or warriorCounts
     * @param p ClanMember - the clanMember to add to playerCounts and healerORwarriorCounts
     */
    public void addPlayer(ClanMember p) {
        int clanID = p.getClanID();
        hitPoints[clanID] += p.getHitPoints();
        playerCounts[clanID] += 1;
        if (p.getType() == ClanMember.ClanMemberType.HEALER)
            healerCounts[clanID] += 1;
        else if (p.getType() == ClanMember.ClanMemberType.WARRIOR)
            warriorCounts[clanID] += 1;
    }

    /**
     * Getter method for the number of hit point a specific clan has
     * @param clanID int - the ID of the clan desired
     * @return int - the number of hit points a clan has
     */
    public int getHitPoints(int clanID) {
        return hitPoints[clanID];
    }

    /**
     * Getter method for the number of players in a specific clan
     * @param clanID int - the ID of the desired clan
     * @return int - the number of player in the clan
     */
    public int getPlayerCount(int clanID) {
        return playerCounts[clanID];
    }

    /**
     * Getter method for the number of warriors in a specific clan
     * @param clanID int - the ID of the desired clan
     * @return int - the number of warriors in the clan
     */
    public int getWarriorCount(int clanID) {
        return warriorCounts[clanID];
    }

    /**
     * Getter method for the number of healers in a specific clan
     * @param clanID int - the ID of the desired clan
     * @return int - the number of healers in the clan
     */
    public int getHealerCount(int clanID) {
        return healerCounts[clanID];
    }

    /**
     * Getter method for the total number of players involved for all clans
     * @return int - all the players involved for all clans
     */
    public int getClanCount() {
        int clanCount = 0;
        for (int i = 0; i < totalClanCount; i++) {
            if (playerCounts[i] != 0)
                clanCount += 1;
        }
        return clanCount;
    }

    /**
     * Getter method to return the ID of the clan with the most hit points 'the winner'
     * @return int - the ID of the winning clan
     */
    public int getWinner() {
        int max = 0;
        int maxID = 0;

        for (int i = 0; i < totalClanCount; i++) {
            if (hitPoints[i] > max) {
                max = hitPoints[i];
                maxID = i;
            }
        }

        return maxID;
    }
}
