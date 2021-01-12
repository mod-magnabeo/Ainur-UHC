package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class BalrogInfiltre {
	static int lastJour = 0;
	public static boolean u(CStart p, Player player, String[] args) {
		
		if(player != p.balrog_infiltré) {
			return false;
		}
		if(args.length == 0) {
			player.sendMessage("§4/u [player a 15 blocks]");
			return true;
		}
		if(lastJour == TimerTasks.timeDay) {
			player.sendMessage("§cAttends le prochain jour");
			return true;
		}
		Player[] pl = Search.pNext(player, p, 15);
		for(Player play : pl) {
			if(play.getName().equalsIgnoreCase(args[0])) {
			Role role = Search.roleF(play.getName(), p);
				if(role == null) {
					player.sendMessage("§4Le role de ce joueur n'a pas été trouvé");
					return true;
				}
			player.sendMessage("§e"+play.getDisplayName()+" est "+role.getRole());
			lastJour = TimerTasks.timeDay;
			play.setHealth(play.getHealth()-0.5F);
				return true;
			}
		}
		player.sendMessage("§4Ce joueur n'est pas à 15 blocks de vous");
		return true;
	}

}
