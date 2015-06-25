package eu.spvp.kits;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.spvp.enums.Kits;
import eu.spvp.objects.Kit;
import eu.spvp.objects.User;

public class PvP extends Kit {
	
	public PvP() {
		super("PvP", 50);
	}

	@Override
	public void give(User p) {
		p.setKit(Kits.getKit("PvP"));
		
		giveArmor(p.getPlayer());
		giveSword(p.getPlayer());
		
		ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta meta = soup.getItemMeta();
		meta.setDisplayName("§aMushrooms §bSoup");
		soup.setItemMeta(meta);
		
		for(int i = 0; i < 36; i++) {
			p.getPlayer().getInventory().addItem(soup);
		}
	}

}
