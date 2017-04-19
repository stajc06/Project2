package HowardClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class HowardHealerMember extends Clan {

    public HowardHealerMember(int clanID)
    {
        super("Howie Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<ClanMember>();

        ActionPointDecider decider = new HowardHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 201;
            if (adjHitPoints < 201)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
