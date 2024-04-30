package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetEnderlinkProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).EnderlinkAssistant).equals("null")) {
			{
				String _setval = "<Enderlink Assistant #" + new java.text.DecimalFormat("####").format(Mth.nextInt(RandomSource.create(), Mth.nextInt(RandomSource.create(), 1, 1000), Mth.nextInt(RandomSource.create(), 1000, 9999))) + "> ";
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnderlinkAssistant = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
