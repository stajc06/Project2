package HowardClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class HowardSimpleWarriorDecider implements ActionPointDecider {

    private int actionPoints;

    public HowardSimpleWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember opponent) {
        boolean clanIDs = self.getClanID() == opponent.getClanID();

        if (!clanIDs) {
            if ((self.getHitPoints()-actionPoints > 0 && self.getHitPoints()*2 >= opponent.getHitPoints())) {
                return actionPoints + 1;
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

}
