package net.mcreator.evaadditionsforge.client.toasts;

import net.minecraft.world.level.entity.Visibility;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class PowerUpperToastToast implements Toast {
	@Override
	public Visibility render(GuiGraphics guiGraphics, ToastComponent component, long lastChanged) {
		guiGraphics.blit(TEXTURE, 0, 0, 0, 32, this.width(), this.height());
		guiGraphics.drawString(component.getMinecraft().font, Component.translatable("toasts.eva_additions.power_upper_toast.title"), 30, 7, -11534256, false);
		guiGraphics.drawString(component.getMinecraft().font, Component.translatable("toasts.eva_additions.power_upper_toast.description"), 30, 18, -16777216, false);
		RenderSystem.enableBlend();
		guiGraphics.blit(new ResourceLocation("eva_additions:textures/screens/aptitdue_background.png"), 6, 6, 296, 120, 20, 20);
		if (lastChanged <= 5000)
			return Visibility.SHOW;
		else
			return Visibility.HIDE;
	}
}
