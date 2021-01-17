package com.Wolf_IV.AnuirUHC.Role;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class SRouge {
public static void interact(Player player, Action action, CStart p) {
		
		if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
			if(!p.SRouge.equalsIgnoreCase(player.getDisplayName())) {
				player.sendMessage("§bVous n'avez pas le silmaril");
				return;
			}
			if(p.SRU == false) {
				player.sendMessage("§bLe simarils a déja été utilisé");
				return;
			}
			double dégat = 4.0F;
			Player pl[] = Search.pNext(player, p, 15);
			for(Player playerH : pl) {
				if(playerH != null && playerH.getMaxHealth()>dégat) {
					playerH.sendMessage("§6La une des dernière lumiere des arbre de Valianor vous atteint §cle Silmaril Rouge §6vous retire 2 coeur permanent");
					playerH.setMaxHealth(playerH.getMaxHealth()-dégat);
				}
			}
			player.sendMessage("§aLe silmarils a été utilisé");
			p.SRU = false;
			ItemMeta Imeta = p.SR.getItemMeta();
				Imeta.removeEnchant(Enchantment.ARROW_KNOCKBACK);  
				Imeta.setLore(Arrays.asList("§cSilmaril utilisé"));
				p.SR.setItemMeta(Imeta);
				player.getInventory().setItemInHand(p.SR);
			
			
		}
		
		
	}
}
