package com.Wolf_IV.AnuirUHC.Objects.Lasso;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Objects.Object;
import com.Wolf_IV.AnuirUHC.Objects.ObjectListener;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Lasso extends Object {
	
	/**
	 * Idée au lieu de empécher d'enlever le feu faire que quand l'éffet extinguish est joué ralumé le feu et cancel l'event pour le bruit et les particule
	 */
	
	public Projectile currentProjectile;
	public LassoTimer tasks;

	public Lasso(Player player) {
		super(player);
		ItemStack Lasso = new ItemStack(Material.LEASH, 1);
		ItemMeta customLasso = Lasso.getItemMeta();
		customLasso.setDisplayName("§8Lasso de Feu");
		Lasso.setItemMeta(customLasso);
		setItem(Lasso);
	}
	
	@Override
	public void onActivate(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		player.getWorld().playSound(player.getLocation(), Sound.BLAZE_HIT, 10.0F, 0.0F);
		currentProjectile = player.launchProjectile(FishHook.class);
		currentProjectile.setVelocity(player.getLocation().getDirection().multiply(0.5));
		//Timer doit demarer apres la creation du projectile
		tasks = new LassoTimer(this, player);
		tasks.runTaskTimer(MainA.main, 0, 5);
		MainA.main.getServer().getPluginManager().registerEvents(new LassoListener(this), MainA.main);
	}
	

}
