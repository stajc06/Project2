package GleasonClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
/**
 * Created by johngleason on 4/19/17.
 */
public class GleasonHealerDecider implements ActionPointDecider {
    private int actionpoints;

    public GleasonHealerDecider(int actionpoints){
        this.actionpoints = actionpoints;
    }
    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        if (me.getClanID() == other.getClanID()) {
            return actionpoints;
        }

        else
            return 0;


    }


}
