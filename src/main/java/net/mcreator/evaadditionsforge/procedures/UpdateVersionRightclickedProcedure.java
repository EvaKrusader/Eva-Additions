package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class UpdateVersionRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3 == 1) {
			{
				double _setval = 2;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ver3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3 == 2) {
			{
				double _setval = 3;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ver3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3 == 3) {
			{
				double _setval = 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ver3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
