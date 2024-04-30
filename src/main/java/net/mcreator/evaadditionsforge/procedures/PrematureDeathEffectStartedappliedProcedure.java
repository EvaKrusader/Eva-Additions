package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class PrematureDeathEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ShowLiveleak = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
