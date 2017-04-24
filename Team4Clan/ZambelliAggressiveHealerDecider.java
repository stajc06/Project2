package Team4Clan;

/**
 * @author zambeezy
 */
public class ZambelliAggressiveHealerDecider implements clanmelee.ActionPointDecider
{
    private int actionPoints;

    public ZambelliAggressiveHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
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
