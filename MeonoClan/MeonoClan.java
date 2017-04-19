package MeonoClan;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;


public class MeonoClan extends Clan {

    public MeonoClan(int ClanID){
        super("MeonoClan", ClanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints){

        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        MeonoHealerMember meonoHealer = new MeonoHealerMember(getClanID());
        MeonoWarriorMember meonoWarrior = new MeonoWarriorMember(getClanID());

        fullClanMembers.addAll(meonoHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(meonoWarrior.getClanMembers(hitPoints));

        return fullClanMembers;
    }






}
