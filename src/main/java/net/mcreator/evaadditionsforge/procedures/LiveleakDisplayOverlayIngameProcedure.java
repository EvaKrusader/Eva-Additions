package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class LiveleakDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ShowLiveleak;
	}
}
