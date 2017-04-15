package clanmelee;

import ZambelliClan.ZambelliClan;
import clanmelee.Clan1.Clan1;
import clanmelee.Clan2.Clan2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Creates a list of clans with unique ID's
 */
public class ClanFactory {
    public Collection<Clan> getClans() {
        ArrayList<Clan> clans = new ArrayList<Clan>();

        int clanID = 0;

        clans.add(new Clan1(clanID++));
        clans.add(new Clan2(clanID++));
        clans.add(new ZambelliClan(clanID++));


        return clans;
    }
}
