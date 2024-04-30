package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

public class AntibodyOVLStep3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("antibodyOverlay") == 3) {
			return true;
		}
		return false;
	}
}
