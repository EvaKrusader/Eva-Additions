package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

public class GPSWhileEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isInWaterOrBubble()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.WATER_PROOF.get(), itemstack) != 0) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((("X : " + new java.text.DecimalFormat("##.##").format(Math.round(entity.getX()))) + " " + ("Z : " + new java.text.DecimalFormat("##.##").format(Math.round(entity.getZ()))))), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((("X : " + new java.text.DecimalFormat("##.##").format(Math.round(entity.getX()) + Mth.nextInt(RandomSource.create(), -3, 3))) + " "
							+ ("Z : " + new java.text.DecimalFormat("##.##").format(Math.round(entity.getZ()) + Mth.nextInt(RandomSource.create(), -3, 3))))), true);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((("X : " + new java.text.DecimalFormat("##.##").format(Math.round(entity.getX()))) + " " + ("Z : " + new java.text.DecimalFormat("##.##").format(Math.round(entity.getZ()))))), true);
		}
	}
}
