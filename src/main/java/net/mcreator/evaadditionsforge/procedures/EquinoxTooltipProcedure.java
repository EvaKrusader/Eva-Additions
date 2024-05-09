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
public class EquinoxTooltipProcedure {
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
		if (itemstack.getItem() == EvaAdditionsModItems.EQUINOX.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 1) {
						tooltip.add(Component.literal(("Day " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					} else if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 2) {
						tooltip.add(Component.literal(("Night " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					}
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 1) {
						tooltip.add(Component.literal(("Day " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					} else if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 2) {
						tooltip.add(Component.literal(("Night " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					}
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 1) {
						tooltip.add(Component.literal(("Day " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					} else if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 2) {
						tooltip.add(Component.literal(("Night " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					}
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 1) {
						tooltip.add(Component.literal(("Day " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					} else if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 2) {
						tooltip.add(Component.literal(("Night " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					}
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 1) {
						tooltip.add(Component.literal(("Day " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					} else if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 2) {
						tooltip.add(Component.literal(("Night " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
					}
				}
			}
			tooltip.add(Component.literal(("baublePower = " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("baublePower")))));
			tooltip.add(Component.literal(("equinoxCycle = " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("equinoxCycle")))));
			tooltip.add(Component.literal(("equinoxTime = " + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("equinoxTime")))));
			tooltip.add(Component.literal(("equinoxCycle Logic = " + itemstack.getOrCreateTag().getBoolean("equinoxCycle"))));
		}
	}
}
