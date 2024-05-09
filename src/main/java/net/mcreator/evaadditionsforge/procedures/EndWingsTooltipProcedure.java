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
		if (itemstack.getItem() == EvaAdditionsModItems.END_WINGS.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				GetItemRarityColorProcedure.execute(entity, itemstack);
				if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
					if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
						tooltip.add(Component.literal(("Will save you from falling in the void and will give you " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "Slow Falling I"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
					} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
						tooltip.add(Component.literal(("Will save you from falling in the void and will give you " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "Slow Falling II"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
					} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
						tooltip.add(Component.literal(("Will save you from falling in the void and will give you " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "Slow Falling III"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
					} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
						tooltip.add(Component.literal((entity.getPersistentData().getString(("current" + "ItemRarity")) + "Will"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " save you from falling in the void.")));
					} else {
						tooltip.add(Component.literal(("Will " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "not"
								+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " save you from falling in the void.")));
					}
				}
				if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.SMARTASS.get()) {
					tooltip.add(Component.literal(("I HAVE KNOWLEDGE "
							+ new java.text.DecimalFormat("##.##").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower) + "")));
				}
			}
		}
	}
}
