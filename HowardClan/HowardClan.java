package HowardClan;

import java.util.ArrayList;
import clanmelee.Clan;
import clanmelee.ClanMember;

public class HowardClan extends Clan {

    public HowardClan(int clanID) {
        super("HowardClan", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {

        ArrayList<ClanMember> fullClanMembers = new ArrayList<ClanMember>();

        HowardHealerMember howieHealer = new HowardHealerMember(getClanID());
        HowardNiceHealerMember niceHealer = new HowardNiceHealerMember(getClanID());
        HowardSavageWarriorMember howieSavage = new HowardSavageWarriorMember(getClanID());
        HowardSimpleWarriorMember simpleWarrior = new HowardSimpleWarriorMember(getClanID());

        fullClanMembers.addAll(howieHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(howieSavage.getClanMembers(hitPoints));
        fullClanMembers.addAll(niceHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(simpleWarrior.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
