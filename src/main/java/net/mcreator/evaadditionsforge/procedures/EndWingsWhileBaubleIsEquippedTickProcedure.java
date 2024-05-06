package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class EndWingsWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.END) {
			if (entity.getY() <= 0) {
				EndWingsUppiesProcedure.execute(entity);
			}
			if (entity.getY() >= 80) {
				if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).VoidWingsSlow == true) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (itemstack.getOrCreateTag().getDouble("baublePower") - 3), false, false));
					{
						boolean _setval = false;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.VoidWingsSlow = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
