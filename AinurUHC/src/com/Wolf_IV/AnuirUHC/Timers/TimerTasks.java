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
import com.Wolf_IV.AnuirUHC.Role.Fingolfin;
import com.Wolf_IV.AnuirUHC.Role.Maedhros;
import com.Wolf_IV.AnuirUHC.Role.Planatir;
import com.Wolf_IV.AnuirUHC.Role.Role;
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
	public static int fe=0;
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
			if(fe > 0) {
				fe--;
			if(fe == 0) {
				Fingolfin.done(p);
			}
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
				 JourSay="§eBordur Jour 7⚙";
				 Bukkit.broadcastMessage("§eJour 4⚙ PVP Activé"); 
				 pvp=true;
				 //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
			 }else if(timeDay==6){
				 Feanor.distribution(p, p.FeanorS, p.Feanor, true, true, true);
				 Bukkit.broadcastMessage("§eJour 6⚙ Distribution des silmarils"); 
			 }else if(timeDay==7){
				 JourSay="§eFin Bordur Jour 8⚙";
				 /**
				  * SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				  */
				//SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 2000");
				 Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 600 1200");
				 //SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				 /**
				  * SI TU MODIFIE LA BORDUR OUBLIE PAS DE MODIFIER LE REVIVE
				  */
				 Bukkit.broadcastMessage("§eJour 7⚙ Bordur 3000 block elle serat a 100 block d'ici Jour 8⚙"); 
			 }else if(timeDay==8){
				 JourSay="§eBonne chance a tous";
				 Bukkit.broadcastMessage("§eJour 7⚙ La Bordur c'est aréter a 100blocks"); 
			 }else {
			 
				 Bukkit.broadcastMessage("§eJour "+timeDay+"⚙"); 
			 }
			 Search search =new Search();
			 if(timeDay==5){
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
				for(int i = 1; i<=p.nubPlayer; i++) {
					if(Bukkit.getPlayer(p.role[i].getPlayer()) != null) {
						Player player = Bukkit.getPlayer(p.role[i].getPlayer());
						player.sendMessage("§e"+p.role[i].getLien());
					}
				}
				
			}else if(timerR==2) {
				for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
					playerO.playSound(playerO.getLocation(), Sound.LEVEL_UP, 10.0F, 0.0F);
					}
				for(int i = 1; i<=p.nubPlayer; i++) {
					if(Bukkit.getPlayer(p.role[i].getPlayer()) != null) {
						Player player = Bukkit.getPlayer(p.role[i].getPlayer());
						player.sendMessage("§eVous etes "+p.role[i].getRole());
					}
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
				p.Melkor.sendMessage("§3vous êtes melkor, votre objectif est d'éliminé l'ainur ainsi que les rôles solo. Vous êtes le chef des balrogs. Vous obtenez trois cœur en plus a l'annonce des rôles ainsi que la possibilité de parler a vos serviteurs, mais luthien verra aussi vos messages. Lorsque les silmarils seront dans les main des balrogs ils vous seront directement envoyé et les effets de la couronne s’activeront pour tous les balrogs, vous obtiendrai en plus force la nuit ainsi que la possibilité d'infecter un joueur avec la commande /u.\r\n" + 
						"");
				p.Melkor.setMaxHealth(p.Melkor.getMaxHealth()+6.0F);
				 }
				 if(p.Feanor != null) {	
	p.Feanor.sendMessage("§3 vous êtes feanor, votre objectif est d'éliminé tous les balrogs ainsi que les roles solo. Vous avez une rôle majeur pour la victoire de l'ainur, votre but est de distribuer les trois silmarils a des joueurs a moins de 20 block de vous avant l'épisode 6 avec la commande /don « pseudo ». si vous ne donner pas vos silmarils a temps ils seront distribué aléatoirement a des joueurs. Les silmarils n'auront aucun effet sur vous.\r\n" + 
			""
						);
				Feanor.giveF(p.Feanor, p);
				 }
				for(int i=1;i<=7;i++) {
					if(p.balrog[i] != null) {
					p.balrog[i].sendMessage("§3 vous êtes balrog, votre objectif est d'éliminé l'ainur ainsi que les rôles solo. Pour cela vous avez la possibilté d 'enlever 2 cœur pendant 20 min en utilisant la commande /u «pseudo» et en devinant le rôle de la personne vous pourrez utiliser votre pouvoir toutes les 20 minutes mais vous ne pourrez pas choisir deux fois la même personne dans la partie. Une fois la couronne de fer craft vous obtiendrai en plus force la nuit.\r\n" + 
							"" 
							);
					}
				}
				if(p.balrog_infiltré != null) {
				p.balrog_infiltré.sendMessage("§3Tu est un Balrog spécial tu est Balrog infiltré contrairement à ce qu’on dit "
						+ "ci-dessus tu ne connais pas ton équipe(tu ne peut pas faire /team). Mais si un role info cherche "
						+ "à connaître ton rôle il sera dit que tu est gentil. Une fois par jour tu peux spec un joueur qui se "
						+ "trouve à 15 blocs de toi. Mais celui ci prendra un dégât de un demi-coeur.");
				/*Role r = new Role();
				r.setPlayer(p.balrog_infiltré.getDisplayName());
				r.setRole("§kBalrog Infiltré");
				r.setLien("Maiar");
				for(int i = 1; i<=p.nubPlayer; i++) {
					  if(p.role[i].getPlayer().equalsIgnoreCase(p.balrog_infiltré.getName())) {
						  p.role[i] = r;
					  }
				  }*/
				}
				
				if(p.balrog_noir != null) {
				p.balrog_noir.sendMessage("§3vous êtes balrog brouilleur, votre objectif est d'éliminé l'ainur ainsi que les rôles solo. Pour cela vous avez la possibilté de masquer une fois dans la partie la mort d'une personne avec la commande /u après sa mort. Une fois la couronne de fer craft vous obtiendrai en plus force la nuit.\r\n" + 
						""
						);
				}
				if(p.balrog_brouilleur != null) {
					p.balrog_brouilleur.sendMessage("§3vous êtes balrog sablier, votre objectif est d'éliminé l'ainur ainsi que les roles solo. Pour cela toute les 10 minutes vous avez la possibilité d'enlever tous les pouvoirs d'une personne (pouvoir, effet) pendant 10 minutes avec la commande /u. Une fois la couronne crafté vous aurez en plus force la nuit.\r\n" + 
							"" + 
							""
							);
					}
				if(p.sauron != null) {
				p.sauron.sendMessage("§3vous êtes sauron, votre objectif est d'éliminé l'ainur et tous les roles solo. Vous êtes un simple balrog mais si melkor meurt vous prenez sa place et obtenez tous ses pouvoirs. Une fois la couronne crafté vous aurez en plus force la nuit\r\n" + 
						"");
				}
				if(p.Eru_Iluvatar != null) {
				p.Eru_Iluvatar.sendMessage("§3vous êtes eru ilvatar, votre objectif est d'éliminé touts les balrogs ainsi que les roles solos. Pour cela vous avez entre vos mains deux chansons mais vous ne pourrez en utiliser qu'une seule avec la commande /u, vous devrez choisir votre chanson avant 25 minutes, l'ainur connaît votre identité.\r\n" + 
						"");
				BaseComponent[] page = new ComponentBuilder("§d[§bChanson de Revelation§d]")
						.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/u revelation"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aTu peut dévoiler a tous le monde le role d'un joueur situé a 10 blocks de toi avec /u [joueur]").create()))
				        .create();
				BaseComponent[] page2 = new ComponentBuilder("§d[§bChanson de Soul§d]")
						.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/u soul"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aSi tu meurt d'un joueur tu peut entre qu'il perds 5 coeurs ou que tu reprenne vie en perdant 1 coeur tout les jour").create()))
				        .create();
				p.Eru_Iluvatar.spigot().sendMessage(page);
				p.Eru_Iluvatar.spigot().sendMessage(page2);
				Bukkit.broadcastMessage("§e"+p.Eru_Iluvatar.getDisplayName()+" est Eru Iluvatar");
				}
				if(p.manwé != null) {
				p.manwé.sendMessage("Tu fait parti de l'Ainur. Tu est insensible a l'effet passif du silmarils bleu. Tu fais parti de l'Ainur. A Chaque debut de jour tu sera si au debut du jour d'avant tu était a 50 blocks ou moins de Melkor. Tu posséder un effet speed permanent");
				}
				if(p.luthien != null) {
				p.luthien.sendMessage("Tu fait parti de l'Ainur. Tu aperçois les message que reçoit les balrog");
				}
				if(p.namo != null) {
				p.namo.sendMessage("Tu fais parti de l'Ainur.2 fois dans la game avec /u pseudo tu peut connaitre la raison de la mort d’un joueur "
				+"Tu peut savoir qui la tué si il est mort pvp. Mais quand tu t’en sert tu va "
						+ "perdre 2 coeur permanent par utilisation. Si le tueur et le Balrog Infiltré tu vera le message en "
						+ "brouiller.");
				}
				if(p.sauruman != null) {
				p.sauruman.sendMessage("Pendant les 15 première minute d’un jour tu peut écrire un message avec /u msg qui sera "
						+ "envoyé a tout le monde le debut du jour suivant. Tu restera anonyme.");
				}
				if(p.gandalf != null) {
				p.gandalf.sendMessage("Tu fait parti de l'Ainur. Cinq fois dans la game tu peut inspecter 5 personnes a 10 block de toi. "
						+ "il y a deux résultat possible au flaire: " + 
						"suspect: 80%(4/5) méchant 20%(1/5) gentils" + 
						"innocentés: 80%(4/5) gentils 20%(1/5) méchant" + 
						"tu peut flairer plusieur fois la même personne.");
				}
				if(p.lorien != null) {
				p.lorien.sendMessage("Tu fais parti de l'Ainur. A partir de l'episode 4 tes compas pointeront vers le planatir");
				 //p.lorien.setCompassTarget(new Location(p.lorien.getWorld(), 50, 100, 50));
				}
				if(p.scorcier_bleu_1 != null) {
				p.scorcier_bleu_1.sendMessage("Tu fait parti de l'Ainur. Tu a un scorcier bleu d’ont tu ne connais pas le nom. "
						+ "Tu a la commande /u pseudo a une seul utilisation que vous partager, pour tenter de trouver ton confrère. "
						+ "Si tu réussi si l'un de vous meurt a moin de 20 blocks de l'autre il sera réssuisiter. Si tu rate tu resevra "
						+ "son vrai nom mais tu ne ressevra pas de pouvoir. Si ta cible est en realité un balrog, il recevera 2 coeur permanent");
				
				}
				if(p.scorcier_bleu_2 != null) {
				p.scorcier_bleu_2.sendMessage("Tu fait parti de l'Ainur. Tu a un scorcier bleu d’ont tu ne connais pas le nom. "
						+ "Tu a la commande /u pseudo a une seul utilisation que vous partager, pour tenter de trouver ton confrère. "
						+ "Si tu réussi si l'un de vous meurt a moin de 20 blocks de l'autre il sera réssuisiter. Si tu rate tu resevra "
						+ "son vrai nom mais tu ne ressevra pas de pouvoir. Si ta cible est en realité un balrog, il recevera 2 coeur permanent");
				}
				if(p.aulé != null) {
				p.aulé.sendMessage("Tu fait parti de l'Ainur. Tu a un livre sharp 3 et un livre prot 3");
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
				p.fingolfin.sendMessage("Tu fait parti de l'Ainur. Tu lorsque la moitié des joueur sont mort tu a 2min pour choisir un camps(balrog/Ainur/Neutre).");
				
				}
				if(p.varda != null) {
				p.varda.sendMessage("Tu fait parti de l'Ainur. A chaque début d’episode avec /u pseudo tu peut découvrir le Type d'un joueur");
				
				}
				if(p.maedhros != null) {
					
				
				p.maedhros.sendMessage("Tu fait parti de l'Ainur. Tu peut cacher une personne par épisode en lui donnant l’effet invisibilité avec /u pseudo. "
						+ "Tu a droit de te cacher toi même que 2 fois dans la partie.");
				
				}
				if(p.tulkas != null) {
				p.tulkas.sendMessage("Tu fait parti de l'Ainur. Tu a un effet de force le jour et tu a deux coeur en plus.");
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
				Search.Revive(playerO, p);
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

