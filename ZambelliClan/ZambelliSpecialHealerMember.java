package ZambelliClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

/**
 * @author zambeezy
 */
public class ZambelliSpecialHealerMember extends Clan
{
    public ZambelliSpecialHealerMember(int clanID)
    {
        super("Zambelli Special Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new ZambelliSpecialHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 300;
            if (adjHitPoints < 300)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }

}
