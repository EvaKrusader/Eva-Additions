
package net.mcreator.evaadditionsforge.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class BlessingEnchantment extends Enchantment {
	public BlessingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, slots);
	}
}
