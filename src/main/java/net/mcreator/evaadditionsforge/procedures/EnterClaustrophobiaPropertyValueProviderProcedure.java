package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class EnterClaustrophobiaPropertyValueProviderProcedure {
	public static double execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return 0;
		if (entity.getY() < -40 && (world instanceof Level _lvl1 && _lvl1.isDay()) == true) {
			return 1;
		}
		return 0;
	}
}
