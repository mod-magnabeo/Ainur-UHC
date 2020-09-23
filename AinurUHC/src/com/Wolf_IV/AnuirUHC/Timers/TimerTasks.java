package com.Wolf_IV.AnuirUHC.Timers;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.AnuirUHC.AListener;
import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class TimerTasks extends BukkitRunnable {

	private MainA main;
	private CStart p;
	public TimerTasks(MainA mainA, CStart cstart) {
	this.main =mainA;
	this.p=cstart;
	}
	
	public static int timerS=60;
	public static int timerR=-1;
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
	public static String JourSay="§eRole Jour 2⚙";
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
			 for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.GHAST_SCREAM2, 10.0F, 0.0F);
					}
			 if(timeDay==2) {
				 JourSay="§ePvp Jour 4⚙";
				 Bukkit.broadcastMessage("§eJour 2⚙  Role dans 10s"); 
				 timerR=10;
			 }else if(timeDay==4) {
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
		
	
	
		if(timerR>=0) {
			timerR--;
			if(timerR==8) {
				 Bukkit.broadcastMessage("§aVotre Type:");
				
			}else if(timerR==7) {
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.CLICK, 10.0F, 5.0F);
					}
			}else if(timerR==2) {
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.LEVEL_UP, 10.0F, 0.0F);
					}
			}else if(timerR==0) {
				 
				 for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
							playerO.playSound(playerO.getLocation(), Sound.CLICK, 10.0F, 5.0F);
						}
				/*p.Melkor.sendMessage("A l’annonce des rôles tu obtient 3 coeur en plus tout le temps. lorsque qu’un méchant tue\r\n" + 
						" un joueur qui a un silmarils le silmarils est envoyer dans son l'inventaire mais il ne recevra pas ces\r\n" + 
						" effet. lorsqu’il aura les trois silmarils il pourra craft la couronne avec ces silmarils et en la mettant\r\n" +
						" sur sa tête il obtient ( Ungoliant doit gagner seul, tout les balrog et sauron obtiennent l’effet force 1 la\r\n" +
						"nuit, et melkor obtient force 1 et speed 1 la nuit et il peut infecter un joueur sauf eru . méchant");*/
				p.Melkor.sendMessage("§3 Ton rôle est très important ta mission est simple. Récupérer les trois silmarils.\r\n" + 
						"§3 Après les avoir récupérer tu gagne en étant le dernier vivant avec ton équipe.\r\n" + 
						"§3 Les balrog et sauron sont avec toi, tu peut les identifier avec la command /team\r\n" + 
						"§3 Dès qu'un de tes fidèle balrog ou bien sauron récupère un silmarils, il est directement\r\n" + 
						"§3 envoyer dans ton inventaire. Tu ne peux pas te servir des silmarils. Quand tu a les trois\r\n" +
						"§3 qu’il doit trahir son équipe c’est Ungoliant(sauf si il est déjà mort). Tous les balrogs et\r\n" + 
						"§3 sauron obtienne force 1 la nuit tu obtiens force 1 et speed 1. Et tu pourra infecter un joueur\r\n" + 
						"§3 gentil apart Eru Iluvatar. Si ton équipe obtient le planatìr elle peut s'en servir pour traquer\r\n" + 
						"§3 les silmarils A ta mort sauron récupère tes silmarils et ton planatìr ou couronne.");
				
				
	p.Feanor.sendMessage("§3 Tu est le protagonist de la partie. En début de game tu dois crafté trois\r\n" + 
						"§3  silmarils vide. Tu doit les remplir de la lumière des arbres du\r\n" + 
						"§3 valinor en 0 0. Tu devra alors distribuer tes silmarils a des\r\n" + 
						"§3 joueurs grâce à la commande /donner <pseudo> et l’item dans la main.\r\n" + 
						"§3 Si tu ne les a pas distribuer ou craft avant le jour 5 (quand les\r\n" +
						"§3 arbres seront détruis) ils seront distribuées aléatoirement a des\r\n" + 
						"§3 joueur. Tu peux pas te servir d’un silmarils avant de l’avoir donnés."
						);
	
	
				
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

