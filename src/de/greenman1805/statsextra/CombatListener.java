package de.greenman1805.statsextra;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class CombatListener implements Listener {
	public Main m;

	public CombatListener(Main plugin) {
		this.m = plugin;
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerKill(PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = e.getEntity();
			if (p.getKiller() instanceof Player) {
				Player k = p.getKiller();
				if (p != k) {
					StatsAPI.addDeath(p.getUniqueId());
					StatsAPI.addKill(k.getUniqueId());
				}
			}
		}

	}

}
