package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class SmartassRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = -1;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.knowledgeLVL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		ChooseAptitudeProcedure.execute(entity);
	}
}
