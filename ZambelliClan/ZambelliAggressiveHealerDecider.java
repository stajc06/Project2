package ZambelliClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * @author zambeezy
 */
public class ZambelliAggressiveHealerDecider implements ActionPointDecider
{
    private int actionPoints;

    public ZambelliAggressiveHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        int difference = other.getMaxHitPoints() - other.getHitPoints();

        if (clanIDsMatch)
        {
            if (difference > 10)
                return difference;
            else
                return actionPoints;
        }
        else
        {
            return 0;
        }
    }
}
