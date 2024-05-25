package idea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class idea implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String idea, String[] args) {
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		File folder = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\idea");
		File banFolder = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\ideaBan");
		File file = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\idea\\\\" + sender.getName() + ".txt");
		File areBannedIdea = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\ideaBan\\\\" + sender.getName() + ".txt");
		ArrayList<String> al = new ArrayList<>();
		ArrayList<String> al2 =new ArrayList<>();
		ArrayList<String> al3 =new ArrayList<>();
		
		boolean fileWasCreated = false;
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		if(!banFolder.exists()) {
			banFolder.mkdirs();
		}
		
			if(cmd.getName().equalsIgnoreCase("idea")) {
				
				if(!areBannedIdea.exists()) {
				
					if(!file.exists()) {
						
						try {
							file.createNewFile();
							fileWasCreated = false;
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}else {
						fileWasCreated = true;
					}
						
					if(args.length == 0) {
						sender.sendMessage("§cLa commande est : §o/idea <votre idée>");
					}
						
					if(args.length >= 1) {
						
						
						StringBuilder bc = new StringBuilder();
						for(String part : args) {
							bc.append(part + " ");
						}
						
						if(bc.toString().equalsIgnoreCase("<votre idée> ") || bc.toString().equalsIgnoreCase("<votre idee> ") || bc.toString().equalsIgnoreCase("<votre id2e> ")) {
							sender.sendMessage(ChatColor.GRAY + "Vous ne pouvez pas recommender " + bc.toString() + '\n' + "Essayer autre chose !");
							return true;
						}
						try
						{
							if(fileWasCreated == false) {
								Files.write(Paths.get("C:\\Users\\max\\Desktop\\serveur local mc\\idea\\" + sender.getName() + ".txt"),(sender.getName() + " a eu quelque petites idées : " + bc.toString()).getBytes(), StandardOpenOption.APPEND);
								sender.sendMessage("§eVotre recommendation : " + bc.toString() + " a bien été envoyer au dev");
								
							}else {
								Files.write(Paths.get("C:\\Users\\max\\Desktop\\serveur local mc\\idea\\" + sender.getName() + ".txt"),(", " + bc.toString()).getBytes(), StandardOpenOption.APPEND);
								sender.sendMessage("§eVotre recommendation : " + bc.toString() + " a bien été envoyer au dev");
							}
						}
						catch (IOException e)
						{
							System.out.println("le fichier " + file.toString() + " est inacessible.");
						}
					}
				}else {
					sender.sendMessage("§cVous ne pouvez plus envoyer de recommendation" + '\n' + "§cContactez un administrateur pour régler ce problême");
				}
			}
			
		if(cmd.getName().equalsIgnoreCase("idea.erase")) {
			if(args.length == 0 || args.length >= 2) {
				sender.sendMessage("§cLa Commande est §o/idea.erase <Joueur>");
			}
			
			if(args.length == 1) {
				
				for(String part : args) {
					sb.append(part);
				}
				File eraseFile = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\idea\\\\" + sb.toString() + ".txt");
				if(eraseFile.exists()) {
					eraseFile.delete();
					sender.sendMessage("§cFile has been delete");
				}else if(!eraseFile.exists()) {
					sender.sendMessage("§cLe joueur " + ChatColor.AQUA + sb.toString() + " §cn'a pas encore envoyer de recommandation ");
				}
				return true;
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("idea.ban")) {
			

			if(args.length == 0 || args.length == 1) {
				sender.sendMessage("§cLa Commande est §o/idea.ban <Joueur> <raison>");
			}
			
			
			if(args.length > 1) {
				
				File banFile = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\ideaBan" + args[0] + ".txt");
				
				al.add(args[0]);
				
				for(String part : al) {
					al3.add(part);
				}
				
				for(String parts : args) {
					al2.add(parts);
				}
				sender.sendMessage(al2.toString());
				sender.sendMessage(al3.toString());
				if(al2.contains(args[0])) {
					al2.remove(args[0]);
				}
				sender.sendMessage("§e" + al2.toString());
				
				if(!banFile.exists()) {
					try {
						banFile.createNewFile();
						FileWriter fw = new FileWriter(banFile);
						fw.write(al2.toString());
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}	
		}
		
		if(cmd.getName().equalsIgnoreCase("idea.deban")) {
			
			if(args.length == 0 || args.length >= 2 ) {
				sender.sendMessage("§cLa Commande est §o/idea.deban <Joueur>");
			}
			
			if(args.length == 1) {
				for(String part : args) {
					sb.append(part);
				}
				File banFile = new File("C:\\\\Users\\\\max\\\\Desktop\\\\serveur local mc\\\\ideaBan\\\\" + sb.toString() + ".txt");
				if(!banFile.exists()) {
					
					sender.sendMessage("§cLe joueur " + ChatColor.AQUA + sb.toString() + " §cn'est pas banni des recommendations");
				
				}else if(banFile.exists()) {
					banFile.delete();
					sender.sendMessage("§cLe joueur " + ChatColor.AQUA + sb.toString() + " §ca été debanni des recommendations");
				}
				return true;
			}	
			
		}
		return false;
	}
}
