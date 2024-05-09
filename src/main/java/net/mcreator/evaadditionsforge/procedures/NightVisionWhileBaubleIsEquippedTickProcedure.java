package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModMobEffects;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class NightVisionWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getY() <= itemstack.getOrCreateTag().getDouble("gogglesY")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
			if ((entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get())) == false) {
				if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get(), itemstack) != 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get(), (int) (20 * (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get()) + 1)), 0, false, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get(), 20, 0, false, false));
				}
			}
			if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).gogglesDamage > 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt((int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).gogglesDamage, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					double _setval = 0;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gogglesDamage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("gogglesY") == 86 && (world instanceof Level _lvl15 && _lvl15.isDay()) == false) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
			if ((entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get())) == false) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get(), 200, 0, false, false));
			}
			if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).gogglesDamage > 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt((int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).gogglesDamage, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					double _setval = 0;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gogglesDamage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
