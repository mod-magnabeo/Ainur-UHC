package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class Namo {

	public static String lastDead;
	public static int times = 2;
	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.namo) {
			return false;
		}
		if(lastDead.isEmpty()) {
			player.sendMessage("Il n'y a pas encore eu de mort");
			return true;
		}
		if(times<=0) {
			player.sendMessage("Il ne vous reste plus de pouvoir");
		}
		times--;
		player.sendMessage(lastDead);
		player.setMaxHealth(player.getMaxHealth()-2.0F);
		
		return true;
	}

}
