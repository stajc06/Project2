package GleasonClan;
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.HEALER;
import java.util.ArrayList;

/**
 * Created by johngleason on 4/19/17.
 */
public class GleasonHealerMember extends clanmelee.Clan {
    GleasonHealerMember(int clanID){
        super("Gleason Healer", clanID);
    }

    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {

        ArrayList<clanmelee.ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new GleasonHealerDecider(20);

        int adjHitPoints = (int) (hitPoints * .15);
        while(adjHitPoints > 0){
            int nextHP = 600;
            if(adjHitPoints < 600){
                nextHP = adjHitPoints;
            }
            clanMembers.add(new ClanMember(getClanID(),HEALER,nextHP,decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }

}
