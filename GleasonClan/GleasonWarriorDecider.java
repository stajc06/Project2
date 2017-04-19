package GleasonClan;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by johngleason on 4/19/17.
 */
public class GleasonWarriorDecider implements clanmelee.ActionPointDecider {
    private int actionPoints;

    public GleasonWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember self, clanmelee.ClanMember other) {
        boolean clanIDsMatch = self.getClanID() == self.getClanID();

        if (!clanIDsMatch && other.getType() == WARRIOR) {
            if (other.getHitPoints() < (self.getHitPoints() / 2)) {
                return actionPoints * 2;
            } else if (other.getHitPoints() < (self.getHitPoints())) {
                return actionPoints;
            } else {
                return 10;
            }

        }
        return 0;
    }
}
