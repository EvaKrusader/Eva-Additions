package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class VoidWingsCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Your wings will receive "
					+ entity.getPersistentData().getString(("current" + "ItemRarity")) + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("wingDamager"))
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " damage every time you fly.")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") > 2) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You will receive "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Slow Falling " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower") - 2)
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " when you land.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You will "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "not"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " receive "
						+ entity.getPersistentData().getString(("current" + "ItemRarity")) + "Slow Falling"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " when you land.")));
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.PILLAR_SCRAPER.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Your fall "
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "will"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " be slowed down when you land from an obsidian pillar.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can "
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "enchant"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " your wings to "
						+ entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "slow your fall"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " when you land from an obsidian pillar.")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 3) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.PLUME_SHIELD.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Your plume shield will give you "
						+ (entity.getPersistentData().getString(("current" + "ItemRarity")) + "Resistance " + new java.text.DecimalFormat("##.##").format(itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.PLUME_SHIELD.get()) + 2)
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " when you land."))));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
						+ "You can enchant your wings to reduce the fall damage taken from landing.")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 4) {
			if (itemstack.isDamaged()) {
				if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get(), itemstack) != 0) {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can use your gel-coated wings "
							+ (entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "\u00A7n")
							+ new java.text.DecimalFormat("##.##").format(Math.ceil((itemstack.getMaxDamage() - itemstack.getDamageValue()) / itemstack.getOrCreateTag().getDouble("wingDamager"))) + " more times"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
				} else {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can use your wings "
							+ (entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "\u00A7n")
							+ new java.text.DecimalFormat("##.##").format(Math.ceil((itemstack.getMaxDamage() - itemstack.getDamageValue()) / itemstack.getOrCreateTag().getDouble("wingDamager"))) + " more times"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
							+ "You can coat your wings with a special gel to use them for longer.")));
				}
			} else {
				if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get(), itemstack) != 0) {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can use your gel-coated wings "
							+ (entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "\u00A7n")
							+ new java.text.DecimalFormat("##.##").format(Math.ceil((itemstack.getMaxDamage() - itemstack.getDamageValue()) / itemstack.getOrCreateTag().getDouble("wingDamager"))) + " times"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
				} else {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "You can use your wings "
							+ (entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "\u00A7n")
							+ new java.text.DecimalFormat("##.##").format(Math.ceil((itemstack.getMaxDamage() - itemstack.getDamageValue()) / itemstack.getOrCreateTag().getDouble("wingDamager"))) + " times"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
							+ "You can coat your wings with a special gel to use them for longer.")));
				}
			}
		}
	}
}
