package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class EruIluvatar {
	public static boolean revel = false;
	public static boolean raise = false;
	public static boolean choice = false;
	public static boolean revi = false;

	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.Eru_Iluvatar) {
			return false;
		}
		if(args.length == 0) {
			player.sendMessage("§4/u choix");
			return true;
		}
		if(TimerTasks.timeSDay < 5*60 && TimerTasks.timeDay == 2 && args[0] != null) {
			if(choice == true) {
				player.sendMessage("§4Vous avez déjà choisi une chanson");
				return true;
			}else if(args[0].equalsIgnoreCase("revelation")) {
				player.sendMessage("§bVous avez choisi la chanson de revelation");
				revel = true;
				choice = true;
				return true;
			}else if(args[0].equalsIgnoreCase("soul")) {
				player.sendMessage("§bVous avez choisi la chanson de soul");
				raise = true;
				choice = true;
				return true;
			}
		}else if(choice = false) {
			player.sendMessage("§4Vous n'avez pas choisi de chanson dans les 5 premiere minute du Jour 2");
			return true;
		}
		if(revel == true && Bukkit.getPlayer(args[0]) != null) {
			Player[] pl = Search.pNext(player, p, 10);
			for(Player playerN :pl) {
				if(args[0].equalsIgnoreCase(playerN.getDisplayName())) {
					Bukkit.broadcastMessage("§3Eru_Iluvatar revel le joueur "+playerN.getDisplayName()+" a l'Ainur il est "+Search.roleF(playerN.getDisplayName(), p).getRole());
					revel =false;
					return true;
				}
			}
			player.sendMessage("§bCe joueur n'est pas a 10 blocks de vous");
		}
		if(revel == false && raise == false) {
			player.sendMessage("§bVous n'aver plus de chason :-(");
			return true;
		}
			
		
		

		player.sendMessage("§4[Error] §cRevelation : /u [player à 10 blocks]");
		return true;
	}
	public static void onDead(Player killer, CStart p) {
		if(raise == true) {
			raise = false;
			revi = true;
			p.Eru_Iluvatar.closeInventory();
			Inventory inv = Bukkit.createInventory(null, 27, "§bChoisir:");
			
			ItemStack Kill =new Wool(DyeColor.RED).toItemStack();
			ItemMeta customKill = Kill.getItemMeta();
			customKill.setDisplayName("§4Enlevé 5 coeur à : "+killer.getDisplayName());
			Kill.setItemMeta(customKill);
			
			ItemStack Revive =new Wool(DyeColor.GREEN).toItemStack();
			ItemMeta customRevive = Revive.getItemMeta();
			customRevive.setDisplayName("§aRevive");
			Revive.setItemMeta(customRevive);
			
			inv.setItem(11, Kill);
			inv.setItem(15, Revive);
			
			p.Eru_Iluvatar.openInventory(inv);
			p.Eru_Iluvatar.setGameMode(GameMode.SPECTATOR);
		}
	}
	
	public static void nDay(CStart p) {
		if(revi == true && p.Eru_Iluvatar != null) {
			p.Eru_Iluvatar.setMaxHealth(p.Eru_Iluvatar.getMaxHealth()-2.0F);
		}
	}

}
