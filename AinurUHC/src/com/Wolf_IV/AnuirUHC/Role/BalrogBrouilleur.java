package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class BalrogBrouilleur {
	public static Player cible;
	static int lastDay = 0;
	public static boolean u(CStart p, Player player, String[] args) {
		if(p.balrog_brouilleur == null || p.balrog_brouilleur != player) {
			return false;
		}
	if(TimerTasks.timeDay == lastDay) {
		player.sendMessage("§cVous ne pouvais que vous servir de cette command une fois par jour");
		return true;
	}
	if(args.length == 0) {
		player.sendMessage("§b/u [player]");
		return true;
	}
	cible = null;
	for(Player posC : Search.getLivingAndConnectedPlayers(p, null)) {
		if(posC != null && posC.getName().equalsIgnoreCase(args[0])) {
			cible = posC;
		}
	}
	if(cible == null) {
		player.sendMessage("§cCette personne est hors ligne ou morte");
		return true;
	}
	cible.sendMessage("§aVous avez été brouillé par le balrog brouilleur vous ne pouvais desormais plus vous servir de la commande /u jusquau prochain jour");
	player.sendMessage("§5"+cible.getName()+" a été brouillé");
	lastDay = TimerTasks.timeDay;
	return true;
}
	public static void nDay(CStart p) {
		cible = null;
	}
}
