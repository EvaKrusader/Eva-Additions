package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class EndWingsUppiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, 5, 0));
		{
			boolean _setval = true;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.VoidWingsSlow = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
