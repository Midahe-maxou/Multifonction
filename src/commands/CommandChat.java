package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandChat implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(cmd.getName().equalsIgnoreCase("alert")) {
			if(args.length == 0) {
				return false;
			}
			
			if(args.length >= 1) {
				
				StringBuilder bc = new StringBuilder();
				for(String part : args) {
					bc.append(part + " ");
				}
				if(sender.getName() != null) {
					if(sender.getName().equalsIgnoreCase("console")) {
						Bukkit.broadcastMessage(ChatColor.DARK_RED + bc.toString());
					}else {
						Bukkit.broadcastMessage(ChatColor.AQUA + "§o[" + sender.getName() + "]§r " + ChatColor.WHITE +  bc.toString());
					}
				}else {
					return false;
				}
			}
		}
		return true;
	}
}
