package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class AltometerWaterproofReturnProcedure {
	public static double execute(ItemStack itemstack) {
		if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
			return 1;
		}
		return 0;
	}
}
