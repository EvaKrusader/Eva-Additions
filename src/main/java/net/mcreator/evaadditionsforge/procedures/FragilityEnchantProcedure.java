package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class FragilityEnchantProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.FRAGILITY.get(), itemstackiterator) != 0) {
						if (itemstackiterator.getEnchantmentLevel(EvaAdditionsModEnchantments.FRAGILITY.get()) == 1) {
							EvaAdditionsMod.queueServerWork(200, () -> {
								{
									ItemStack _ist = itemstackiterator;
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							});
						} else if (itemstackiterator.getEnchantmentLevel(EvaAdditionsModEnchantments.FRAGILITY.get()) == 2) {
							EvaAdditionsMod.queueServerWork(100, () -> {
								{
									ItemStack _ist = itemstackiterator;
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							});
						} else if (itemstackiterator.getEnchantmentLevel(EvaAdditionsModEnchantments.FRAGILITY.get()) == 3) {
							EvaAdditionsMod.queueServerWork(20, () -> {
								{
									ItemStack _ist = itemstackiterator;
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							});
						}
					}
				}
			}
		}
	}
}
