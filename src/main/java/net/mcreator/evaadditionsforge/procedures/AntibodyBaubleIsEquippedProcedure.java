package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class AntibodyBaubleIsEquippedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean hasTried = false;
		boolean triedWither = false;
		boolean FixNext = false;
		String itemName = "";
		double baubleChance = 0;
		itemName = "Immune System";
		baubleChance = Math.random();
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 0) {
			if (baubleChance > 0.95) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
			} else if (baubleChance > 0.8) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
			} else if (baubleChance > 0.6) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
			} else if (baubleChance > 0.25) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
			} else if (baubleChance > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A77Dead \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7aDeficient \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7bGood \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7dGreat \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A76Perfect \u00A7r\u00A7f" + itemName)));
		}
		AntibodyEnderlinkProcedure.execute(world, x, y, z, entity);
	}
}
