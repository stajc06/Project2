package HowardClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class HowardNiceHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public HowardNiceHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDs = me.getClanID() == other.getClanID();

        int difference = other.getMaxHitPoints() - other.getHitPoints();

        if (clanIDs) {
            if (difference > 10) {
                return difference;
            }
            else {
                return actionPoints;
            }
        }
        else {
            return 0;
        }
    }
}
