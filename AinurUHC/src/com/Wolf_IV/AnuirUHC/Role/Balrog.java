package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Balrog {
	public String dev[] = new String[24+1+1];
	public int dernierJ = 0;
	public String player;

	public static boolean u(CStart p, Player player, String[] args) {
		boolean balrogI = false;
		for(Player balrog : p.balrog) {
			if(balrog != null && balrog == player) {
				balrogI = true;
			}
		}
		if(!balrogI) {
			return false;
		}
		if(args.length == 0) {
			player.sendMessage("�b/u [player]");
			return true;
		}
		if(Search.balFinder(p, player.getName()).dernierJ == TimerTasks.timeDay) {
			player.sendMessage("�4Vous avez d�j� utilis� votre pouvoir aujourd'hui");
			return true;
		}
		for(String cible : Search.balFinder(p, player.getName()).dev) {
			if(cible != null && cible.equalsIgnoreCase(args[0])) {
				player.sendMessage("�4Vous avez d�j� choisi cette personne");
				return true;
			}
		}
		for(String cible : p.deviner) {
			if(cible != null && cible.equalsIgnoreCase(args[0])) {
				player.sendMessage("�4Cette personne a d�j� �t� atteint aujourd'hui");
				return true;
			}
		}
		
		Inventory inv = Bukkit.createInventory(null, 27, "�cQui est "+args[0]);
		int pi =0;
		for(Role role : p.role) {
			if(role != null) {
			ItemStack roleP = new ItemStack(Material.PAPER);
			ItemMeta meta = roleP.getItemMeta();
			meta.setDisplayName(role.getRole());
			roleP.setItemMeta(meta);
			inv.setItem(pi, roleP);
			pi++;
			}
		}
		
			
		player.openInventory(inv);
		
		return true;
	}
	
	public static void nDay(CStart p) {
		for(int i=1;i<=5;i++) {
			if(p.deviner[i] != null && Bukkit.getPlayer(p.deviner[i]) != null) {
				Player player = Bukkit.getPlayer(p.deviner[i]);
				p.deviner[i] = null;
				player.setHealth(player.getHealth()+4.0F);
				
			}
		}
		
	}

}
