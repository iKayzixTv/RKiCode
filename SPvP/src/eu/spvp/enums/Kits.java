package eu.spvp.enums;

import eu.spvp.objects.Kit;

public enum Kits {

	PVP("PvP");
	
	//private Kit class_reference;
	private String name;
	
	Kits(String name) {
		this.name = name;
	}
	
	public Kit getKit() {
		return null;
	}
	
	public String getName() {
		return name;
	}
}
