package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class HigherSensesWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double glowDistance = 0;
		double glowDuration = 0;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 1) {
			glowDistance = 3;
			glowDuration = 5;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 2) {
			glowDistance = 5;
			glowDuration = 10;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 3) {
			glowDistance = 10;
			glowDuration = 15;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 4) {
			glowDistance = 15;
			glowDuration = 20;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 5) {
			glowDistance = 25;
			glowDuration = 30;
		}
		if (entity.isShiftKeyDown()) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("effect give @e[distance=.." + new java.text.DecimalFormat("##.##").format(glowDistance) + "] minecraft:glowing " + new java.text.DecimalFormat("##.##").format(glowDuration) + " 0 true"));
				}
			}
		}
	}
}
