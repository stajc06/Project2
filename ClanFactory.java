package clanmelee;

import ClanCarr.ClanCarr;
import HowardClan.HowardClan;
import MeonoClan.MeonoClan;
import ZambelliClan.ZambelliClan;
import MateoClan.MateoClan;
import GleasonClan.GleasonClan;
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
        clans.add(new ClanCarr(clanID++));
        clans.add(new HowardClan(clanID++));
        clans.add(new MeonoClan(clanID++));
        clans.add(new MateoClan(clanID++));
        clans.add(new GleasonClan(clanID++));


        return clans;
    }
}
