package com.Wolf_IV.AnuirUHC;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
					player.sendMessage("§4Les role n'ont pas été donné");
					return false;
				}
				for(Player balrog : p.evil) {
					if(balrog != null && player == balrog && player != p.balrog_infiltré) {
						player.sendMessage("§cVoici la liste des balrog:");
						player.sendMessage("§4------------");
						for(String pla : Search.getLivingPlayers(p)) {
						for(String mechant : p.evilS) {
							if(mechant != null && mechant.equalsIgnoreCase(pla)) {
								player.sendMessage("§3"+mechant);
							}
						}
						}
						
						player.sendMessage("§4------------");
						return true;
				}
				}
			}
			}
		return false;
	}
	
}
