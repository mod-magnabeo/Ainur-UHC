package com.Wolf_IV.AnuirUHC;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class CRevive implements CommandExecutor {

	CStart p;
	public CRevive(CStart cstart) {
		p = cstart;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("arevive")) {
				Player player = (Player)sender;
				if(args.length == 0) {
					player.sendMessage("§b/arevive [player]");
					return true;
				}
				if(Bukkit.getPlayer(args[0]) != null) {
					Search.Revive(Bukkit.getPlayer(args[0]), p);
					player.sendMessage("§bJoueur revive");
				}else {
					player.sendMessage("§bJoueur déconnecté");
				}
				}
			}
		return false;
	}

}
