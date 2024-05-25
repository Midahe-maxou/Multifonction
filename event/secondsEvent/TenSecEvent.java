package secondsEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TenSecEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	
	public TenSecEvent(Player p) {
		this.player = p;
	}

	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}