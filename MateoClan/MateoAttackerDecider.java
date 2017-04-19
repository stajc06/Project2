package MateoClan;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
/**
 * Created by laurenmateo on 4/18/17.
 */
public class MateoAttackerDecider implements ActionPointDecider{
    private int actionPoints;

    public MateoAttackerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember opponent) {
        boolean clanIDsMatch = me.getClanID() == opponent.getClanID();

        if (!clanIDsMatch) {
            if (opponent.getHitPoints()<opponent.getHitPoints()/2)
                return actionPoints+10;
            return actionPoints;
        }
        else {
            return 0;
        }
    }
}