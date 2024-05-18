package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ExportItemsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Some items may be ported over to different mods, so inform me of the ones you have, so I can give you compensation"), false);
	}
}
