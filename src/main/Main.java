package main;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import commands.CommandBottlexp;
import commands.CommandBvn;
import commands.CommandChat;
import commands.CommandHours;
import commands.CommandNick;
import commands.CommandNv;
import commands.CommandRename;
import commands.CommandSpeed;
import idea.idea;
import listener.DEVArmorEffect;
import listener.ThrowBottleXpListener;
import listener.onDiamondBlock;
import listener.setMessageListener;
import listener.tntListener;

public class Main extends JavaPlugin {
	
	private static ConsoleCommandSender console = Bukkit.getConsoleSender();
	private static int playerOnServer;
	
	@Override
	public void onEnable() {
		
		new time.Time().Timer();
		console.sendMessage("§aLe Plugin MultiFonction s'allume");
		
		Main.setPlayerOnServer(getServer().getOnlinePlayers().size());
		
		getCommand("alert").setExecutor(new CommandChat());
		getCommand("idea").setExecutor(new idea());
		getCommand("idea.erase").setExecutor(new idea());
		getCommand("idea.ban").setExecutor(new idea());
		getCommand("idea.deban").setExecutor(new idea());
		getCommand("bvn").setExecutor(new CommandBvn());
		getCommand("rename").setExecutor(new CommandRename());
		getCommand("nick").setExecutor(new CommandNick());
		getCommand("nightvision").setExecutor(new CommandNv());
		getCommand("bottlexp").setExecutor(new CommandBottlexp());
		getCommand("hours").setExecutor(new CommandHours());
		getCommand("speed").setExecutor(new CommandSpeed());
		
		getServer().getPluginManager().registerEvents(new tntListener(), this);
		getServer().getPluginManager().registerEvents(new onDiamondBlock(), this);
		getServer().getPluginManager().registerEvents(new setMessageListener(), this);
		getServer().getPluginManager().registerEvents(new ThrowBottleXpListener(), this);
		
       /******************************ON DEVLOPPMENT******************************/
		getServer().getPluginManager().registerEvents(new DEVArmorEffect(), this);
		
		
		
	}
	
	@Override
	public void onDisable() {
		console.sendMessage("§cLe Plugin MultiFonction s'eteint");
	}

	public static int getPlayerOnServer() {
		return playerOnServer;
	}

	private static void setPlayerOnServer(int player) {
		Main.playerOnServer = player;
	}
}
