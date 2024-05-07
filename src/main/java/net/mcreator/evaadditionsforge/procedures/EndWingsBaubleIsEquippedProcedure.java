package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

public class EndWingsBaubleIsEquippedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double baubleChance = 0;
		String itemName = "";
		String itemRarity = "";
		String itemReset = "";
		String nameItem = "";
		itemReset = "\u00A7r\u00A7f";
		if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
			itemName = "Void Wings";
		} else if (Minecraft.getInstance().options.languageCode.equals("pt_br")) {
			itemName = "Asas do Vazio";
		} else if (Minecraft.getInstance().options.languageCode.equals("fr_fr")) {
			itemName = "Ailes du vide";
		}
		baubleChance = Math.random();
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 0) {
			if (baubleChance > 0.8) {
				itemstack.getOrCreateTag().putDouble("baublePower", 5);
				itemRarity = "\u00A76";
			} else if (baubleChance > 0.6) {
				itemstack.getOrCreateTag().putDouble("baublePower", 4);
				itemRarity = "\u00A7d";
			} else if (baubleChance > 0.4) {
				itemstack.getOrCreateTag().putDouble("baublePower", 3);
				itemRarity = "\u00A7b";
			} else if (baubleChance > 0.2) {
				itemstack.getOrCreateTag().putDouble("baublePower", 2);
				itemRarity = "\u00A7a";
			} else if (baubleChance > 0) {
				itemstack.getOrCreateTag().putDouble("baublePower", 1);
				itemRarity = "\u00A77";
			}
		}
		if (Minecraft.getInstance().options.languageCode.equals("en_us")) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A77Frail\u00A7r\u00A7f " + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7aWeak\u00A7r\u00A7f " + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7bAverage\u00A7r\u00A7f " + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7dStrong\u00A7r\u00A7f " + itemName)));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A76Remarkable\u00A7r\u00A7f " + itemName)));
			}
		} else if (Minecraft.getInstance().options.languageCode.equals("fr_fr")) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A77Fr\u00EAles")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A7aFaibles")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A7bMoyennes")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A7dSolides")));
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				itemstack.setHoverName(Component.literal(("\u00A7r\u00A7f " + itemName + " \u00A7r\u00A76Remarquables")));
			}
		}
		EndWingsEnderlinkProcedure.execute(world, x, y, z, entity);
	}
}
