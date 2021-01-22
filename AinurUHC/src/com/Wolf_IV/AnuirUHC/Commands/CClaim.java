package com.Wolf_IV.AnuirUHC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.Search;

public class CClaim implements CommandExecutor {

	CStart p;
	public CClaim(CStart cstart) {
		p = cstart;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("claim")) {
				Player player =(Player) sender;
				Search.pInvItemSup(player, p.SB);
				Search.pInvItemSup(player, p.SG);
				Search.pInvItemSup(player, p.SR);
				Search.pInvItemSup(player, p.P);
				if(player.getDisplayName() == p.SBleu) {
					player.getInventory().addItem(p.SB);
					player.sendMessage("§bVous recevez le §bSilmaril Bleu");
				}
				if(player.getDisplayName() == p.SVert) {
					player.getInventory().addItem(p.SG);
					player.sendMessage("§bVous recevez le §aSilmaril Vert");
				}
				if(player.getDisplayName() == p.SRouge) {
					player.getInventory().addItem(p.SR);
					player.sendMessage("§bVous recevez le §cSilmaril Rouge");
				}
				if(player.getDisplayName() == p.Planatir) {
					player.getInventory().addItem(p.P);
					player.sendMessage("§bVous recevez le §7Planatir");
				}
				return true;
			}
		}
		return false;
	}

}
