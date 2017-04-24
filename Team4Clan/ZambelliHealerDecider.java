package Team4Clan;

/**
 * @author zambeezy
 */
public class ZambelliHealerDecider implements clanmelee.ActionPointDecider
{
    private int actionPoints;

    public ZambelliHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch)
        {
            return actionPoints;
        }
        else
        {
            return 0;
        }
    }
}
