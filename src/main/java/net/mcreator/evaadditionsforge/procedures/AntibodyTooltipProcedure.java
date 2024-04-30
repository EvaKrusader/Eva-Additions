package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class AntibodyTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == EvaAdditionsModItems.ANTIBODY.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					tooltip.add(
							Component.literal(("Has a \u00A77\u00A7n" + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%\u00A7r\u00A7f chance of curing illnesses when you get hurt.")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					tooltip.add(
							Component.literal(("Has a \u00A7a\u00A7n" + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%\u00A7r\u00A7f chance of curing illnesses when you get hurt.")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					tooltip.add(
							Component.literal(("Has a \u00A7b\u00A7n" + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%\u00A7r\u00A7f chance of curing illnesses when you get hurt.")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					tooltip.add(
							Component.literal(("Has a \u00A7d\u00A7n" + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%\u00A7r\u00A7f chance of curing illnesses when you get hurt.")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					tooltip.add(
							Component.literal(("Has a \u00A76\u00A7n" + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%\u00A7r\u00A7f chance of curing illnesses when you get hurt.")));
				}
			}
		}
	}
}
