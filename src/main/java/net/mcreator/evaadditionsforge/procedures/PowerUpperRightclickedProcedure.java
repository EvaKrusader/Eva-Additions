package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

public class PowerUpperRightclickedProcedure {
	public static void execute(Entity entity) {
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
		} else {
			{
				double _setval = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower + 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(EvaAdditionsModItems.COGNITION.get(), 1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(EvaAdditionsModItems.PERCEPTION.get(), 1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(EvaAdditionsModItems.REQUIEM.get(), 1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(EvaAdditionsModItems.EQUINOX.get(), 1);
			new ItemStack(EvaAdditionsModItems.COGNITION.get()).getOrCreateTag().putDouble("baublePower",
					((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
			new ItemStack(EvaAdditionsModItems.PERCEPTION.get()).getOrCreateTag().putDouble("baublePower",
					((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
			new ItemStack(EvaAdditionsModItems.REQUIEM.get()).getOrCreateTag().putDouble("baublePower",
					((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
			new ItemStack(EvaAdditionsModItems.EQUINOX.get()).getOrCreateTag().putDouble("baublePower",
					((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
		}
		ChooseAptitudeProcedure.execute(entity);
	}
}
