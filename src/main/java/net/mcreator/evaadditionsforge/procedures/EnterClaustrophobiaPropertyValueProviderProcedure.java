package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;

public class EnterClaustrophobiaPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("canNoctua");
	}
}
