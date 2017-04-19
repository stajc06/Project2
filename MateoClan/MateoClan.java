package MateoClan;

import java.util.ArrayList;

import clanmelee.ClanMember;
import clanmelee.Clan;

/**
 * Created by laurenmateo on 4/18/17.
 */
public class MateoClan extends Clan{
    public MateoClan(int clanID) {

        super("MateoClan", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        MateoHealerMember MateoHealer = new MateoHealerMember(getClanID());
        MateoAttackerMember MateoAttacker = new MateoAttackerMember(getClanID());


        fullClanMembers.addAll(MateoHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(MateoAttacker.getClanMembers(hitPoints));


        return fullClanMembers;
    }
}
