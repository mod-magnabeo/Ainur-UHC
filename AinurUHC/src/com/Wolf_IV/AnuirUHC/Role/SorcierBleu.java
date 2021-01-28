package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class SorcierBleu {
	public static boolean utilisé =false;
	public static boolean pouvoir =false;
	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.scorcier_bleu_1 && player != p.scorcier_bleu_2) {
			return false;
		}
		
		if(utilisé == true) {
			if(player == p.scorcier_bleu_1) {
			player.sendMessage("§bVous conaisser deja votre scorcier bleu c'est "+p.scorcier_bleu_2S);
			}else {
				player.sendMessage("§bVous conaisser deja votre scorcier bleu c'est "+p.scorcier_bleu_1S);
			}
			return true;
		}
		
		if(args.length>0) {
			
			if(Bukkit.getPlayer(args[0]) != null) {
				player.sendMessage("§cJoueur hors ligne");
				return true;
			}else if(player == p.scorcier_bleu_1) {
				utilisé = true;
				if(Bukkit.getPlayer(args[0]) == p.scorcier_bleu_2) {
					player.sendMessage("§aBien joué tu a trouvé ton confrère scorcier bleu "+p.scorcier_bleu_2S+". Vous beneficier donc du pouvoir");
					p.scorcier_bleu_2.sendMessage("§aTon confrère scorcier bleu a visé juste sont nom est "+player.getDisplayName()+". Vous beneficier donc du pouvoir");
					pouvoir = true;
					return true;
				}else {
					player.sendMessage("§cRaté tu n'a trouvé ton confrère scorcier bleu. Le vrai s'appelle "+p.scorcier_bleu_2S+". Vous beneficier donc pas du pouvoir");
					p.scorcier_bleu_2.sendMessage("§cTon confrère scorcier bleu a mal visé juste sont nom est "+player.getDisplayName()+". Vous beneficier donc pas du pouvoir");
				}
				
			}else if(player == p.scorcier_bleu_2) {
				utilisé = true;
				if(Bukkit.getPlayer(args[0]) == p.scorcier_bleu_1) {
					player.sendMessage("§aBien joué tu a trouvé ton confrère scorcier bleu "+p.scorcier_bleu_1S+". Vous beneficier donc du pouvoir");
					p.scorcier_bleu_1.sendMessage("§aTon confrère scorcier bleu a visé juste sont nom est "+player.getDisplayName()+". Vous beneficier donc du pouvoir");
					pouvoir = true;
					return true;
				}else {
					player.sendMessage("§cRaté tu n'a trouvé ton confrère scorcier bleu. Le vrai s'appelle "+p.scorcier_bleu_2S+". Vous beneficier donc pas du pouvoir");
					p.scorcier_bleu_2.sendMessage("§cTon confrère scorcier bleu a mal visé juste sont nom est "+player.getDisplayName()+". Vous beneficier donc pas du pouvoir");
				}
				
			}
			
			utilisé = true;
			Player pChoix = Bukkit.getPlayer(args[0]);
			for(Player evil : p.evil) {
				if(evil != null && evil == pChoix) {
					pChoix.sendMessage("§bBravo un scorcier bleu ta pris pour l'autre soricier bleu. Tu beneficie de 2 coeur en plus permanent");
					pChoix.setMaxHealth(pChoix.getMaxHealth()+4.0F);
				}
			}
			return true;
		}else {
			player.sendMessage("§bu [player]");
		}
		return true;
	}
}
