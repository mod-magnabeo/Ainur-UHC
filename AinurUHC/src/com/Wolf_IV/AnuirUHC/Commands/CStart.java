package com.Wolf_IV.AnuirUHC.Commands;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Wolf_IV.AnuirUHC.MainA;
import com.Wolf_IV.AnuirUHC.Timers.TimerTasks;

public class CStart implements CommandExecutor {
		public static String Nvert="§aRejoindre Equipe Verte";
		public static String Njaune="§eRejoindre Equipe Jaune";
		public static String Nbleu="§1Rejoindre Equipe Blue";
		public static String Nnoir="§0Rejoindre Equipe Noir";
		public static String Nmagenta="§dRejoindre Equipe Magenta";
		private static MainA main;
		public CStart(MainA mainA) { 
			this.main= mainA;
			
		}

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
			
			
			if(sender instanceof Player) {
				if(cmd.getName().equalsIgnoreCase("startuhc")) {
					Player player = (Player) sender;
					TimerTasks tasks = new TimerTasks(main);
					tasks.runTaskTimer(main, 0, 20);
					TimerTasks.starting=true;
					for (Player playerO : Bukkit.getServer().getOnlinePlayers()) {
						playerO.getInventory().clear();
						//bleu/jaune noir/blanc vert/magenta 
						playerO.getInventory().setHeldItemSlot(0);
						 ItemStack Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.MAGENTA.getData());
						ItemMeta customG = Green.getItemMeta();
						customG.setDisplayName(Nvert);
						Green.setItemMeta(customG);
						playerO.getInventory().setItemInHand(Green);
						
						playerO.getInventory().setHeldItemSlot(1);
						 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.BLUE.getData());
						 customG = Green.getItemMeta();
						customG.setDisplayName(Njaune);
						Green.setItemMeta(customG);
						playerO.getInventory().setItemInHand(Green);
						
						playerO.getInventory().setHeldItemSlot(2);
						 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.YELLOW.getData());
						 customG = Green.getItemMeta();
						customG.setDisplayName(Nbleu);
						Green.setItemMeta(customG);
						playerO.getInventory().setItemInHand(Green);
						
						playerO.getInventory().setHeldItemSlot(3);
						 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.WHITE.getData());
						 customG = Green.getItemMeta();
						customG.setDisplayName(Nnoir);
						Green.setItemMeta(customG);
						playerO.getInventory().setItemInHand(Green);
						
						playerO.getInventory().setHeldItemSlot(4);
						 Green = new ItemStack(Material.INK_SACK, 1, (short)0, DyeColor.GREEN.getData());
						 customG = Green.getItemMeta();
						customG.setDisplayName(Nmagenta);
						Green.setItemMeta(customG);
						playerO.getInventory().setItemInHand(Green);
						}
					
					
				}
			}
			return false;
		}

	}
