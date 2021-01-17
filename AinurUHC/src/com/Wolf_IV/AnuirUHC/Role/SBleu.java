package com.Wolf_IV.AnuirUHC.Role;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Wool;

import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class SBleu {

	public static void interact(Player player, Action action, CStart p) {
		
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(!p.SBleu.equalsIgnoreCase(player.getDisplayName())) {
				player.sendMessage("§bVous n'avez pas le silmaril");
				return;
			}
			if(p.SBU == false) {
				player.sendMessage("§bLe simarils a déja été utilisé");
				return;
			}
			Inventory inv = Bukkit.createInventory(null, 27, "§bTeleporter a un joueur:");
			
			int pi = 0;
			for(int i = 1; i<=p.nubPlayer; i++) {
       			if(p.jou[i] !=  null && p.jouD[i] == true) {
       				ItemStack skull = new ItemStack(397, 1, (short) 3);
       				SkullMeta meta = (SkullMeta) skull.getItemMeta();
       				meta.setDisplayName("§aChoisir §b"+p.jou[i].getName());
       				meta.setOwner(p.jou[i].getName());
       				skull.setItemMeta(meta);
       				
       				inv.setItem(pi, skull);
       				pi++;
       				
       			}
			}
			
			
			
			player.openInventory(inv);
		}
		
		
	}

}
