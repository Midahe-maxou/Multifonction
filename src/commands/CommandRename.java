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
				sender.sendMessage("�4[Erreur]: �cVous n'avez pas d'�quipement � renommer");
				
			}else {

				org.bukkit.inventory.ItemStack item = ((Player) sender).getInventory().getItemInMainHand();
				ItemMeta itemMeta = ((Player) sender).getInventory().getItemInMainHand().getItemMeta();
				String badname = (((Player) sender).getInventory().getItemInMainHand()).getItemMeta().getDisplayName();
				String itemType = ((Player) sender).getInventory().getItemInMainHand().getType().toString();

				if(itemType.contains("SWORD") || itemType.contains("AXE") || itemType.contains("BOW") || itemType.contains("HELMET") || itemType.contains("CHESTPLATE") || itemType.contains("LEGGINGS") || itemType.contains("BOOTS")) {
					if(itemMeta.hasDisplayName()) {
						if(badname.contains("&")) {
							String goodname = badname.replaceAll("&", "�");
							String itemtype = itemType.replaceAll("_", " ");
							itemMeta.setDisplayName(goodname);
							item.setItemMeta(itemMeta);
							sender.sendMessage("Votre �b" + itemtype.toLowerCase() + " �ra �t� renomm� en " + goodname);
	
						}else {
							sender.sendMessage("�4[Erreur]: �cVous devez renommer vote �quippement avec la formule : & + chiffre/lettre correspondant � la couleur (/color)");
						}
					}else {
						sender.sendMessage("�4[ERREUR]: �cVous n'avez pas renomm� votre pi�ce d'�quipement");
					}
				}else {
					sender.sendMessage("�4[Erreur]: �cVous ne pouvez renommer que des pi�ces d'�quipements");
				}
			}
		}else {
			sender.sendMessage("�4[Erreur]: Vous devez etre un joueur pour utiliser cette commande");
		}
		return true;
	}
}