package com.Wolf_IV.AnuirUHC.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Role.BalrogInfiltre;
import com.Wolf_IV.AnuirUHC.Role.BalrogTraceur;
import com.Wolf_IV.AnuirUHC.Role.EruIluvatar;
import com.Wolf_IV.AnuirUHC.Role.Fingolfin;
import com.Wolf_IV.AnuirUHC.Role.Gandalf;
import com.Wolf_IV.AnuirUHC.Role.Maedhros;
import com.Wolf_IV.AnuirUHC.Role.Namo;
import com.Wolf_IV.AnuirUHC.Role.Oromé;
import com.Wolf_IV.AnuirUHC.Role.Saruman;
import com.Wolf_IV.AnuirUHC.Role.Varda;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class CU implements CommandExecutor {
	private static CStart p;
	public CU(CStart cstart) { 
		this.p= cstart;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("u")) {
				Player player = (Player)sender;
				if(TimerTasks.Ingame==false) {
					player.sendMessage("§4La game n'est pas encore lancer");
					return false;
				}
				
				if(BalrogInfiltre.u(p, player, args)==true) {
					
				}else if(BalrogTraceur.u(p, player, args)==true) {
					
				}else if(EruIluvatar.u(p, player, args)==true) {
					
				}else if(Oromé.u(p, player, args)==true) {
					
				}else if(Namo.u(p, player, args)==true) {
					
				}else if(Saruman.u(p, player, args)==true) {
					
				}else if(Gandalf.u(p, player, args)==true) {
					
				}else if(Fingolfin.u(p, player, args)==true) {
					
				}else if(Varda.u(p, player, args)==true) {
					
				}else if(Maedhros.u(p, player, args)==true) {
					
				}
				player.sendMessage("§4Vous ne pouver pas vous serivir de ctte command maintenant");
				return true;
			}
		}
		sender.sendMessage("§4Vous ne pouver pas vous servir de cette command");
		return false;
	}

}
