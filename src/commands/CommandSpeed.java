package commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandSpeed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean isNotSelfEffect = false;
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(args.length == 0 || args.length > 3) {
				return false;
			}
			
			try {
			
				if(args.length >=1) {
					
					try {
						int i = Integer.parseInt(args[0]);
					}catch (Exception e) {
						isNotSelfEffect = true;
					}
					
					if(isNotSelfEffect == true) {
						
						Player target = Bukkit.getPlayer(args[0]);
						
						if (target != null) {
							
							if(args.length >=2) {
								int amplifier = Integer.valueOf(args[1]);
								if(args.length == 3) {
									int duration = Integer.valueOf(args[2]);
									target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration*20, amplifier), true);
									player.sendMessage("§aVous avez donné à §b" + target.getName() + " §al'effet de speed §b" + amplifier + " §apendant §b" + duration + "s");
									target.sendMessage("§aVous avez reçu l'effet de speed §b" + amplifier + " §apendant §b" + duration + "s");
								}else {
									target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60*20, amplifier), true);
									player.sendMessage("§aVous avez donné à §b" + target.getName() + " §al'effet de speed §b" + amplifier + " §apendant §b60s");
									target.sendMessage("§aVous avez reçu l'effet de speed §b" + amplifier + " §apendant §b60s");
								}
							}else {
								target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60*20, 1), true);
								player.sendMessage("§aVous avez donné à §b" + target.getName() + " §al'effet de speed §b1 §apendant §b60s");
								target.sendMessage("§aVous avez reçu à l'effet de speed §b1 §apendant §b60s");
							}
						}else {
							sender.sendMessage("§4[Erreur]: le joueur spécifié n'est pas connecter");
						}
					}else {
						
						if(args.length > 2) {
							return false;
						}
						if(args.length >=1) {
							int amplifier = Integer.valueOf(args[0]);
							if(args.length >= 2) {
								int duration = Integer.valueOf(args[1]);
								player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration*20, amplifier), true);
								player.sendMessage("§aVous avez maintenant l'effet de speed §b" + amplifier + " §apendant §b" + duration + "s");
							}else {
								player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60*20, amplifier), true);
								player.sendMessage("§aVous avez maintenant l'effet de speed §b" + amplifier + " §apendant §b60s");
							}
						}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				sender.sendMessage("§4[Erreur]: seul les nombres sont acceptés");
			}
		}else {
			sender.sendMessage("§4[Erreur]: Vous devez etre un joueur pour executer cette commande");
		}
		return true;
	}
}
