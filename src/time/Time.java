package time;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import secondsEvent.TenSecEvent;
import secondsEvent.TwoSecEvent;

public class Time {
	
	private static int decahours = 0;
	private static int hours = 0;
	private static int decaminutes = 0;
	private static int minutes = 0;
	private static int decaseconds = 0;
	private static int seconds = 0;
	
	public void Timer() {
		
		Timer chrono = new Timer();
		
		chrono.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				seconds++;
				
				if(seconds == 10) {
					decaseconds++;
					seconds = 0;
				}
				
				if(decaseconds == 6) {
					minutes++;
					decaseconds = 0;
				}
				if(minutes == 10) {
					decaminutes++;
					decaminutes = 0;
				}
				if(decaminutes == 6) {
					hours++;
					decaminutes = 0;
				}
				if(hours == 10) {
					decahours++;
					hours = 0;
				}
				if(decahours == 2 && hours == 4) {
					seconds = 0;
					decaseconds = 0;
					minutes = 0;
					decaminutes = 0;
					hours = 0;
					decahours = 0;
				}
				
				if(seconds == 0 || seconds == 2 || seconds == 4 || seconds == 6 || seconds == 8) {
					
					String str = Bukkit.getOnlinePlayers().toString();
					String[] player;
					int resi = 0;
					
					if(str.contains("CraftPlayer{name=")) {
						str = str.replace("CraftPlayer{name=", "");
					}
					
					if(str.contains(" ")) {
						str = str.replace(" ", "");
					}
						
					if(str.contains("}]")) {
						str = str.replace("}]", ",");
					}
						
					
					if(str.contains("[")) {
						str = str.replace("[", "");
					}
						
					if(str.contains("}")) {
						str = str.replace("}", "");
					}
						
					str.trim();
					player = str.split(",");
					
					for(int i = 0; i < main.Main.getPlayerOnServer(); i++) {
						
						player[i] = player[i].trim();
						Player p = Bukkit.getPlayer(player[i]);
						
						
						Bukkit.getPluginManager().callEvent(new TwoSecEvent(p));
						
						if(seconds == 0) {
							Bukkit.getPluginManager().callEvent(new TenSecEvent(p));
						}
					}
				}
				
			}
		}, 1000, 1000);
	}
	
	public static int getDecahours() {
		return decahours;
	}
	
	public static int getHours() {
		return hours;
	}
	
	public static int getDecaminutes() {
		return decaminutes;
	}
	
	public static int getMinutes() {
		return minutes;
	}
	
	public static int getDecaseconds() {
		return decaseconds;
	}
	
	public static int getSeconds() {
		return seconds;
	}
	
	public static void setDecahours(int decahours) {
		Time.decahours = decahours;
	}
	
	public static void setHours(int hours) {
		Time.hours = hours;
	}
	
	public static void setDecaminutes(int decaminutes) {
		Time.decaminutes = decaminutes;
	}
	
	public static void setMinutes(int minutes) {
		Time.minutes = minutes;
	}
	
	public static void setDecaseconds(int decaseconds) {
		Time.decaseconds = decaseconds;
	}
	
	public static void setSeconds(int seconds) {
		Time.seconds = seconds;
	}
}
