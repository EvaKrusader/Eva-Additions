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
public class HighSensesTooltipProcedure {
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
		double speedPower = 0;
		double cooldown = 0;
		double speedDuration = 0;
		double glowDistance = 0;
		double glowDuration = 0;
		double speedHealth = 0;
		if (itemstack.getItem() == EvaAdditionsModItems.PERCEPTION.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 1) {
					glowDistance = 3;
					glowDuration = 5;
					speedDuration = 1;
					speedHealth = 3;
					cooldown = 5;
				} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 2) {
					glowDistance = 5;
					glowDuration = 10;
					speedDuration = 1;
					speedHealth = 5;
					cooldown = 10;
				} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 3) {
					glowDistance = 10;
					glowDuration = 15;
					speedDuration = 1;
					speedHealth = 7;
					cooldown = 15;
				} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 4) {
					glowDistance = 15;
					glowDuration = 20;
					speedDuration = 1;
					speedHealth = 9;
					cooldown = 20;
				} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 5) {
					glowDistance = 25;
					glowDuration = 30;
					speedDuration = 1;
					speedHealth = 11;
					cooldown = 30;
				}
				speedPower = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower;
				GetItemRarityColorProcedure.execute(entity, itemstack);
				tooltip.add(Component.literal(("You can mark entities in a " + entity.getPersistentData().getString(("current" + "AptitudeItemRarity")) + new java.text.DecimalFormat("##.##").format(glowDistance) + " " + "block radius"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " and you get an "
						+ entity.getPersistentData().getString(("current" + "AptitudeItemRarity")) + "adrenaline boost"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " if your health falls under "
						+ entity.getPersistentData().getString(("current" + "AptitudeItemRarity")) + new java.text.DecimalFormat("##.##").format(speedHealth / 2) + " hearts"
						+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ".")));
			}
		}
	}
}
