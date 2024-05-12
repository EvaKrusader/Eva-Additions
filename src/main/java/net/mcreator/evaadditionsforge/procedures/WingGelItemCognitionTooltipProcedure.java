package net.mcreator.evaadditionsforge.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class WingGelItemCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		String enchantNum = "";
		if (itemstack.getOrCreateTag().getDouble("gelPower") == 1) {
			enchantNum = "I";
		} else if (itemstack.getOrCreateTag().getDouble("gelPower") == 2) {
			enchantNum = "II";
		} else if (itemstack.getOrCreateTag().getDouble("gelPower") == 3) {
			enchantNum = "III";
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EvaAdditionsModItems.VOID_WINGS.get(), lv).isPresent() : false) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "A gel you can put on your wings.")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "A gel you can put on your wings, if you have any.")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EvaAdditionsModItems.VOID_WINGS.get(), lv).isPresent() : false) {
				if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).wingersss).getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get()) == itemstack
						.getOrCreateTag().getDouble("gelPower")) {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
							+ "This gel will do "
							+ (entity.getPersistentData().getString(("Tier" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gelPower") + 2) + "AptitudeItemRarity")) + "\u00A7n" + "nothing"
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
									+ " because your wings are already coated with an equivalent gel."))));
				} else if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).wingersss)
						.getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get()) > itemstack.getOrCreateTag().getDouble("gelPower")) {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
							+ "This gel will do "
							+ (entity.getPersistentData().getString(("Tier" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gelPower") + 2) + "AptitudeItemRarity")) + "\u00A7n" + "nothing"
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
									+ " because your wings are already coated with a stronger gel"))));
				} else {
					tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "This gel will enchant your wings with "
							+ (entity.getPersistentData().getString(("Tier" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gelPower") + 2) + "AptitudeItemRarity")) + "\u00A7n" + "Coating " + enchantNum
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "."))));
				}
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "This gel would enchant your wings with "
						+ (entity.getPersistentData().getString(("Tier" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("gelPower") + 2) + "AptitudeItemRarity")) + "\u00A7n" + "Coating " + enchantNum
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ", if you had any."))));
			}
		}
	}
}
