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

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class SmartassTooltipProcedure {
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
		if (itemstack.getItem() == EvaAdditionsModItems.COGNITION.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				GetItemRarityColorProcedure.execute(entity, itemstack);
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					tooltip.add(Component.literal(("You understand " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "nothing"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset
							+ " about those weird artifacts, you can only guess what they can do.")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					tooltip.add(Component.literal(("You understand " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "some things"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " about artifacts but you will miss "
							+ entity.getPersistentData().getString(("next" + "ItemRarity")) + "important details"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					tooltip.add(Component.literal(("You understand " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "most things"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " about artifacts but you will miss "
							+ entity.getPersistentData().getString(("next" + "ItemRarity")) + "some details"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					tooltip.add(Component.literal(("You understand " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "almost everything"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " about artifacts but you can miss "
							+ entity.getPersistentData().getString(("next" + "ItemRarity")) + "some finer details"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					tooltip.add(Component.literal(("You understand " + entity.getPersistentData().getString(("current" + "ItemRarity")) + "everything perfectly"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ", nothing is a problem to you.")));
				}
			}
		}
	}
}
