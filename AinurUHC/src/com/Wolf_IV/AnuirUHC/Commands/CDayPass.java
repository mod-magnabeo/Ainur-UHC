package com.Wolf_IV.AnuirUHC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class CDayPass implements CommandExecutor {

private TimerTasks timer;
	public CDayPass(TimerTasks timert) {
	this.timer=timert;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("daypass")) {
		timer.timeSDay=1197;
		return true;
			}
		}
		return false;
	}

}
