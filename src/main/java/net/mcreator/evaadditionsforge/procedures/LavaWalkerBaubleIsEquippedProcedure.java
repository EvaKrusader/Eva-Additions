package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class LavaWalkerBaubleIsEquippedProcedure {
	public static void execute(ItemStack itemstack) {
		String itemName = "";
		double baubleChance = 0;
		itemName = "Necklace";
		baubleChance = Math.random();
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 0) {
			if (baubleChance > 0.9) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
			} else if (baubleChance > 0.7) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
			} else if (baubleChance > 0.45) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
			} else if (baubleChance > 0.1) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
			} else if (baubleChance > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A77" + "Room Temperature" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7a" + "Cold" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7b" + "Icy" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7d" + "Frozen" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A76" + "Glacial" + " \u00A7r\u00A7f" + itemName)));
		}
		LavaWalkerEnderlinkProcedure.execute();
	}
}
