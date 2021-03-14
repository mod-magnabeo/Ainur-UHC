package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class Ungoliant {
	
	public static void trans(CStart p) {
		if(p.ungoliant == null) {
			return;
		}
		
		p.ungoliant.sendMessage("§cVous etes ungoliant maintenant votre but et de etre le dernier survivant trahisser les balrogs");
		p.ungoliant.setMaxHealth(p.ungoliant.getMaxHealth()+10.0F);
		p.ungoliant.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999999, 1 /*infini*/, false, false));
	}

}
