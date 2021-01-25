package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class Melkor {
	static boolean crown = false;
	
	public static void crownCheck(CStart p) {
		int sil = 0;
		for(String evil : p.evilS) {
			if(evil != null) {
				if(evil.equalsIgnoreCase(p.SBleu)) {
					sil++;
				}
				if(evil.equalsIgnoreCase(p.SVert)) {
					sil++;
				}
				if(evil.equalsIgnoreCase(p.SRouge)) {
					sil++;
				}
			}
		}
		
		if(sil == 3) {
			Bukkit.broadcastMessage("§6Les balrogs on obtenu les trois silmarils. Melkor a construit sa couronne de fer. "
					+ "Et il est maintenant connu sous le nom de Morgoth. Morgoth peut desormais transformer un joueur en Orc. Ungoliant est révèler");
			Bukkit.broadcastMessage("hop la");
			for(Player evil : p.evil) {
				if(evil != null) {
					Search.pInvItemSup(evil, p.SB);
					Search.pInvItemSup(evil, p.SG);
					Search.pInvItemSup(evil, p.SR);
				}
			}
			Bukkit.broadcastMessage("hop la la");
			p.SVert = null;
			p.SBleu = null;
			p.SRouge = null;
			Bukkit.broadcastMessage("hop la la la");
			crown = true;
			Bukkit.broadcastMessage("hop la la la la");
		}
	}
	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.Melkor) {
			return false;
		}
		if(p.OrcS == null) {
			Player pl[] = Search.getLivingAndConnectedPlayers(p, p.Eru_Iluvatar);
			int pi = 0;
			Inventory inv = Bukkit.createInventory(null, 27, "§cTransformer un joueur:");
			for(Player playerO : pl) {
				if(playerO != null) {
					Bukkit.broadcastMessage("nom = "+playerO);
			ItemStack skull = new ItemStack(397, 1, (short) 3);
				SkullMeta meta = (SkullMeta) skull.getItemMeta();
				meta.setOwner(playerO.getName());
				skull.setItemMeta(meta);
				
				inv.setItem(pi, skull);
				pi++;
			}
			}
			p.Melkor.openInventory(inv);
		}
		
		return true;
	}

}
