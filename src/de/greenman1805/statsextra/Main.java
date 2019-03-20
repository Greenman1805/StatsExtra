package de.greenman1805.statsextra;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static YamlConfiguration cfg;

	@Override
	public void onEnable() {
		try {
			checkUserdataDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new CombatListener(this), this);
		cfg = loadPlayerData();
	}

	@Override
	public void onDisable() {
		savePlayerData(cfg);
	}

	private static YamlConfiguration loadPlayerData() {
		return YamlConfiguration.loadConfiguration(new File("plugins//StatsExtra//playerdata.yml"));
	}

	private static void savePlayerData(YamlConfiguration playerdata) {
		try {
			playerdata.save(new File("plugins//StatsExtra//playerdata.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkUserdataDirectory() throws IOException {
		File file1 = new File("plugins//StatsExtra");
		File file2 = new File("plugins//StatsExtra//playerdata.yml");

		if (!file1.isDirectory()) {
			file1.mkdir();
		}

		if (!file2.exists()) {
			file2.createNewFile();
		}
	}

}
