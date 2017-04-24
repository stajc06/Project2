package Team4Clan;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

/**
 * @author zambeezy
 */
public class ZambelliAttackerDecider implements clanmelee.ActionPointDecider
{
    private int actionPoints;

    public ZambelliAttackerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch)
        {
            if (other.getType() == HEALER)
                return actionPoints;
            else
                return actionPoints + 2;
        }
        else
        {
            return 0;
        }
    }
}
