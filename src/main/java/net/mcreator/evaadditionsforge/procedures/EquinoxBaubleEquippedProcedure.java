package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class EquinoxBaubleEquippedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String itemName = "";
		double baubleChance = 0;
		{
			ItemStack _setval = itemstack;
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.aptitudeItem = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		itemName = "Equinox";
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 0) {
			itemstack.getOrCreateTag().putDouble("baublePower", ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
			if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.97) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.85) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.53) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.13) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A77" + "Deaf" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7a" + "Inattentive" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7b" + "Attentive" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7d" + "Keen" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A76" + "Psychic" + " \u00A7r\u00A7f" + itemName)));
		}
		if ((world instanceof Level _lvl35 && _lvl35.isDay()) == true) {
			itemstack.getOrCreateTag().putDouble("equinoxCycle", 1);
		} else {
			itemstack.getOrCreateTag().putDouble("equinoxCycle", 2);
		}
		EquinoxEnderlinkProcedure.execute(world, x, y, z, entity);
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:equinox_adv"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
	}
}
