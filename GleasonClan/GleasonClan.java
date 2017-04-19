package GleasonClan;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;



public class GleasonClan extends Clan {
    public GleasonClan(int ClanID) { super("GleasonClan", ClanID);}

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        GleasonHealerMember gleasonHealer = new GleasonHealerMember(getClanID());
        GleasonWarriorMember gleasonWarrior = new GleasonWarriorMember(getClanID());

        fullClanMembers.addAll(gleasonHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(gleasonWarrior.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
