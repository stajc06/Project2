package ClanCarr;

/**
 * Created by andrew on 4/17/17.
 */

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class CarrHealerMember extends clanmelee.Clan {

    public CarrHealerMember(int ClanID) {
        super("Carr Healer", ClanID);
    }

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {
        ArrayList<clanmelee.ClanMember> clanMembers = new ArrayList<>();

        clanmelee.ActionPointDecider decider = new CarrHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .35);
        while (adjHitPoints > 0) {
            int nextHP = 500;
            if (adjHitPoints < 500)
                nextHP = adjHitPoints;

            clanMembers.add(new clanmelee.ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
