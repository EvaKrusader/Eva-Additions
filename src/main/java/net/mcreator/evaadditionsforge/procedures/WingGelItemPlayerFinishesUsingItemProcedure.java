package net.mcreator.evaadditionsforge.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import java.util.Map;

public class WingGelItemPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv) {
			CuriosApi.getCuriosHelper().findCurios(lv, EvaAdditionsModItems.VOID_WINGS.get()).forEach(item -> {
				ItemStack itemstackiterator = item.stack();
				if (itemstack.getOrCreateTag().getDouble("gelPower") > itemstackiterator.getEnchantmentLevel(EvaAdditionsModEnchantments.WING_GEL.get())) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstackiterator);
						if (_enchantments.containsKey(EvaAdditionsModEnchantments.WING_GEL.get())) {
							_enchantments.remove(EvaAdditionsModEnchantments.WING_GEL.get());
							EnchantmentHelper.setEnchantments(_enchantments, itemstackiterator);
						}
					}
					itemstackiterator.enchant(EvaAdditionsModEnchantments.WING_GEL.get(), (int) itemstack.getOrCreateTag().getDouble("gelPower"));
				}
			});
		}
	}
}
