package com.Wolf_IV.AnuirUHC.Objects;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.Wolf_IV.AnuirUHC.MainA;

public class Object {
	
	

	public Object(Player player) {
		if(player != null) {
		this.player = player.getName();
		//ne pas faire de drop sauf pour les scorcier
		player.getWorld().dropItemNaturally(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY()+1, player.getLocation().getZ()), item);
		}
		/**
		 * Listener creation
		 */
		MainA.main.getServer().getPluginManager().registerEvents(new ObjectListener(this), MainA.main);
	}
	
	public ItemStack item;
	public String player;
	
	public void onActivate(PlayerInteractEvent event) {
		
	}
	public void onHit(EntityDamageByEntityEvent event) {
		
	}
	
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}

}
