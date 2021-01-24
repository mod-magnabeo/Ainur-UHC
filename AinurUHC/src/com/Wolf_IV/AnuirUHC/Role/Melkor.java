package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.Search;
import com.Wolf_IV.AnuirUHC.Commands.CStart;

public class Melkor {
	
	public static void crownCheck(CStart p) {
		int sil = 0;
		for(String evil : p.evilS) {
			if(evil != null) {
				if(evil.equalsIgnoreCase(p.SBleu)) {
					sil++;
				}
				if(evil.equalsIgnoreCase(p.SVert)) {
					sil++;
				}
				if(evil.equalsIgnoreCase(p.SRouge)) {
					sil++;
				}
			}
		}
		
		if(sil == 3) {
			Bukkit.broadcastMessage("§6Les balrogs on obtenu les trois silmarils. Melkor a construit sa couronne de fer. "
					+ "Et il est maintenant connu sous le nom de Morgoth. Morgoth peut desormais transformer un joueur en Orc. Ungoliant est révèler");
			for(Player evil : p.evil) {
				if(evil != null) {
					Search.pInvItemSup(evil, p.SB);
					Search.pInvItemSup(evil, p.SG);
					Search.pInvItemSup(evil, p.SR);
				}
			}
			p.SVert = null;
			p.SBleu = null;
			p.SRouge = null;
		}
	}

}
