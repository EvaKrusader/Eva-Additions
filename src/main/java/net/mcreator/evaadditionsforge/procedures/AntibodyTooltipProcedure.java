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
public class AntibodyTooltipProcedure {
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
		if (itemstack.getItem() == EvaAdditionsModItems.ANTIBODY.get()) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") != 0) {
				GetItemRarityColorProcedure.execute(entity, itemstack);
				if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
					tooltip.add(Component.literal(("Has a " + entity.getPersistentData().getString(("current" + "ItemRarity")) + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25) + "%"
							+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " chance of curing illnesses when you get hurt.")));
				} else if (Minecraft.getInstance().options.languageCode.equals("pt_br")) {
					tooltip.add(
							Component.literal(("H\u00E1 uma chande de " + entity.getPersistentData().getString(("current" + "ItemRarity")) + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25)
									+ "%" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " de curar uma doen\u00E7a quando leva dano.")));
				} else if (Minecraft.getInstance().options.languageCode.equals("fr_fr")) {
					tooltip.add(Component.literal(("A une chance de" + entity.getPersistentData().getString(("current" + "ItemRarity")) + new java.text.DecimalFormat("##.##").format((itemstack.getOrCreateTag().getDouble("baublePower") - 1) * 25)
							+ "%" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " de soigner vos maladies quand vous vous blessez")));
				}
				if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.SMARTASS.get()) {
					tooltip.add(Component.literal(("I HAVE KNOWLEDGE "
							+ new java.text.DecimalFormat("##.##").format((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower) + "")));
				}
			}
		}
	}
}
