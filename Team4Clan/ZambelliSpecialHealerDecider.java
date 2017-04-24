package Team4Clan;

/**
 * @author zambeezy
 */
public class ZambelliSpecialHealerDecider implements clanmelee.ActionPointDecider
{
    private int actionPoints;

    public ZambelliSpecialHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other)
    {
        return 0;
    }
}
