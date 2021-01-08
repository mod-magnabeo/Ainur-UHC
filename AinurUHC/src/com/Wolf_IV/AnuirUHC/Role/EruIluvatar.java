package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class EruIluvatar {
	public static boolean revel = false;
	public static boolean raise = false;

	public static boolean u(CStart p, Player player, String[] args) {
		if(TimerTasks.timeSDay < 5*60 && TimerTasks.timeDay == 2 && args[0] != null) {
			if(args[0].equalsIgnoreCase("revelation")) {
				
			}
		}
		
		return false;
	}

}
