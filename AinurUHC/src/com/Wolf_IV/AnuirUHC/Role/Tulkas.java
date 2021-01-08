package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Tulkas {

	public static void nDay(CStart p) {
		if(p.tulkas == null) {
			return;
		}
		//executer quand un jour passe
		p.tulkas.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600*20, 0 /*fin du jour*/, false, false));
		
		
	}
}
