package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class PowerUpperRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "\u00A7r\u00A7f";
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ItemColorReset = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 5) {
			{
				double _setval = 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EvaAdditionsMod.queueServerWork(10, () -> {
				{
					boolean _setval = true;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.justPowered = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				EvaAdditionsMod.queueServerWork(10, () -> {
					{
						ItemStack _setval = ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem);
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aptitudeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			});
		} else {
			{
				double _setval = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower + 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EvaAdditionsMod.queueServerWork(10, () -> {
				{
					boolean _setval = true;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.justPowered = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				EvaAdditionsMod.queueServerWork(10, () -> {
					{
						ItemStack _setval = ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem);
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aptitudeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			});
		}
	}
}
