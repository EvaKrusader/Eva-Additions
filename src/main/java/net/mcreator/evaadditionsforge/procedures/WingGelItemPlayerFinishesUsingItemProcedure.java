package net.mcreator.evaadditionsforge.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

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
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:wing_gel_adv"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			});
		}
	}
}
