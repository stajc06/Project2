package ClanCarr;

/**
 * Created by andrew on 4/17/17.
 */

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class CarrFighterMember extends clanmelee.Clan {

    public CarrFighterMember(int clanID){
        super("Carr Fighter", clanID);
    }

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {
        ArrayList<clanmelee.ClanMember> clanMembers = new ArrayList<>();

        clanmelee.ActionPointDecider decider = new CarrFighterDecider(10);

        int adjHitPoints = (int)(hitPoints * .65);
        while (adjHitPoints > 0) {
            int nextHP = 600;
            if (adjHitPoints < 600)
                nextHP = adjHitPoints;

            clanMembers.add(new clanmelee.ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
