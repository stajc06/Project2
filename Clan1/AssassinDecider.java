package clanmelee.Clan1;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class AssassinDecider implements ActionPointDecider {
    private int actionPoints;

    /**
     *
     * @param actionPoints the base number of points all Assassin class clan members will damage enemies
     */

    public AssassinDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param me self
     * @param other target of interaction
     * @return number of action points to be used in interaction
     * If ClanMember other is WARRIOR type, and HitPoints of other are 1/3 * max or less, return triple actionPoints
     * If ClanMember other is HEALRER type, return double actionPoints
     */

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch && other.getType() == WARRIOR) {
            if (other.getHitPoints() <= (other.getMaxHitPoints() / 3)) {
                return actionPoints * 3;
            }
            else {
                return actionPoints;
            }
        }

        if (!clanIDsMatch && other.getType() == HEALER) {
            return actionPoints * 2;
        }
        return  0;
    }
}
