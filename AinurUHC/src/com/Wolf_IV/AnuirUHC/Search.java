package com.Wolf_IV.AnuirUHC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Role.Maedhros;
import com.Wolf_IV.AnuirUHC.Role.Role;
import com.Wolf_IV.AnuirUHC.Role.Saruman;
import com.Wolf_IV.AnuirUHC.Role.Tulkas;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Search {
static Random rand =new Random();
	public void dayRole(CStart p) {
	Maedhros.nDay(p);
	Tulkas.nDay(p);
	Saruman.nDay(p);
	}
	
	public static Player[] pNext(Player player, CStart p, int dis){
		Player[] pl = new Player[24+1+1];
		int pI = 0;
		for(int i = 1; i<=p.nubPlayer; i++) {
   			if(p.jouD[i] == true && p.jou[i] != null) {
   				double xd = Math.abs(player.getLocation().getX() - p.jou[i].getLocation().getX());
   				double yd = Math.abs(player.getLocation().getY() - p.jou[i].getLocation().getY());
   				double zd = Math.abs(player.getLocation().getZ() - p.jou[i].getLocation().getZ());
   				if(xd <=dis && yd <= dis && zd <= dis) {
   					pl[pI] = p.jou[i];
   					pI++;
   				}
   			}
		}
		return pl;
	}
	
	public static Role roleF(String player, CStart p){
		  for(int i = 1; i<=p.nubPlayer; i++) {
			  if(p.role[i].getPlayer().equalsIgnoreCase(player)) {
				  return p.role[i];
			  }
		  }
		return null;
	}
	
	public static void Revive(Player player, CStart p) {
		for(int i = 1; i<=p.nubPlayer; i++) {
			if(p.jou[i] != null && player == p.jou[i]) {
				p.jouD[i] = true;
				int dist = 1000;
				if(TimerTasks.timeDay>=6) {
					dist = 100;
				}
				int x =rand.nextInt(dist*2)-dist;
				int z =rand.nextInt(dist*2)-dist;
				int y;
				boolean sky = true;
				for(y = 254; sky == true; y--) {
				
					Location loc = new Location(player.getWorld(),x,y,z);
					if(loc.getBlock().getType() != Material.AIR) {
						sky = false;
						player.teleport(new Location(player.getWorld(),x,y+2,z));
						player.setGameMode(GameMode.SURVIVAL);
					}
			}
			}
		}
	}
	
	public static Player[] getLivingAndConnectedPlayers(CStart p, Player pNon/*Mettre a null si tu veut pas enlever de joueur*/) {
		Player[] pl = new Player[24+1+1];
		int pI = -1;
		for(int i = 1; i<=p.nubPlayer; i++) {
   			if(p.jouD[i] == true && p.jou[i] != null) {
   				if(pNon == null || pNon != p.jou[i]) {
   					pI++;
   				pl[pI] = p.jou[i];
   				}
   				
   			}
		}
		Bukkit.broadcastMessage("pI = "+pI);
		Player[] lpl = new Player[pI+1];
   		int ii =-1;
   		for(Player player : pl) {
   			if(player != null){
   				Bukkit.broadcastMessage(player.getDisplayName());
   				ii++;
   				lpl[ii] = player;
   				Bukkit.broadcastMessage("ii = "+ii);
   				
   			}else {
   				return lpl;
   			}
   		}
   	return lpl;
	}
	public static int[] pInvItemSup(Player player, ItemStack item) {
		PlayerInventory inv = player.getInventory();
		int s[]= new int[36];
		int si = -1;
		int slot = 0;
		while(slot <= 35) {
			if(inv.getItem(slot) != null && inv.getItem(slot).getType()  == item.getType()) {
				if(!inv.getItem(slot).getItemMeta().hasDisplayName() || inv.getItem(slot).getItemMeta().getDisplayName().equalsIgnoreCase(item.getItemMeta().getDisplayName())) {
					inv.setItem(slot, null);
					si++;
					s[si]=slot;
				}
			}
			slot++;
		}
		int sr[]= new int[si+1];
		return sr;
	}
	
	public static String[] melangerS(String[] s, int max, int round, int min) {
		int rando=rand.nextInt(round)+Math.round(round/5);
		for(int i=0;i<=rando;i++) {
			int choose=rand.nextInt(max)+min;
			int choose2=rand.nextInt(max)+min;
			String container=s[choose2];
			s[choose2]=s[choose];
			s[choose]=container;
			}
		return s;
	}

	
}
