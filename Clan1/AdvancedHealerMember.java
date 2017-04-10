package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class AdvancedHealerMember extends Clan{

    public AdvancedHealerMember(int clanID) {
        super("Advanced Healer", clanID);
    }

    /**
     * Creates an ArrayList of all clan members of the AdvancedHealer class using hitPoints as the total hit point value
     *
     * @param hitPoints the number of hit points to be distributed amongst all the AdvancedHealer class clan members
     * @return An ArrayList containing all AdvancedHealer class clan members
     *
     */

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new AdvancedHealerDecider(20);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 600;
            if (adjHitPoints < 600)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
