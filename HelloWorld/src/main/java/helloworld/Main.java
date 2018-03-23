package helloworld;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	
	public void onEnable() {
		getLogger().info("Enabled. Have fun!");
	}
	
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String albel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ayy")) {
			Player player = (Player) sender;
			String name = sender.getName();
			player.sendMessage(ChatColor.GREEN + name + " lmao my dude");
			return true;
		}
		else {
			return false;
		}
	}

}
