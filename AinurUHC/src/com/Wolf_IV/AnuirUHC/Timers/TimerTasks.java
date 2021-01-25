package com.Wolf_IV.AnuirUHC.Timers;

import java.awt.TextComponent;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.Wolf_IV.AnuirUHC.AListener;
import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Role.Feanor;
import com.Wolf_IV.AnuirUHC.Role.Maedhros;
import com.Wolf_IV.AnuirUHC.Role.Planatir;
import com.Wolf_IV.AnuirUHC.Role.Ungoliant;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;

public class TimerTasks extends BukkitRunnable {

	private MainA main;
	private CStart p;
	public TimerTasks(MainA mainA, CStart cstart) {
	this.main =mainA;
	this.p=cstart;
	}
	
	public static boolean jN = true;
	public static boolean role = false;
	public static int pls=0;
	public static int timerS=10;
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
		/*Bukkit.broadcastMessage(""+p.maedhros);
		Bukkit.broadcastMessage(""+p.maedhrosS);*/
		//p.Melkor.sendMessage("salut");
		timeSDay++;
		timeSec++;
		
		if(role == true) {
			if(pls > 0) {
				pls--;
			}
			//Bug qq fois ici
			if(p.SBleu != null && Bukkit.getPlayer(p.SBleu) != null) {
				//FAIRE NO EFFECT POUR AULé et tt
				if(p.manwé == null || !p.manwéS.equalsIgnoreCase(p.SBleu)) {
				Bukkit.getPlayer(p.SBleu).removePotionEffect(PotionEffectType.SPEED);
				Bukkit.getPlayer(p.SBleu).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*5, 0 , false, false));
				}
			}
			if(p.SVert != null && Bukkit.getPlayer(p.SVert) != null) {
				Bukkit.getPlayer(p.SVert).removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				Bukkit.getPlayer(p.SVert).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20*5, 0 , false, false));
			}
			if(p.SRouge != null && Bukkit.getPlayer(p.SRouge) != null) {
				if(p.aulé == null || !p.auléS.equalsIgnoreCase(p.SRouge)) {
				Bukkit.getPlayer(p.SRouge).removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				Bukkit.getPlayer(p.SRouge).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*5, 0, false, false));
				}
			}
		}
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
		if(timeSDay==600) {
			jN=false;
			Planatir.plColor(p, DyeColor.BLACK);
			 for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.BLAZE_BREATH, 10.0F, 0.0F);
					}
			 Bukkit.broadcastMessage("§9Nuit🌙");
		}else if(timeSDay==1200) {
			jN=true;
			 timeSDay=0;
			 timeDay++;
			 Planatir.plColor(p, DyeColor.WHITE);
			/* Search search =new Search();
			 search.dayRole(p);*/
			/* Maedhros ma = new Maedhros();
			 ma.nDay(p);*/
			 
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
				 //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
			 }else if(timeDay==6){
				 Feanor.distribution(p);
				 JourSay="§eFin Bordur Jour 7⚙";
				 /**
				  * SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				  */
				//SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 6000");
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 200 1200");
				 //SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				 /**
				  * SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				  */
				 Bukkit.broadcastMessage("§eJour 6⚙ Bordur 3000 block elle serat a 100 block d'ici Jour 7⚙"); 
			 }else if(timeDay==7){
				 JourSay="§eBonne chance a tous";
				 Bukkit.broadcastMessage("§eJour 7⚙ La Bordur c'est aréter a 100blocks"); 
			 }else {
			 
				 Bukkit.broadcastMessage("§eJour "+timeDay+"⚙"); 
			 }
			 Search search =new Search();
			 if(timeDay==7){
				 Ungoliant.trans(p);
			 }else if(timeDay==5){
				 Planatir.lorienAcces(p);
			 }else if(timeDay==6){
				 Planatir.eAcces(p);
			 }
			 search.dayRole(p);
			 }
		
	
	
		if(timerR>=0) {
			timerR--;
			if(timerR==8) {
				 Bukkit.broadcastMessage("§aVotre Type:");
				
			}else if(timerR==7) {
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.CLICK, 10.0F, 5.0F);
					}
				//Bug quand melkor n'existe pas
				p.Melkor.sendMessage("§eValar");
			}else if(timerR==2) {
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.LEVEL_UP, 10.0F, 0.0F);
					}
			}else if(timerR==0) {
				role = true;
				 
				 for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
							playerO.playSound(playerO.getLocation(), Sound.CLICK, 10.0F, 5.0F);
						}
				/*p.Melkor.sendMessage("A l’annonce des rôles tu obtient 3 coeur en plus tout le temps. lorsque qu’un méchant tue\r\n" + 
						" un joueur qui a un silmarils le silmarils est envoyer dans son l'inventaire mais il ne recevra pas ces\r\n" + 
						" effet. lorsqu’il aura les trois silmarils il pourra craft la couronne avec ces silmarils et en la mettant\r\n" +
						" sur sa tête il obtient ( Ungoliant doit gagner seul, tout les balrog et sauron obtiennent l’effet force 1 la\r\n" +
						"nuit, et melkor obtient force 1 et speed 1 la nuit et il peut infecter un joueur sauf eru . méchant");*/
				 if(p.Melkor != null) {
				p.Melkor.sendMessage("§3 Ton rôle est très important ta mission est simple. Récupérer les trois silmarils.\r\n" + 
						"§3 Après les avoir récupérer tu gagne en étant le dernier vivant avec ton équipe.\r\n" + 
						"§3 Les balrog et sauron sont avec toi, tu peut les identifier avec la command /team\r\n" + 
						"§3 Dès qu'un de tes fidèle balrog ou bien sauron récupère un silmarils, il est directement\r\n" + 
						"§3 envoyer dans ton inventaire. Tu ne peux pas te servir des silmarils. Quand tu a les trois\r\n" +
						"§3 qu’il doit trahir son équipe c’est Ungoliant(sauf si il est déjà mort). Tous les balrogs et\r\n" + 
						"§3 sauron obtienne force 1 la nuit tu obtiens force 1 et speed 1.Ton pseudo est révéler Et tu pourra "
						+ "infecter un joueur\r\n" + 
						"§3 gentil apart Eru Iluvatar. Si ton équipe obtient le planatìr elle peut s'en servir pour traquer\r\n" + 
						"§3 les silmarils A ta mort sauron récupère tes silmarils et ton planatìr ou couronne.");
				p.Melkor.setMaxHealth(p.Melkor.getMaxHealth()+6.0F);
				 }
				 if(p.Feanor != null) {	
	p.Feanor.sendMessage("§3 Tu est le protagonist de la partie. En début de game tu dois crafté trois" + 
						"§3 silmarils vide. Tu doit les remplir de la lumière des arbres du" + 
						"§3 valinor en 0 0. Tu devra alors distribuer tes silmarils a des"+ 
						"§3 joueurs grâce à la commande /donner <pseudo> et l’item dans la main." + 
						"§3 Si tu ne les a pas distribuer ou craft avant le jour 5 (quand les" +
						"§3 arbres seront détruis) ils seront distribuées aléatoirement a des" + 
						"§3 joueur. Tu peux pas te servir d’un silmarils avant de l’avoir donnés."
						);
				Feanor.giveF(p.Feanor, p);
				 }
				for(int i=1;i<=7;i++) {
					if(p.balrog[i] != null) {
					p.balrog[i].sendMessage("§3Ton rôle est simple. Avec ton équipe récupérer les trois silmarils(qui " + 
							" arriveront directement dans l’inventaire de Melkor)." + 
							" Après les avoir récupérer tu gagne en étant le dernier vivant avec ton équipe." + 
							" Les autres balrog sauron et Melkor sont avec toi, tu peut les identifier avec la command /br" + 
							" Quand vous avez les trois silmarils il se transformeront en couronne de fer, une fois porter par Melkor un "
							+ "balrog sera informé qu’il doit trahir son équipe c’est Ungoliant(sauf si il est déjà mort). Tu obtiens force 1 "
							+ "la nuit comme tous les autre balrogs et sauron. Un joueur choisi par Melkor rejoindra ton équipe. Si ton équipe obtient "
							+ "le planatìr elle peut s'en servir pour traquer les silmarils. Tu a 1 chance sur 7 d’étre Ungoliant sa te sera rèvèler a "
							+ "la construction de la couronne" 
							);
					}
				}
				if(p.balrog_infiltré != null) {
				p.balrog_infiltré.sendMessage("Tu est un Balrog spécial tu est Balrog infiltré contrairement à ce qu’on dit "
						+ "ci-dessus tu ne connais pas ton équipe(tu ne peut pas faire /team). Mais si un role info cherche "
						+ "à connaître ton rôle il sera dit que tu est gentil. Une fois par jour tu peux spec un joueur qui se "
						+ "trouve à 15 blocs de toi. Mais celui ci prendra un dégât de un demi-coeur.");
				}
				if(p.balrog_traceur != null) {
				p.balrog_traceur.sendMessage("Tu est un Balrog spécial tu est Balrog traceur. A chaque épisode tu peux choisir un "
						+ "joueur que tu va tracer(/u pseudo). La boussole que tu va recevoir te pointera la direction du joueur "
						+ "choisi(tu pourra l'actualité avec clique droit). La boussole sera reset au prochain épisode. Il ne "
						+ "sera pas possible de tracer le même joueur 2 fois d’affilé."
						);
				}
				if(p.sauron != null) {
				p.sauron.sendMessage("Ton rôle est simple. Avec ton équipe récupérer les trois silmarils(qui " + 
						"arriveront directement dans l’inventaire de Melkor). " + 
						"Après les avoir récupérer tu gagne en étant le dernier vivant avec ton équipe. " + 
						"Les autres balrog et Melkor sont avec toi, tu peut les identifier avec la command /team " + 
						"Quand vous avez les trois silmarils il se transformeront en couronne de fer, une fois porter "
						+ "par Melkor un balrog sera informé qu’il doit trahir son équipe c’est Ungoliant(sauf si il est déjà mort)."
						+ " Tu obtiens force 1 la nuit comme tous les balrogs. Un joueur choisi par Melkor rejoindra ton équipe. "
						+ "Si ton équipe obtient le planatìr elle peut s'en servir pour traquer les silmarils. Tu bénéficie de 1 "
						+ "coeur en plus. Si Melkor vient à mourir tu récupèrera tous ses objet spécial(Couronne,silmarils,planatir)."
						+ " Tu passera a 13 coeur. Et ton pseudo est révélé dans le chat si Melkor avait obtenu la couronne. "
						+ "Tu devra accomplir la mission abandonné par Melkor.");
				}
				if(p.Eru_Iluvatar != null) {
				p.Eru_Iluvatar.sendMessage("Tout les joueur les joueur connaisent ton role. Tu ne peut pas avoir les effet des "
						+ "silmarils et si tu en gagne un tu doit le donner avec la commande /donner pseudo dans les 3 min sinon "
						+ "il sera donner aléatoirement a un joueur. Tu doit maintenant choisir entre deux chanson. Elle sont "
						+ "expliquer en dessous.");
				BaseComponent[] page = new ComponentBuilder("§d[§bChanson de Revelation§d]")
						.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/u revelation"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aTu peut dévoiler a tous le monde le role d'un joueur situé a 10 blocks de toi avec /u [joueur]").create()))
				        .create();
				BaseComponent[] page2 = new ComponentBuilder("§d[§bChanson de Soul§d]")
						.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/u soul"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aSi tu meurt d'un joueur tu peut entre qu'il perds 5 coeurs ou que tu reprenne vie").create()))
				        .create();
				p.Eru_Iluvatar.spigot().sendMessage(page);
				p.Eru_Iluvatar.spigot().sendMessage(page2);
				}
				if(p.manwé != null) {
				p.manwé.sendMessage("Tout les joueur les joueur connaisent ton role. Tu ne peut pas avoir les effet des silmarils "
						+ "et si tu en gagne un tu doit le donner avec la commande /donner pseudo dans les 3 min sinon il sera "
						+ "donner aléatoirement a un joueur. Tu doit maintenant choisir entre deux chanson. Elle sont expliquer "
						+ "en dessous.");
				}
				if(p.oromé != null) {
				p.oromé.sendMessage("Une fois par épisode pendant 5 minutes tu peut te transformer en mouton Gandalf te voit dans "
						+ "ta vrai forme");
				}
				if(p.namo != null) {
				p.namo.sendMessage("2 fois dans la game avec /u pseudo tu peut connaitre la raison de la mort d’un joueur dans "
						+ "les 30s après sa mort. Tu peut savoir qui la tué si il est mort pvp. Mais quand tu t’en sert tu va "
						+ "perdre 1 coeur permanent par utilisation. Si le tueur et le Balrog Infiltré tu vera le message en "
						+ "brouiller.");
				}
				if(p.sauruman != null) {
				p.sauruman.sendMessage("Pendant les 15 première minute d’un jour tu peut écrire un message avec /u msg qui sera "
						+ "envoyé a tout le monde le debut du jour suivant. Tu restera anonyme.");
				}
				if(p.gandalf != null) {
				p.gandalf.sendMessage(" trois fois dans la game tu peut inspecter 3 personnes a 10 block de toi. "
						+ "il y a deux résultat possible au flaire: " + 
						"suspect: 87,5%(7/8) méchant 12,5%(1/8) gentils" + 
						"innocentés: 87,5%(7/8) gentils 12,5%(1/8) méchant" + 
						"tu peut flairer plusieur fois la même personne." + 
						"tu peut voir oromé même en forme de mouton.");
				}
				if(p.lorien != null) {
				p.lorien.sendMessage("A l’épisode 2 tu aura le x de l’emplacement du planatir, a l’épisode 3 tu aura le y "
						+ "du planatir et à l’épisode 4 tu aura le z du planatir");
				 //p.lorien.setCompassTarget(new Location(p.lorien.getWorld(), 50, 100, 50));
				}
				if(p.scorcier_bleu_1 != null) {
				p.scorcier_bleu_1.sendMessage("Tu a un scorcier bleu d’ont tu connais le non. Tu peut lui parler avec /u msg. "
						+ "Si il vient a mourir tu recupérera tous ses objet sépcial (planatir, silmarils) et tu connaitra la raison "
						+ "de sa mort.");
				
				}
				if(p.scorcier_bleu_2 != null) {
				p.scorcier_bleu_2.sendMessage("Tu a un scorcier bleu d’ont tu connais le non. Tu peut lui parler avec /u msg. "
						+ "Si il vient a mourir tu recupérera tous ses objet sépcial (planatir, silmarils) et tu connaitra la raison "
						+ "de sa mort.");
				}
				if(p.aulé != null) {
				p.aulé.sendMessage("Tu a un livre sharp 3 et un livre prot 3");
				 ItemStack Book = new ItemStack(Material.ENCHANTED_BOOK);
				ItemMeta customBook = Book.getItemMeta();
				customBook.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
				Book.setItemMeta(customBook);
				p.aulé.getInventory().addItem(Book);
				customBook.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				Book.setItemMeta(customBook);
				p.aulé.getInventory().addItem(Book);
				}
				if(p.fingolfin != null) {
				p.fingolfin.sendMessage("Tu lorsque la moitié des joueur sont mort tu a 30s pour choisir un camps(balrog/valar).");
				
				}
				if(p.varda != null) {
				p.varda.sendMessage("A chaque début d’episode avec /u pseudo1 pseudo2 tu peut savoir si deux joueur vivant ont "
						+ "le même lien. Liens:Connaitre les liens avec la commande /lien");
				
				}
				if(p.maedhros != null) {
					
				
				p.maedhros.sendMessage("Tu peut protéger une personne par épisode en lui donnant l’effet resistance avec /u pseudo. "
						+ "Tu a droit de se protéger toi même que 2 fois dans la partie.");
				
				}
				if(p.tulkas != null) {
				p.tulkas.sendMessage("Tu a un effet de force le jour et tu a deux coeur en plus.");
				p.tulkas.setMaxHealth(p.tulkas.getMaxHealth()+4.0F);
				}
	
			/*	Search search =new Search();
				 search.dayRole(p);//PENSER A LE METTRE EN HAUT*/
				 
				
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
			Ingame=true;
			timerS--;
			starting=false;
			Planatir.plPlace(p);
		
			
		
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

