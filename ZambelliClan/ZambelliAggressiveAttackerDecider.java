package ZambelliClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * @author zambeezy
 */
public class ZambelliAggressiveAttackerDecider implements ActionPointDecider
{
    private int actionPoints;

    public ZambelliAggressiveAttackerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
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
