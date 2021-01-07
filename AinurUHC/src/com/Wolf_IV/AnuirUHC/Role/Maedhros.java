package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Maedhros {
	public static int lastDay = 0;
	public static int MCM = 1;
	public static boolean u(CStart p, Player player, String[] args) {
		
		if(player == p.maedhros) {
			if(args.length>0) {
				if(lastDay==TimerTasks.timeDay) {
					player.sendMessage("§bVous ne pouver pas protéger 2 fois en un jour");
					return true;
				}
				if(!args[0].equals(player.getName())) {
					
				}else if(MCM>0) {
					MCM--;
					player.sendMessage("§aVous pouvez vous protéger vous meme plus que "+MCM+" fois dans la partie");
				}else {
					player.sendMessage("§bVous aver dépasser la limite de auto-protection");
					return true;
				}
				Player pChoix = Bukkit.getPlayer(args[0]);
				player.sendMessage("§bVous avez protéger "+args[0]);
				pChoix.sendMessage("§aAujourd'hui Maedhros vous rend invisible");													//			false, false enleve les particule
				pChoix.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (1200-TimerTasks.timeSDay)*20, 0 /*fin du jour*/, false, false));
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
