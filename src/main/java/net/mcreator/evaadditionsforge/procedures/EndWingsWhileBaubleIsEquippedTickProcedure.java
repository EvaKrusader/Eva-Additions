package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class EndWingsWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState lastWalked = Blocks.AIR.defaultBlockState();
		if ((entity.level().dimension()) == Level.END) {
			if (entity.getY() <= 0) {
				EndWingsUppiesProcedure.execute(entity);
				if ((EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get(), itemstack) != 0) == true) {
					{
						double _setval = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).extraWingDamage + 1;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.extraWingDamage = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).extraWingDamage == itemstack
							.getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get())) {
						{
							double _setval = 0;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.extraWingDamage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt((int) itemstack.getOrCreateTag().getDouble("wingDamager"), RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				} else {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt((int) itemstack.getOrCreateTag().getDouble("wingDamager"), RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
			if (entity.getY() >= 70) {
				if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).VoidWingsSlow == true) {
					if (itemstack.getOrCreateTag().getDouble("baublePower") > 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (itemstack.getOrCreateTag().getDouble("baublePower") - 3), false, false));
					}
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
			if ((EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.PILLAR_SCRAPER.get(), itemstack) != 0) == true) {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.OBSIDIAN) {
					{
						BlockState _setval = Blocks.OBSIDIAN.defaultBlockState();
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lastWalked5seconds = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					EvaAdditionsMod.queueServerWork(300, () -> {
						{
							BlockState _setval = Blocks.AIR.defaultBlockState();
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lastWalked5seconds = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
				if (entity.getY() < 80) {
					if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).lastWalked5seconds).getBlock() == Blocks.OBSIDIAN) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 2, false, false));
						{
							BlockState _setval = Blocks.AIR.defaultBlockState();
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lastWalked5seconds = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		{
			ItemStack _setval = itemstack;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.wingersss = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
