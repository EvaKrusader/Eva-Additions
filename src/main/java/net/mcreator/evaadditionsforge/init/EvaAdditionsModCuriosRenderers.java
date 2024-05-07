package net.mcreator.evaadditionsforge.init;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

import net.mcreator.evaadditionsforge.client.renderer.NightVisionRenderer;
import net.mcreator.evaadditionsforge.client.renderer.LavaWalkerRenderer;
import net.mcreator.evaadditionsforge.client.model.ModelNightVision;
import net.mcreator.evaadditionsforge.client.model.ModelLavaWalker;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EvaAdditionsModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(EvaAdditionsModLayerDefinitions.NIGHT_VISION, ModelNightVision::createBodyLayer);
		evt.registerLayerDefinition(EvaAdditionsModLayerDefinitions.LAVA_WALKER, ModelLavaWalker::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(EvaAdditionsModItems.NIGHT_VISION.get(), NightVisionRenderer::new);
		CuriosRendererRegistry.register(EvaAdditionsModItems.LAVA_WALKER.get(), LavaWalkerRenderer::new);
	}
}
