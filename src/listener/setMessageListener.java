package listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class setMessageListener implements Listener {
	
	@EventHandler
	public void onJoin (PlayerJoinEvent e) {
		
		e.setJoinMessage("§b" + e.getPlayer().getName() + ChatColor.YELLOW + " vient de rejoindre le serveur");
		e.getPlayer().setDisplayName("§b" + e.getPlayer().getName() + "§r");
		
	}
	
	@EventHandler
	public void onQuit (PlayerQuitEvent e) {
		
		e.setQuitMessage("§b" + e.getPlayer().getName() + ChatColor.YELLOW + " a quitter le serveur");
	}
	
	@EventHandler
	public void onKick (PlayerKickEvent e) {
		
		e.setLeaveMessage("§b" + e.getPlayer().getName() + ChatColor.YELLOW + " s'est fait kick du serveur");
	}
}
