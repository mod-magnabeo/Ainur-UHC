package com.Wolf_IV.AnuirUHC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

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

	
}
