package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class GetItemRarityColorProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String itemRarity = "";
		if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
			entity.getPersistentData().putString(("previous" + "ItemRarity"), "\u00A77\u00A7n");
			entity.getPersistentData().putString(("current" + "ItemRarity"), "\u00A77\u00A7n");
			entity.getPersistentData().putString(("next" + "ItemRarity"), "\u00A7a\u00A7n");
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
			entity.getPersistentData().putString(("previous" + "ItemRarity"), "\u00A77\u00A7n");
			entity.getPersistentData().putString(("current" + "ItemRarity"), "\u00A7a\u00A7n");
			entity.getPersistentData().putString(("next" + "ItemRarity"), "\u00A7b\u00A7n");
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
			entity.getPersistentData().putString(("previous" + "ItemRarity"), "\u00A7a\u00A7n");
			entity.getPersistentData().putString(("current" + "ItemRarity"), "\u00A7b\u00A7n");
			entity.getPersistentData().putString(("next" + "ItemRarity"), "\u00A7d\u00A7n");
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
			entity.getPersistentData().putString(("previous" + "ItemRarity"), "\u00A7b\u00A7n");
			entity.getPersistentData().putString(("current" + "ItemRarity"), "\u00A7d\u00A7n");
			entity.getPersistentData().putString(("next" + "ItemRarity"), "\u00A76\u00A7n");
		} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
			entity.getPersistentData().putString(("previous" + "ItemRarity"), "\u00A7d\u00A7n");
			entity.getPersistentData().putString(("current" + "ItemRarity"), "\u00A76\u00A7n");
			entity.getPersistentData().putString(("next" + "ItemRarity"), "\u00A7c\u00A7n");
		}
	}
}
