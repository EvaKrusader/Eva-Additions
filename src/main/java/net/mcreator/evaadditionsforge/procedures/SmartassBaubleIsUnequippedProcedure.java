package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;

public class SmartassBaubleIsUnequippedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setCount(0);
	}
}
