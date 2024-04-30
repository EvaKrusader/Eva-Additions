
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.evaadditionsforge.client.model.ModelNightVision;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EvaAdditionsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelNightVision.LAYER_LOCATION, ModelNightVision::createBodyLayer);
	}
}
