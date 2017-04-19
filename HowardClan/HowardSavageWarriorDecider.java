package HowardClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class HowardSavageWarriorDecider implements ActionPointDecider {

    private int actionPoints;

    public HowardSavageWarriorDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDs = (me.getClanID() == other.getClanID());

        if (!clanIDs) {
            if (other.getType().equals(HEALER)) {
                return this.actionPoints;
            }
            else {
                return other.getActionPoints(other) + 1;
            }
        }
        else {
            return 0;
        }
    }
}
