package com.Wolf_IV.AnuirUHC;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerProt;

public class AListener implements Listener {
	public static Player TB1= null;
	public static Player TB2= null;
	public static Player TV1= null;
	public static Player TV2= null;
	public static Player TM1= null;
	public static Player TM2= null;
	public static Player TN1= null;
	public static Player TN2= null;
	public static Player TJ1= null;
	public static Player TJ2= null;
	@EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
		 if (event.getEntity() instanceof Player) {
             Player victim = (Player)event.getEntity();
            if(TimerProt.NoHurtA==true) {
                event.setCancelled(true);
            }
		 }
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player =event.getPlayer();
		Action action =event.getAction();
		ItemStack it =event.getItem();
		if(it != null) {
			if(it.hasItemMeta() && it.getItemMeta().hasDisplayName()) {
				if(it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nvert) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nnoir) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nmagenta) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Njaune) || it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nbleu)) {
					if(TB1==player) {
						TB1= null;
					}
					if(TB2==player) {
						TB2= null;
					}
					if(TJ1==player) {
						TJ1= null;
					}
					if(TJ2==player) {
						TJ2= null;
					}
					if(TN1==player) {
						TN1= null;
					}
					if(TN2==player) {
						TN2= null;
					}
					if(TV1==player) {
						TV1= null;
					}
					if(TV2==player) {
						TV2= null;
					}
					if(TM1==player) {
						TM1= null;
					}
					if(TM2==player) {
						TM2= null;
					}
				}
			}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nbleu)) {
		if(TB1==null) {
			TB1=player;
			Bukkit.broadcastMessage("§1"+player.getName()+" A rejoin l'équipe bleu");
		}else if(TB2==null) {
			TB2=player;
			Bukkit.broadcastMessage("§1"+player.getName()+" A rejoin l'équipe bleu");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Njaune)) {
		if(TJ1==null) {
			TJ1=player;
			Bukkit.broadcastMessage("§e"+player.getName()+" A rejoin l'équipe jaune");
		}else if(TJ2==null) {
			TJ2=player;
			Bukkit.broadcastMessage("§e"+player.getName()+" A rejoin l'équipe jaune");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nmagenta)) {
		if(TM1==null) {
			TM1=player;
			Bukkit.broadcastMessage("§d"+player.getName()+" A rejoin l'équipe magenta");
		}else if(TM2==null) {
			TM2=player;
			Bukkit.broadcastMessage("§d"+player.getName()+" A rejoin l'équipe magenta");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nnoir)) {
		if(TN1==null) {
			TN1=player;
			Bukkit.broadcastMessage("§0"+player.getName()+" A rejoin l'équipe noir");
		}else if(TN2==null) {
			TN2=player;
			Bukkit.broadcastMessage("§0"+player.getName()+" A rejoin l'équipe noir");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	if(it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(CStart.Nvert)) {
		if(TV1==null) {
			TV1=player;
			Bukkit.broadcastMessage("§a"+player.getName()+" A rejoin l'équipe vert");
		}else if(TV2==null) {
			TV2=player;
			Bukkit.broadcastMessage("§a"+player.getName()+" A rejoin l'équipe vert");
		}else {
			player.sendMessage("§4Il n'y a plus de place dans cette équipe");
		}
	}
	
	}
	}
}