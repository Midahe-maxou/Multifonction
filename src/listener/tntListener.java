package listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class tntListener implements Listener {
	

	@EventHandler
	public void TnT(PlayerInteractEvent tnt) {
		
		Player player =  tnt.getPlayer();
		player.getInventory().remove(Material.TNT);
		player.getInventory().remove(new ItemStack(Material.EXPLOSIVE_MINECART));
		
	}
}