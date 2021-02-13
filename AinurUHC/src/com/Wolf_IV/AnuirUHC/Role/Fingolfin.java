package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class Fingolfin {
	public static boolean j12 = false;
	public static boolean done = false;
	public static boolean choix = false;
	public static boolean neutre = false;
	public static boolean mechant = false;
	public static boolean gentil = false;

	public static boolean u(CStart p, Player player, String[] args) {
		if(player != p.fingolfin) {
		return false;
		}
		if(j12 == false) {
			player.sendMessage("§4Il faut que la moitié des joueur soit mort pour choisir ton camp");
			return true;
		}else if(done == true && choix == false) {
			player.sendMessage("§4Tu a pris trop de temps a choisir tu doit donc gagner tout seul");
			return true;
		}else if(choix == true) {
			player.sendMessage("§4Tu a déjà choisi");
			return true;
		}
		Inventory inv = Bukkit.createInventory(null, 27, "§bChoisir un camp:");
		
		ItemStack Bal =new Wool(DyeColor.RED).toItemStack();
		ItemMeta customBal = Bal.getItemMeta();
		customBal.setDisplayName("§4Servir Melkor/Morgoth(Devenir Méchant)");
		Bal.setItemMeta(customBal);
		
		ItemStack Neutre =new Wool(DyeColor.YELLOW).toItemStack();
		ItemMeta customNeutre = Neutre.getItemMeta();
		customNeutre.setDisplayName("§ePour gagner tu dois etre le dernier survivant");
		Neutre.setItemMeta(customNeutre);
		
		ItemStack Gen =new Wool(DyeColor.GREEN).toItemStack();
		ItemMeta customGen = Gen.getItemMeta();
		customGen.setDisplayName("§aDevenir Gentil(Combatre Melkor/Morgoth)");
		Gen.setItemMeta(customGen);
		
		inv.setItem(11, Bal);
		inv.setItem(13, Neutre);
		inv.setItem(15, Gen);
		
		p.fingolfin.openInventory(inv);
		return true;
	}
	public static void j12(CStart p) {
		j12 = true;
		if(p.fingolfin != null) {
			p.fingolfin.sendMessage("§bfingolfin le nombre de joueur en vie et decendu a ou moin 12 tu a 5 min pour choisir un camp grace a la commande /u");
		}
		
	}
	
	public static void done(CStart p) {
		done = true;
		if(choix == false) {
			if(p.fingolfin != null) {
				p.fingolfin.sendMessage("§bLe temps et écoulé vous devez desormais etre le dernier survivant de la partie");
				neutre(p);
				choix=false;
			}
		}
		
	}
	public static void mechant(CStart p) {
		choix = true;
		mechant = true;
		int sil = 0;
		if(p.SBleu != null && p.SBleu.equalsIgnoreCase(p.fingolfinS))sil++;
		if(p.SVert != null && p.SVert.equalsIgnoreCase(p.fingolfinS))sil++;
		if(p.SRouge != null && p.SRouge.equalsIgnoreCase(p.fingolfinS))sil++;
		for(Player evil : p.evil) {
			if(evil != null) {
				evil.sendMessage("§cFingolfin a rejoin votre camp");
				for(int i = 1; i<=sil; i++) {
					for(Player bal : p.evil) {
						if(bal != null) {
							bal.sendMessage("§cUn membre de votre equipe a recupèrer un silmarils");
						}
					}
					if(p.luthien != null) {
						p.luthien.sendMessage("§cUn membre de l'equipe adverse a recupèrer un silmarils");
					}
					Melkor.crownCheck(p);
				}
			}
		}
		
		for(int i=1;i<=11;i++) {
			if(p.evilS[i] == null) {
				p.evilS[i] = p.fingolfinS;
				p.evil[i] = p.fingolfin;
				p.finMechant = p.fingolfin;
				p.finMechantS = p.fingolfinS;
				p.fingolfin.sendMessage("§bTu est desormais méchant fais /br pour connaitre les membre de ton camp");
				return;
			}
		}

	}
	
	public static void gentil(CStart p) {
		choix = true;
		gentil = true;
		p.fingolfin.sendMessage("§bTu est desormais gentil");
	}
	public static void neutre(CStart p) {
		choix = true;
		neutre = true;
		p.fingolfin.sendMessage("§bTu dois desormais gagner seul");
	}
	
	

}
