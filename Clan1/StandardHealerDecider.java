package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class StandardHealerDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     *
     * @param actionPoints the number of points all StandardHealer class clan members will heal allies
     */

    public StandardHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param me self
     * @param other target of interaction
     * @return number of action points to be used in interaction
     * If clanMember other is from the same clan as clanMember me, return default actionPoints.
     * Otherwise, return 0.
     */

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch) {
            return actionPoints;
        }
        else {
            return 0;
        }
    }
}
