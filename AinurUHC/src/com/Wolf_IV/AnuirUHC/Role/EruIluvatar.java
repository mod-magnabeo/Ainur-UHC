package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class EruIluvatar {
	public static boolean revel = false;
	public static boolean raise = false;
	public static boolean choice = false;

	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.Eru_Iluvatar) {
			return false;
		}
		if(args.length == 0) {
			player.sendMessage("§4/u choix");
			return true;
		}
		if(TimerTasks.timeSDay < 5*60 && TimerTasks.timeDay == 2 && args[0] != null) {
			if(choice == true) {
				player.sendMessage("§4Vous avez déjà choisi une chanson");
				return true;
			}else if(args[0].equalsIgnoreCase("revelation")) {
				player.sendMessage("§bVous avez choisi la chanson de revelation");
				revel = true;
				choice = true;
			}else if(args[0].equalsIgnoreCase("soul")) {
				player.sendMessage("§bVous avez choisi la chanson de soul");
				raise = true;
				choice = true;
			}
		}else if(choice = false) {
			player.sendMessage("§4Vous n'avez pas choisi de chanson dans les 5 premiere minute du Jour 2");
			return true;
		}
		
		Player[] pl = Search.pNext(player, p, 10);
		
		player.sendMessage("p1 = "+pl[0].getDisplayName());
		player.sendMessage("p1 = "+pl[0].getDisplayName()+" p2 = "+pl[1].getDisplayName());
		
		return true;
	}

}
