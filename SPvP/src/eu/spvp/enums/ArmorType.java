package eu.spvp.enums;

public enum ArmorType {

	HELMET(0),
	CHESTPLATE(1),
	LEGGINGS(2),
	BOOTS(3);
	
	private int slot;
	
	private ArmorType(Integer slot) {
		this.slot = slot;
	}
	
	public int getSlot() {
		return slot;
	}
}
