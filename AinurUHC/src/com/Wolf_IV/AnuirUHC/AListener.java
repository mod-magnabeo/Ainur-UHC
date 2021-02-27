package com.Wolf_IV.AnuirUHC;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Skull;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Role.EruIluvatar;
import com.Wolf_IV.AnuirUHC.Role.Feanor;
import com.Wolf_IV.AnuirUHC.Role.Fingolfin;
import com.Wolf_IV.AnuirUHC.Role.Namo;
import com.Wolf_IV.AnuirUHC.Role.Planatir;
import com.Wolf_IV.AnuirUHC.Role.Role;
import com.Wolf_IV.AnuirUHC.Role.SBleu;
import com.Wolf_IV.AnuirUHC.Role.SRouge;
import com.Wolf_IV.AnuirUHC.Timers.TimerMort;
import com.Wolf_IV.AnuirUHC.Timers.TimerProt;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

public class AListener implements Listener {
	Random rand =new Random();
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
		}else if(p.FeanorS != null && p.FeanorS.equalsIgnoreCase(player.getName())) {
			p.Feanor = player;
		}else if(p.Eru_IluvatarS != null && p.Eru_IluvatarS.equalsIgnoreCase(player.getName())) {
			p.Eru_Iluvatar = player;
		}else if(p.manwéS != null && p.manwéS.equalsIgnoreCase(player.getName())) {
			p.manwé = player;
		}else if(p.luthienS != null && p.luthienS.equalsIgnoreCase(player.getName())) {
			p.luthien = player;
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
		
		if(p.balrog_infiltréS != null && p.balrog_infiltréS.equalsIgnoreCase(player.getName())) {
			p.balrog_infiltré = player;
		}else if(p.balrog_noirS != null && p.balrog_noirS.equalsIgnoreCase(player.getName())) {
			p.balrog_noir = player;
		}
		if(p.finMechantS != null && p.finMechantS.equalsIgnoreCase(player.getName())) {
			p.finMechant = player;
		}
		if(p.OrcS != null && p.OrcS.equalsIgnoreCase(player.getName())) {
			p.Orc = player;
		}
		for(i=1;i<=24;i++) {
			if(p.jouS[i] != null && p.jouS[i].equalsIgnoreCase(player.getName())) {
				p.jou[i] = player;
			}
			
		}
			for(i=1;i<=24;i++) {
				if(p.jouHitS[i] != null && p.jouHitS[i].equalsIgnoreCase(player.getName())) {
					p.jouHit[i] = player;
				}
			}
		for(i=1;i<=11;i++) {
			if(p.evilS[i] != null && p.evilS[i].equalsIgnoreCase(player.getName())) {
				p.evil[i] = player;
			}
			}
		for(i=1;i<=7;i++) {
			if(p.balrogS[i] != null && p.balrogS[i].equalsIgnoreCase(player.getName())) {
				p.balrog[i] = player;
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
	       				
	       				if(p.SVert != null && p.SVert.equalsIgnoreCase(player.getDisplayName()) && p.SGU == true) {
	       				
	       				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
	       					for(int ii = 0; ii<=500; ii++) {
	       						 float x = (rand.nextInt(3)+rand.nextFloat())-2.0F;
	       						float y = (rand.nextInt(3)+rand.nextFloat())-2.0F;
	       						float z = (rand.nextInt(3)+rand.nextFloat())-2.0F;
	       						if(x+y+z <= 2.0F && x+y+z >= -2.0F) {
	       																																																									//Rouge  Vert    Bleu en dégatif de 0 à -1
	       				PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.SPELL_MOB, true, (float) playerO.getLocation().getX()+x, (float) playerO.getLocation().getY()+y, (float) playerO.getLocation().getZ()+z, 0.0F, -1.0F, 0.0F, -10.0F, 0);
	       					((CraftPlayer)playerO).getHandle().playerConnection.sendPacket(particle);
	       						}
	       				}
	       				}
	       				event.setCancelled(true);
		       				player.setMaxHealth(Math.round(player.getMaxHealth()/2));
		       				player.setHealth(player.getMaxHealth());
		       				p.SGU = false;
		       				ItemMeta Imeta = p.SG.getItemMeta();
		    				Imeta.removeEnchant(Enchantment.ARROW_KNOCKBACK);  
		    				Imeta.setLore(Arrays.asList("§cSilmaril utilisé"));
		    				p.SG.setItemMeta(Imeta);
		    				int pl[] = Search.pInvItemSup(player, p.SG);
		    				if(pl.length > 0) {
		    				player.getInventory().setItem(pl[0], p.SG);
		    				}
		    				player.sendMessage("§6La puissance de la lumière des arbre de Valianor du §aSilmaril Vert §6vous confère une seconde vie, mais vous avez désormais perdu la moitiè de votre vie de façon permanente");
		       				Search.Revive(player, p);
	       				}
	       			if(p.jouHit[i] ==null) {
	       					return;
	       				}
	       			
	       			
	       			if(p.Eru_Iluvatar != null &&p.Eru_Iluvatar == player && EruIluvatar.raise == true) {
	       				event.setCancelled(true);
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
       			
       				TimerMort tasks = new TimerMort(victim, p);
					tasks.runTaskTimer(p.main, 0, 20);
					TimerMort.lastMort = tasks;
       				Player killer = victim;
       				if(p.jouHit[i] ==null) {
       					Namo.lastDead = "§a"+victim.getName()+" est mort de PVE";
       					Player pl[] = Search.getLivingAndConnectedPlayers(p, null);
       					if(pl.length > 0) {
       						int plN = rand.nextInt(pl.length);
       						killer = pl[plN];
       					}else {
       						Bukkit.broadcastMessage("§4Il n'a plus de joueur pour donner sont silmarils");
       					}
       					//Randomisé le choix du joueur
       				}else {
       					Namo.lastDead = "§a"+p.jouHit[i].getName()+" est la derniere personne a avoir frapper "+victim.getName();
       					killer = p.jouHit[i];
       				}
       				
       			   if(Search.getLivingPlayers(p).length <= 12) {
     		    	  Fingolfin.j12(p);
     		      }
       				if(p.Feanor != null && p.Feanor == victim) {
       					Feanor.distribution(p, p.FeanorS, p.Feanor, true, true, true);
       				}else {
       			 //DONER SILMARILS
       			if(p.SBleu.equalsIgnoreCase(victim.getName())) {
    				//Probleme avec SB
    				CDON.don(p.SB.getItemMeta(), killer, p, victim.getName());
    					Search.pInvItemSup(victim, p.SB);
    			}if(p.SVert.equalsIgnoreCase(victim.getName())) {
    				CDON.don(p.SG.getItemMeta(), killer, p,victim.getName());
    					Search.pInvItemSup(victim, p.SG);
    			}if(p.SRouge.equalsIgnoreCase(victim.getName())) {
    				//Bizare donne a Feanor
    				CDON.don(p.SR.getItemMeta(), killer, p, victim.getName());
    					Search.pInvItemSup(victim, p.SR);
    			}
       				}
       			}}
		   
		      if(p.sauron != null &&victim == p.sauron) {
		    	  if(p.mMort == true) {
		    		 p.doubleMMort =true; 
		    	  }else {
		    		  p.mMort = true;
		    	  }
		      }
		      if(p.Melkor != null &&victim == p.Melkor) {
		    	  if(p.mMort == true) {
			    		 p.doubleMMort =true; 
			    	  }else {
			    		  p.mMort = true;
			    	  }
		    	  Bukkit.broadcastMessage("§cMelkor/Morgoth est mort. Sauron le remplace");
		    	  if(p.sauron != null) {
		    		  p.Melkor = p.sauron;
		    		  p.MelkorS = p.sauronS;
		    		  p.sauron.sendMessage("§aTu remplace maintenant Melkor/Morgoth tu beneficie de 2 coeur en plus");
		    		 p.sauron.setMaxHealth(p.sauron.getMaxHealth()+4.0F);
		    	  }else if(p.sauronS != null) {
		    		  p.MelkorS = p.sauronS;
		    	  }
		      }
		  
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player =(Player) event.getWhoClicked();
		ItemStack current= event.getCurrentItem();
		if(inv.getName().substring(0 , 9).equalsIgnoreCase("§cQui est")) {
			if(Bukkit.getPlayer(inv.getName().substring(10)) == null) {
				player.sendMessage("§4Joueur Déconnécter");
				player.closeInventory();
				return;
			}
			Player cible = Bukkit.getPlayer(inv.getName().substring(10));
			for(String dev : p.deviner) {
				if(dev != null && dev == cible.getName()) {
					player.sendMessage("§cCette personne a déjà était deviner aujourd'hui. Vous avez quand mème utilisié votre pouvoir");
				}
			}
			if(current==null) return;
			if(current.getType() != Material.PAPER) return;
			for(Role role : p.role) {
				if(role != null && role.getRole().equalsIgnoreCase(current.getItemMeta().getDisplayName())) {
					if(role.getPlayer().equalsIgnoreCase(cible.getName())) {
						cible.sendMessage("§cUn balrog a deviner votre role il vous enlève 2 coeur pendant le reste du jour");
						cible.setMaxHealth(cible.getMaxHealth()-4.0F);
						Search.balFinder(p, player.getName()).dernierJ = TimerTasks.timeDay;
						/*boolean doneAnCible = false;
						for(String anCible : Search.balFinder(p, player.getName()).dev) {
							if(anCible == null && doneAnCible == false) {
								anCible = cible.getName();
								doneAnCible = true;
							}
						}*/
						String anCible[] =  Search.balFinder(p, player.getName()).dev;
						boolean doneAnCible = false;
						for(i=1;i<=24;i++) {
							if(anCible[i] == null && doneAnCible == false) {
								anCible[i] = cible.getName();
								doneAnCible = true;
							}
						}
						
						boolean doneDev = false;
						for(i=1;i<=5;i++) {
							if(p.deviner[i] == null && doneDev == false) {
								p.deviner[i] = cible.getName();
								doneDev = true;
							}
						}
						
					}
					
				}
			}
			player.closeInventory();
		}else if(inv.getName().equalsIgnoreCase("§bChoisir:")) {
		if(current==null) return;
		
		event.setCancelled(true);
		
		if(current.getItemMeta().getDisplayName().equals("§aRevive")) {
			Search.Revive(player, p);
			player.closeInventory();
			
		}else if(current != null) {
			if(Bukkit.getPlayer(current.getItemMeta().getDisplayName().substring(21)) != null) {
				Player killer = Bukkit.getPlayer(current.getItemMeta().getDisplayName().substring(21));
				killer.setMaxHealth(killer.getMaxHealth()-10.0F);
				killer.sendMessage("§bEru Iluvatar vous retire 5 coeur permanent");
				player.closeInventory();
				player.sendMessage("§bVous avez retirer 5 coeur à "+killer.getDisplayName());
				
			}else {
				player.sendMessage("§4Joueur déconnecter");
			}
		}
		
		}else if(inv.getName().equalsIgnoreCase("§bChoisir un camp:")) {
			if(current==null) return;
			event.setCancelled(true);
			if(current.getItemMeta().getDisplayName().equals("§4Servir Melkor/Morgoth(Devenir Méchant)")) {
				Fingolfin.mechant(p);
			}else if(current.getItemMeta().getDisplayName().equals("§ePour gagner tu dois etre le dernier survivant")) {
				Fingolfin.neutre(p);
			}else if(current.getItemMeta().getDisplayName().equals("§aDevenir Gentil(Combatre Melkor/Morgoth)")) {
				Fingolfin.gentil(p);
			}
			player.closeInventory();
			
		}else if(inv.getName().equalsIgnoreCase("§cTransformer un joueur:")) {
			if(current == null) return;
			event.setCancelled(true);
			if(current.getType() == Material.SKULL_ITEM && current.getItemMeta().hasDisplayName()) {
				SkullMeta skullM = (SkullMeta) current.getItemMeta();
				for(Player playerO : Search.getLivingAndConnectedPlayers(p, p.Eru_Iluvatar)) {
					if(playerO != null && skullM.getOwner().equalsIgnoreCase(playerO.getName())) {
						p.Melkor.closeInventory();
						p.Orc = playerO;
						p.OrcS = playerO.getName();
						for(i=1;i<=11;i++) {
							if(p.evilS[i] == null) {
								p.evilS[i] = p.OrcS;
								p.evil[i] = p.Orc;
								p.Orc.sendMessage("§2Morgoth vous transforme en Orc. Vous faites desormais partie de l'équipe des Balrog. Faite /br");
								//BROADCAST
								Bukkit.broadcastMessage("§cMorgoth a transformé une personne en Orc. Cette Orc fait désormais partie de son équipe");
								return;
							}
						}
					}
				}
			}
		}	else if(inv.getName().equalsIgnoreCase("§bTeleporter a un joueur:")) {
		
			if(current == null) return;
			event.setCancelled(true);
			if(current.getType() == Material.SKULL_ITEM && current.getItemMeta().hasDisplayName()) {
				SkullMeta skullM = (SkullMeta) current.getItemMeta();
				for(int i = 1; i<=p.nubPlayer; i++) {
					if(p.jou[i] !=  null && p.jouD[i] == true && p.jou[i].getName().equalsIgnoreCase(skullM.getOwner())) {
	       				player.teleport(p.jou[i]);
	       				
	       				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
	       					for(int ii = 0; ii<=500; ii++) {
	       						 float x = (rand.nextInt(3)+rand.nextFloat())-2.0F;
	       						float y = (rand.nextInt(3)+rand.nextFloat())-2.0F;
	       						float z = (rand.nextInt(3)+rand.nextFloat())-2.0F;
	       						if(x+y+z <= 2.0F && x+y+z >= -2.0F) {
	       																																																									//Rouge  Vert    Bleu en dégatif de 0 à -1
	       				PacketPlayOutWorldParticles particle = new PacketPlayOutWorldParticles(EnumParticle.SPELL_MOB, true, (float) playerO.getLocation().getX()+x, (float) playerO.getLocation().getY()+y, (float) playerO.getLocation().getZ()+z, 0.0F, -0.1F, -0.5F, -10.0F, 0);
	       					((CraftPlayer)playerO).getHandle().playerConnection.sendPacket(particle);
	       						}
	       					}
	       				}
	       				
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
	            }else if(drop.getItemStack().getItemMeta().hasDisplayName() && drop.getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(p.P.getItemMeta().getDisplayName())) {
	            	player.sendMessage("§4Jeté pas votre Planatir");
	                event.setCancelled(true);  
	            }
	    }
	 
	 @EventHandler
	    public void onPlayerPlaceBlock (BlockPlaceEvent event) {
		 ItemStack it =event.getItemInHand();
		 if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName() == p.P.getItemMeta().getDisplayName()) {
			 event.setCancelled(true);
		 }
	 }
	 @EventHandler
	    public void onPlayerBreakBlock (BlockBreakEvent event) {
		 if(Planatir.disc == false && event.getBlock().getType() == Material.STAINED_GLASS && event.getBlock().getLocation().getBlockX() == Planatir.Loc.getBlockX()&& event.getBlock().getLocation().getBlockZ() == Planatir.Loc.getBlockZ()&& event.getBlock().getLocation().getBlockY() == Planatir.Loc.getBlockY()) {						//ORANGE A ENLEVé
			 ItemStack Planatir = new ItemStack(Material.STAINED_GLASS, 1, (short)0, DyeColor.WHITE/*White*/.getData());
			ItemMeta customPlanatir = Planatir.getItemMeta();
			customPlanatir.setDisplayName("§7Plantir");
			customPlanatir.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
			customPlanatir.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			Planatir.setItemMeta(customPlanatir);
			p.P = Planatir;
			p.Planatir =event.getPlayer().getDisplayName();
			event.getPlayer().getInventory().addItem(p.P);
			Bukkit.broadcastMessage("§9Le Planatir a été découvert");
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
				}else if(it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName() == p.P.getItemMeta().getDisplayName()) {
					//event.setCancelled(true);
				Planatir.interact(player, action, p);
				}
				
				
			}
			
	 }
	 
	
	
}