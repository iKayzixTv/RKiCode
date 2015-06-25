package eu.spvp.objects;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

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
		
	}
	
	public User(File user) {
		
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

}
