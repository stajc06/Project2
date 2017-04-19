package HowardClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class HowardNiceHealerMember extends Clan {

    public HowardNiceHealerMember(int clanID)
    {
        super("Howie Nice Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<ClanMember>();

        ActionPointDecider decider = new HowardNiceHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 600;
            if (adjHitPoints < 600) {
                nextHP = adjHitPoints;
            }
            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
