package listener;

/*import java.util.Timer;
*import java.util.TimerTask;
*import org.bukkit.Location;
*import org.bukkit.Material;
*import org.bukkit.entity.Player;
*import org.bukkit.inventory.ItemStack;
*/import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class onDiamondBlock implements Listener {
	
	
	/*private static boolean OnDiamondBlock = false;
	*private static int time = 0;
	*/
	
	@EventHandler
	public boolean diamondBlock(PlayerMoveEvent event) throws InterruptedException {
		
/*		Player player = event.getPlayer();
*		Location loc = player.getLocation();
*		
*		if(loc.add(0, -1, 0).getBlock().getType() == Material.DIAMOND_BLOCK) {
*			if(time == 0) {
*				OnDiamondBlock = false;
*			}else {
*				OnDiamondBlock = true;
*			}
*			
*			if(OnDiamondBlock == false) {
*				
*				player.getInventory().addItem(new ItemStack(Material.MINECART));
*				player.sendMessage(player.getName());
*				OnDiamondBlock = true;
*				time = 10;
*				Timer chrono = new Timer();
*				chrono.schedule(new TimerTask() {
*					
*					@Override
*					public void run() {
*						
*						time --;
*						if(time == 0) {
*							cancel();
*						}
*					}
*				}, 1000, 1000);
*			}else {
*				player.sendMessage("temps restant : " + time);
*				Thread.sleep(10000);
*				
*			}
*		}
*/		return false;
	}
}
		
