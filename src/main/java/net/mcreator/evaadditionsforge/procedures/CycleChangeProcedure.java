package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CycleChangeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean cycle = false;
		if (cycle == false) {
			if (world instanceof Level _lvl0 && _lvl0.isDay()) {
				new ItemStack(EvaAdditionsModItems.ENTER_CLAUSTROPHOBIA.get()).getOrCreateTag().putDouble("equinoxCycle", 1);
				new ItemStack(EvaAdditionsModItems.ENTER_CLAUSTROPHOBIA.get()).getOrCreateTag().putBoolean("equinoxCycle", true);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(EvaAdditionsModItems.ENTER_CLAUSTROPHOBIA.get(), 1);
				cycle = true;
			} else {
				new ItemStack(EvaAdditionsModItems.ENTER_CLAUSTROPHOBIA.get()).getOrCreateTag().putDouble("equinoxCycle", 2);
				new ItemStack(EvaAdditionsModItems.ENTER_CLAUSTROPHOBIA.get()).getOrCreateTag().putBoolean("equinoxCycle", false);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(EvaAdditionsModItems.ENTER_CLAUSTROPHOBIA.get(), 1);
				cycle = true;
			}
		}
		cycle = false;
	}
}
