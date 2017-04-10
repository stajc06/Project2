package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class AdvancedHealerDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     *
     * @param actionPoints the number of points all AdvancedHealer class clan members will heal allies
     */

    public AdvancedHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param me self
     * @param other target of interaction
     * @return number of action points to be used in interaction
     * If clanMember other is from a different clan, return 0
     * If clanMember other is from the same clan and has less than half their maxHitPoints, return default actionPoints
     */

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch && other.getHitPoints() < (other.getMaxHitPoints() / 2))
            return actionPoints;
        else
            return 0;
    }
}
