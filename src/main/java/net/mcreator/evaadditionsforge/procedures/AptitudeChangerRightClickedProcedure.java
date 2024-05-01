package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class AptitudeChangerRightClickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.hasAptitude = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		EvaAdditionsMod.queueServerWork(1, () -> {
			ChooseAptitudeProcedure.execute(entity);
			EvaAdditionsMod.queueServerWork(1, () -> {
				ChooseAptitudeProcedure.execute(entity);
			});
		});
	}
}
