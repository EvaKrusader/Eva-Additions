package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

public class SmartassBaubleIsEquippedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
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
		itemName = "Knowledge";
		itemstack.getOrCreateTag().putDouble("baublePower", ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
		if (itemstack.getOrCreateTag().getDouble("baublePower") != 0 && (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).justPowered == false
				&& (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).HasAptitudeUpped == 0) {
			if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.98) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.9) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.76) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0.31) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
			} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).knowledgeLVL > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
			}
			{
				double _setval = itemstack.getOrCreateTag().getDouble("baublePower");
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") != 0 && (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).justPowered == true) {
			{
				double _setval = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).HasAptitudeUpped + 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HasAptitudeUpped = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			itemstack.getOrCreateTag().putDouble("baublePower", ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower));
			{
				double _setval = itemstack.getOrCreateTag().getDouble("baublePower");
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = false;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.justPowered = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A77" + "Nonexistant" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7a" + "Common" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7b" + "Higher" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7d" + "Advanced" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A76" + "Esoteric" + " \u00A7r\u00A7f" + itemName)));
		}
		SmartassEnderlinkProcedure.execute();
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:smartass_adv"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
	}
}
