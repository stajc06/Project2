/**
 * @author zambeezy
 */
package ZambelliClan;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class ZambelliClan extends Clan
{
    public ZambelliClan(int clanID)
    {
        super("ZambelliClan", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        ZambelliAttackerMember zam = new ZambelliAttackerMember(getClanID());
        ZambelliAggressiveAttackerMember zaam = new ZambelliAggressiveAttackerMember(getClanID());
        ZambelliHealerMember zhm = new ZambelliHealerMember(getClanID());
        ZambelliAggressiveHealerMember zahm = new ZambelliAggressiveHealerMember(getClanID());
        ZambelliSpecialHealerMember zshm = new ZambelliSpecialHealerMember(getClanID());

        fullClanMembers.addAll(zam.getClanMembers(hitPoints));
        fullClanMembers.addAll(zaam.getClanMembers(hitPoints));
        fullClanMembers.addAll(zhm.getClanMembers(hitPoints));
        fullClanMembers.addAll(zahm.getClanMembers(hitPoints));
        fullClanMembers.addAll(zshm.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}
