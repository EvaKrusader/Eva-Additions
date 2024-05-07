package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class EquinoxWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("equinoxCycle") == 3) {
			if ((world instanceof Level _lvl2 && _lvl2.isDay()) == true) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 1);
				itemstack.getOrCreateTag().putDouble("equinoxCycle", 2);
			} else if ((world instanceof Level _lvl7 && _lvl7.isDay()) == false) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 1);
				itemstack.getOrCreateTag().putDouble("equinoxCycle", 1);
			}
			itemstack.getOrCreateTag().putDouble("equinoxCycle", 3);
		}
	}
}
