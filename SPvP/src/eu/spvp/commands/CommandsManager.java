package eu.spvp.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;

import eu.spvp.objects.PlayerCommand;

public class CommandsManager {

	public static HashMap<String, PlayerCommand> commands = new HashMap<String, PlayerCommand>();
	
	public static void invokeRegister() {
		
		//commands.put("name", new ClassDeLaCommand());
		
		for(PlayerCommand command : commands.values()) {
			Bukkit.getPluginCommand(command.getCommand()).setExecutor(command);
		}
	}
	
}
