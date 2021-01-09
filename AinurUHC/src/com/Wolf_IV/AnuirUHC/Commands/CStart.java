package com.Wolf_IV.AnuirUHC.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.MainA;
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
	
	public boolean jouD[]= new boolean[24+1+1];
	public Role role[]=new Role[24+1+1];
	public Player jou[]=new Player[24+1+1];
	public Player jouHit[]=new Player[24+1+1];
	public Player evil[]=new Player[9+1+1];
	public Player Feanor;
	public Player Melkor;
	public Player ungoliant;
	public Player balrog[]=new Player[7+1+1];
	public Player balrogC[]=new Player[6+1+1];
	public Player balrog_infiltré;
	public Player balrog_traceur;
	public Player sauron;
	public Player Eru_Iluvatar;
	public Player manwé;
	public Player oromé;
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
	
	public String jouS[]=new String[24+1+1];
	public String jouHitS[]=new String[24+1+1];
	public String evilS[]=new String[9+1+1];
	public String FeanorS;
	public String MelkorS;
	public String ungoliantS;
	public String balrogS[]=new String[7+1+1];
	public String balrog_infiltréS;
	public String balrog_traceurS;
	public String sauronS;
	public String Eru_IluvatarS;
	public String manwéS;
	public String oroméS;
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
	
	
	
		private static MainA main;
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
			
			
			if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase("startainuruhc")) {
					Player player = (Player) sender;
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
						
						  for(i = 1; i<=nubPlayer; i++) {
							  role[i].setPlayer(jou[i]);
						  }
						Melkor=jou[1];
						role[1].setRole("Melkor");
						sauron=jou[2];
						role[2].setRole("Sauron");
						ungoliant=jou[3];
						role[3].setRole("Ungoliant");
						
						for(i=1;i<=6;i++) {
							balrog[i]=jou[i+3];
							}
						
						balrog[7]=ungoliant;
						role[7].setRole("Balrog");
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
							role[i+3].setRole("Balrog");
						}
						
						balrog_infiltré=balrog[1];
						role[4].setRole("Balrog Infiltré");
						balrog_traceur=balrog[2];
						role[5].setRole("Balrog Traceur");
						
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
						role[10].setRole("Fëanor");
						Eru_Iluvatar=jou[11];
						role[11].setRole("Eru Iluvatar");
						manwé=jou[12];
						role[12].setRole("Manwë");
						oromé=jou[13];
						role[13].setRole("Oromë");
						namo=jou[14];
						role[14].setRole("Namo");
						sauruman=jou[15];
						role[15].setRole("Saruman");
						gandalf=jou[16];
						role[16].setRole("Gandalf");
						lorien=jou[17];
						role[17].setRole("Lorien");
						scorcier_bleu_1=jou[18];
						role[18].setRole("Scorcier Bleu");
						scorcier_bleu_2=jou[19];
						role[19].setRole("Scorcier Bleu");
						aulé=jou[20];
						role[20].setRole("Aulë");
						fingolfin=jou[21];
						role[21].setRole("Fingolfin");
						varda=jou[22];
						role[22].setRole("Varda");
						maedhros=jou[23];
						role[23].setRole("Maedhros");
						tulkas=jou[24];
						role[24].setRole("Tulkas");
						
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
										if(args[i].equalsIgnoreCase("melkor")) {
											Melkor=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Melkor");
											evil[evilnub]=playerO;
											evilnub++;
										}else if(args[i].equalsIgnoreCase("sauron")) {
											sauron=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Sauron");
											evil[evilnub]=playerO;
											evilnub++;
										}else if(args[i].equalsIgnoreCase("ungoliant")) {
											ungoliant=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Ungoliant");
											evil[evilnub]=playerO;
											evilnub++;
											balrog[balnub]=playerO;
											balnub++;
										}else if(args[i].equalsIgnoreCase("balrog_infiltré")) {
											balrog_infiltré=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Balrog Infiltré");
											evil[evilnub]=playerO;
											evilnub++;
											balrog[balnub]=playerO;
											balnub++;
										}else if(args[i].equalsIgnoreCase("balrog_traceur")) {
											balrog_traceur=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Balrog Traceur");
											evil[evilnub]=playerO;
											evilnub++;
											balrog[balnub]=playerO;
											balnub++;
										}else if(args[i].equalsIgnoreCase("balrog")) {
											balrog_traceur=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Balrog");
											evil[evilnub]=playerO;
											evilnub++;
											balrog[balnub]=playerO;
											balnub++;
										}else if(args[i].equalsIgnoreCase("feanor")) {
											Feanor=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Fëanor");
										}else if(args[i].equalsIgnoreCase("eru_iluvatar")) {
											Eru_Iluvatar=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Eru Iluvatar");
										}else if(args[i].equalsIgnoreCase("manwé")) {
											manwé=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Manwé");
										}else if(args[i].equalsIgnoreCase("oromé")) {
											oromé=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Oromé");
										}else if(args[i].equalsIgnoreCase("namo")) {
											namo=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Namo");
										}else if(args[i].equalsIgnoreCase("sauruman")) {
											sauruman=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Sauruman");
										}else if(args[i].equalsIgnoreCase("gandalf")) {
											gandalf=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Gandalf");
										}else if(args[i].equalsIgnoreCase("lorien")) {
											lorien=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Lorien");
										}else if(args[i].equalsIgnoreCase("scorcier_bleu")) {
											if(scb==1) {
											scorcier_bleu_1=playerO;
											}else {
												scorcier_bleu_2=playerO;
											}
											Bukkit.broadcastMessage(""+playerO.getName()+" est Scorcier Bleu");
										}else if(args[i].equalsIgnoreCase("aulé")) {
											aulé=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Aulé");
										}else if(args[i].equalsIgnoreCase("fingolfin")) {
											fingolfin=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Fingolfin");
										}else if(args[i].equalsIgnoreCase("varda")) {
											varda=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Varda");
										}else if(args[i].equalsIgnoreCase("maedhros")) {
											maedhros=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Maedhros");
										}else if(args[i].equalsIgnoreCase("tulkas")) {
											tulkas=playerO;
											Bukkit.broadcastMessage(""+playerO.getName()+" est Tulkas");
										}
										jou[i+1]=playerO;
										jouD[i+1] = true;
										role[i+1].setPlayer(playerO);
										role[i+1].setRole(args[i]);
										
									
									//Bukkit.broadcastMessage("1");
									}
									
								}
								  for(i = 1; i<=nubPlayer; i++) {
									  role[i].setPlayer(jou[i]);
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
			if(balrog_traceur!=null)balrog_traceurS=balrog_traceur.getName();
			
			
			if(Feanor!=null)FeanorS=Feanor.getName();
			if(Eru_Iluvatar!=null)Eru_IluvatarS=Eru_Iluvatar.getName();
			if(manwé!=null)manwéS=manwé.getName();
			if(oromé!=null)oroméS=oromé.getName();
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
