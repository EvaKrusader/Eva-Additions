package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

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
			double _setval = itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.MEDS.get()) - 1;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AntibodyMedsLVL = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.MEDS.get(), itemstack) != 0;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.hasMeds = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).doDamageAntibody == true) {
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
