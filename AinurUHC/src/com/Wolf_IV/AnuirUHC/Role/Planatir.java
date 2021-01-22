package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Planatir {
	

public static void interact(Player player, Action action, CStart p) {
		
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(!p.Planatir.equalsIgnoreCase(player.getDisplayName())) {
				player.sendMessage("§bVous n'avez pas le planatir");
				return;
			}
			boolean evil = false;
			for(Player evilP : p.evil) {
				if(evilP != null) {
					if(evilP == player) {
						evil = true;
					}
				}
			}
			if(TimerTasks.jN == false && !evil) {
				player.sendMessage("§bVous pouver que vous servir du planatir le Jour");
				return;
			}else if(TimerTasks.jN == true && evil) {
				player.sendMessage("§bVous pouver que vous servir du planatir la Nuit");
				return;
			}
			if(p.SBleu == null || p.SVert == null || p.SRouge == null) {
				player.sendMessage("§4Au moins un des silmarils n'appartient a personne. Bug?");
				return;
			}
			String sil[]=new String[4];
			int max =3;
			sil[0] = p.SBleu;
			sil[1] = p.SVert;
			sil[2] = p.SRouge;
			if(sil[0].equalsIgnoreCase(sil[1])) {
				sil[1] = null;
				max--;
			}
			if(sil[1] != null && sil[1].equalsIgnoreCase(sil[2])) {
				sil[2] = null;
				max--;
			}
			if(sil[2] != null && sil[0].equalsIgnoreCase(sil[2])) {
				sil[2] = null;
				max--;
			}
			
			sil = Search.melangerS(sil, max, 50, 0);
			player.sendMessage("§eVoici les joueurs possèdent les silmarils:");
			player.sendMessage("§c----------------------------------");
			for(String silmaril : sil) {
				if(silmaril != null) {
					player.sendMessage("§9"+silmaril);
				}
			}
			player.sendMessage("§c----------------------------------");
}
}
}