package ClanCarr;

/**
 * Created by andrew on 4/17/17.
 */

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class CarrFighterDecider implements clanmelee.ActionPointDecider {
    private int actionPoints;

    public CarrFighterDecider(int actionPoints){
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other){
        boolean clanIDsMatch = me.getClanID() == other.getClanID();
        if(!clanIDsMatch){
            if(other.getMaxHitPoints() == other.getHitPoints()){
                if(other.getType() == WARRIOR){
                    return (actionPoints * 3);
                }
                if(other.getType() == HEALER){
                    return (actionPoints * 2);
                }
            }
            else{
                if(other.getType() == WARRIOR){
                    return (actionPoints * 2);
                }
                return actionPoints;
            }
        }
        return 0;
    }
}

