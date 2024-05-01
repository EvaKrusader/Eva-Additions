
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.evaadditionsforge.item.SmartassItem;
import net.mcreator.evaadditionsforge.item.PowerUpperItem;
import net.mcreator.evaadditionsforge.item.NightVisionItem;
import net.mcreator.evaadditionsforge.item.EntomologistEpiphanyItem;
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
import net.mcreator.evaadditionsforge.item.DevLiveleakItem;
import net.mcreator.evaadditionsforge.item.DevAntibodyItemItem;
import net.mcreator.evaadditionsforge.item.CryostasisItem;
import net.mcreator.evaadditionsforge.item.AptitudeChangerItem;
import net.mcreator.evaadditionsforge.item.AntibodyItem;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

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
	public static final RegistryObject<Item> DISCOGRAPHY_ITEM = REGISTRY.register("discography_item", () -> new DiscographyItemItem());
	public static final RegistryObject<Item> ENTOMOLOGIST_EPIPHANY = REGISTRY.register("entomologist_epiphany", () -> new EntomologistEpiphanyItem());
	public static final RegistryObject<Item> DISC_POMNI = REGISTRY.register("disc_pomni", () -> new DiscPomniItem());
	public static final RegistryObject<Item> MINING_AID = block(EvaAdditionsModBlocks.MINING_AID);
	public static final RegistryObject<Item> MINING_AID_STOP = block(EvaAdditionsModBlocks.MINING_AID_STOP);
	public static final RegistryObject<Item> DISC_ROUNDABOUT = REGISTRY.register("disc_roundabout", () -> new DiscRoundaboutItem());
	public static final RegistryObject<Item> DISC_LIBET = REGISTRY.register("disc_libet", () -> new DiscLibetItem());
	public static final RegistryObject<Item> DISC_BURNINGMEMORY = REGISTRY.register("disc_burningmemory", () -> new DiscBurningmemoryItem());
	public static final RegistryObject<Item> DISC_BUDDYHOLLY = REGISTRY.register("disc_buddyholly", () -> new DiscBuddyhollyItem());
	public static final RegistryObject<Item> CRYOSTASIS = REGISTRY.register("cryostasis", () -> new CryostasisItem());
	public static final RegistryObject<Item> QUARTZ_TILES = block(EvaAdditionsModBlocks.QUARTZ_TILES);
	public static final RegistryObject<Item> QUARTZ_TILES_2 = block(EvaAdditionsModBlocks.QUARTZ_TILES_2);
	public static final RegistryObject<Item> QUARTZ_TILES_3 = block(EvaAdditionsModBlocks.QUARTZ_TILES_3);
	public static final RegistryObject<Item> DEV_LIVELEAK = REGISTRY.register("dev_liveleak", () -> new DevLiveleakItem());
	public static final RegistryObject<Item> ANTIBODY = REGISTRY.register("antibody", () -> new AntibodyItem());
	public static final RegistryObject<Item> LAPIS_TILES_5 = block(EvaAdditionsModBlocks.LAPIS_TILES_5);
	public static final RegistryObject<Item> NIGHT_VISION = REGISTRY.register("night_vision", () -> new NightVisionItem());
	public static final RegistryObject<Item> DEV_ANTIBODY_ITEM = REGISTRY.register("dev_antibody_item", () -> new DevAntibodyItemItem());
	public static final RegistryObject<Item> END_WINGS = REGISTRY.register("end_wings", () -> new EndWingsItem());
	public static final RegistryObject<Item> COLD_OBSIDIAN = block(EvaAdditionsModBlocks.COLD_OBSIDIAN);
	public static final RegistryObject<Item> CRACKING_OBSIDIAN = block(EvaAdditionsModBlocks.CRACKING_OBSIDIAN);
	public static final RegistryObject<Item> SMARTASS = REGISTRY.register("smartass", () -> new SmartassItem());
	public static final RegistryObject<Item> POWER_UPPER = REGISTRY.register("power_upper", () -> new PowerUpperItem());
	public static final RegistryObject<Item> APTITUDE_CHANGER = REGISTRY.register("aptitude_changer", () -> new AptitudeChangerItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
