package com.Wolf_IV.AnuirUHC;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Role.Feanor;
import com.Wolf_IV.AnuirUHC.Role.Melkor;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

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
				if(TimerTasks.Ingame == false) {
					player.sendMessage("§4Il n'y a pas de Ainur UHC en cours");
				}
				if(args.length == 0) {
					player.sendMessage("§c/don [pseudo a 25 blocks avec silmarils dans la main]");
					return true;
				}
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
				Player[] pl = Search.pNext(player, p, 20);
				for(Player play : pl) {
					if(play.getName().equalsIgnoreCase(args[0])) {
						if(p.Eru_Iluvatar != null && p.Eru_Iluvatar == play) {
							player.sendMessage("§aEru_Iluvatar ne peut posééder d'artéfact");
							return true;
						}else if(p.Feanor != null && p.Feanor == player) {
							for(String pS : Feanor.plGive) {
								if(pS != null && pS.equalsIgnoreCase(play.getName())) {
									player.sendMessage("§aVous avez déjà donner un silmarils a ce joueur");
									return true;
								}
							}
						}
					if(don(item, play, p, player.getName()) == false) {
						player.sendMessage("§aCeci n'est pas un silmarils ou il ne vous appartient pas");
						return true;
					}else {
						player.sendMessage("§eVotre Silmaril a été envoyé");
						inv.setItemInHand(null);
						if(p.Feanor != null && player == p.Feanor) {
							for(String pS : Feanor.plGive) {
								if(pS == null) {
									pS = play.getName();
								}
							}
						}
						return true;
							}
					}
				}
				player.sendMessage("§cCe joueur n'est pas a 20 blocks de vous");
				return true;
			}
		}
		return false;
	}
	public static boolean don(ItemMeta item, Player play, CStart p, String player) {
		boolean V = false;
		boolean B = false;
		boolean R = false;
		if(item.getDisplayName().equalsIgnoreCase("§aSilmaril Vert") && p.SVert.equalsIgnoreCase(player) ) {
			play.getInventory().addItem(p.SG);
			p.SVert = play.getName();
			V = true;
			play.sendMessage("§dVous recever le §aSilmaril Vert §dfaite /claim si vous ne l'avez pas reçu");
		}else if(item.getDisplayName().equalsIgnoreCase("§bSilmaril Bleu") && p.SBleu.equalsIgnoreCase(player)) {
			Bukkit.broadcastMessage(play.getDisplayName());
			play.getInventory().addItem(p.SB);
			p.SBleu = play.getName();
			B = true;
			play.sendMessage("§dVous recever le §bSilmaril Bleu §dfaite /claim si vous ne l'avez pas reçu");
		}else if(item.getDisplayName().equalsIgnoreCase("§cSilmaril Rouge") && p.SRouge.equalsIgnoreCase(player)) {
			play.getInventory().addItem(p.SR);
			p.SRouge = play.getName();
			R = true;
			play.sendMessage("§dVous recever le §eSilmaril Jaune §dfaite /claim si vous ne l'avez pas reçu");
		}else if(item.getDisplayName().equalsIgnoreCase(p.P.getItemMeta().getDisplayName()) && p.Planatir.equalsIgnoreCase(player)) {
			play.getInventory().addItem(p.P);
			p.Planatir = play.getName();
			play.sendMessage("§dVous recever le §7Planatir§d faite /claim si vous ne l'avez pas reçu");
		}else {
			return false;
		}
		if(p.Feanor != null && play == p.Feanor) {
			Feanor.distribution(p, p.FeanorS, p.Feanor, V, B, R);
			return true;
		}else if(p.Eru_Iluvatar != null && p.Eru_Iluvatar == play) {
			Feanor.distribution(p, p.Eru_IluvatarS, p.Eru_Iluvatar, V, B, R);
			return true;
		}
		for(Player bl : p.evil) {
			if(bl != null && bl == play) {
				for(Player evil : p.evil) {
					if(evil != null) {
					evil.sendMessage("§cUn membre de votre equipe a recupèrer un silmarils");
					}
				}
				Melkor.crownCheck(p);
			}
		}
		return true;
	}
}
