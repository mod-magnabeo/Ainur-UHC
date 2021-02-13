package com.Wolf_IV.AnuirUHC.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Role.Balrog;
import com.Wolf_IV.AnuirUHC.Role.Role;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class CStart implements CommandExecutor {
	Random rand = new Random();
	int rando;
	public int nubPlayer=0;
	int nubjou=0;
	Player container;
	int choose;
	int choose2;
	int i;
	
	public World world;
	public ItemStack SG;
	public ItemStack SB;
	public ItemStack SR;
	public ItemStack P;
	
	public boolean mMort = false;
	public boolean doubleMMort = false;
	public boolean SGU = true;
	public boolean SBU = true;
	public boolean SRU = true;
	public boolean SPU = true;
	
	public String deviner[] = new String[5+1+1];
	public Balrog balrogD[] = new Balrog[5+1+1];
	
	public boolean jouD[]= new boolean[24+1+1];
	public Role[] role =new Role[24+1+1];;
	public Player jou[]=new Player[24+1+1];
	public Player jouHit[]=new Player[24+1+1];
	public Player evil[]=new Player[11+1+1];
	public Player Feanor;
	public Player Melkor;
	public Player ungoliant;
	public Player balrog[]=new Player[7+1+1];
	public Player balrogC[]=new Player[6+1+1];
	public Player balrog_infiltré;
	public Player balrog_noir;
	public Player sauron;
	public Player Eru_Iluvatar;
	public Player manwé;
	public Player luthien;
	public Player namo;
	public Player sauruman;
	public Player gandalf;
	public Player lorien;
	public Player scorcier_bleu_1;
	public Player scorcier_bleu_2;
	public Player aulé;
	public Player fingolfin;
	public Player varda;
	public Player maedhros;
	public Player tulkas;
	public Player Orc;
	public Player finMechant;
	
	public String jouS[]=new String[24+1+1];
	public String jouHitS[]=new String[24+1+1];
	public String evilS[]=new String[11+1+1];
	public String FeanorS;
	public String MelkorS;
	public String ungoliantS;
	public String balrogS[]=new String[7+1+1];
	public String balrog_infiltréS;
	public String balrog_noirS;
	public String sauronS;
	public String Eru_IluvatarS;
	public String manwéS;
	public String luthienS;
	public String namoS;
	public String saurumanS;
	public String gandalfS;
	public String lorienS;
	public String scorcier_bleu_1S;
	public String scorcier_bleu_2S;
	public String auléS;
	public String fingolfinS;
	public String vardaS;
	public String maedhrosS;
	public String tulkasS;
	public String OrcS;// A la creation de l'orc noublie pas de le co register
	public String finMechantS;
	
	public String SVert;
	public String SBleu;
	public String SRouge;
	public String Planatir;
	
	
		public static MainA main;
		public CStart(MainA mainA) { 
			this.main= mainA;
			
		}
		//bleu/jaune noir/blanc vert/magenta 
		/*playerO.getInventory().setHeldItemSlot(0);
		 ItemStack Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.MAGENTA.getData());
		ItemMeta customG = Green.getItemMeta();
		customG.setDisplayName(Nvert);
		Green.setItemMeta(customG);
		playerO.getInventory().setItemInHand(Green);*/
		
		//Note: PotionEffect(PotionEffectType type, int duration, int ampflier, boolean ambient, boolean showParticles) 
		//Note: https://www.spigotmc.org/threads/partially-invisible.197565/#post-2057708 Invisible completement

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
			Role r =new Role();
			
			if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase("startainuruhc")) {
					Player player = (Player) sender;
					world = player.getWorld();
					TimerTasks tasks = new TimerTasks(main, this);
					tasks.runTaskTimer(main, 0, 20);
					TimerTasks.starting=true;
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set day");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "difficulty easy");
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "gamerule showDeathMessages false");
					
					
					for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
						playerO.setMaxHealth(20.0F);
						nubPlayer++;
					}
					if(nubPlayer==24) {
						for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
							nubjou++;
							jou[nubjou]=playerO;
							jouD[nubjou] = true;
						}
						rando=rand.nextInt(250)+50;
						for(i=0;i<=rando;i++) {
							choose=rand.nextInt(24)+1;
							choose2=rand.nextInt(24)+1;
							container=jou[choose2];
							jou[choose2]=jou[choose];
							jou[choose]=container;
							}
						
						r.setPlayer(jou[1].getDisplayName());
						Melkor=jou[1];
						r.setRole("Melkor");
						r.setLien("Valar");
						role[1] = r;
						sauron=jou[2];
						r.setRole("Sauron");
						r.setLien("Maiar");
						role[2] =r;
						ungoliant=jou[3];
						r.setRole("Ungoliant");
						r.setLien("Maiar");
						role[3] =r;
						
						for(i=1;i<=6;i++) {
							balrog[i]=jou[i+3];
							}
						
						balrog[7]=ungoliant;
						r.setRole("Balrog");
						r.setLien("Maiar");
						role[7] =r;
						for(i=1;i<=9;i++) {
							evil[i]=jou[i];
						}
						
						
						rando=rand.nextInt(50)+10;
						for(i=0;i<=rando;i++) {
							choose=rand.nextInt(7)+1;
							choose2=rand.nextInt(7)+1;
							container=balrog[choose2];
							balrog[choose2]=balrog[choose];
							balrog[choose]=container;
							}
						
						for(i=1;i<=7;i++) {
							r.setRole("Balrog");
							r.setLien("Maiar");
							role[i+3] =r;//ici
							if(i >=3) {//ici
							/**
								TODO	A changer si tu rajoute un balrog l.-2, l.-1, l.4
							*/
								Balrog bal = new Balrog();
								bal.player = balrog[i].getName();
								balrogD[i-2] = bal;//ici
							}
						}
						
						balrog_infiltré=balrog[1];
						r.setRole("Balrog Infiltré");
						r.setLien("Maiar");
						role[4] =r;
						balrog_noir=balrog[2];
						r.setRole("Balrog Traceur");
						r.setLien("Maiar");
						role[5] =r;
						
						
						for(i=1;i<=6;i++) {
							balrogC[i]=balrog[i+2];
						}
						rando=rand.nextInt(50)+10;
						for(i=0;i<=rando;i++) {
							choose=rand.nextInt(7)+1;
							choose2=rand.nextInt(7)+1;
							container=balrog[choose2];
							balrog[choose2]=balrog[choose];
							balrog[choose]=container;
							}
						
						
						Feanor=jou[10];
						r.setRole("Fëanor");
						r.setLien("Elf");
						role[10] =r;
						Eru_Iluvatar=jou[11];
						r.setRole("Eru Iluvatar");
						r.setLien("Pas de Type");
						role[11] =r;
						manwé=jou[12];
						r.setRole("Manwë");
						r.setLien("Valar");
						role[12] =r;
						luthien=jou[13];
						r.setRole("Lúthien");
						r.setLien("Valar");
						role[13] =r;
						namo=jou[14];
						r.setRole("Namo");
						r.setLien("Valar");
						role[14] =r;
						sauruman=jou[15];
						r.setRole("Saruman");
						r.setLien("Maiar");
						role[15] =r;
						gandalf=jou[16];
						r.setRole("Gandalf");
						r.setLien("Maiar");
						role[16] =r;
						lorien=jou[17];
						r.setRole("Lorien");
						r.setLien("Valar");
						role[17] =r;
						scorcier_bleu_1=jou[18];
						r.setRole("Scorcier Bleu");
						r.setLien("Maiar");
						role[18] =r;
						scorcier_bleu_2=jou[19];
						r.setRole("Scorcier Bleu");
						r.setLien("Maiar");
						role[19] =r;
						aulé=jou[20];
						r.setRole("Aulë");
						r.setLien("Valar");
						role[20] =r;
						fingolfin=jou[21];
						r.setRole("Fingolfin");
						r.setLien("Elf");
						role[21] =r;
						varda=jou[22];
						r.setRole("Varda");
						r.setLien("Valar");
						role[22]=r;
						maedhros=jou[23];
						r.setRole("Maedhros");
						r.setLien("Elf");
						role[23]=r;
						tulkas=jou[24];
						r.setRole("Tulkas");
						r.setLien("Valar");
						role[24]=r;
						
						for(i = 1; i<=nubPlayer; i++) {
							  r.setPlayer(jou[i].getDisplayName());
							  r.setRole(role[i].getRole());
							  r.setLien(role[i].getLien());
							  role[i] =r;
						  }
						
						rando=rand.nextInt(50)+10;
						for(i=0;i<=rando;i++) {
							choose=rand.nextInt(7)+1;
							choose2=rand.nextInt(7)+1;
							container=balrog[choose2];
							balrog[choose2]=balrog[choose];
							balrog[choose]=container;
							}
						
						rando=rand.nextInt(250)+50;
						for(i=0;i<=rando;i++) {
							choose=rand.nextInt(24)+1;
							choose2=rand.nextInt(24)+1;
							container=jou[choose2];
							jou[choose2]=jou[choose];
							jou[choose]=container;
							}
						
						RegisterString();
						
					}else {
						if(args.length!=0) {
							Bukkit.broadcastMessage("player: "+nubPlayer);
							Bukkit.broadcastMessage("role: "+args.length);
							
							if(args.length<=nubPlayer) {
								i=-1;//car il y a args[0] le premier role
								for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
									i++;
									if(args.length>=i) {
										
										
										Bukkit.broadcastMessage("args: "+args[0]);
										int balnub=1;
										int evilnub=1;
										int scb=1;
										Role rr =new Role();
										if(args[i].equalsIgnoreCase("melkor")) {
											Melkor=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Melkor");
											evil[evilnub]=playerO;
											evilnub++;
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("sauron")) {
											sauron=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Sauron");
											evil[evilnub]=playerO;
											evilnub++;
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("ungoliant")) {
											ungoliant=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Ungoliant");
											evil[evilnub]=playerO;
											evilnub++;
											balrogC[balnub] = playerO;
											balrog[balnub]=playerO;
											balnub++;
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("balrog_infiltré")) {
											balrog_infiltré=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Balrog Infiltré");
											evil[evilnub]=playerO;
											evilnub++;
											balrog[balnub]=playerO;
											balnub++;
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("balrog_noir")) {
											balrog_noir=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Balrog Noir");
											evil[evilnub]=playerO;
											evilnub++;
											balrogC[balnub] = playerO;
											balrog[balnub]=playerO;
											balnub++;
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("balrog")) {
											Bukkit.broadcastMessage(""+playerO.getName()+" est Balrog");
											evil[evilnub]=playerO;
											evilnub++;
											balrogC[balnub] = playerO;
											balrog[balnub]=playerO;
											balnub++;
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("feanor")) {
											Feanor=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Fëanor");
											rr.setLien("Elf");
										}else if(args[i].equalsIgnoreCase("eru_iluvatar")) {
											Eru_Iluvatar=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Eru Iluvatar");
											rr.setLien("Pas de Type");
										}else if(args[i].equalsIgnoreCase("manwé")) {
											manwé=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Manwé");
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("luthien")) {
											luthien=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Lúthien");
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("namo")) {
											namo=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Namo");
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("sauruman")) {
											sauruman=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Sauruman");
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("gandalf")) {
											gandalf=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Gandalf");
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("lorien")) {
											lorien=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Lorien");
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("scorcier_bleu")) {
											if(scb==1) {
											scorcier_bleu_1=playerO;
											}else {
												scorcier_bleu_2=playerO;
											}
											Bukkit.broadcastMessage(""+playerO.getName()+" est Scorcier Bleu");
											rr.setLien("Maiar");
										}else if(args[i].equalsIgnoreCase("aulé")) {
											aulé=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Aulé");
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("fingolfin")) {
											fingolfin=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Fingolfin");
											rr.setLien("Elf");
										}else if(args[i].equalsIgnoreCase("varda")) {
											varda=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Varda");
											rr.setLien("Valar");
										}else if(args[i].equalsIgnoreCase("maedhros")) {
											maedhros=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Maedhros");
											rr.setLien("Elf");
										}else if(args[i].equalsIgnoreCase("tulkas")) {
											tulkas=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Tulkas");
											rr.setLien("Valar");
										}
										jou[i+1]=playerO;
										jouD[i+1] = true;
										
										rr.setPlayer(playerO.getDisplayName());
										rr.setRole(args[i]);
										role[i+1] = rr;
										
									
									}
									
								}
								RegisterString();
							}else {
								Bukkit.broadcastMessage("§4Trop de role pour "+nubPlayer+" joueur(s)");
								return true;
							}
								
						Bukkit.broadcastMessage("La game se lance en essaie (Ce n'est pas une vrai game)");
						}else {
							Bukkit.broadcastMessage("§4Il n'y a pas assez de joueur");
							return true;
						}
						
					}
					
					
					
					
					
					
					
					return true;
				}
			}
			return false;
		}
		
		public void RegisterString() {
			
			if(Melkor!=null)MelkorS=Melkor.getName();
			if(sauron!=null)sauronS=sauron.getName();
			if(ungoliant!=null)ungoliantS=ungoliant.getName();
			
			for(i=1;i<=7;i++) {
				if(balrog[i]!=null) {
			balrogS[i]=balrog[i].getName();
				}
			}
			
			for(i=1;i<=9;i++) {
				if(evil[i]!=null) {
				evilS[i]=evil[i].getName();
				}
			}
			
			
			
			if(balrog_infiltré!=null)balrog_infiltréS=balrog_infiltré.getName();
			if(balrog_noir!=null)balrog_noirS=balrog_noir.getName();
			
			
			if(Feanor!=null)FeanorS=Feanor.getName();
			if(Eru_Iluvatar!=null)Eru_IluvatarS=Eru_Iluvatar.getName();
			if(manwé!=null)manwéS=manwé.getName();
			if(luthien!=null)luthienS=luthien.getName();
			if(namo!=null)namoS=namo.getName();
			if(sauruman!=null)saurumanS=sauruman.getName();
			if(gandalf!=null)gandalfS=gandalf.getName();
			if(lorien!=null)lorienS=lorien.getName();
			if(scorcier_bleu_1!=null)scorcier_bleu_1S=scorcier_bleu_1.getName();
			if(scorcier_bleu_2!=null)scorcier_bleu_2S=scorcier_bleu_2.getName();
			if(aulé!=null)auléS=aulé.getName();
			if(fingolfin!=null)fingolfinS=fingolfin.getName();
			if(varda!=null)vardaS=varda.getName();
			if(maedhros!=null)maedhrosS=maedhros.getName();
			if(tulkas!=null)tulkasS=tulkas.getName();
			
			for(i=1;i<=24;i++) {
				if(jou[i]!=null) {
				jouS[i]=jou[i].getName();
				}
				}
		
		}
		

	}
