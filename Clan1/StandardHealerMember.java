package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class StandardHealerMember extends Clan {

    public StandardHealerMember(int clanID) {
        super("Standard Healer", clanID);
    }

    /**
     * Creates an ArrayList of all clan members of the StandardHealer class using hitPoints as the total hit point value
     *
     * @param hitPoints the number of hit points to be distributed amongst all the StandardHealer class clan members
     * @return An ArrayList containing all StandardHealer class clan members
     *
     */

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new StandardHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 200;
            if (adjHitPoints < 200)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
