package eu.spvp.enums;

import java.util.HashMap;

import eu.spvp.kits.PvP;
import eu.spvp.objects.Kit;

public class Kits {

	protected static HashMap<String, Kit> kits = new HashMap<String, Kit>();

	public static Kit getKit(String name) {
		return kits.get(name);
	}
	
	public static void setKit(String name, Kit kit) {
		kits.put(name, kit);
	}
	
	public static void invokeRegister() {
		setKit("PvP", new PvP());
	}
}
