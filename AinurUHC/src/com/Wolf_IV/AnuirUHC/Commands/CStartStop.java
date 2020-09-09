package com.Wolf_IV.AnuirUHC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class CStartStop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("startainuruhcstop")) {
				Player player = (Player)sender;
				if(TimerTasks.starting == true) {
					TimerTasks.stop = true;
				}else {
					player.sendMessage("§4 Game pas encore ou déjà lancer");
				}
				
		
			return true;
	}
		}
		return false;
	}

}
