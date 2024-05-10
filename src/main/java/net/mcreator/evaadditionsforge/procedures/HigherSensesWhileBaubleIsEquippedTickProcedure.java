package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class HigherSensesWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double glowDistance = 0;
		double glowDuration = 0;
		double speedDuration = 0;
		double speedHealth = 0;
		double speedPower = 0;
		double cooldown = 0;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 1) {
			glowDistance = 3;
			glowDuration = 5;
			speedDuration = 1;
			speedHealth = 3;
			cooldown = 5;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 2) {
			glowDistance = 5;
			glowDuration = 10;
			speedDuration = 1;
			speedHealth = 5;
			cooldown = 10;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 3) {
			glowDistance = 10;
			glowDuration = 15;
			speedDuration = 1;
			speedHealth = 7;
			cooldown = 15;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 4) {
			glowDistance = 15;
			glowDuration = 20;
			speedDuration = 1;
			speedHealth = 9;
			cooldown = 20;
		} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 5) {
			glowDistance = 25;
			glowDuration = 30;
			speedDuration = 1;
			speedHealth = 11;
			cooldown = 30;
		}
		speedPower = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower;
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
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.GLOWING);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < speedHealth) {
			if (!(entity instanceof Player _plrCldCheck5 && _plrCldCheck5.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) (speedDuration * 20), (int) (speedPower - 1), false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) (speedDuration * 20), (int) ((speedPower - 2) * 2), false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, (int) (speedDuration * 20), (int) (speedPower - 1), false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) (speedDuration * 20), (int) (speedPower - 1), false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, (int) (speedDuration * 20), (int) (speedPower - 1), false, false));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("effect give @e[distance=.." + new java.text.DecimalFormat("##.##").format(glowDistance) + "] minecraft:slowness " + new java.text.DecimalFormat("##.##").format(glowDuration / 5) + " "
										+ new java.text.DecimalFormat("##.##").format(speedPower - 1) + " true"));
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (cooldown * 20));
			}
		}
	}
}
