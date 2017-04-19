package MeonoClan;



import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;



public class MeonoWarriorDecider {
    private int actionPoints;

    public MeonoWarriorDecider(int actionPoints){
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember self, ClanMember opp) {
        boolean clanIDsMatch = self.getClanID() == self.getClanID();

        if (!clanIDsMatch && opp.getType() == WARRIOR) {
            if (opp.getHitPoints() <= (opp.getMaxHitPoints() / 3)) {
                return actionPoints * 3;
            }
            else {
                return actionPoints;
            }
        }

        if (!clanIDsMatch && opp.getType() == HEALER) {
            return actionPoints * 2;
        }
        return  0;
    }
}
