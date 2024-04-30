package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

public class AntibodyHurtOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double OVLtime = 0;
		if (entity.getPersistentData().getDouble("antibodyOverlay") > 0) {
			return true;
		}
		return false;
	}
}
