package de.greenman1805.statsextra;

import java.util.UUID;

public class StatsAPI {


	
	public static int getKills(UUID uuid) {
		return Main.cfg.getInt(uuid + ".kills");
	}

	public static void addKill(UUID uuid) {
		int kills = Main.cfg.getInt(uuid.toString() + ".kills") + 1;
		Main.cfg.set(uuid + ".kills", kills);
	}
	
	public static int getDeaths(UUID uuid) {
		return Main.cfg.getInt(uuid + ".deaths");
	}

	public static void addDeath(UUID uuid) {
		int deaths = Main.cfg.getInt(uuid.toString() + ".deaths") + 1;
		Main.cfg.set(uuid + ".deaths", deaths);
	}
}
