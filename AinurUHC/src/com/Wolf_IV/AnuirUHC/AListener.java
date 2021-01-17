package com.Wolf_IV.AnuirUHC;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Skull;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Role.EruIluvatar;
import com.Wolf_IV.AnuirUHC.Role.Namo;
import com.Wolf_IV.AnuirUHC.Role.SBleu;
import com.Wolf_IV.AnuirUHC.Role.SRouge;
import com.Wolf_IV.AnuirUHC.Timers.TimerProt;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class AListener implements Listener {
	
	int i;
	
	private static CStart p;
	public AListener(CStart cstart) {
	this.p=cstart;
	}
	
	
	/*@EventHandler
	  public void onEntityDeath(EntityDeathEvent event) {
			if (!(event.getEntity() instanceof Player)) {
			      return;
			    }
			 Player victim = (Player)event.getEntity();
			 EntityDamageEvent e = event.getEntity().getLastDamageCause();
			    if (!(e instanceof EntityDamageByEntityEvent)) {
			      return;
			    }
			    EntityDamageByEntityEvent nEvent = (EntityDamageByEntityEvent)e;
			 
			    if (!(nEvent.getDamager() instanceof Player)) {
			      return;
			    }
			    //Player killed
			    
			    Player killer = (Player)nEvent.getDamager();
	}*/
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
			Player player=event.getPlayer();
		
		
		if(p.MelkorS != null && p.MelkorS.equalsIgnoreCase(player.getName())) {
		p.Melkor = player;
		}else if(p.sauronS != null && p.sauronS.equalsIgnoreCase(player.getName())) {
			p.sauron = player;
		}else if(p.ungoliantS != null && p.ungoliantS.equalsIgnoreCase(player.getName())) {
			p.ungoliant = player;
		}else if(p.balrog_infiltréS != null && p.balrog_infiltréS.equalsIgnoreCase(player.getName())) {
			p.balrog_infiltré = player;
		}else if(p.balrog_traceurS != null && p.balrog_traceurS.equalsIgnoreCase(player.getName())) {
			p.balrog_traceur = player;
		}else if(p.FeanorS != null && p.FeanorS.equalsIgnoreCase(player.getName())) {
			p.Feanor = player;
		}else if(p.Eru_IluvatarS != null && p.Eru_IluvatarS.equalsIgnoreCase(player.getName())) {
			p.Eru_Iluvatar = player;
		}else if(p.manwéS != null && p.manwéS.equalsIgnoreCase(player.getName())) {
			p.manwé = player;
		}else if(p.oroméS != null && p.oroméS.equalsIgnoreCase(player.getName())) {
			p.oromé = player;
		}else if(p.namoS != null && p.namoS.equalsIgnoreCase(player.getName())) {
			p.namo = player;
		}else if(p.saurumanS != null && p.saurumanS.equalsIgnoreCase(player.getName())) {
			p.sauruman = player;
		}else if(p.gandalfS != null && p.gandalfS.equalsIgnoreCase(player.getName())) {
			p.gandalf = player;
		}else if(p.lorienS != null && p.lorienS.equalsIgnoreCase(player.getName())) {
			p.lorien = player;
		}else if(p.scorcier_bleu_1S != null && p.scorcier_bleu_1S.equalsIgnoreCase(player.getName())) {
			p.scorcier_bleu_1 = player;
		}else if(p.scorcier_bleu_2S != null && p.scorcier_bleu_2S.equalsIgnoreCase(player.getName())) {
			p.scorcier_bleu_2 = player;
		}else if(p.auléS != null && p.auléS.equalsIgnoreCase(player.getName())) {
			p.aulé = player;
		}else if(p.fingolfinS != null && p.fingolfinS.equalsIgnoreCase(player.getName())) {
			p.fingolfin = player;
		}else if(p.vardaS != null && p.vardaS.equalsIgnoreCase(player.getName())) {
			p.varda = player;
		}else if(p.maedhrosS != null && p.maedhrosS.equalsIgnoreCase(player.getName())) {
			p.maedhros = player;
		}else if(p.tulkasS != null && p.tulkasS.equalsIgnoreCase(player.getName())) {
			p.tulkas = player;
		}
		
		if(p.OrcS.equalsIgnoreCase(player.getName())) {
			p.Orc = player;
		}
		for(i=1;i<=24;i++) {
			if(p.jouS[i].equalsIgnoreCase(player.getName())) {
				p.jou[i] = player;
			}
			for(i=1;i<=24;i++) {
				if(p.jouHitS[i].equalsIgnoreCase(player.getName())) {
					p.jouHit[i] = player;
				}
			}
		for(i=1;i<=9;i++) {
			if(p.evilS[i].equalsIgnoreCase(player.getName())) {
				p.evil[i] = player;
			}
			}
		for(i=1;i<=7;i++) {
			if(p.balrogS[i].equalsIgnoreCase(player.getName())) {
				p.balrog[i] = player;
			}
			}
		
		
	}
	}
	@EventHandler
    public void onTestEntityDamage(EntityDamageByEntityEvent event) {
		if(TimerTasks.Ingame != true) {
			return;
		}
	
		if (!(event.getDamager() instanceof Player)){
            if (!(event.getEntity() instanceof Player)) {
            	return;
            }
		}
            	 Player victim = (Player)event.getEntity();
            	 Player Damager = (Player)event.getDamager();
            	 for(i = 1; i<=p.nubPlayer; i++) {
         			if(victim == p.jou[i]) {
         				p.jouHit[i]=Damager;
         				p.jouHitS[i]=Damager.getName();
         			
            	 
		}
	}
            	
	
}
	
	@EventHandler
    public void onDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();

		if(player.getHealth()-event.getDamage() <=0) {
			 for(i = 1; i<=p.nubPlayer; i++) {
	       			if(p.jou[i] != null && player == p.jou[i]) {
	       				p.jouD[i]=false;
	       			if(p.jouHit[i] ==null) {
	       					return;
	       				}
	       			
	       			event.setCancelled(true);
	       			if(p.SVert != null && player.getName().equalsIgnoreCase(p.SVert)) {
	       				player.setMaxHealth(Math.round(player.getMaxHealth()/2));
	       				player.setHealth(player.getMaxHealth());
	       				p.SGU = false;
	       				ItemMeta Imeta = p.SG.getItemMeta();
	    				Imeta.removeEnchant(Enchantment.ARROW_KNOCKBACK);  
	    				Imeta.setLore(Arrays.asList("§cSilmaril utilisé"));
	    				p.SG.setItemMeta(Imeta);
	    				player.getInventory().setItemInHand(p.SG);
	    				player.sendMessage("§6La puissance de la lumière des arbre de Valianor du §aSilmaril Vert §6vous confère une seconde vie, mais vous avez désormais perdu la moitiè de votre vie de façon permanente");
	       				Search.Revive(player, p);
	       			}if(p.Eru_Iluvatar != null &&p.Eru_Iluvatar == player && EruIluvatar.raise == true) {
	       				 EruIluvatar.onDead(p.jouHit[i], p);
	       			}
	       			 
	       			}}
		}
			
		}
		}
	
	@SuppressWarnings("static-access")
	@EventHandler
	  public void onEntityDeath(EntityDeathEvent event) {
		
		if (!(event.getEntity() instanceof Player)) {
		      return;
		    }
		
		      Player victim = (Player)event.getEntity();
		      for(i = 1; i<=p.nubPlayer; i++) {
       			if(p.jou[i] != null && victim == p.jou[i]) {
       				p.jouD[i] = false;
       			
       				
       				if(p.jouHit[i] ==null) {
       					Namo.lastDead = "§a"+victim.getName()+" est mort de PVE";
       					return;
       				}
       				
       			 Namo.lastDead = "§a"+p.jouHit[i].getName()+" est la derniere personne a avoir frapper "+victim.getName();
       			 if(victim == p.Eru_Iluvatar) {
       				 EruIluvatar.onDead(p.jouHit[i], p);
       			 }
       			}}
		  
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player =(Player) event.getWhoClicked();
		ItemStack current= event.getCurrentItem();
		if(inv.getName().equalsIgnoreCase("§bChoisir:")) {
		if(current==null) return;
		
		event.setCancelled(true);
		
		if(current.getItemMeta().getDisplayName().equals("§aRevive")) {
			Search.Revive(player, p);
			player.closeInventory();
			EruIluvatar.raise = true;
		}else if(current != null) {
			if(Bukkit.getPlayer(current.getItemMeta().getDisplayName().substring(21)) != null) {
				Player killer = Bukkit.getPlayer(current.getItemMeta().getDisplayName().substring(21));
				killer.setMaxHealth(killer.getMaxHealth()-10.0F);
				killer.sendMessage("§bEru Iluvatar vous retire 5 coeur permanent");
				player.closeInventory();
				player.sendMessage("§bVous avez retirer 5 coeur à "+killer.getDisplayName());
				EruIluvatar.raise = true;
			}else {
				player.sendMessage("§4Joueur déconnecter");
			}
		}
		
		}else if(inv.getName().equalsIgnoreCase("§bTeleporter a un joueur:")) {
			if(current == null) return;
			event.setCancelled(true);
			if(current.getType() == Material.SKULL_ITEM && current.getItemMeta().hasDisplayName()) {
				SkullMeta skullM = (SkullMeta) current.getItemMeta();
				for(int i = 1; i<=p.nubPlayer; i++) {
					Bukkit.broadcastMessage(p.jou[i].getDisplayName()+" owner"+skullM.getOwner());
					if(p.jou[i] !=  null && p.jouD[i] == true && p.jou[i].getName().equalsIgnoreCase(skullM.getOwner())) {
	       				player.teleport(p.jou[i]);
	       				
	       				player.closeInventory();
	       				player.sendMessage("§eVous avez été Teleporter");
	       				p.SBU = false;
	       				ItemMeta Imeta = p.SB.getItemMeta();
	       				Imeta.removeEnchant(Enchantment.ARROW_KNOCKBACK);  
	       				Imeta.setLore(Arrays.asList("§cSilmaril utilisé"));
	       				p.SB.setItemMeta(Imeta);
	       				player.getInventory().setItemInHand(p.SB);
	       				return;
	       			}
				}
				player.sendMessage("§4Le joueur est aculement indisponible");
			}
		}
	}
	 @EventHandler
	    public void onItemDrop (PlayerDropItemEvent event) {
	        Player player = event.getPlayer();
	       
	            Item drop = event.getItemDrop();
	            if (drop.getItemStack().getType() == Material.INK_SACK) {
	            	player.sendMessage("§4Jeté pas vos silmarils");
	                event.setCancelled(true);  
	            }
	    }
	 
	 
	 @EventHandler
		public void onInteract(PlayerInteractEvent event) {
			Player player =event.getPlayer();
			Action action =event.getAction();
			ItemStack it =event.getItem();
			
			
			if(it != null) {
				if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName() == p.SB.getItemMeta().getDisplayName()) {
				SBleu.interact(player, action, p);
				}else if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName() == p.SR.getItemMeta().getDisplayName()) {
				SRouge.interact(player, action, p);
				}
				
				
			}
			
	 }
	 
	
	
}