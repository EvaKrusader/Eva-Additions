package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class EndWingsWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.END) {
			if (entity.getY() <= 0) {
				EndWingsUppiesProcedure.execute(entity);
			}
		}
	}
}
