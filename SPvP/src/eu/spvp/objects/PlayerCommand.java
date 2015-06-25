package eu.spvp.objects;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class PlayerCommand implements CommandExecutor {

	private String command, permission;

	public PlayerCommand(String command, String permission) {
		this.command = command;
		this.permission = permission;
	}	

	public PlayerCommand(String command) {
		this.command = command;
		this.permission = null;
	}	

	public abstract void onPlayerCommand(String[] args, Player p);

	@Override
	public boolean onCommand(CommandSender sender, Command command,  String label, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player p = (Player) sender;
		if(command.getName().equalsIgnoreCase(this.command)) {
			if(permission == null) {
				onPlayerCommand(args, p);
			} else {
				if(p.hasPermission(permission)) {
					onPlayerCommand(args, p);
				}
			}
		}
		return false;
	}

	public String getCommand() {
		return command;
	}

	public String getPermission() {
		return permission;
	}
}
