package com.Wolf_IV.AnuirUHC;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class CDON implements CommandExecutor {
	CStart p;
	public CDON(CStart cstart) {
		p = cstart;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("don")) {
				Player player =(Player) sender;
				if(args.length == 0) {
					player.sendMessage("§c/don [pseudo a 25 blocks avec silmarils dans la main]");
					return true;
				}
				Player[] pl = Search.pNext(player, p, 20);
				for(Player play : pl) {
					if(play.getName().equalsIgnoreCase(args[0])) {
						PlayerInventory inv = player.getInventory();
						ItemMeta item = inv.getItemInHand().getItemMeta();
						if(item == null) {
							player.sendMessage("§aMet un silmaril dans ta main");
							return true;
						}
						if(!item.hasDisplayName()) {
							player.sendMessage("§aCeci n'est pas un silmarils");
							return true;
						}
						if(item.getDisplayName().equalsIgnoreCase("§aSilmaril Vert") && p.SVert.equalsIgnoreCase(player.getDisplayName()) ) {
							play.getInventory().addItem(p.SG);
							p.SVert = play.getName();
							play.sendMessage("§dVous recever le §aSilmaril Vert faite /claim si vous ne l'avez pas reçu");
						}else if(item.getDisplayName().equalsIgnoreCase("§bSilmaril Bleu") && p.SBleu.equalsIgnoreCase(player.getDisplayName())) {
							play.getInventory().addItem(p.SB);
							p.SBleu = play.getName();
							play.sendMessage("§dVous recever le §bSilmaril Bleu faite /claim si vous ne l'avez pas reçu");
						}else if(item.getDisplayName().equalsIgnoreCase("§eSilmaril Rouge") && p.SRouge.equalsIgnoreCase(player.getDisplayName())) {
							play.getInventory().addItem(p.SR);
							p.SRouge = play.getName();
							play.sendMessage("§dVous recever le §eSilmaril Jaune faite /claim si vous ne l'avez pas reçu");
						}else {
							player.sendMessage("§aCeci n'est pas un silmarils");
							return true;
						}
						player.sendMessage("§eVotre Silmaril a été envoyé");
						inv.setItemInHand(null);
						return true;
					}
				}
				player.sendMessage("§cCe joueur n'est pas a 20 blocks de vous");
				return true;
			}
		}
		return false;
	}

}
