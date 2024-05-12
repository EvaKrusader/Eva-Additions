package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class EndWingsBaubleIsEquippedProcedure {
	public static void execute(ItemStack itemstack) {
		double baubleChance = 0;
		String itemName = "";
		String itemRarity = "";
		String nameItem = "";
		itemName = "Void Wings";
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
		if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get(), itemstack) != 0) {
			if (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get()) == 1) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 2);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 3);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 4);
				}
				itemstack.setHoverName(Component.literal(((itemstack.getDisplayName().getString()).substring(1, (int) ((itemstack.getDisplayName().getString()).length() - 1)) + " " + "\u00A7b\u00A7n(Loob Coating)")));
			} else if (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get()) == 2) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 2);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 3);
				}
				itemstack.setHoverName(Component.literal(((itemstack.getDisplayName().getString()).substring(1, (int) ((itemstack.getDisplayName().getString()).length() - 1)) + " " + "\u00A7d\u00A7n(Waks Coating)")));
			} else if (itemstack.getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get()) == 3) {
				if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 1);
				} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
					itemstack.getOrCreateTag().putDouble("wingDamager", 2);
				}
				itemstack.setHoverName(Component.literal(((itemstack.getDisplayName().getString()).substring(1, (int) ((itemstack.getDisplayName().getString()).length() - 1)) + " " + "\u00A76\u00A7n(Viveldop Coating)")));
			}
		} else {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				itemstack.getOrCreateTag().putDouble("wingDamager", 1);
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 4) {
				itemstack.getOrCreateTag().putDouble("wingDamager", 2);
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 3) {
				itemstack.getOrCreateTag().putDouble("wingDamager", 3);
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 2) {
				itemstack.getOrCreateTag().putDouble("wingDamager", 4);
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				itemstack.getOrCreateTag().putDouble("wingDamager", 5);
			}
		}
		EndWingsEnderlinkProcedure.execute();
	}
}
