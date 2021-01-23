package com.Wolf_IV.AnuirUHC.Role;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Planatir {
	public static boolean disc = false;
	public static Location Loc;
	static Random rand =new Random();

public static void interact(Player player, Action action, CStart p) {
		
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(!p.Planatir.equalsIgnoreCase(player.getDisplayName())) {
				player.sendMessage("§bVous n'avez pas le planatir");
				return;
			}
			boolean evil = false;
			for(Player evilP : p.evil) {
				if(evilP != null) {
					if(evilP == player) {
						evil = true;
					}
				}
			}
			if(TimerTasks.jN == false && !evil) {
				player.sendMessage("§bVous pouver que vous servir du planatir le Jour");
				return;
			}else if(TimerTasks.jN == true && evil) {
				player.sendMessage("§bVous pouver que vous servir du planatir la Nuit");
				return;
			}
			if(p.SBleu == null || p.SVert == null || p.SRouge == null) {
				player.sendMessage("§4Au moins un des silmarils n'appartient a personne. Bug?");
				return;
			}
			
			if(TimerTasks.pls != 0) {
				player.sendMessage("§2Ne Spam pas");
				return;
			}
			TimerTasks.pls = 5;
			String sil[]=new String[4];
			int max =3;
			sil[0] = p.SBleu;
			sil[1] = p.SVert;
			sil[2] = p.SRouge;
			if(sil[0].equalsIgnoreCase(sil[1])) {
				sil[1] = null;
				max--;
			}
			if(sil[1] != null && sil[1].equalsIgnoreCase(sil[2])) {
				sil[2] = null;
				max--;
			}
			if(sil[2] != null && sil[0].equalsIgnoreCase(sil[2])) {
				sil[2] = null;
				max--;
			}
			
			sil = Search.melangerS(sil, max, 50, 0);
			player.sendMessage("§eVoici les joueurs possèdent les silmarils:");
			player.sendMessage("§c----------------------------------");
			for(String silmaril : sil) {
				if(silmaril != null) {
					player.sendMessage("§9"+silmaril);
				}
			}
			player.sendMessage("§c----------------------------------");
}
}
		public static void plColor(CStart p, DyeColor color) {
			if(p.Planatir != null && Bukkit.getPlayer(p.Planatir) != null) {
				Player player = Bukkit.getPlayer(p.Planatir);
				PlayerInventory inv = player.getInventory();
				int pl[] =Search.pInvItemSup(player, p.P);
				if(pl.length > 0) {
					ItemStack Planatir = new ItemStack(Material.STAINED_GLASS, 1, (short)0, color.getData());
					ItemMeta customPlanatir = p.P.getItemMeta();
					Planatir.setItemMeta(customPlanatir);
					p.P = Planatir;
					inv.setItem(pl[0], p.P);
				}
			}
		}
		public static void plPlace(CStart p) {
			Bukkit.broadcastMessage("Le Planatir a été posé? si non relancé");
			int dist = 1000;
			int minY = 11;
			int x =rand.nextInt(dist*2)-dist;
			int z =rand.nextInt(dist*2)-dist;
			int y =0;
			boolean sky = true;
			for(y = 0; sky == true; y++) {
			Location loc = new Location(p.world,x,y,z);
				if(loc.getBlock().getType() == Material.AIR) {
					sky = false;
				}
		}
			
			if(y>minY) {
			y = rand.nextInt(y-minY-2)+minY;
			}else{
				y = minY;
			}
			Loc = new Location(p.world,x,y,z);
			
			Loc.getBlock().setType(Material.STAINED_GLASS);
			Loc.getBlock().setData(DyeColor.WHITE.getData());
			Bukkit.broadcastMessage("Oui");
		}
		
		public static void lorienAcces(CStart p) {
			
			p.lorien.setCompassTarget(Loc);
			p.lorien.sendMessage("§2Vos Compas pointe désormais vers le planatir");
			
		}
		public static void eAcces(CStart p) {
			for(int i = 1; i<=p.nubPlayer; i++) {
	   			if(p.jouD[i] == true && p.jou[i] != null) {
	   				if(!p.jou[i].getName().equalsIgnoreCase(p.lorienS)) {
	   				p.jou[i].setCompassTarget(Loc);
	   				}
	   			}
			}
			Bukkit.broadcastMessage("§2Vos Compas pointe désormais vers l'emplacement du planatir");
			
		}
		
		
}