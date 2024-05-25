package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
		
		if (sender instanceof Player) {
			
			String DisplayName = ((Player) sender).getDisplayName();
			
			if(args.length == 1) {
				
				String newDisplayName = args[0];
				
				if(((Player) sender).getDisplayName().equals(newDisplayName)) {
					sender.sendMessage("§4Vous êtes déja nommé §e" + newDisplayName);
					return true;
				}
				
				((Player) sender).setDisplayName(newDisplayName);
				sender.sendMessage("§eVous avez bien changer votre pseudo de §v" + sender.getName() + " §eà §b" + newDisplayName);
				
			}else if(DisplayName != sender.getName() || args.length == 0) {
				
				((Player) sender).setDisplayName(sender.getName());
				sender.sendMessage("§eVous avez bien remis votre vrai Pseudo : §b" + sender.getName());
				
			}else {
				return false;
			}
		}
		return true;
	}
}