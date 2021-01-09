package com.Wolf_IV.AnuirUHC;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Role.Maedhros;
import com.Wolf_IV.AnuirUHC.Role.Saruman;
import com.Wolf_IV.AnuirUHC.Role.Tulkas;

public class Search {

	public void dayRole(CStart p) {
	Maedhros.nDay(p);
	Tulkas.nDay(p);
	Saruman.nDay(p);
	}
	
	public static Player[] pNext(Player player, CStart p, int dis){
		Bukkit.broadcastMessage("hey1");
		Player[] pl = new Player[24+1+1];
		int pI = 0;
		Bukkit.broadcastMessage("hey2");
		for(int i = 1; i<=p.nubPlayer; i++) {
			Bukkit.broadcastMessage("jouD = "+p.jouD[i]+"jou = "+p.jou[i]);
   			if(p.jouD[i] == true && p.jou[i] != null) {
   				Bukkit.broadcastMessage("i2 = "+i);
   				double xd = Math.abs(player.getLocation().getX() - p.jou[i].getLocation().getX());
   				double yd = Math.abs(player.getLocation().getY() - p.jou[i].getLocation().getY());
   				double zd = Math.abs(player.getLocation().getZ() - p.jou[i].getLocation().getZ());
   				Bukkit.broadcastMessage("i3 = "+i);
   				if(xd <=dis && yd <= dis && zd <= dis) {
   					Bukkit.broadcastMessage("i4 = "+i);
   					pl[pI] = p.jou[i];
   					pI++;
   					Bukkit.broadcastMessage("i5 = "+i);
   				}
   			}
		}
		return pl;
	}

	
}
