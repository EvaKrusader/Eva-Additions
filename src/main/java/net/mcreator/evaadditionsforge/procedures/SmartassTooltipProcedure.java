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
public class SmartassTooltipProcedure {
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
		if (itemstack.getItem() == EvaAdditionsModItems.SMARTASS.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					tooltip.add(Component.literal("You understand \u00A77\u00A7nnothing\u00A7r\u00A7f about those weird artifacts, you can only guess what they can do."));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					tooltip.add(Component.literal("You understand \u00A7a\u00A7nsome stuff\u00A7r\u00A7f about artifacts but you will miss some \u00A7b\u00A7nimportant parts\u00A7r\u00A7f."));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					tooltip.add(Component.literal("You understand \u00A7b\u00A7nmost things\u00A7r\u00A7f about artifacts but you will miss some \u00A7d\u00A7ndetails\u00A7r\u00A7f."));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					tooltip.add(Component.literal("You understand \u00A7d\u00A7nalmost everything\u00A7r\u00A7f but about artifacts but you can miss some \u00A76\u00A7nfiner details\u00A7r\u00A7f."));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					tooltip.add(Component.literal("You understand \u00A76\u00A7neverything perfectly\u00A7r\u00A7f, nothing is a problem to you."));
				}
			}
		}
	}
}
