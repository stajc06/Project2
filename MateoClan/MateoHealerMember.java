package MateoClan;

import java.util.ArrayList;
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

/**
 * Created by laurenmateo on 4/18/17.
 */
public class MateoHealerMember extends Clan{

    public MateoHealerMember(int clanID) {
        super("Mateo Healer", clanID);
    }



    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new MateoHealerDecider(20);

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
