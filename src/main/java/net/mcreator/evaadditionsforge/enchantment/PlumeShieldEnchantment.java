
package net.mcreator.evaadditionsforge.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

public class PlumeShieldEnchantment extends Enchantment {
	public PlumeShieldEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEARABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(EvaAdditionsModItems.VOID_WINGS.get())).test(itemstack);
	}
}
