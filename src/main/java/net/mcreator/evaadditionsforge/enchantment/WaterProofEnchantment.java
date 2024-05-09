
package net.mcreator.evaadditionsforge.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

public class WaterProofEnchantment extends Enchantment {
	public WaterProofEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEARABLE, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack itemstack) {
		return Ingredient.of(new ItemStack(EvaAdditionsModItems.NIGHT_VISION.get()), new ItemStack(EvaAdditionsModItems.CRYSTAL_OXYGEN.get()), new ItemStack(EvaAdditionsModItems.GPS.get()), new ItemStack(EvaAdditionsModItems.UPGRADED_GPS.get()),
				new ItemStack(EvaAdditionsModItems.CRYSTAL_DEPTH.get()), new ItemStack(EvaAdditionsModItems.CRYSTAL_EARTH.get())).test(itemstack);
	}
}
