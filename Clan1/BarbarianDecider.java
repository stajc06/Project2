package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class BarbarianDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     *
     * @param actionPoints the number of points all Barbarian class clan members will damage enemies
     */

    public BarbarianDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param me self
     * @param other target of interaction
     * @return number of action points to be used in interaction
     * Returns 0 if clanMember other is from the same clan as clanMember me.  Otherwise, returns default amount
     * of actionPoints
     */

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch)
            return actionPoints;
        else
            return 0;
    }
}
