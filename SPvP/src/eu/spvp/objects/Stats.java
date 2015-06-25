package eu.spvp.objects;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Stats {

	private User p;
	private UUID uuid;

	private FileConfiguration data;
	private File config;

	private int kills = 0;
	private int deaths = 0;
	private int killstreak = 0;
	private int maxkillstreak = 0;
	private double ratio = 0;
	private int score = 0;

	public Stats(User p) {
		this.p = p;
		this.uuid = p.getUUID();
		
		config = p.getConfig();
		data = p.getData();
	}

	public Stats(File file) {
		config = file;
		data = YamlConfiguration.loadConfiguration(config);
		
		String[] args = data.getString("stats").split("#");
		setKills(Integer.valueOf(args[0]));
		setDeaths(Integer.valueOf(args[1]));
		setMaxKillstreak(Integer.valueOf(args[2]));
	}

	public User getPlayer() {
		return p;
	}

	public UUID getUUID() {
		return uuid;
	}

	public FileConfiguration getData() {
		return data;
	}

	public File getFile() {
		return config;
	}

	public int getKills() {
		return kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public int getKillstreak() {
		return killstreak;
	}

	public int getMaxKillstreak() {
		if(killstreak > maxkillstreak) maxkillstreak = killstreak;
		return maxkillstreak;
	}

	public double getRatio() {
		if(deaths != 0) {
			ratio = Math.round(((double)kills/(double)deaths) * 100.0D) / 100.0D;
			/*DecimalFormat format = new DecimalFormat();
			format.setMaximumFractionDigits(1);
			format.setMinimumFractionDigits(1);
			format.setDecimalSeparatorAlwaysShown(true); 
			ratio = Double.valueOf(format.format(ratio));
			 */
		} else {
			ratio = kills;
		}
		return ratio;
	}

	public int getScore() {
		score = kills - deaths;
		return score;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public void setKillstreak(int killstreak) {
		this.killstreak = killstreak;
	}
	
	public void setMaxKillstreak(int maxkillstreak) {
		this.maxkillstreak = maxkillstreak;
	}

	public void save() {
		try {
			String serialize = getKills() + "#" + getDeaths() + "#" + getMaxKillstreak() + "#" + getKillstreak() + "#" + getRatio() + "#" + getScore();
			getData().set("stats", serialize);
			getData().save(getFile());
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§4§lCannot save the stats of " + getPlayer().getPlayer().getName());
		}
	}
}
