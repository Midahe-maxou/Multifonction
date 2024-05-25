package commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandBottlexp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		int level;
		
		
		
		if(sender instanceof Player) {
			
			ItemStack bottlexp = new ItemStack(Material.EXP_BOTTLE);
			ItemMeta itemMeta = bottlexp.getItemMeta();

			Player player = (Player) sender;
			
			if(player.getLevel() != 0) {
	
				if(args.length == 0) {
					if(player.getInventory().firstEmpty() != -1) {
						
						level = player.getLevel();
						
						itemMeta.setDisplayName("§b§lLevel : " + level);
						bottlexp.setItemMeta(itemMeta);
						player.setLevel(0);
						player.getInventory().addItem(bottlexp);
						player.sendMessage("§aVous avez transformé §b" + level + " §aniveaux en bouteille");
						
					}else {
						player.sendMessage("§cVous n'avez pas asser de place dans votre inventaire pour vos bouteille d'exp");
					}
				}else if(args.length == 1) {
					
					try {
						level = Integer.valueOf(args[0]);
					}catch(Exception e) {
						e.printStackTrace();
						sender.sendMessage("§4[Erreur]: seul les nombres sont acceptés");
						return true;
					}
					
					if(player.getLevel() >= level) {
						itemMeta.setDisplayName("§b§lLevel : " + level);
						bottlexp.setItemMeta(itemMeta);
						player.setLevel(player.getLevel() - level);
						player.getInventory().addItem(bottlexp);
						player.sendMessage("§aVous avez transformé §b" + level + " §aniveaux en bouteille");
					}else {
						player.sendMessage("§4[erreur]: Vous n'avez pas assez de niveaux");
					}
					
				}else {
					return false;
				}

			}else {
				player.sendMessage("§4[erreur]: Vous n'avez pas assez de niveaux");
			}
		}else {
			sender.sendMessage("§4[Erreur]: Vous devez etre un joueur pour executer cette commande");
		}


		return true;
	}
}
