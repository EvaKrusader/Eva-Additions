package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class UpgrGPSCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + ""
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Never"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " turns on.")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Turns on under "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Y:" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gogglesY"))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " and "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "during the night"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Turns on under "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Y:" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gogglesY"))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Turns on if the light level is "
					+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "under 7"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 3) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Turns on if the light level is "
					+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "under 7"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 4) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You currently have "
						+ entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity"))
						+ new java.text.DecimalFormat("##.##").format((itemstack.getMaxDamage() - itemstack.getDamageValue()) * (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get()) + 1)) + " seconds left"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of use on these goggles.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You currently have "
						+ entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + new java.text.DecimalFormat("##.##").format(itemstack.getMaxDamage() - itemstack.getDamageValue()) + " seconds left"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "of use on these goggles.")));
			}
		}
	}
}
