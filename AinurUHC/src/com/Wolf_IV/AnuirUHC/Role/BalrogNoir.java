package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerMort;

public class BalrogNoir {

	public static boolean u(CStart p, Player player, String[] args) {
		if(p.balrog_noir == null || p.balrog_noir != player) {
			return false;
		}
		TimerMort.lastMort.stop = true;
		player.sendMessage("§aLe role de ce joueur ne serat pas dévoiler a tous e monde");
		return true;
	}

}
