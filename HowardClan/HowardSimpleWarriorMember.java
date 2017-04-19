package HowardClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class HowardSimpleWarriorMember extends Clan {

    public HowardSimpleWarriorMember(int clanID)
    {
        super("Howie Simple Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<ClanMember>();

        ActionPointDecider decider = new HowardSimpleWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .25);
        while (adjHitPoints > 0) {
            int nextHP = 901;
            if (adjHitPoints < 901)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}


