package eu.spvp.objects;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import eu.spvp.enums.ArmorType;

public abstract class Kit {

	private String name;
	
	private int price = 0;
	
	private HashMap<ArmorType, ItemStack> armor;
	private ItemStack sword;
	
	public Kit(String name, int price) {
		this.name = name;
		this.price = price;
		this.armor = new HashMap<ArmorType, ItemStack>();
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public HashMap<ArmorType, ItemStack> getArmor() {
		return armor;
	}
	
	public ItemStack getSword() {
		return sword;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setArmor(ArmorType type, ItemStack item) {
		this.armor.put(type, item);
	}
	
	public void setSword(ItemStack sword) {
		this.sword = sword;
	}
	
	public void giveArmor(Player p) {
		for(ArmorType type : getArmor().keySet()) {
			switch(type) {
			case HELMET:
				p.getInventory().setHelmet(getArmor().get(type));
				break;
			case CHESTPLATE:
				p.getInventory().setChestplate(getArmor().get(type));
				break;
			case LEGGINGS:
				p.getInventory().setLeggings(getArmor().get(type));
				break;
			case BOOTS:
				p.getInventory().setBoots(getArmor().get(type));
				break;
			default:
				break;
			}
		}
	}
	
	public void giveSword(Player p) {
		/**
		 * @TODO Get the setting of player (Slot of sword)
		 */
		p.getInventory().setItem(0, getSword());
	}
	
	public abstract void give(User p);
	
}
