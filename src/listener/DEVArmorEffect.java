package listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import secondsEvent.TwoSecEvent;

public class DEVArmorEffect implements Listener {
	
	Player p;
	
	static boolean Helmet;
	static boolean Chestplate;
	static boolean Leggings;
	static boolean Boots;
	
	@EventHandler
	public void ArmorEffectEvent(TwoSecEvent e) {
		
		this.p = e.getEachPlayer();
		
		boolean hasHelmet = false;
		boolean hasChestplate = false;
		boolean hasLeggings = false;
		boolean hasBoots = false;
		
		try {
			p.getInventory().getHelmet().getType();
			hasHelmet = true;
		}catch(NullPointerException exception) {
			hasHelmet = false;
		}
		
		try {
			p.getInventory().getChestplate().getType();
			hasChestplate = true;
		}catch(NullPointerException exception) {
			hasChestplate = false;
		}
		
		try {
			p.getInventory().getLeggings().getType();
			hasLeggings = true;
		}catch(NullPointerException exception) {
			hasLeggings = false;
		}
		
		try {
			p.getInventory().getBoots().getType();
			hasBoots = true;
		}catch(NullPointerException exception) {
			hasBoots = false;
		}
		
		int resi = 0;
			
			
			if(hasHelmet == true && p.getInventory().getHelmet().getType() == Material.DIAMOND_HELMET) {
				
				setHelmet(hasHelmet);
			}
			
			if(hasChestplate == true && p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE) {
				
				setChestplate(hasChestplate);
			}
			
			if(hasLeggings == true && p.getInventory().getLeggings().getType() == Material.DIAMOND_LEGGINGS) {
				
				setLeggings(hasLeggings);
			}
			
			if(hasBoots == true && p.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS) {
				
				setBoots(hasBoots);
			}
	}
	
	private void setHelmet(boolean b) {
		DEVArmorEffect.Helmet = b;
	}
	
	private void setChestplate(boolean b) {
		DEVArmorEffect.Chestplate = b;
	}
	
	private void setLeggings(boolean b) {
		DEVArmorEffect.Leggings = b;
	}
	
	private void setBoots(boolean b) {
		DEVArmorEffect.Boots = b;
	}
	
	public static boolean hasHelmet() {
		return Helmet;
	}
	
	public static boolean hasChestplate() {
		return Chestplate;
	}
	
	public static boolean hasLeggings() {
		return Leggings;
	}
	
	public static boolean hasBoots() {
		return Boots;
	}
	
}
