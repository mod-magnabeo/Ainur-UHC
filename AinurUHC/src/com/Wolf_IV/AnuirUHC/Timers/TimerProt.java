package com.Wolf_IV.AnuirUHC.Timers;

import org.bukkit.scheduler.BukkitRunnable;

public class TimerProt extends BukkitRunnable {

	public static int timerFallA=0;
	public static boolean NoHurtA=false;
	private boolean cancel=false;
	
	@Override
	public void run() {
		
		if(cancel==true) {
			cancel=false;
			cancel();
		}
		
		
		if(timerFallA>0) {
			timerFallA--;
			NoHurtA=true;
			if(timerFallA==0) cancel=true;
		}else {
			NoHurtA=false;
		}
		

	}
}
