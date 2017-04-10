
package clanmelee;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ClanMelee {
    TotalWinsOfClans totalWinsOfClans = new TotalWinsOfClans();

    ArrayList<ClanMember> participants;
    int totalClanCount;
    ClanStats clanStats;
    String[] clanNames;
    // the maximum number of hit points
    public static final int HIT_POINT_CAP = 1000;
    // number of action points that do not cost additional iteration damage
    public static final int FREE_ACTION_POINTS = 10;
    // number of extra action points which cost a single iteration damage point
    public static final int ACTION_POINTS_PER_ITERATION_DAMAGE_POINT = 2;

    /**
     * Runs one round of interactions until one clan is left, or there is a winner
     * @param clans - the list of clans involved in the interaction
     * @param hitPoints - maximum number of hit points for the specific round
     */
    public void runMelee(Collection<Clan> clans, int hitPoints) {
        participants = new ArrayList<ClanMember>(); // initializes an ArrayList of all ClanMember involved
        totalClanCount = clans.size(); // number of clans in the collections 'clans'
        clanNames = new String[totalClanCount]; // initializes the length of the list of all clan names
        clanStats = new ClanStats(totalClanCount); // initializes a ClanStats object with the size of 'clans'

        createParticipantsList(clans, hitPoints);

        int clanCount = totalClanCount;

        int numInteractions = playRound(clanCount);

        printResults(clanCount, numInteractions);
    }

    /**
     * Runs the loop to play one round of clan melee until one team wins
     * or all teams are eliminated
     *
     * @param clanCount - the number of clans playing a round
     * @return numInteractions - report the number of interactions before a clan has won
     */
    private int playRound(int clanCount)
    {
        int numInteractions = 0;
        // initializes a list of booleans for each clan to say they were all alive
        boolean[] previouslyAlive = new boolean[totalClanCount];
        Arrays.fill(previouslyAlive, true);

        while (clanCount > 1) {
            Collections.shuffle(participants); // randomly order all clanMembers involved
            clanStats = new ClanStats(totalClanCount); // initialize clanStats with number of clans as argument
            // initialize list of booleans for each clan to say they are dead
            boolean[] currentlyAlive = new boolean[totalClanCount];
            Arrays.fill(currentlyAlive, false);
            // creates a list to keep track of the clanMembers still alive
            ArrayList<ClanMember> remaining = new ArrayList<ClanMember>(participants.size());
            // loop iterates 2 at a time so that one clanMember does not interact twice in a row
            performAllInteractions(currentlyAlive, remaining);

            // update clanCount to the number of clanMember left alive
            clanCount = clanStats.getClanCount();

            numInteractions += 1;

            // removes clans that have been eliminated
            reportEliminatedClan(currentlyAlive, previouslyAlive, numInteractions);

            // updates previously alive for next iteration
            previouslyAlive = currentlyAlive;

            // update participants to only the remaining left alive
            participants = remaining;
        }
        return numInteractions;
    }

    /**
     * Helper method to report that a clan has been eliminated
     * @param currentlyAlive - boolean[] the clans still alive
     * @param previouslyAlive - boolean[] the clans that were alive before the round
     * @param numInteractions - int the number of battles occured before elimination
     */
    private void reportEliminatedClan(boolean[] currentlyAlive, boolean[] previouslyAlive, int numInteractions)
    {
        for (int i = 0; i < totalClanCount; i++) {
            if (!currentlyAlive[i] && previouslyAlive[i]) {
                if (clanNames[i] == null)
                    continue;
                System.out.println(clanNames[i] + " eliminated after " +
                        numInteractions + " interactions");
            }
        }
    }

    /**
     * Helper method to perform all the interactions between participants
     * including the last player self inflicting damage
     *
     * @param currentlyAlive - the list of players currently alive
     * @param remaining - the list of player remaining alive after the interactions
     */
    private void performAllInteractions(boolean[] currentlyAlive, ArrayList<ClanMember> remaining)
    {
        for (int i = 0; i < participants.size() - 1; i += 2) {
            ClanMember p1 = participants.get(i);
            ClanMember p2 = participants.get(i + 1);

            // runs an interaction between adjacent clanMembers in the list
            runInteraction(p1, p2);
            // p1 wins, say he is alive
            addLivingPlayer(p1, currentlyAlive, remaining);
            // p2 wins, say he is alive
            addLivingPlayer(p2, currentlyAlive, remaining);
        }

        // if one clanMember is left over, make them inflict damage on themselves
        if (participants.size() % 2 == 1) {
            ClanMember lastPlayer = participants.get(participants.size() - 1);
            int lastID = lastPlayer.getClanID();
            lastPlayer.dealIterationDamage(0);
            // checks if last member is alive, adds him if he is
            addLivingPlayer(lastPlayer, currentlyAlive, remaining);
        }
    }

    /**
     * Helper method to create the list of all ClanMembers involved
     *
     * @param clans - collection the list of all clans
     * @param hitPoints - int the max number of hit points
     */
    private void createParticipantsList(Collection<Clan> clans, int hitPoints)
    {
        for (Clan clan : clans) {
            int clanID = clan.getClanID();
            String clanName = clan.getClanName();
            // adds each clan in clans to clansWins with ID as key, clanName as the value
            if (totalWinsOfClans.clanCount() < clans.size())
                totalWinsOfClans.addClan(clanID, clanName);
            // creates a collection of the clan member in a specific clan
            Collection<ClanMember> members = clan.getClanMembers(hitPoints);
            // ensures the clan is valid
            if (!validateClan(members, hitPoints, clanID, clan.getClanName()))
                continue;
            // adds name of the clan to the list of clanNames
            clanNames[clanID] = clan.getClanName();
            // adds all members of each clan to the list of participants
            participants.addAll(members);
            // adds each member to clanStats to keep track of hitPoints, wins, etc
            for (ClanMember member : members)
                clanStats.addPlayer(member);
        }
    }

    /**
     * Helper method that prints the results of a round.
     * Output changes depending on if there are 0 clans left or there was a winner.
     *
     * @param numClans - int the number of clans left
     * @param numInteractions - int the number of battles fought
     */
    private void printResults(int numClans, int numInteractions)
    {
        if (numClans == 0) {
            System.out.println("All were slain after " + numInteractions
                    + " interactions!");
        } // prints name of winning clan if not all eliminated
        else
        {
            int victorID = clanStats.getWinner();
            System.out.println(clanNames[victorID] + " emerged victorious after " +
                    numInteractions + " interactions!");
            totalWinsOfClans.addWin(victorID);
        }
    }

    /**
     * Helper method to add the players who lived through the last round
     * to the list of living players
     *
     * @param player - the ClanMember being queried
     * @param currentlyAlive - the list of living players
     * @param remaining - the list of remaining players
     */
    private void addLivingPlayer(ClanMember player, boolean[] currentlyAlive, ArrayList<ClanMember> remaining)
    {
        if (player.isAlive()) {
            clanStats.addPlayer(player);
            currentlyAlive[player.getClanID()] = true;
            remaining.add(player);
        }
    }

    /**
     * Performs 1 turn for clan members involved.
     * Uses 1 applyAction for each member.
     *
     * Sets up an interaction where p1 and p2 attack/heal one another
     *
     * @param p1 - the first ClanMember in an interaction
     * @param p2 - the second ClanMember in an interaction
     */
    private void runInteraction(ClanMember p1, ClanMember p2) {
        int p1Action = p1.getActionPoints(p2);
        int p2Action = p2.getActionPoints(p1);

        // performs the attacks or heals
        applyAction(p1, p1Action, p2, p2Action);
        applyAction(p2, p2Action, p1, p1Action);
    }

    /**
     * Performs heal action for HEALER clan member or
     * dealDamage action for other character.
     *
     * Performs the attack or heal action between two clanMembers
     *
     * @param p1 - the first clanMember in an interaction
     * @param p1Action - the number of points p1 has to attack or heal with
     * @param p2 - the second clanMember in an interaction
     * @param p2Action - the number of points p2 has to attack or heal with
     */
    private void applyAction(ClanMember p1, int p1Action,
                             ClanMember p2, int p2Action) {
        if (p1.getType() == HEALER)
            p2.heal(p1Action); // heals p2
        else {
            if (p2Action > 0 || Math.random() < 0.5)
                p2.dealDamage(p1Action); // attacks p2
        }
    }

    /**
     * Calls print method in TotalWinsOfClans class to print the name and
     * number of wins for each clan involved in the round
     */
    void printStats() {
        totalWinsOfClans.print();
    }

    /**
     * Checks for validity of each clan member within a clan.
     * If member's ID does not match overall clan's ID, clan is disqualified, and may not be used.
     * If clan has more total hit points than are allowed by game, then the clan is disqualified.
     * Otherwise, clan is valid.
     *
     */

    private boolean validateClan(Collection<ClanMember> members, int hitPoints,
                                 int clanID, String clanName) {
        int hitPointSum = 0;
        for (ClanMember cm : members) {
            if (cm.getClanID() != clanID) {
                System.out.println(clanName + " does not have consistent clan IDs!!");
                System.out.println(clanName + " DISQUALIFIED!!");
                return false;
            }
            hitPointSum += cm.getMaxHitPoints();
        }
        if (hitPointSum > hitPoints) {
            System.out.println(clanName + " has " + hitPointSum +
                    " hit points when only " + hitPoints + " are allowed!!");
            System.out.println(clanName + " DISQUALIFIED!!");
            return false;
        }
        return true;
    }
}

