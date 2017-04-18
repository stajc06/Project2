package ClanCarr;

/**
 * Created by andrew on 4/17/17.
 */

import java.util.ArrayList;

public class ClanCarr extends clanmelee.Clan {

    public ClanCarr(int ClanID){
        super("ClanCarr", ClanID);
    }

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints){
        ArrayList<clanmelee.ClanMember> fullClanMembers = new ArrayList<>();

        CarrHealerMember carrHealer = new CarrHealerMember(getClanID());
        CarrFighterMember carrFighter = new CarrFighterMember(getClanID());

        fullClanMembers.addAll(carrHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(carrFighter.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
