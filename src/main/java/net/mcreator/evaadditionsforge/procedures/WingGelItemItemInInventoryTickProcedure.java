package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class WingGelItemItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double gelChance = 0;
		if (itemstack.getOrCreateTag().getDouble("gelPower") == 0) {
			gelChance = Math.random();
			if (gelChance > 0.66) {
				itemstack.getOrCreateTag().putDouble("gelPower", 3);
				itemstack.setHoverName(
						Component.literal(("\u00A76\u00A7n" + "Rarity" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " Wing Gel")));
			} else if (gelChance > 0.33) {
				itemstack.getOrCreateTag().putDouble("gelPower", 2);
				itemstack.setHoverName(
						Component.literal(("\u00A7d\u00A7n" + "Rarity" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " Wing Gel")));
			} else {
				itemstack.getOrCreateTag().putDouble("gelPower", 1);
				itemstack.setHoverName(
						Component.literal(("\u00A7b\u00A7n" + "Rarity" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " Wing Gel")));
			}
		}
	}
}
