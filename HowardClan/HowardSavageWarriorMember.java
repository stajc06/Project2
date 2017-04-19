package HowardClan;

import java.util.ArrayList;
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class HowardSavageWarriorMember extends Clan {

    public HowardSavageWarriorMember(int clanID)
    {
        super("Howard Savage Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<ClanMember>();

        ActionPointDecider decider = new HowardSavageWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .30);
        while (adjHitPoints > 0) {
            int nextHP = 801;
            if (adjHitPoints < 801)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
