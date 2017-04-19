package MeonoClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;


public class MeonoHealerMember extends Clan{

    MeonoHealerMember(int clanID){
        super("Meono Healer", clanID);
    }
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints){
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new MeonoHealerDecider(10);

        int adjHitPoints = (int) (hitPoints * .15);
        while(adjHitPoints > 0){
            int nextHP = 200;
            if(adjHitPoints < 200){
                nextHP = adjHitPoints;
            }
            clanMembers.add(new ClanMember(getClanID(),HEALER,nextHP,decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
