package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class AssassinMember extends Clan {

    public AssassinMember(int clanID) {
        super("Assassin", clanID);
    }

    /**
     * Creates an ArrayList of all clan members of the Assassin class using hitPoints as the total hit point value
     *
     * @param hitPoints the number of hit points to be distributed amongst all the Assassin class clan members
     * @return An ArrayList containing all Assassin class clan members
     *
     */

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new AssassinDecider(16);

        int adjHitPoints = (int)(hitPoints * .40);
        while (adjHitPoints > 0) {
            int nextHP = 900;
            if (adjHitPoints < 900)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
