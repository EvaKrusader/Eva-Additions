package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class NightVisionBaubleIsEquippedProcedure {
	public static void execute(ItemStack itemstack) {
		String itemName = "";
		double baubleChance = 0;
		itemName = "Night Vision Goggles";
		baubleChance = Math.random();
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 0) {
			if (baubleChance > 0.9) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
				itemstack.getOrCreateTag().putDouble("gogglesY", 86);
			} else if (baubleChance > 0.75) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
				itemstack.getOrCreateTag().putDouble("gogglesY", 64);
			} else if (baubleChance > 0.55) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
				itemstack.getOrCreateTag().putDouble("gogglesY", 0);
			} else if (baubleChance > 0.3) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
				itemstack.getOrCreateTag().putDouble("gogglesY", (-32));
			} else if (baubleChance > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
				itemstack.getOrCreateTag().putDouble("gogglesY", (-128));
			}
		}
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A77Broken \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7aCheap \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7bAverage \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7dExpensive \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A76Elite \u00A7r\u00A7f" + itemName)));
		}
		NightVisionEnderlinkProcedure.execute();
	}
}
