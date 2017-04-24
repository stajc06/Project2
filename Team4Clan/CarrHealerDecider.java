package Team4Clan;

/**
 * Created by andrew on 4/17/17.
 */

public class CarrHealerDecider implements clanmelee.ActionPointDecider {
    private int actionPoints;

    /**
     *
     * @param actionPoints the number of points all AdvancedHealer class clan members will heal allies
     */

    public CarrHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    /**
     *
     * @param me self
     * @param other target of interaction
     * @return number of action points to be used in interaction
     * if other is from different clan, return 0
     * i
     */

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch && other.getHitPoints() < (other.getMaxHitPoints() / 2))
            return actionPoints * 2;
        else if (clanIDsMatch && (other.getHitPoints() < other.getMaxHitPoints())){
            return actionPoints;
        }
        else {
            return 0;
        }
    }
}
