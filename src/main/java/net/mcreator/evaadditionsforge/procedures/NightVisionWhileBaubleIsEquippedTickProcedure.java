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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModMobEffects;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class NightVisionWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double sendDamage = 0;
		if (entity.getY() <= itemstack.getOrCreateTag().getDouble("gogglesY")) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7) {
				if (entity.isInWaterRainOrBubble()) {
					if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
						if ((entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get())) == false) {
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
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:night_vision_adv"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:night_vision_water_adv"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
					if ((entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get())) == false) {
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
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:night_vision_adv"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("gogglesY") == 86 && (world instanceof Level _lvl32 && _lvl32.isDay()) == false) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) <= 7) {
				if (entity.isInWaterRainOrBubble()) {
					if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
						if ((entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get())) == false) {
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
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:night_vision_adv"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:night_vision_water_adv"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
					if ((entity instanceof LivingEntity _livEnt50 && _livEnt50.hasEffect(EvaAdditionsModMobEffects.GOGGLES_DAMAGE.get())) == false) {
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
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:night_vision_adv"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
	}
}
