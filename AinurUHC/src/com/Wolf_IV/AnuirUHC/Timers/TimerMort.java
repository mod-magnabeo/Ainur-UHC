package com.Wolf_IV.AnuirUHC.Timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class TimerMort extends BukkitRunnable {
	public static TimerMort lastMort;
	Player player;
	CStart p;
	public boolean stop = false;
	public TimerMort(Player victim, CStart cstart) {
	player = victim;
	p = cstart;
	}
	int time = 6;
	@Override
	public void run() {
		if(stop ==true) {
			cancel();
		}else if(time != 0) {
			time--;
		}else {
			lastMort = null;
			Bukkit.broadcastMessage("§2Un nouveau Ainu est mort cétait "+player.getDisplayName()+" il était "+Search.roleF(player.getName(), p).getRole());
			cancel();
		}

	}

}
