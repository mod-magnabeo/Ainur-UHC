package com.Wolf_IV.AnuirUHC.Role;

import org.bukkit.entity.Player;

public class Role {

	Player player;
	String role;
	String lien;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
}
