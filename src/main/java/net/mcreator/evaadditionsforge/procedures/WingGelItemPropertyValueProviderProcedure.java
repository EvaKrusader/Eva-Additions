package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;

public class WingGelItemPropertyValueProviderProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("gelPower");
	}
}
