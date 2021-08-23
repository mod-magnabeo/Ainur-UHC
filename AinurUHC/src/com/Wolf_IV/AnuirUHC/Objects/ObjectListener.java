package com.Wolf_IV.AnuirUHC.Objects;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ObjectListener implements Listener{
	Object object;

	public ObjectListener(Object object) {
	this.object = object;	
	}
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if(player.getInventory().getItemInHand()!= null && player.getInventory().getItemInHand() == object.getItem()) {
			if(object.getPlayer()==null || player.getName().equalsIgnoreCase(object.getPlayer())) {
				object.onHit(event);
			}else {
				player.sendMessage("§cCette Item ne vous posséde pas !");
			}
			}
			
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player =event.getPlayer();
		Action action =event.getAction();
		ItemStack it =event.getItem();
		
		
		if(it != null && player.getInventory().getItemInHand() == it) {
			if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
				if(object.getPlayer()==null || player.getName().equalsIgnoreCase(object.getPlayer())) {
					object.onActivate(event);
				}else {
					player.sendMessage("§cCette Item ne vous posséde pas !");
				}
			}
		}
	}

}
