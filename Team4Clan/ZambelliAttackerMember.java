package Team4Clan;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * @author zambeezy
 */
public class ZambelliAttackerMember extends clanmelee.Clan
{
    public ZambelliAttackerMember(int clanID)
    {
        super("Zambelli Attacker", clanID);
    }

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {
        ArrayList<clanmelee.ClanMember> clanMembers = new ArrayList<>();

        clanmelee.ActionPointDecider decider = new Team4Clan.ZambelliAttackerDecider(10);

        int adjHitPoints = (int)(hitPoints * .25);
        while (adjHitPoints > 0) {
            int nextHP = 900;
            if (adjHitPoints < 900)
                nextHP = adjHitPoints;

            clanMembers.add(new clanmelee.ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}

