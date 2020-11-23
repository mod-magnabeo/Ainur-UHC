package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Maedhros {
	public static int lastDay = 0;
	public static int MCM = 2;
	public static boolean u(CStart p, Player player, String[] args) {
		if(player == p.maedhros) {
			if(args.length>0) {
				if(lastDay==TimerTasks.timeDay) {
					player.sendMessage("§bVous ne pouver pas protéger 2 fois en un jour");
					return true;
				}
				if(MCM>0 && args[1]==player.getName()) {
					MCM--;
					player.sendMessage("§aVous pouvez vous protéger vous meme plus que "+MCM+" fois dans la partie");
				}else {
					player.sendMessage("§bVous ne pouver pas plus vous protéger");
					return true;
				}
				Player pChoix = Bukkit.getPlayer(args[1]);
				player.sendMessage("§bVous avez protéger "+args[1]);
				pChoix.sendMessage("§aAujourd'hui Maedhros vous protège");
				pChoix.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 0, (1200-TimerTasks.timeSDay)*20/*fin du jour*/, false));
				lastDay=TimerTasks.timeDay;
				return true;
			}else {
				player.sendMessage("§bu [player]");
			}
		}
		
		return false;
	}
	
	
	public static void nDay(CStart p) {
		//executer quand un jour passe
		p.maedhros.sendMessage("§9Vous pouver choisir une nouvelle personne a protéger");
		
	}
	
	

}
