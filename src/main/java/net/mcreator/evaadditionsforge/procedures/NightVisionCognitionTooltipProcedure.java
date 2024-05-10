package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class NightVisionCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Does "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "not"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " turns on.")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Turns on under "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Y:" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gogglesY"))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " and "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "during the night"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " if the light level is "
						+ entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "under 7"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Turns on under "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Y:" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gogglesY"))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " and if the light level is "
						+ entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "under 7"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "These goggles "
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "work under water"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "The goggles "
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "will not work under water"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ", but they "
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "can be enchanted"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
						+ "You "
						+ (entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "can enchant"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " these goggles to make them ")
						+ (entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "work under water"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "."))));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 3) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + ""
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + ""
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + ""
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + ""
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 4) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You currently have "
						+ entity.getPersistentData().getString(("current" + "ItemRarity"))
						+ new java.text.DecimalFormat("##.##").format((itemstack.getMaxDamage() - itemstack.getDamageValue()) * (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get()) + 1)) + " seconds left"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of use on these goggles.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You currently have "
						+ entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + new java.text.DecimalFormat("##.##").format(itemstack.getMaxDamage() - itemstack.getDamageValue()) + " seconds left"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " of use on these goggles. ")));
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can enchant these goggles to extend it's durability.")));
			}
		}
	}
}
