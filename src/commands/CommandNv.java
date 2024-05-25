package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandNv implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		PotionEffectType night_vision = PotionEffectType.NIGHT_VISION;
		
		if(sender instanceof Player) {
			
			if(!((Player) sender).hasPotionEffect(night_vision)) {
				((Player) sender).addPotionEffect(new PotionEffect(night_vision, 1000000000, 1));
				
			}else {
				((Player) sender).removePotionEffect(night_vision);
				sender.sendMessage("§bVous avez §4désactivé §bl'effet de vision nocturne");
			}
		}
		return false;	
	}
}
