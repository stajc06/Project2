package Team4Clan;

import HowardClan.*;

import java.util.ArrayList;

/**
 * Created by andrew on 4/22/17.
 */
public class Team4Clan extends clanmelee.Clan {

    public Team4Clan(int clanID){ super("Team4Clan", clanID);}

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<clanmelee.ClanMember> fullClanMembers = new ArrayList<>();

        if(hitPoints >= 5000 && hitPoints < 950000) {
            ZambelliAttackerMember zam = new ZambelliAttackerMember(getClanID());
            ZambelliAggressiveAttackerMember zaam = new ZambelliAggressiveAttackerMember(getClanID());
            ZambelliHealerMember zhm = new ZambelliHealerMember(getClanID());
            ZambelliAggressiveHealerMember zahm = new ZambelliAggressiveHealerMember(getClanID());
            Team4Clan.ZambelliSpecialHealerMember zshm = new Team4Clan.ZambelliSpecialHealerMember(getClanID());

            fullClanMembers.addAll(zam.getClanMembers(hitPoints));
            fullClanMembers.addAll(zaam.getClanMembers(hitPoints));
            fullClanMembers.addAll(zhm.getClanMembers(hitPoints));
            fullClanMembers.addAll(zahm.getClanMembers(hitPoints));
            fullClanMembers.addAll(zshm.getClanMembers(hitPoints));

        }
        else if( hitPoints < 5000){
            CarrHealerMember carrHealer = new CarrHealerMember(getClanID());
            Team4Clan.CarrFighterMember carrFighter = new Team4Clan.CarrFighterMember(getClanID());

            fullClanMembers.addAll(carrHealer.getClanMembers(hitPoints));
            fullClanMembers.addAll(carrFighter.getClanMembers(hitPoints));
        }
        else{
            HowardHealerMember howieHealer = new HowardHealerMember(getClanID());
            HowardNiceHealerMember niceHealer = new HowardNiceHealerMember(getClanID());
            HowardSavageWarriorMember howieSavage = new HowardSavageWarriorMember(getClanID());
            HowardSimpleWarriorMember simpleWarrior = new HowardSimpleWarriorMember(getClanID());

            fullClanMembers.addAll(howieHealer.getClanMembers(hitPoints));
            fullClanMembers.addAll(howieSavage.getClanMembers(hitPoints));
            fullClanMembers.addAll(niceHealer.getClanMembers(hitPoints));
            fullClanMembers.addAll(simpleWarrior.getClanMembers(hitPoints));
        }
        return fullClanMembers;
    }
}
