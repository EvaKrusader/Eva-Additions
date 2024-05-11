package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class EarthCrystalCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		ItemStack item2 = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
		ItemStack item3 = ItemStack.EMPTY;
		ItemStack item4 = ItemStack.EMPTY;
		item1 = new ItemStack(EvaAdditionsModItems.CRYSTAL_EARTH.get());
		item2 = new ItemStack(EvaAdditionsModItems.GPS.get());
		item3 = new ItemStack(EvaAdditionsModItems.UPGRADED_GPS.get());
		item4 = new ItemStack(EvaAdditionsModItems.POWER_UPPER.get());
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "This crystal shows your "
					+ entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "Y level"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			if (!(EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0)) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Water will fault the crystal's Y level detection"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 3) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
						+ "This waterproof crystal will detect the correct Y level no matter what"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "The crystal can be enchanted to be waterproof"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 4) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + ""
						+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item1.getDisplayName().getString()).substring(1, (int) ((item1.getDisplayName().getString()).length() - 1))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " + "
						+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item2.getDisplayName().getString()).substring(1, (int) ((item2.getDisplayName().getString()).length() - 1))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
						+ (" + " + entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item4.getDisplayName().getString()).substring(1, (int) ((item4.getDisplayName().getString()).length() - 1)))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " = "
						+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item3.getDisplayName().getString()).substring(1, (int) ((item3.getDisplayName().getString()).length() - 1))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "This "
						+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item1.getDisplayName().getString()).substring(1, (int) ((item1.getDisplayName().getString()).length() - 1))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " can be fused with a "
						+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item2.getDisplayName().getString()).substring(1, (int) ((item2.getDisplayName().getString()).length() - 1))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
						+ (" and a " + entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item4.getDisplayName().getString()).substring(1, (int) ((item4.getDisplayName().getString()).length() - 1))
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset)
						+ " to create an " + entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + (item3.getDisplayName().getString()).substring(1, (int) ((item3.getDisplayName().getString()).length() - 1))
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
	}
}
