package com.Wolf_IV.AnuirUHC.Role;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

public class SRouge {
	static Random rand = new Random();
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
			for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					for(int ii = 0; ii<=500; ii++) {
						 float x = (rand.nextInt(3)+rand.nextFloat())-2.0F;
						float y = (rand.nextInt(3)+rand.nextFloat())-2.0F;
						float z = (rand.nextInt(3)+rand.nextFloat())-2.0F;
						if(x+y+z <= 2.0F && x+y+z >= -2.0F) {
																																																									//Rouge  Vert    Bleu en dégatif de 0 à -1
				PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.SPELL_MOB, true, (float) playerO.getLocation().getX()+x, (float) playerO.getLocation().getY()+y, (float) playerO.getLocation().getZ()+z, -1.0F, 0.0F, 0.0F, -10.0F, 0);
					((CraftPlayer)playerO).getHandle().playerConnection.sendPacket(particle);
						}
					}
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
