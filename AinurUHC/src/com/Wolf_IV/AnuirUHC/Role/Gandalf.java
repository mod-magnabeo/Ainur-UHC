package com.Wolf_IV.AnuirUHC.Role;

import java.util.Random;

import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class Gandalf {
static Random rand = new Random();
	public static boolean u(CStart p, Player player, String[] args) {
		int inspect = 3;
		int pourcentage = 80;
		if(player != p.gandalf) {
			return false;
		}
		if(args.length == 0) {
			player.sendMessage("§4/u [player a 10 blocks]");
			return true;
		}
		if(inspect == 0) {
			player.sendMessage("§cIl te reste plus d'inspections");
			return true;
		}
		boolean evil = false;
		Player[] pl = Search.pNext(player, p, 10);
		for(Player play : pl) {
			if(play.getName().equalsIgnoreCase(args[0])) {
				for(Player ev : p.evil) {
					if(ev == play) {
						evil = true;
					}
				}
				if(play == p.balrog_infiltré) {
					evil = false;
				}
				if(rand.nextInt(100)+1 >= pourcentage) {
					evil = !evil;
				}
				if(evil) {
				player.sendMessage("§a"+play.getDisplayName()+" est supposé méchant");
				}else {
					player.sendMessage("§a"+play.getDisplayName()+" est supposé gentil");
				}
				player.sendMessage("§cIl te reste "+inspect+" inspection(s)");
				return true;
			}
		}
		player.sendMessage("§4Ce joueur n'est pas à 10 blocks de vous");
		return true;
	}

}
