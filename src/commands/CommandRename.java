package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandRename implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {

			if(((Player) sender).getInventory().getItemInMainHand().toString().contains("AIR")) {
				sender.sendMessage("§4[Erreur]: §cVous n'avez pas d'équipement à renommer");
				
			}else {

				org.bukkit.inventory.ItemStack item = ((Player) sender).getInventory().getItemInMainHand();
				ItemMeta itemMeta = ((Player) sender).getInventory().getItemInMainHand().getItemMeta();
				String badname = (((Player) sender).getInventory().getItemInMainHand()).getItemMeta().getDisplayName();
				String itemType = ((Player) sender).getInventory().getItemInMainHand().getType().toString();

				if(itemType.contains("SWORD") || itemType.contains("AXE") || itemType.contains("BOW") || itemType.contains("HELMET") || itemType.contains("CHESTPLATE") || itemType.contains("LEGGINGS") || itemType.contains("BOOTS")) {
					if(itemMeta.hasDisplayName()) {
						if(badname.contains("&")) {
							String goodname = badname.replaceAll("&", "§");
							String itemtype = itemType.replaceAll("_", " ");
							itemMeta.setDisplayName(goodname);
							item.setItemMeta(itemMeta);
							sender.sendMessage("Votre §b" + itemtype.toLowerCase() + " §ra été renommé en " + goodname);
	
						}else {
							sender.sendMessage("§4[Erreur]: §cVous devez renommer vote équippement avec la formule : & + chiffre/lettre correspondant à la couleur (/color)");
						}
					}else {
						sender.sendMessage("§4[ERREUR]: §cVous n'avez pas renommé votre pièce d'équipement");
					}
				}else {
					sender.sendMessage("§4[Erreur]: §cVous ne pouvez renommer que des pièces d'équipements");
				}
			}
		}else {
			sender.sendMessage("§4[Erreur]: Vous devez etre un joueur pour utiliser cette commande");
		}
		return true;
	}
}