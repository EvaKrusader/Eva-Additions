package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;

public class CycleChangeProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		boolean cycle = false;
		if (cycle == false) {
			itemstack.getOrCreateTag().putBoolean("equinoxCycle", (world instanceof Level _lvl0 && _lvl0.isDay()));
			cycle = true;
		}
	}
}
