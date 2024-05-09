
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.evaadditionsforge.procedures.EnterClaustrophobiaPropertyValueProviderProcedure;
import net.mcreator.evaadditionsforge.item.WeatherCrystalItem;
import net.mcreator.evaadditionsforge.item.UpgradedGPSItem;
import net.mcreator.evaadditionsforge.item.UpgradedAltomerItem;
import net.mcreator.evaadditionsforge.item.SmartassItem;
import net.mcreator.evaadditionsforge.item.RequiemItem;
import net.mcreator.evaadditionsforge.item.PowerUpperItem;
import net.mcreator.evaadditionsforge.item.NightVisionItem;
import net.mcreator.evaadditionsforge.item.MoodCrystalItem;
import net.mcreator.evaadditionsforge.item.LavaWalkerItem;
import net.mcreator.evaadditionsforge.item.HigherSensesItem;
import net.mcreator.evaadditionsforge.item.GiveNewAptitudeItem;
import net.mcreator.evaadditionsforge.item.GPSItem;
import net.mcreator.evaadditionsforge.item.EquinoxItem;
import net.mcreator.evaadditionsforge.item.EntomologistEpiphanyItem;
import net.mcreator.evaadditionsforge.item.EnterClaustrophobiaItem;
import net.mcreator.evaadditionsforge.item.EndWingsItem;
import net.mcreator.evaadditionsforge.item.DiscographyItemItem;
import net.mcreator.evaadditionsforge.item.DiscWeevilItem;
import net.mcreator.evaadditionsforge.item.DiscTreehopperItem;
import net.mcreator.evaadditionsforge.item.DiscTortoisebeetleItem;
import net.mcreator.evaadditionsforge.item.DiscSpinyspiderItem;
import net.mcreator.evaadditionsforge.item.DiscScarabItem;
import net.mcreator.evaadditionsforge.item.DiscRoundaboutItem;
import net.mcreator.evaadditionsforge.item.DiscPomniItem;
import net.mcreator.evaadditionsforge.item.DiscMothItem;
import net.mcreator.evaadditionsforge.item.DiscLibetItem;
import net.mcreator.evaadditionsforge.item.DiscIsopodItem;
import net.mcreator.evaadditionsforge.item.DiscButterflyItem;
import net.mcreator.evaadditionsforge.item.DiscBurningmemoryItem;
import net.mcreator.evaadditionsforge.item.DiscBumblebeeItem;
import net.mcreator.evaadditionsforge.item.DiscBuddyhollyItem;
import net.mcreator.evaadditionsforge.item.DevSmartassItemItem;
import net.mcreator.evaadditionsforge.item.DevNightVisionItemItem;
import net.mcreator.evaadditionsforge.item.DevLiveleakItem;
import net.mcreator.evaadditionsforge.item.DevCurioItemItem;
import net.mcreator.evaadditionsforge.item.DevAptitudeItemItem;
import net.mcreator.evaadditionsforge.item.DevAntibodyItemItem;
import net.mcreator.evaadditionsforge.item.DepthCrystalItem;
import net.mcreator.evaadditionsforge.item.CryostasisItem;
import net.mcreator.evaadditionsforge.item.AptitudeChangerItem;
import net.mcreator.evaadditionsforge.item.AntibodyItem;
import net.mcreator.evaadditionsforge.item.AltometerItem;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EvaAdditionsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EvaAdditionsMod.MODID);
	public static final RegistryObject<Item> DISC_WEEVIL = REGISTRY.register("disc_weevil", () -> new DiscWeevilItem());
	public static final RegistryObject<Item> DISC_BUTTERFLY = REGISTRY.register("disc_butterfly", () -> new DiscButterflyItem());
	public static final RegistryObject<Item> DISC_TREEHOPPER = REGISTRY.register("disc_treehopper", () -> new DiscTreehopperItem());
	public static final RegistryObject<Item> DISC_MOTH = REGISTRY.register("disc_moth", () -> new DiscMothItem());
	public static final RegistryObject<Item> DISC_ISOPOD = REGISTRY.register("disc_isopod", () -> new DiscIsopodItem());
	public static final RegistryObject<Item> DISC_BUMBLEBEE = REGISTRY.register("disc_bumblebee", () -> new DiscBumblebeeItem());
	public static final RegistryObject<Item> DISC_SCARAB = REGISTRY.register("disc_scarab", () -> new DiscScarabItem());
	public static final RegistryObject<Item> DISC_SPINYSPIDER = REGISTRY.register("disc_spinyspider", () -> new DiscSpinyspiderItem());
	public static final RegistryObject<Item> DISC_TORTOISEBEETLE = REGISTRY.register("disc_tortoisebeetle", () -> new DiscTortoisebeetleItem());
	public static final RegistryObject<Item> DISC_POMNI = REGISTRY.register("disc_pomni", () -> new DiscPomniItem());
	public static final RegistryObject<Item> DISC_ROUNDABOUT = REGISTRY.register("disc_roundabout", () -> new DiscRoundaboutItem());
	public static final RegistryObject<Item> DISC_LIBET = REGISTRY.register("disc_libet", () -> new DiscLibetItem());
	public static final RegistryObject<Item> DISC_BURNINGMEMORY = REGISTRY.register("disc_burningmemory", () -> new DiscBurningmemoryItem());
	public static final RegistryObject<Item> DISC_BUDDYHOLLY = REGISTRY.register("disc_buddyholly", () -> new DiscBuddyhollyItem());
	public static final RegistryObject<Item> CRYOSTASIS = REGISTRY.register("cryostasis", () -> new CryostasisItem());
	public static final RegistryObject<Item> ENTER_CLAUSTROPHOBIA = REGISTRY.register("enter_claustrophobia", () -> new EnterClaustrophobiaItem());
	public static final RegistryObject<Item> POWER_UPPER = REGISTRY.register("power_upper", () -> new PowerUpperItem());
	public static final RegistryObject<Item> APTITUDE_CHANGER = REGISTRY.register("aptitude_changer", () -> new AptitudeChangerItem());
	public static final RegistryObject<Item> GIVE_NEW_APTITUDE = REGISTRY.register("give_new_aptitude", () -> new GiveNewAptitudeItem());
	public static final RegistryObject<Item> ENTOMOLOGIST_EPIPHANY = REGISTRY.register("entomologist_epiphany", () -> new EntomologistEpiphanyItem());
	public static final RegistryObject<Item> MINING_AID = block(EvaAdditionsModBlocks.MINING_AID);
	public static final RegistryObject<Item> METABOLISM = REGISTRY.register("metabolism", () -> new AntibodyItem());
	public static final RegistryObject<Item> NIGHT_VISION = REGISTRY.register("night_vision", () -> new NightVisionItem());
	public static final RegistryObject<Item> VOID_WINGS = REGISTRY.register("void_wings", () -> new EndWingsItem());
	public static final RegistryObject<Item> LAVA_WALKER = REGISTRY.register("lava_walker", () -> new LavaWalkerItem());
	public static final RegistryObject<Item> MOOD_CRYSTAL = REGISTRY.register("mood_crystal", () -> new MoodCrystalItem());
	public static final RegistryObject<Item> WEATHER_CRYSTAL = REGISTRY.register("weather_crystal", () -> new WeatherCrystalItem());
	public static final RegistryObject<Item> CRYSTAL_OXYGEN = REGISTRY.register("crystal_oxygen", () -> new AltometerItem());
	public static final RegistryObject<Item> CRYSTAL_DEPTH = REGISTRY.register("crystal_depth", () -> new DepthCrystalItem());
	public static final RegistryObject<Item> CRYSTAL_EARTH = REGISTRY.register("crystal_earth", () -> new UpgradedAltomerItem());
	public static final RegistryObject<Item> GPS = REGISTRY.register("gps", () -> new GPSItem());
	public static final RegistryObject<Item> UPGRADED_GPS = REGISTRY.register("upgraded_gps", () -> new UpgradedGPSItem());
	public static final RegistryObject<Item> LAPIS_TILES_5 = block(EvaAdditionsModBlocks.LAPIS_TILES_5);
	public static final RegistryObject<Item> QUARTZ_TILES_5 = block(EvaAdditionsModBlocks.QUARTZ_TILES_5);
	public static final RegistryObject<Item> COGNITION = REGISTRY.register("cognition", () -> new SmartassItem());
	public static final RegistryObject<Item> PERCEPTION = REGISTRY.register("perception", () -> new HigherSensesItem());
	public static final RegistryObject<Item> REQUIEM = REGISTRY.register("requiem", () -> new RequiemItem());
	public static final RegistryObject<Item> EQUINOX = REGISTRY.register("equinox", () -> new EquinoxItem());
	public static final RegistryObject<Item> DISCOGRAPHY_ITEM = REGISTRY.register("discography_item", () -> new DiscographyItemItem());
	public static final RegistryObject<Item> MINING_AID_STOP = block(EvaAdditionsModBlocks.MINING_AID_STOP);
	public static final RegistryObject<Item> DEV_LIVELEAK = REGISTRY.register("dev_liveleak", () -> new DevLiveleakItem());
	public static final RegistryObject<Item> DEV_ANTIBODY_ITEM = REGISTRY.register("dev_antibody_item", () -> new DevAntibodyItemItem());
	public static final RegistryObject<Item> COLD_OBSIDIAN = block(EvaAdditionsModBlocks.COLD_OBSIDIAN);
	public static final RegistryObject<Item> CRACKING_OBSIDIAN = block(EvaAdditionsModBlocks.CRACKING_OBSIDIAN);
	public static final RegistryObject<Item> DEV_SMARTASS_ITEM = REGISTRY.register("dev_smartass_item", () -> new DevSmartassItemItem());
	public static final RegistryObject<Item> DEV_NIGHT_VISION_ITEM = REGISTRY.register("dev_night_vision_item", () -> new DevNightVisionItemItem());
	public static final RegistryObject<Item> DEV_APTITUDE_ITEM = REGISTRY.register("dev_aptitude_item", () -> new DevAptitudeItemItem());
	public static final RegistryObject<Item> DEV_CURIO_ITEM = REGISTRY.register("dev_curio_item", () -> new DevCurioItemItem());
	public static final RegistryObject<Item> APTITUDE_ORE = block(EvaAdditionsModBlocks.APTITUDE_ORE);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(ENTER_CLAUSTROPHOBIA.get(), new ResourceLocation("eva_additions:enter_claustrophobia_readytoenter"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) EnterClaustrophobiaPropertyValueProviderProcedure.execute(itemStackToRender));
		});
	}
}
