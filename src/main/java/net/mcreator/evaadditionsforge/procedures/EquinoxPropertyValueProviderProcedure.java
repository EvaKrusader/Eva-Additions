package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;

public class EquinoxPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 1) {
			return 1;
		} else if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 2) {
			return 2;
		}
		return 0;
	}
}
