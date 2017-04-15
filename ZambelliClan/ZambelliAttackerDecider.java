package ZambelliClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * @author zambeezy
 */
public class ZambelliAttackerDecider implements ActionPointDecider
{
    private int actionPoints;

    public ZambelliAttackerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
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
