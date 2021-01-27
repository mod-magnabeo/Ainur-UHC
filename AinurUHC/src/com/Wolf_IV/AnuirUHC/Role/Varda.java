package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Varda {
	static int lastDay = 0;

	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.varda) {
			return false;
		}
		if(TimerTasks.timeDay == lastDay) {
			player.sendMessage("§4Vous vous etes déjà servis de se pouvoir aujourd'hui");
			return true;
		}
		for(String play : Search.getLivingPlayers(p)) {
			Role role = Search.roleF(play, p);
			if(role == null) {
				player.sendMessage("§4Le role de ce joueur n'a pas été trouvé");
				return true;
			}
			player.sendMessage("§a"+play+" est un membre des "+role.getLien());
			
		}
		lastDay = TimerTasks.timeDay;
		return true;
	}
	public static void nDay(CStart p) {
		if(p.varda == null) {
			return;
		}
		//executer quand un jour passe
		p.varda.sendMessage("§9Vous pouver connaitre le type d'une nouvelle personne");
		
	}

}
