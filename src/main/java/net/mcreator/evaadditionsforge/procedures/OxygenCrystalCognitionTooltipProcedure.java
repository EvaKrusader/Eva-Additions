package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.List;

public class OxygenCrystalCognitionTooltipProcedure {
	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 1) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "This crystal shows your "
					+ entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "Y level"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " but "
					+ entity.getPersistentData().getString(("Tier2" + "AptitudeItemRarity")) + "only if it is " + "\u00A7a\u00A7n" + "positive"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 2) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier3" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "Water will fault the crystal's Y level detection"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 3) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ")
						+ "This waterproof crystal will detect the correct Y level no matter what"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			} else {
				tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier4" + "AptitudeItemRarity")) + "*"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "The crystal can be enchanted to be waterproof "
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower > 4) {
			tooltip.add(Component.literal(((entity.getPersistentData().getString(("Tier5" + "AptitudeItemRarity")) + "*"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " ") + "This crystal can be fused with a "
					+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + "Depth Crystal"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " to create an "
					+ entity.getPersistentData().getString(("Tier0" + "AptitudeItemRarity")) + "\u00A7n" + "Earth Crystal"
					+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
		}
	}
}
