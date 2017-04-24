package Team4Clan;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

/**
 * @author zambeezy
 */
public class ZambelliAggressiveAttackerDecider implements clanmelee.ActionPointDecider
{
    private int actionPoints;

    public ZambelliAggressiveAttackerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch)
        {
            if (other.getType() == HEALER)
                return 2 * actionPoints;
            else
                return other.getHitPoints();
        }
        else
        {
            return 0;
        }
    }
}
