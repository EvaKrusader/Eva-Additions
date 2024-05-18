package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class AntibodyWhileBaubleIsEquippedTickProcedure {
	public static double execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		{
			double _setval = itemstack.getOrCreateTag().getDouble("baublePower") - 1;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AntibodyLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.SELF_REGULATION.get()) - 1;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AntibodyMedsLVL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.SELF_REGULATION.get(), itemstack) != 0;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.hasMeds = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).doDamageAntibody == true) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:antibody_adv"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.SELF_REGULATION.get(), itemstack) != 0) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:antibody_meds_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			{
				boolean _setval = false;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.doDamageAntibody = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		return itemstack.getOrCreateTag().getDouble("baublePower");
	}
}
