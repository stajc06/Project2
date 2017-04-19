package HowardClan;


import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class HowardHealerDecider implements ActionPointDecider {

    private int actionPoints;

    public HowardHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDs = me.getClanID() == other.getClanID();

        if (clanIDs) {
            return this.actionPoints + 1;
        }
        else {
            return 0;
        }
    }
}
