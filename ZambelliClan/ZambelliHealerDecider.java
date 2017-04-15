package ZambelliClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * @author zambeezy
 */
public class ZambelliHealerDecider implements ActionPointDecider
{
    private int actionPoints;

    public ZambelliHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
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
