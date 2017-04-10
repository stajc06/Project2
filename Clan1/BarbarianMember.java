package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class BarbarianMember extends Clan {

    public BarbarianMember(int clanID) {
        super("Barbarian", clanID);
    }

    /**
     * Creates an ArrayList of all clan members of the Barbarian class using hitPoints as the total hit point value
     *
     * @param hitPoints the number of hit points to be distributed amongst all the Barbarian class clan members
     * @return An ArrayList containing all Barbarian class clan members
     *
     */

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new BarbarianDecider(10);

        int adjHitPoints = (int)(hitPoints * .30);
        while (adjHitPoints > 0) {
            int nextHP = 500;
            if (adjHitPoints < 500)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
