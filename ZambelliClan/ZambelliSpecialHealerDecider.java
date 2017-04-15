package ZambelliClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * @author zambeezy
 */
public class ZambelliSpecialHealerDecider implements ActionPointDecider
{
    private int actionPoints;

    public ZambelliSpecialHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other)
    {
        return 0;
    }
}
