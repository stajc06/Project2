package MateoClan;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by laurenmateo on 4/18/17.
 */
public class MateoHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public MateoHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember opponent) {
        boolean clanIDsMatch = me.getClanID() == opponent.getClanID();

        if (clanIDsMatch && opponent.getHitPoints() < (opponent.getMaxHitPoints() * (3/4))) {
            return actionPoints;
        } else {
            return 0;
        }
    }
}
