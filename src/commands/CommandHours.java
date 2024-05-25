package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHours implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String[] s = new String[10];
		String str = new String();
		int hms[] = new int[10];
		
		
		
		try {
			
			if(args.length == 0) {
				sender.sendMessage("§bIl est "+ time.Time.getDecahours() + time.Time.getHours() + "h " + time.Time.getDecaminutes() + time.Time.getMinutes() + "m " + time.Time.getDecaseconds() + time.Time.getSeconds() + "s");
				return true;
			}else if(args.length > 3) {
				return false;
			}else if(args.length >= 1) {
				try {
					double hours = Integer.valueOf(args[0]);
					
					if(hours > 23) {
						sender.sendMessage("§4[Erreur]: les heures doivent êtres inférieurs à 24");
						return true;
					}
					
					str = "" + hours;
					s = str.split("");
					
					if(hours > 9) {
					
						hms[0] = Integer.valueOf(s[0]);
						hms[1] = Integer.valueOf(s[1]);
						time.Time.setDecahours(hms[0]);
						time.Time.setHours(hms[1]);
					}else {
						hms[0] = Integer.valueOf(s[0]);
						time.Time.setHours(hms[0]);
					}
					
					if(args.length >= 2 ) {
						double minutes = Integer.valueOf(args[1]);
						
						if(minutes > 59) {
							sender.sendMessage("§4[Erreur]: Les minutes doivent êtres inferieurs à 60");
							return true;
						}
						
						str = "" + minutes;
						s = str.split("");
						
						if(minutes > 9) {
							
							hms[0] = Integer.valueOf(s[0]);
							hms[1] = Integer.valueOf(s[1]);
							time.Time.setDecaminutes(hms[0]);
							time.Time.setMinutes(hms[1]);
						}else {
							hms[0] = Integer.valueOf(s[0]);
							time.Time.setMinutes(hms[0]);
						}
						
						if(args.length == 3) {
							int seconds = Integer.valueOf(args[2]);
							
							if(seconds > 59) {
								sender.sendMessage("§4[Erreur]: Les secondes doivent êtres inferieurs à 60");
								return true;
							}
							
							str = "" + seconds;
							s = str.split("");
							
							if(seconds > 9) {
								
								hms[0] = Integer.valueOf(s[0]);
								hms[1] = Integer.valueOf(s[1]);
								time.Time.setDecaseconds(hms[0]);
								time.Time.setSeconds(hms[1]);
							}else {
								hms[0] = Integer.valueOf(s[0]);
								time.Time.setSeconds(hms[0]);
							}
							
							sender.sendMessage("§aL'heure est maintenant de : §b" + time.Time.getDecahours() + time.Time.getHours() + "h " + time.Time.getDecaminutes() + time.Time.getMinutes() + "m " + time.Time.getDecaseconds() + time.Time.getSeconds() + "s");
						}else {
							sender.sendMessage("§aL'heure est maintenant de : §b" + time.Time.getDecahours() + time.Time.getHours() + "h " + time.Time.getDecaminutes() + time.Time.getMinutes() + "m ");
						}
					}else {
						sender.sendMessage("§aL'heure est maintenant de : §b" + time.Time.getDecahours() + time.Time.getHours() + "h ");
					}
				}catch(NumberFormatException e) {
					sender.sendMessage("§4[Erreur]: Seul les nombres sont acceptés");
				}
			}
		}catch(Exception e1) {
			sender.sendMessage("§4[Erreur]: Une Erreur a été trouvé pendant l'éxécution de ce programme");
		}
		return true;
	}
}