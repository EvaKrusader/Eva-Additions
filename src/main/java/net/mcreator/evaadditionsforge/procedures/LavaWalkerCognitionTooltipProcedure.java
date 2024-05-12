package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class LavaWalkerCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You will freeze lava into "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "stone"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " with this necklace.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You will freeze lava into "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "obsidian"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " with this necklace.")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Piglins "
					+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "will not"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " attack you when you are wearing this necklace.")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 3) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.FIRE_WALKER.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You "
						+ entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "will"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " protect the path you create.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can enchant this necklace to "
						+ entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "protect"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " the path you create.")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 4) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can freeze lava "
						+ entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity"))
						+ new java.text.DecimalFormat("##.##").format((itemstack.getMaxDamage() - itemstack.getDamageValue()) * (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.INCORRODIBLE.get()) + 1)) + " more times"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " with this necklace")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can freeze lava "
						+ entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + new java.text.DecimalFormat("##.##").format(itemstack.getMaxDamage() - itemstack.getDamageValue()) + " more times"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " with this necklace")));
			}
		}
	}
}
