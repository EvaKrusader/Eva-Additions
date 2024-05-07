package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class EndWingsWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == Level.END) {
			if (entity.getY() <= 0) {
				EndWingsUppiesProcedure.execute(entity);
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
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
					if ((EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.PLUME_SHIELD.get(), itemstack) != 0) == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, (int) (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.PLUME_SHIELD.get()) + 1), false, false));
					}
				}
			}
		}
	}
}
