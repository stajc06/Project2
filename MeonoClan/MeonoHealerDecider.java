package MeonoClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;



public class MeonoHealerDecider implements ActionPointDecider {
    private int actionpoints;

    public MeonoHealerDecider(int actionpoints){
        this.actionpoints = actionpoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember opp){
        boolean clansIDMatch = self.getClanID() == opp.getClanID();

        if(clansIDMatch){
            return actionpoints;
        }
        else
            return 0;
    }
}
