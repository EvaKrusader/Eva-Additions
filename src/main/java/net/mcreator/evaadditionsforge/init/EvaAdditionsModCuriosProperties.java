package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.evaadditionsforge.procedures.NightVisionPropertyValueProviderProcedure;
import net.mcreator.evaadditionsforge.procedures.EquinoxPropertyValueProviderProcedure;
import net.mcreator.evaadditionsforge.procedures.AntibodyPropertyValueProviderProcedure;
import net.mcreator.evaadditionsforge.procedures.AltometerWaterproofReturnProcedure;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EvaAdditionsModCuriosProperties {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(EvaAdditionsModItems.METABOLISM.get(), new ResourceLocation("eva_additions:metabolism_antibody_level"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.NIGHT_VISION.get(), new ResourceLocation("eva_additions:night_vision_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.NIGHT_VISION.get(), new ResourceLocation("eva_additions:night_vision_shine"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) NightVisionPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.VOID_WINGS.get(), new ResourceLocation("eva_additions:void_wings_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.LAVA_WALKER.get(), new ResourceLocation("eva_additions:lava_walker_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.CRYSTAL_OXYGEN.get(), new ResourceLocation("eva_additions:crystal_oxygen_waterproof"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AltometerWaterproofReturnProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.CRYSTAL_DEPTH.get(), new ResourceLocation("eva_additions:crystal_depth_waterproof"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AltometerWaterproofReturnProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.CRYSTAL_EARTH.get(), new ResourceLocation("eva_additions:crystal_earth_waterproof"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AltometerWaterproofReturnProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.COGNITION.get(), new ResourceLocation("eva_additions:cognition_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.PERCEPTION.get(), new ResourceLocation("eva_additions:perception_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.REQUIEM.get(), new ResourceLocation("eva_additions:requiem_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.EQUINOX.get(), new ResourceLocation("eva_additions:equinox_baublepower"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) AntibodyPropertyValueProviderProcedure.execute(itemStackToRender));
			ItemProperties.register(EvaAdditionsModItems.EQUINOX.get(), new ResourceLocation("eva_additions:equinox_cycle"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) EquinoxPropertyValueProviderProcedure.execute(itemStackToRender));
		});
	}
}
