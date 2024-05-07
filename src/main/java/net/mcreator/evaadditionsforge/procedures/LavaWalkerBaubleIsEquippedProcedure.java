package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class LavaWalkerBaubleIsEquippedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String itemName = "";
		double baubleChance = 0;
		itemName = "Immune System";
		baubleChance = Math.random();
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 0) {
			if (baubleChance > 0.95) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
			} else if (baubleChance > 0.8) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
			} else if (baubleChance > 0.6) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
			} else if (baubleChance > 0.25) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
			} else if (baubleChance > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A77" + "" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7a" + "" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7b" + "" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A7d" + "" + " \u00A7r\u00A7f" + itemName)));
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			itemstack.setHoverName(Component.literal(("\u00A7r\u00A76" + "" + " \u00A7r\u00A7f" + itemName)));
		}
		AntibodyEnderlinkProcedure.execute(world, x, y, z, entity);
		if (entity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:antibody_adv"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
	}
}
