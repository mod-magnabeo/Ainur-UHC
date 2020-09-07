package com.Wolf_IV.AnuirUHC;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Commands.CStartStop;

public class MainA extends JavaPlugin implements Listener{
	@Override
	public void onEnable() {
	getCommand("startainuruhc").setExecutor(new CStart(this));
	getCommand("startainuruhcstop").setExecutor(new CStartStop());
	getServer().getPluginManager().registerEvents(new AListener(), this);
	}
	@Override
	public void onDisable() {
	System.out.println("-Wolf_IV");
	}
}
