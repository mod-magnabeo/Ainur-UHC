package com.Wolf_IV.AnuirUHC.Objects.Lasso;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LassoTimer extends BukkitRunnable {
	Lasso lasso;
	Player player;

	public LassoTimer(Lasso lasso, Player player) {
		this.lasso = lasso;
		this.player = player;
	}

	@Override
	public void run() {
		if(lasso.currentProjectile != null || player == null) {
			
			player.getWorld().playEffect(lasso.currentProjectile.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
		}else {
			cancel();
		}

	}

}
