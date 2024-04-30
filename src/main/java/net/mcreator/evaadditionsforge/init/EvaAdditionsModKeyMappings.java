
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.evaadditionsforge.network.GamemodeSwitcherMessage;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EvaAdditionsModKeyMappings {
	public static final KeyMapping GAMEMODE_SWITCHER = new KeyMapping("key.eva_additions.gamemode_switcher", GLFW.GLFW_KEY_UNKNOWN, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				EvaAdditionsMod.PACKET_HANDLER.sendToServer(new GamemodeSwitcherMessage(0, 0));
				GamemodeSwitcherMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(GAMEMODE_SWITCHER);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				GAMEMODE_SWITCHER.consumeClick();
			}
		}
	}
}
