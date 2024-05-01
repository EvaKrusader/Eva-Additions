package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.evaadditionsforge.procedures.AntibodyPropertyValueProviderProcedure;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EvaAdditionsModCuriosProperties {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(EvaAdditionsModItems.ANTIBODY.get(), new ResourceLocation("eva_additions:antibody_antibody_level"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.NIGHT_VISION.get(), new ResourceLocation("eva_additions:night_vision_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.SMARTASS.get(), new ResourceLocation("eva_additions:smartass_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.HIGHER_SENSES.get(), new ResourceLocation("eva_additions:higher_senses_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
		});
	}
}
