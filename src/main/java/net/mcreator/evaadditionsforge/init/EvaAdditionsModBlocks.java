
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.evaadditionsforge.block.QuartzTilesBlock;
import net.mcreator.evaadditionsforge.block.QuartzTiles3Block;
import net.mcreator.evaadditionsforge.block.QuartzTiles2Block;
import net.mcreator.evaadditionsforge.block.MiningAidStopBlock;
import net.mcreator.evaadditionsforge.block.MiningAidBlock;
import net.mcreator.evaadditionsforge.block.LapisTilesBlock;
import net.mcreator.evaadditionsforge.block.LapisTiles5Block;
import net.mcreator.evaadditionsforge.block.LapisTiles4Block;
import net.mcreator.evaadditionsforge.block.LapisTiles3Block;
import net.mcreator.evaadditionsforge.block.LapisTiles2Block;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class EvaAdditionsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EvaAdditionsMod.MODID);
	public static final RegistryObject<Block> MINING_AID = REGISTRY.register("mining_aid", () -> new MiningAidBlock());
	public static final RegistryObject<Block> MINING_AID_STOP = REGISTRY.register("mining_aid_stop", () -> new MiningAidStopBlock());
	public static final RegistryObject<Block> QUARTZ_TILES = REGISTRY.register("quartz_tiles", () -> new QuartzTilesBlock());
	public static final RegistryObject<Block> LAPIS_TILES = REGISTRY.register("lapis_tiles", () -> new LapisTilesBlock());
	public static final RegistryObject<Block> QUARTZ_TILES_2 = REGISTRY.register("quartz_tiles_2", () -> new QuartzTiles2Block());
	public static final RegistryObject<Block> LAPIS_TILES_2 = REGISTRY.register("lapis_tiles_2", () -> new LapisTiles2Block());
	public static final RegistryObject<Block> QUARTZ_TILES_3 = REGISTRY.register("quartz_tiles_3", () -> new QuartzTiles3Block());
	public static final RegistryObject<Block> LAPIS_TILES_3 = REGISTRY.register("lapis_tiles_3", () -> new LapisTiles3Block());
	public static final RegistryObject<Block> LAPIS_TILES_4 = REGISTRY.register("lapis_tiles_4", () -> new LapisTiles4Block());
	public static final RegistryObject<Block> LAPIS_TILES_5 = REGISTRY.register("lapis_tiles_5", () -> new LapisTiles5Block());
}
