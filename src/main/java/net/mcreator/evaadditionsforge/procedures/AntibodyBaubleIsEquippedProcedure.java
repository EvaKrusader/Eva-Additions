package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

public class AntibodyBaubleIsEquippedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean hasTried = false;
		boolean triedWither = false;
		boolean FixNext = false;
		String itemName = "";
		double baubleChance = 0;
		if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
			itemName = "Immune System";
		} else if (Minecraft.getInstance().options.languageCode.equals("pt_br")) {
			itemName = "\u00A7r\u00A7fSistema Imunol\u00F3gico ";
		} else if (Minecraft.getInstance().options.languageCode.equals("fr_fr")) {
			itemName = "Syst\u00E8me Immunitaire";
		}
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
		if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A77Dead \u00A7r\u00A7f" + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7aDeficient \u00A7r\u00A7f" + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7bGood \u00A7r\u00A7f" + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7dGreat \u00A7r\u00A7f" + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A76Perfect \u00A7r\u00A7f" + itemName)));
			}
		} else if (Minecraft.getInstance().options.languageCode.equals("pt_br")) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				itemstack.setHoverName(Component.literal((itemName + "\u00A7r\u00A77Morto")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
				itemstack.setHoverName(Component.literal((itemName + "\u00A7r\u00A7aDeficiente")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
				itemstack.setHoverName(Component.literal((itemName + "\u00A7r\u00A7bBom")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
				itemstack.setHoverName(Component.literal((itemName + "\u00A7r\u00A7d\u00D3timo")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				itemstack.setHoverName(Component.literal((itemName + "\u00A7r\u00A76Perfeito")));
			}
		} else if (Minecraft.getInstance().options.languageCode.equals("fr_fr")) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A77Mort")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A7aD\u00E9ficient")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7bBon\u00A7r\u00A7f " + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7dSuper\u00A7r\u00A7f " + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A76Parfait")));
			}
		}
		AntibodyEnderlinkProcedure.execute(world, x, y, z, entity);
	}
}
