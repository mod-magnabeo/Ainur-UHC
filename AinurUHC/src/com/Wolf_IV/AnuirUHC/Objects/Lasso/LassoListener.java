package com.Wolf_IV.AnuirUHC.Objects.Lasso;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class LassoListener implements Listener {
	Lasso lasso;
	Entity entityCurentlyHit;

	public LassoListener(Lasso lasso) {
		this.lasso = lasso;
	}
	
	@EventHandler
	public void onLassoHit(ProjectileHitEvent event) {
		Projectile pro = event.getEntity();
		if(pro == lasso.currentProjectile) {
			//Peut ne pas marcher Il peut se conter lui meme faire un filtre de LivingEntity si besoin (intanceof et (LivingEntity)
			if(pro.getNearbyEntities(0, 0, 0).get(0) != null) {
				entityCurentlyHit = pro.getNearbyEntities(0, 0, 0).get(0);
				entityCurentlyHit.setFireTicks(20*10);
			}
		}
	}

}
