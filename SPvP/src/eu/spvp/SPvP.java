package eu.spvp;

import org.bukkit.plugin.java.JavaPlugin;

import eu.spvp.commands.CommandsManager;
import eu.spvp.enums.Kits;

public class SPvP extends JavaPlugin {
	
	protected static SPvP instance;
	
	@Override
	public void onEnable() {
	
		instance = this;
		
		CommandsManager.invokeRegister();
		Kits.invokeRegister();
	}
	
	public static SPvP getPlugin() {
		return instance;
	}

}
