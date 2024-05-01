
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.evaadditionsforge.EvaAdditionsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EvaAdditionsModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EvaAdditionsMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(EvaAdditionsModBlocks.QUARTZ_TILES.get().asItem());
			tabData.accept(EvaAdditionsModBlocks.QUARTZ_TILES_2.get().asItem());
			tabData.accept(EvaAdditionsModBlocks.QUARTZ_TILES_3.get().asItem());
			tabData.accept(EvaAdditionsModBlocks.LAPIS_TILES_5.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(EvaAdditionsModBlocks.MINING_AID.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(EvaAdditionsModItems.ENTOMOLOGIST_EPIPHANY.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(EvaAdditionsModItems.DISC_WEEVIL.get());
			tabData.accept(EvaAdditionsModItems.DISC_BUTTERFLY.get());
			tabData.accept(EvaAdditionsModItems.DISC_TREEHOPPER.get());
			tabData.accept(EvaAdditionsModItems.DISC_MOTH.get());
			tabData.accept(EvaAdditionsModItems.DISC_ISOPOD.get());
			tabData.accept(EvaAdditionsModItems.DISC_BUMBLEBEE.get());
			tabData.accept(EvaAdditionsModItems.DISC_SCARAB.get());
			tabData.accept(EvaAdditionsModItems.DISC_SPINYSPIDER.get());
			tabData.accept(EvaAdditionsModItems.DISC_TORTOISEBEETLE.get());
			tabData.accept(EvaAdditionsModItems.DISC_POMNI.get());
			tabData.accept(EvaAdditionsModItems.DISC_ROUNDABOUT.get());
			tabData.accept(EvaAdditionsModItems.DISC_LIBET.get());
			tabData.accept(EvaAdditionsModItems.DISC_BURNINGMEMORY.get());
			tabData.accept(EvaAdditionsModItems.DISC_BUDDYHOLLY.get());
			tabData.accept(EvaAdditionsModItems.CRYOSTASIS.get());
			tabData.accept(EvaAdditionsModItems.ANTIBODY.get());
			tabData.accept(EvaAdditionsModItems.NIGHT_VISION.get());
			tabData.accept(EvaAdditionsModItems.END_WINGS.get());
			tabData.accept(EvaAdditionsModItems.SMARTASS.get());
			tabData.accept(EvaAdditionsModItems.POWER_UPPER.get());
			tabData.accept(EvaAdditionsModItems.APTITUDE_CHANGER.get());
		}
	}
}
