package eu.spvp.objects;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import eu.spvp.SPvP;

public class User {

	private Player player;
	private UUID uuid;

	private FileConfiguration data;
	private File config;

	private Kit last_kit;

	private boolean pvp = false;

	private Long money = 0l;

	private Stats stats;

	public User(Player p) {
		this.player = p;
		this.uuid = p.getUniqueId();

		this.config = new File(SPvP.getPlugin().getDataFolder(), "User-" + p.getUniqueId().toString() + ".yml");
		this.data = YamlConfiguration.loadConfiguration(config);

		stats = new Stats(this);
		save();
	}

	public User(File user) {
		this.config = user;
		this.data = YamlConfiguration.loadConfiguration(config);

		this.player = Bukkit.getPlayer(UUID.fromString(data.getString("uuid")));
		this.uuid = player.getUniqueId();
		
		setMoney(data.getLong("money"));

		stats = new Stats(user);
	}

	public Player getPlayer() {
		return player;
	}

	public UUID getUUID() {
		return uuid;
	}

	public FileConfiguration getData() {
		return data;
	}

	public File getConfig() {
		return config;
	}

	public Kit getKit() {
		return last_kit;
	}

	public boolean canPvP() {
		return pvp;
	}

	public Long getMoney() {
		return money;
	}

	public Stats getStats() {
		return stats;
	}

	public void setKit(Kit kit) {
		last_kit = kit;
	}

	public void setPvP(boolean pvp) {
		this.pvp = pvp;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public void save() {	
		try {
			data.set("uuid", getUUID());
			data.set("name", getPlayer().getName());
			data.set("money", getMoney());

			stats.save();
			
			data.save(config);
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§4§lCannot save user " + getPlayer().getName());
		}
	}

}