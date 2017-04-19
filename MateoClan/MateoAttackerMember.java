package MateoClan;


import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by laurenmateo on 4/18/17.
 */
public class MateoAttackerMember extends Clan{

    public MateoAttackerMember(int clanID) {
        super("MateoAttackerMember", clanID);
    }



    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new MateoAttackerDecider(10);

        int adjHitPoints = (int)(hitPoints * .30);
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
