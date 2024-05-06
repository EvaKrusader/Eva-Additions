
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.evaadditionsforge.block.QuartzTiles5Block;
import net.mcreator.evaadditionsforge.block.MiningAidStopBlock;
import net.mcreator.evaadditionsforge.block.MiningAidBlock;
import net.mcreator.evaadditionsforge.block.LapisTiles5Block;
import net.mcreator.evaadditionsforge.block.CrackingObsidianBlock;
import net.mcreator.evaadditionsforge.block.ColdObsidianBlock;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class EvaAdditionsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EvaAdditionsMod.MODID);
	public static final RegistryObject<Block> MINING_AID = REGISTRY.register("mining_aid", () -> new MiningAidBlock());
	public static final RegistryObject<Block> MINING_AID_STOP = REGISTRY.register("mining_aid_stop", () -> new MiningAidStopBlock());
	public static final RegistryObject<Block> LAPIS_TILES_5 = REGISTRY.register("lapis_tiles_5", () -> new LapisTiles5Block());
	public static final RegistryObject<Block> COLD_OBSIDIAN = REGISTRY.register("cold_obsidian", () -> new ColdObsidianBlock());
	public static final RegistryObject<Block> CRACKING_OBSIDIAN = REGISTRY.register("cracking_obsidian", () -> new CrackingObsidianBlock());
	public static final RegistryObject<Block> QUARTZ_TILES_5 = REGISTRY.register("quartz_tiles_5", () -> new QuartzTiles5Block());
}
