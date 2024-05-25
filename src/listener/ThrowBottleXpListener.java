package listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ThrowBottleXpListener implements Listener {
	
	@EventHandler
	public void onThorwBottleXp(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		Material bottle = Material.EXP_BOTTLE;

		if(e.getAction() != null) {
			Action ac = e.getAction();
			
			if(ac == Action.RIGHT_CLICK_AIR || ac == Action.RIGHT_CLICK_BLOCK) {
				if(e.getItem().getType() == bottle) {
					if(e.getItem().getItemMeta().getDisplayName().contains("§b§lLevel : ")) {
						
						String bottlexpName = e.getItem().getItemMeta().getDisplayName();
						String exp = bottlexpName.replaceFirst("§b§lLevel : " , "");
						exp.trim();
						
						int xp = Integer.valueOf(exp);
						player.setLevel(player.getLevel() + xp);
						e.setCancelled(true);
						
						if(player.getInventory().getItemInMainHand().getAmount() > 1) {
							player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
						}else {
							player.setItemInHand(null);
						}
					}
				}
			}
		}
	}
}
