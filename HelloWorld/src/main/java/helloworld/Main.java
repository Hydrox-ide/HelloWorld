package helloworld;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getLogger().info("Enabled. Have fun!");
		getConfig().addDefault("lmaoMSG", "&aAyy Lmao my Dude!");
		getConfig().addDefault("fuckMSG", "&cAyy Lmao no");
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if(event.getPlayer().hasPermission("helloworld.colour")) {
			String text = event.getMessage();
			String colouredText = ChatColor.translateAlternateColorCodes('&', text);
			event.setMessage(colouredText);
		}
		else if(event.getMessage().contains("&")){
			event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to use colour codes.");
			event.setCancelled(true);
		} else {
			return;
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String albel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("ayy") && sender.hasPermission("helloworld.ayy")) {
			
			Player player = (Player) sender;
			String Ayy = getConfig().getString("lmaoMSG");
			String colouredAyy = ChatColor.translateAlternateColorCodes('&', Ayy);
			player.sendMessage(colouredAyy);
			
			return true;
			
		}
		else if(!(sender.hasPermission("helloworld.ayy"))) {
			Player player = (Player) sender;
			String fuck = getConfig().getString("fuckMSG");
			String colouredFuck = ChatColor.translateAlternateColorCodes('&', fuck);
			player.sendMessage(colouredFuck);
			
			return true;

		}
		else {
			
			return false;
		}
	}

}
