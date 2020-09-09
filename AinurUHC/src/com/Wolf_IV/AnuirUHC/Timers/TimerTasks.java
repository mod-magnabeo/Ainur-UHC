package com.Wolf_IV.AnuirUHC.Timers;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.AnuirUHC.AListener;
import com.Wolf_IV.AnuirUHC.MainA;

public class TimerTasks extends BukkitRunnable {

	private MainA main;
	public TimerTasks(MainA mainA) {
	this.main =mainA;
	}
	public static int timerS=60;
	public static int timeSec=0;
	public static int timeSDay=0;
	public static int timeDay=1;
	public static int timeMin=0;
	public static int timeH=0;
	public static int jour=0;
	public static int wolfch=1;
	public static String timeA="0 : 0";
	public static String AUhc="Ainur UHC";
	public static String WolfS="-Wolf_IV";
	public static String JourSay="§ePvp Jour 2⚙";
	public static boolean AUhcb=false;
	public static boolean pvp=false;
	public static boolean Ingame=false;
	public static boolean starting;
	public static boolean stop= false;

	@Override
	public void run() {
		timeSDay++;
		timeSec++;
		
		if(timeSec==60) {
			timeSec=0;
			timeMin++;
			
		 if(timeMin==60) {
			timeMin=0;
			timeH++;
		}
		 
		 }
		if(timeH==0) {
			timeA="§a"+timeMin+" : "+timeSec;
		}else {
			timeA="§a"+timeH+" : "+timeMin+" : "+timeSec;
		}
		if(AUhcb==true) {
			AUhc="§eAinur §aUHC";
			AUhcb=false;
		}else {
			AUhc="§aAinur §eUHC";
			AUhcb=true;
		}
		if(wolfch==1) {
			wolfch++;
			WolfS="§a-§bW§co§dl§ef§1_§2I§3V";
		}else if(wolfch==2) {
			wolfch++;
			WolfS="§3-§aW§bo§cl§df§e_§1I§2V";
		}else if(wolfch==3) {
			wolfch++;
			WolfS="§2-§3W§ao§bl§cf§d_§eI§1V";
		}else if(wolfch==4) {
			wolfch++;
			WolfS="§1-§2W§3o§al§bf§c_§dI§eV";
		}else if(wolfch==5) {
			wolfch++;
			WolfS="§e-§1W§2o§3l§af§b_§cI§dV";
		}else if(wolfch==6) {
			wolfch++;
			WolfS="§d-§eW§1o§2l§3f§a_§bI§cV";
		}else if(wolfch==7) {
			wolfch++;
			WolfS="§c-§dW§eo§1l§2f§3_§aI§bV";
		}else if(wolfch==8) {
			wolfch=1;
			WolfS="§b-§cW§do§el§1f§2_§3I§aV";
		}
		 
		if(timeSDay==1200) {
			 timeSDay=0;
			 timeDay++;
			 if(timeDay==4) {
				 JourSay="§eBordur Jour 6⚙";
				 Bukkit.broadcastMessage("§eJour 4⚙ PVP Activé"); 
				 pvp=true;
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
			 }else if(timeDay==6){
				 JourSay="§eFin Bordur Jour 7⚙";
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 6000");
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 200 1200");
				 Bukkit.broadcastMessage("§eJour 6⚙ Bordur 3000 block elle serat a 100 block d'ici Jour 7⚙"); 
			 }else if(timeDay==7){
				 JourSay="§eBonne chance a tous";
				 Bukkit.broadcastMessage("§eJour 7⚙ La Bordur c'est aréter a 100blocks"); 
			 }else {
			 
				 Bukkit.broadcastMessage("§eJour "+timeDay+"⚙"); 
			 }
			 }
		
	
	
		
		
	if(timerS>0) {
			timerS--;
			if(stop==true) {
				Bukkit.broadcastMessage("§4Lancement du Ainur UHC Annulé");
				stop=false;
				Ingame=false;
				cancel();
			}
		} else if(timerS==0) {
			Bukkit.broadcastMessage("§eLancement de l'Ainur UHC");
			timerS--;
			starting=false;
		
			
		
			/**
			 * TP ALL
			 */
			for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
				playerO.getInventory().clear();
				playerO.setHealth(20);
				playerO.setFoodLevel(20);
				playerO.setGameMode(GameMode.SURVIVAL);
			}
			Random rand=new Random();
		
			
			
			
				
                TimerProt tasks = new TimerProt();
                tasks.runTaskTimer(main, 0, 20);
                TimerProt.timerFallA=30;
               
                
			/**
			 * TP ALL
			 */
				
				
				
				
				
			
			}//end start
	
	if(this.timeSDay>3) {
		
		 ScoreboardManager scoreM = Bukkit.getScoreboardManager();
		Scoreboard score = scoreM.getNewScoreboard();
		Objective o = score.registerNewObjective("Debut", "Pvp");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(AUhc);
		Score temps = o.getScore("§bTemps Passé: "+timeA);
		//Score debut2 = o.getScore("voir le temps écoulrré");
		Score pvp = o.getScore(JourSay);
		Score wolf = o.getScore(WolfS);
		Score WU = o.getScore("      "+AUhc);
		temps.setScore(4);
		//debut2.setScore(3);
		pvp.setScore(3);
		wolf.setScore(2);
		WU.setScore(1);
		
		
		for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
			playerO.setScoreboard(score);
			}
		
		
		
		
        }
	}

}

