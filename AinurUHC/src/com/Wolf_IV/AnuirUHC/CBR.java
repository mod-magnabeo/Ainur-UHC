package com.Wolf_IV.AnuirUHC;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class CBR implements CommandExecutor {

	CStart p;
	public CBR(CStart cstart) {
		p = cstart;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("br")) {
				Player player = (Player)sender;
				if(TimerTasks.role==false) {
					player.sendMessage("�4Les role n'ont pas �t� donn�");
					return false;
				}
				for(Player balrog : p.balrogC) {
					if(balrog != null && player == balrog || player == p.Melkor || player == p.sauron) {
						player.sendMessage("�cVoici la liste des balrog:");
						player.sendMessage("�4------------");
						for(int i = 1; i<=p.nubPlayer; i++) {
							if(p.jouS[i] != null && p.jouD[i] == true) {
						for(String mechant : p.evilS) {
							if(mechant == p.jouS[i]) {
								player.sendMessage("�3"+mechant);
							}
						}
						}
						}
						player.sendMessage("�4------------");
						return true;
				}
				}
			}
			}
		return false;
	}
	
}