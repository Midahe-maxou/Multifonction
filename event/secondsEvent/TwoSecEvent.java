package secondsEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TwoSecEvent extends Event {
	
	private Player player;
	private static final HandlerList handlers = new HandlerList();

	public TwoSecEvent(Player p) {
	
	this.player = p;
	}
	
	public Player getEachPlayer() {
		return this.player;
	}
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
}
