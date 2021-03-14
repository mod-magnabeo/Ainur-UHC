package com.Wolf_IV.AnuirUHC.Role;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Melkor {
	static Random rand = new Random();
	static boolean crown = false;
	
	public static void crownCheck(CStart p) {
		if(p.doubleMMort == true) {
			Bukkit.broadcastMessage("§cLa couronne n'a pas pu etre crafter car melkor et sauron sont mort");
		}
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
			if(p.sauronS != null && p.MelkorS != null && p.sauronS.equalsIgnoreCase(p.MelkorS)) {
				Bukkit.broadcastMessage("§6Les balrogs on obtenu les trois silmarils. Sauron a construit sa couronne de fer. "
						+ "Sauron peut desormais transformer un joueur en Orc. Ungoliant est révèler");
			}else {
			Bukkit.broadcastMessage("§6Les balrogs on obtenu les trois silmarils. Melkor a construit sa couronne de fer. "
					+ "Et il est maintenant connu sous le nom de Morgoth. Morgoth peut desormais transformer un joueur en Orc. Ungoliant est révèler");
			}

			for(Player evil : p.evil) {
				if(evil != null) {
					int SFR = rand.nextInt(2);
					if(SFR == 0) {
						evil.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200*20*15/*15 jours*/, 0, false, false));
					}else if(SFR == 1) {
						evil.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200*20*15/*15 jours*/, 0, false, false));
					}else {
						evil.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200*20*15/*15 jours*/, 0, false, false));
					}
					Search.pInvItemSup(evil, p.SB);
					Search.pInvItemSup(evil, p.SG);
					Search.pInvItemSup(evil, p.SR);
				}
			}

			p.SVert = null;
			p.SBleu = null;
			p.SRouge = null;

			crown = true;
			Ungoliant.trans(p);
		}
	}
	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.Melkor) {
			return false;
		}
		if(crown==false) {
			if(TimerTasks.jN == true) {
				StringBuilder bc = new StringBuilder();
				for(String part : args) {
					bc.append(part+ " ");
				}
				String msg = bc.toString();
				for(Player evil : p.evil) {
					if(evil != null) {
						evil.sendMessage("§2Melkor : §c"+msg);
					}
				}
				if(p.luthien != null) {
					p.luthien.sendMessage("§2§kMelkor §r§2: §c"+msg);
				}
				
			}else {
				player.sendMessage("§bParle la nuit");
			}
			return true;
		}
		if(p.OrcS == null) {
			Player pl[] = Search.getLivingAndConnectedPlayers(p, p.Eru_Iluvatar);
			int pi = 0;
			Inventory inv = Bukkit.createInventory(null, 27, "§cTransformer un joueur:");
			for(Player playerO : pl) {
				if(playerO != null) {
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
