package GleasonClan;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
/**
 * Created by johngleason on 4/19/17.
 */
public class GleasonWarriorMember extends clanmelee.Clan{

    public GleasonWarriorMember(int clanID) {
        super("Gleason Warrior", clanID);
    }

    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {
        ArrayList<clanmelee.ClanMember> clanMembers = new ArrayList<>();

        clanmelee.ActionPointDecider decider = new GleasonWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .40);
        while (adjHitPoints > 0) {
            int nextHP = 900;
            if (adjHitPoints < 900)
                nextHP = adjHitPoints;

            clanMembers.add(new clanmelee.ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }


}
