package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class EndWingsTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		String itemRarity = "";
		String itemReset = "";
		itemReset = "\u00A7r\u00A7f";
		if (itemstack.getItem() == EvaAdditionsModItems.END_WINGS.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					itemRarity = "\u00A77\u00A7n";
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					itemRarity = "\u00A7a\u00A7n";
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					itemRarity = "\u00A7b\u00A7n";
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					itemRarity = "\u00A7d\u00A7n";
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					itemRarity = "\u00A76\u00A7n";
				}
				if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
					if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
						tooltip.add(Component.literal(("Will save you from falling in the void and will give you " + itemRarity + "Slow Falling I" + itemReset + ".")));
					} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
						tooltip.add(Component.literal(("Will save you from falling in the void and will give you " + itemRarity + "Slow Falling II" + itemReset + ".")));
					} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
						tooltip.add(Component.literal(("Will save you from falling in the void and will give you " + itemRarity + "Slow Falling III" + itemReset + ".")));
					} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
						tooltip.add(Component.literal((itemRarity + "Will" + itemReset + " save you from falling in the void.")));
					} else {
						tooltip.add(Component.literal(("Will " + itemRarity + "not" + itemReset + " save you from falling in the void.")));
					}
				} else if (Minecraft.getInstance().options.languageCode.equals("pt_br")) {
					tooltip.add(Component.literal(
							("H\u00E1 uma chande de " + itemRarity + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%" + itemReset + " de curar uma doen\u00E7a quando leva dano.")));
				} else if (Minecraft.getInstance().options.languageCode.equals("fr_fr")) {
					tooltip.add(Component.literal(
							("A une chance de" + itemRarity + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%" + itemReset + " de soigner vos maladies quand vous vous blessez")));
				}
				if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.SMARTASS.get()) {
					tooltip.add(Component.literal(("I HAVE KNOWLEDGE "
							+ new java.text.DecimalFormat("##.##").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower) + "")));
				}
			}
		}
	}
}
