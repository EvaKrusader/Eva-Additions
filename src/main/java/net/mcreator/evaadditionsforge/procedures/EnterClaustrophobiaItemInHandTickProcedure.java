package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class EnterClaustrophobiaItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world instanceof Level _lvl0 && _lvl0.isDay()) == false && entity.getY() < -40 && (entity.level().dimension()) == Level.OVERWORLD) {
			itemstack.getOrCreateTag().putDouble("canNoctua", 1);
		} else {
			itemstack.getOrCreateTag().putDouble("canNoctua", 0);
		}
	}
}
