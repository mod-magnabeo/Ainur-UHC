package com.Wolf_IV.AnuirUHC;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Wolf_IV.AnuirUHC.Commands.CDayPass;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Commands.CStartStop;
import com.Wolf_IV.AnuirUHC.Commands.CU;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class MainA extends JavaPlugin implements Listener{
	public CStart cstart =new CStart(this);
	public TimerTasks timert =new TimerTasks(this, cstart);
	@Override
	public void onEnable() {
	getCommand("daypass").setExecutor(new CDayPass(timert));
	getCommand("startainuruhc").setExecutor(new CStart(this));
	getCommand("startainuruhcstop").setExecutor(new CStartStop());
	getCommand("u").setExecutor(new CU(cstart));
	getServer().getPluginManager().registerEvents(new AListener(cstart), this);
	}
	@Override
	public void onDisable() {
	System.out.println("-Wolf_IV");
	}
}

/**
 * Maedhros 23/11/2020
 */