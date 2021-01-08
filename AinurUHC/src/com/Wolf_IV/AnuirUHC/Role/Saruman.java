package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Saruman {
	public static String msg = "null";

	public static boolean u(CStart p, Player player, String[] args) {
		if(player == p.sauruman) {
			if(args.length>0) {
				if(TimerTasks.timeSDay <= 10*60) {
					
						StringBuilder bc = new StringBuilder();
						for(String part : args) {
							bc.append(part+ " ");
						}
						msg = "§aLa voix de Saruman : §6"+bc.toString();
						Bukkit.broadcastMessage("§aVotre message a été engistrer et sera envoié lors du debut du prochaine episode");
				return true;
				}else {
					player.sendMessage("§bEnvoié votre message dans les 10 premiere minute du jour");
				}
			}else {
				player.sendMessage("§bu [msg]");
			}
		}
		
		
		return false;
	}
	

	public static void nDay(CStart p) {
		/*if(p.sauruman == null) {
			return; PAS BESOIN
		}*/
		//executer quand un jour passe
		if(!msg.equalsIgnoreCase("null")) {
			Bukkit.broadcastMessage(msg);
			msg = "null";
		}

		
	}
}
