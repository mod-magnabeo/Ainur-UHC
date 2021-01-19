package com.Wolf_IV.AnuirUHC.Role;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.CDON;
import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class Feanor {
	static Random rand = new Random();
	static int rando;
		public static void giveF(Player player, CStart p) {
			Bukkit.broadcastMessage("Hello");
			player.getInventory().setHeldItemSlot(0);
			 ItemStack G = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.MAGENTA/*Green*/.getData());
			ItemMeta customG = G.getItemMeta();
			customG.setDisplayName("§aSilmaril Vert");
			customG.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
			customG.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			G.setItemMeta(customG);
			p.SG = G;
			p.SVert = player.getDisplayName();
			player.getInventory().setItemInHand(G);
			
			player.getInventory().setHeldItemSlot(1);
			ItemStack R = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.ORANGE/*RED*/.getData());
			ItemMeta customR = R.getItemMeta();
			customR.setDisplayName("§cSilmaril Rouge");
			customR.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
			customR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			R.setItemMeta(customR);
			p.SR = R;
			p.SRouge = player.getDisplayName();
			player.getInventory().setItemInHand(R);
			
			player.getInventory().setHeldItemSlot(2);
			ItemStack B = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.PINK/*CYAN*/.getData());
			ItemMeta customB = B.getItemMeta();
			customB.setDisplayName("§bSilmaril Bleu");
			customB.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
			customB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			B.setItemMeta(customB);
			p.SB = B;
			p.SBleu = player.getDisplayName();
			player.getInventory().setItemInHand(B);
		}
		public static void distribution(CStart p) {
			if(p.FeanorS == null) {
				return;
			}
			int si = 0;
			int i = 0;
			String sil[] = new String[4];
			Player pl[] = Search.getLivingAndConnectedPlayers(p, p.Feanor);
			Player plg[] = new Player[4];
			if(pl.length == 0) {
				return;
			}else if(pl.length >= 3) {
				rando=rand.nextInt(pl.length*10)+10;
				for(i=0;i<=rando;i++) {
					int choose=rand.nextInt(pl.length);
					int choose2=rand.nextInt(pl.length);
					Player container=pl[choose2];
					pl[choose2]=pl[choose];
					pl[choose]=container;
					}
				for(i = 0; i<=2;i++) {
				plg[i] = pl[i];
				}
			}else {
				for(i = 0; i<=2;i++) {
					plg[i] = pl[rand.nextInt(pl.length)];
				}
			}
			if(p.SBleu.equalsIgnoreCase(p.FeanorS)) {
				//Probleme avec SB
				CDON.don(p.SB.getItemMeta(), plg[si], p, p.FeanorS);
				si++;
				Bukkit.broadcastMessage("§bTon silmarils Bleu a été donné a "+p.SBleu);
				if(p.Feanor != null) {
					Search.pInvItemSup(p.Feanor, p.SB);
				}
			}if(p.SVert.equalsIgnoreCase(p.FeanorS)) {
				CDON.don(p.SG.getItemMeta(), plg[si], p, p.FeanorS);
				si++;
				Bukkit.broadcastMessage("§bTon silmarils Vert a été donné a "+p.SVert);
				if(p.Feanor != null) {
					Search.pInvItemSup(p.Feanor, p.SG);
				}
			}if(p.SRouge.equalsIgnoreCase(p.FeanorS)) {
				//Bizare donne a Feanor
				CDON.don(p.SR.getItemMeta(), plg[si], p, p.FeanorS);
				si++;
				Bukkit.broadcastMessage("§bTon silmarils Rouge a été donné a "+p.SRouge);
				if(p.Feanor != null) {
					Search.pInvItemSup(p.Feanor, p.SR);
				}
			}
		}
}
